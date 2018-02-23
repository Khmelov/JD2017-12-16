package by.it.kozlov.jd03_03;

import by.it.kozlov.jd03_03.connect.ConnectionCreator;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOCRUD<T> {
    private T bean;
    private String baseName;
    private String tableName;
    Field[] fields;

    public DAOCRUD(T bean, String baseName, String tableName) {
        this.bean = bean;
        this.baseName = baseName;
        this.tableName = tableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    public boolean create(T bean) throws SQLException, IllegalAccessException {
        String names = "";
        String values = "";
        String delimiter = "";
        int result;
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            names = names.concat(delimiter + field.getName());
            values = values.concat(delimiter + "'" + field.get(bean) + "'");
            delimiter = ", ";
        }
        String sql = "INSERT INTO `" + baseName + "`.`" + tableName + "' (" + names + ") values(" + values + ")";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (count == 1) {
                result = resultSet.getInt(1);
                fields[0].setAccessible(true);
                fields[0].set(bean, result);
            }
            return count == 1;
        }
    }

    public T read(int id) throws SQLException, InstantiationException, IllegalAccessException {
        List<T> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }

    public boolean update(T bean) throws SQLException, IllegalAccessException {
        String sql = "UPDATE `" + baseName + "`.`" + tableName + "` SET ";
        String delimiter = "";
        for (int i = 1; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            sql = sql.concat(delimiter + "`" + field.getName() + "` = '" + field.get(bean) + "'");
            delimiter = ", ";
        }
        fields[0].setAccessible(true);
        sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql);
            return count == 1;
        }
    }

    public boolean delete(T bean) throws SQLException, IllegalAccessException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM `" + baseName + "`.`" + tableName + "` WHERE `" + tableName + "`.`ID` = '" + fields[0].get(bean) + "'";
            int count = statement.executeUpdate(sql);
            return count == 1;
        }
    }

    public List<T> getAll(String WHERE) throws SQLException, IllegalAccessException, InstantiationException {
        List<T> beans = new ArrayList<>();
        String sql = "SELECT * FROM `" + baseName + "` . `" + tableName + "` " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                T newBean = (T) bean.getClass().newInstance();
                for (int i = 1; i < fields.length + 1; i++) {
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    String strType = f.getType().toString();
                    if (f.getType() == Boolean.class || strType.equals("boolean"))
                        f.set(newBean, resultSet.getBoolean(f.getName()));
                    if (f.getType() == Byte.class || strType.equals("byte"))
                        f.set(newBean, resultSet.getByte(f.getName()));
                    if (f.getType() == Integer.class || strType.equals("int"))
                        f.set(newBean, resultSet.getInt(f.getName()));
                    if (f.getType() == Double.class || strType.equals("double"))
                        f.set(newBean, resultSet.getDouble(f.getName()));
                    if (f.getType() == Float.class || strType.equals("float"))
                        f.set(newBean, resultSet.getFloat(f.getName()));
                    if (f.getType() == Long.class || strType.equals("long"))
                        f.set(newBean, resultSet.getLong(f.getName()));
                    if (f.getType() == Short.class || strType.equals("short"))
                        f.set(newBean, resultSet.getShort(f.getName()));
                    if (f.getType() == String.class)
                        f.set(newBean, resultSet.getString(f.getName()));
                    if (f.getType() == Date.class)
                        f.set(newBean, resultSet.getDate(f.getName()));
                }
                beans.add(newBean);
            }
        }
        return beans;
    }
}
