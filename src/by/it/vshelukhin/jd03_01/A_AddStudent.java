package by.it.vshelukhin.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddStudent implements Runnable {

    String univer = "";
    int kurs = 0;
    String facultet = "";
    double price = 0.0;
    int role = 1;

    public A_AddStudent() {
        super();
    }

    public A_AddStudent(String univer, int kurs, String facultet, double price, int role) {
        this();
        this.univer = univer;
        this.kurs = kurs;
        this.facultet = facultet;
        this.price = price;
        this.role = role;
    }

    @Override
    public void run() {

        try {
            Connection connectMagaz = MyConnect.getConnection();
            Statement st = connectMagaz.createStatement();
            String s = String.format("INSERT INTO `student`(`univer`, `kurs`, `facultet`, `price`, `id_role`) VALUES ('%s',%d,'%s',%s,%d)", univer, kurs, facultet, Double.toString(price).replace(",","."), role);
            st.executeUpdate(s);
            System.out.println("Запись добавлена в таблицу student");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


