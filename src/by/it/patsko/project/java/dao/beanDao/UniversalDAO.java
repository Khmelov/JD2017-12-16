package by.it.patsko.project.java.dao.beanDao;

import by.it.patsko.project.java.dao.ConnectionCreator;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UniversalDAO<T> extends DAO implements I_DAO<T> {
    public T bean;
    private String tableName;
    List<Field> fields;

    public UniversalDAO() {
    }

    public UniversalDAO(T bean, String tableName) {
        this.bean = bean;
        this.tableName = tableName;
        this.fields = new ArrayList<>(Arrays.asList(bean.getClass().getDeclaredFields()));
    }

    @Override
    public boolean create(T bean) throws SQLException {
        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        String delimiter = "";

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `").append(tableName).append("`(");
        try {
            for (int i = 1; i < fields.size(); i++) {
                Field field = fields.get(i);
                field.setAccessible(true);
                names.append(delimiter + field.getName());
                values.append(delimiter + "'" + field.get(bean) + "'");
                delimiter = ", ";
            }
            sql.append(names).append(") ").append("VALUES (").append(values).append(")");
            int id = executeUpdate(sql.toString());
            if (id > 0) {
                fields.get(0).setAccessible(true);
                fields.get(0).set(bean, id);
            }
            return id > 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public T read(int id) throws SQLException {
        List<T> beanList = getAll(" where id=" + id);
        return !beanList.isEmpty() ? beanList.get(0) : null;
    }

    @Override
    public boolean update(T bean) throws SQLException {
        StringBuilder sql = new StringBuilder();
        String delimiter = "";
        sql.append("UPDATE `").append(tableName).append("` SET ");
        try {
            for (int i = 1; i < fields.size(); i++) {
                Field field = fields.get(i);
                field.setAccessible(true);
                sql.append(delimiter).append("`").append(field.getName()).
                        append("` = '").append(field.get(bean)).append("'");
                delimiter = ", ";
            }
            sql.append(" WHERE `").append(fields.get(0).getName()).
                    append("` = '").append(fields.get(0).get(bean)).append("'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 1 == executeUpdate(sql.toString());
    }

    @Override
    public boolean delete(T bean) throws SQLException {
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("DELETE FROM `").append(tableName).append("` WHERE id='").
                    append(fields.get(0).get(bean)).append("'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0< executeUpdate(sql.toString());
    }

    public List<T> getAll(String where) throws SQLException {
        List<T> beanList = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `" + tableName + "` " + where);
            while (resultSet.next()) {
                T newBean = (T) bean.getClass().newInstance();
                for (int i = 1; i < fields.size() + 1; i++) {
                    Field field = fields.get(i - 1);
                    field.setAccessible(true);
                    String type = field.getType().toString();
                    if (field.getType() == Boolean.class || type.equals("boolean"))
                        field.set(newBean, resultSet.getBoolean(field.getName()));
                    if (field.getType() == Byte.class || type.equals("byte"))
                        field.set(newBean, resultSet.getByte(field.getName()));
                    if (field.getType() == Integer.class || type.equals("int"))
                        field.set(newBean, resultSet.getInt(field.getName()));
                    if (field.getType() == Double.class || type.equals("double"))
                        field.set(newBean, resultSet.getDouble(field.getName()));
                    if (field.getType() == Float.class || type.equals("float"))
                        field.set(newBean, resultSet.getFloat(field.getName()));
                    if (field.getType() == Long.class || type.equals("long"))
                        field.set(newBean, resultSet.getLong(field.getName()));
                    if (field.getType() == Short.class || type.equals("short"))
                        field.set(newBean, resultSet.getShort(field.getName()));
                    if (field.getType() == String.class)
                        field.set(newBean, resultSet.getString(field.getName()));
                    if (field.getType() == Date.class)
                        field.set(newBean, resultSet.getDate(field.getName()));
                }
                beanList.add(newBean);
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return beanList;
    }
}
