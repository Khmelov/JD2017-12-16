package by.it.vshelukhin.jd03_02;

import java.sql.SQLException;

public class Prob {
    public static void main(String[] args) throws SQLException {
//        StudentCRUD studAction = new StudentCRUD();
//        Student st1 = studAction.read(1);
//        System.out.println(st1);
//        st1.setPrice(99.99);
//        studAction.update(st1);
//        System.out.println(st1.getPrice());
//        //st1 = studAction.read(2);
//        studAction.delete(studAction.read(2));

        RoliesCRUD actRolies = new RoliesCRUD();
        Rolies rolie = actRolies.read(1);
        System.out.println(rolie);
        rolie.setRole("Вредитель");
        actRolies.create(rolie);
        System.out.println(rolie.getId());
        rolie.setRole("Нейтральный");
        actRolies.update(rolie);
        actRolies.delete(rolie);

    }
}
