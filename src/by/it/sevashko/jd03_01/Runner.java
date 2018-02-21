package by.it.sevashko.jd03_01;

public class Runner {

    public static void main(String[] args) {
        C_reset.dropAll();
        C_init.createDataBase();
        B_AddRoles.addRoles();
        A_AddUsers.addUsers();
        B_ShowUsers.showUsers();
        A_AddData.addData();
    }
}
