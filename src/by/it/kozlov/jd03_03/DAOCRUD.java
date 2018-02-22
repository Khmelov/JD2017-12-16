package by.it.kozlov.jd03_03;

import java.lang.reflect.Field;

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


}
