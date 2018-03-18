package by.it.akhmelev.project8.java.dao.beanDAO;


import by.it.akhmelev.project8.java.dao.connect.ConnectionCreator;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.Date;

// Изучите чуть более сложный пример с Generics.
// Потенциально способен обработать произвольную сущность (entity) со стандартными полями.
// Ограничение. Первым полем в entity должен быть id.

// Код написал для примера и сильно не проверял, так что к прямому использованию он точно не готов,
// просто давайте повторим generics.

//  нет потокобезопасности, совсем, т.к. это только пример, иначе код заметно усложнится.
//  Поэтому - никакого реального применения, используйте только в учебных целях!

class UniversalDAO<TypeBean> implements InterfaceDAO<TypeBean> {

    private Class<TypeBean> beanClass;  //это некий неизвестный entity
    private String table;   //это его таблица в базе
    private Field[] fields; //это поля entity

    //конструктор DAO
    UniversalDAO(Class<TypeBean> beanClass, String sqlTableName) {
        this.beanClass = beanClass;
        this.table = sqlTableName;
        this.fields = beanClass.getDeclaredFields();
    }

    //=======================================================================================================
    @Override
    public List<TypeBean> getAll(String WHERE) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                //создаем копию бина, в который будем складывать запись из Recordset
                TypeBean newBean = newBean();
                for (int i = 1; i < fields.length + 1; i++) {
                    //перебирая поля бина по очереди извлекаем значения в соответствии с их типом
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    try {
                        Class<?> fType = f.getType();
                        if (fType == boolean.class || fType == Boolean.class)
                            f.set(newBean, rs.getBoolean(f.getName()));
                        if (fType == byte.class || fType == Byte.class)
                            f.set(newBean, rs.getByte(f.getName()));
                        if (fType == int.class || fType == Integer.class)
                            f.set(newBean, rs.getInt(f.getName()));
                        if (fType == double.class || fType == Double.class)
                            f.set(newBean, rs.getDouble(f.getName()));
                        if (fType == float.class || fType == Float.class)
                            f.set(newBean, rs.getFloat(f.getName()));
                        if (fType == long.class || fType == Long.class)
                            f.set(newBean, rs.getLong(f.getName()));
                        if (fType == short.class || fType == Short.class)
                            f.set(newBean, rs.getShort(f.getName()));
                        if (fType == String.class)
                            f.set(newBean, rs.getString(f.getName()));
                        if (fType == Date.class)
                            f.set(newBean, rs.getDate(f.getName()));
                        //... и т.д.
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beans;
    }

    //=======================================================================================================
    //метод чтения по ID делает выборку получая все, но с условием.
    @Override
    public TypeBean read(int id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }


    //=======================================================================================================
    //команда обновления
    @Override
    public boolean update(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // "UPDATE `users` SET
        // `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d'
        // WHERE `users`.`ID` = %d",
        String sql = "UPDATE `" + table + "` SET ";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field f = fields[i];
                f.setAccessible(true);
                //добавляем `FieldName` = 'Value', в цикле
                sql = sql.concat(delimiter + "`" + f.getName() + "` = '" + f.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.println(sql);
        return (0 < executeUpdate(sql));
    }

    //=======================================================================================================
    @Override
    public boolean create(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // insert INTO users(Login,Password,Email,FK_Role)
        // values('%s','%s','%s',%d)
        String names = "";
        String values = "";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field f = fields[i];
                f.setAccessible(true);
                names = names.concat(delimiter + f.getName());
                values = values.concat(delimiter + "'" + f.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO " + table + " (" + names + ") values(" + values + ")";
        //System.out.println(sql);
        int id = executeUpdate(sql);
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }

    //=======================================================================================================
    @Override
    public boolean delete(TypeBean bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`ID` = '" + fields[0].get(bean) + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.println(sql);
        return (0 < executeUpdate(sql));
    }


    //=======================================================================================================
    //т.к. в Generics невозможно сделать new TypeBean(), а новые объекты нужны,
    //создадим объект и приведем его тип к TypeBean "вручную"
    @SuppressWarnings("unchecked") //подавление warning-а
    private TypeBean newBean() {
        try {
            return beanClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null; //если не создался вернем null
    }

    //=======================================================================================================
    //общая команда для Create Update Delete
    private static int executeUpdate(String sql) throws SQLException {
        int result;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            //получим ID, если это требуется извне.
            if (result > 0 && sql.startsWith("INSERT")) {
                //в MySQL можно так .executeQuery("SELECT LAST_INSERT_ID();");
                //но этот способ надежнее (не зависит от базы данных и безопаснее)
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
                System.out.println("id: " + result);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

}