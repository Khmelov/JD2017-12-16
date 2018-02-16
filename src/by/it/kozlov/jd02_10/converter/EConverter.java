package by.it.kozlov.jd02_10.converter;

public enum EConverter {
    TO_XML(1), TO_JSON(2), XML_TO_JSON(3), JSON_TO_XML(4);


    EConverter(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }

    public static String getClassName() {
        return EConverter.class.getName();
    }

}
