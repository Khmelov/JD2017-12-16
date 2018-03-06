package by.it.sevashko.project.java.dao.beanDAO;

import by.it.sevashko.project.java.dao.connect.Connector;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UniversalDAO<Bean> extends AbstractDAO implements InterfaceDAO<Bean> {

    private String tableName;
    private Class<?> beanClass;
    private Field[] fields;

    public UniversalDAO(Bean instance, String tableName) {
        this.tableName = tableName;
        this.beanClass = instance.getClass();
        this.fields = beanClass.getDeclaredFields();
    }

    @Override
    public boolean create(Bean bean) throws SQLException {
        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                names.append(fields[i].getName()).append(',');
                values.append(String.format("'%s',", fields[i].get(bean)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        names.deleteCharAt(names.length()-1);
        values.deleteCharAt(values.length()-1);
        String insert = String.format("INSERT INTO `%s` (%s) VALUES (%s);", tableName, names, values);
        int result = executeUpdate(insert);
        if (result > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, result);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Bean read(int id) throws SQLException {
        String query = String.format("SELECT * FROM `users` WHERE id=%d;", id);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Bean newBean = newBean();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String strType = field.getType().toString();
                    try {
                        if (field.getType() == Boolean.class || strType.equals("boolean"))
                            field.set(newBean, resultSet.getBoolean(field.getName()));
                        if (field.getType() == Byte.class || strType.equals("byte"))
                            field.set(newBean, resultSet.getByte(field.getName()));
                        if (field.getType() == Integer.class || strType.equals("int"))
                            field.set(newBean, resultSet.getInt(field.getName()));
                        if (field.getType() == Double.class || strType.equals("double"))
                            field.set(newBean, resultSet.getDouble(field.getName()));
                        if (field.getType() == Float.class || strType.equals("float"))
                            field.set(newBean, resultSet.getFloat(field.getName()));
                        if (field.getType() == Long.class || strType.equals("long"))
                            field.set(newBean, resultSet.getLong(field.getName()));
                        if (field.getType() == Short.class || strType.equals("short"))
                            field.set(newBean, resultSet.getShort(field.getName()));
                        if (field.getType() == String.class)
                            field.set(newBean, resultSet.getString(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(newBean, resultSet.getDate(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                return newBean;
            }
            return null;
        }
    }

    @Override
    public boolean update(Bean bean) throws SQLException {
        StringBuilder line = new StringBuilder();
        int id = 0;
        try {
            fields[0].setAccessible(true);
            id = (int) fields[0].get(bean);
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                line.append(String.format("%s='%s',", fields[i].getName(), fields[i].get(bean)));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        line.deleteCharAt(line.length()-1);
        String set = String.format("UPDATE `%s` SET %s WHERE users.id='%d';", tableName, line, id);
        return executeUpdate(set) == 1;
    }

    @Override
    public boolean delete(Bean bean) throws SQLException {
        fields[0].setAccessible(true);
        String query = null;
        try {
            query = String.format("DELETE FROM %s WHERE id=%s;", tableName, fields[0].get(bean));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return executeUpdate(query) == 1;
    }

    @Override
    public List<Bean> getALL(String where) throws SQLException {
        List<Bean> list = new ArrayList<>();
        String query = String.format("SELECT * FROM %s %s", tableName, where);
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Bean newBean = newBean();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String strType = field.getType().toString();
                    try {
                        if (field.getType() == Boolean.class || strType.equals("boolean"))
                            field.set(newBean, resultSet.getBoolean(field.getName()));
                        if (field.getType() == Byte.class || strType.equals("byte"))
                            field.set(newBean, resultSet.getByte(field.getName()));
                        if (field.getType() == Integer.class || strType.equals("int"))
                            field.set(newBean, resultSet.getInt(field.getName()));
                        if (field.getType() == Double.class || strType.equals("double"))
                            field.set(newBean, resultSet.getDouble(field.getName()));
                        if (field.getType() == Float.class || strType.equals("float"))
                            field.set(newBean, resultSet.getFloat(field.getName()));
                        if (field.getType() == Long.class || strType.equals("long"))
                            field.set(newBean, resultSet.getLong(field.getName()));
                        if (field.getType() == Short.class || strType.equals("short"))
                            field.set(newBean, resultSet.getShort(field.getName()));
                        if (field.getType() == String.class)
                            field.set(newBean, resultSet.getString(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(newBean, resultSet.getDate(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                list.add(newBean);
            }
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private Bean newBean(){
        try {
            return  (Bean) beanClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
