package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData implements Runnable {
    String name = "";
    int id_student = 0;

    public A_AddData() {
        super();
    }

    public A_AddData(String name, int id_student) {
        this();
        this.name = name;
        this.id_student = id_student;
    }

    @Override
    public void run() {

        try {
            Connection connectMagaz = MyConnect.getConnection();
            Statement st = connectMagaz.createStatement();
            String s = String.format("INSERT INTO `product`(`name`, `fk_students`) VALUES ('%s',%d)", name, id_student);
            System.out.println("Запись добавлена в таблицу product");
            st.executeUpdate(s);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
