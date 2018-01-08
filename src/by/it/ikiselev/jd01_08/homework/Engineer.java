package by.it.ikiselev.jd01_08.homework;

public abstract class Engineer implements Associate {
    private double salary;
    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String speciality;
    private boolean attendance;
    private boolean alcohol;
    private boolean vacation;
    private boolean sickLeave;

    Engineer(int id, String lastName, double salary){
        this.id=id;
        this.lastName=lastName;
        this.salary=salary;
    }

    Engineer(){
        this.salary=500;
    }

    @Override
    public void doWork() {
        int work=0;
        for (int i = 8; i < 18; i++) {
            if (i<14)work=work+10;
            else work=work+5;
        }
        System.out.println("Работы выполнено на "+work+"%");
        System.out.println("Выполнен метод doWork() - то есть сотрудник выполняет работу во время рабочего дня.\nДо обеда работается хорошо, после обеда-хуже.");
    }

    @Override
    public void doReport() {
        System.out.println("Отчет выполнен сотрудником"+this.firstName+" "+this.lastName);
        System.out.println("Выполнен метод doReport() - то есть написание сотрудником отчета о проделанной работе");

    }

    @Override
    public void demandSalaryIncrease() {
        while (this.salary<1500){
            System.out.println("Я требую повышения зарплаты");
            this.salary=this.salary+300;
        }
        System.out.println("Выполнен метод demandSalaryIncrease() - то есть сотрудник требует повышения зарплаты");
    }

    @Override
    public boolean checkAttendance() {
        System.out.println("Выполнен метод checkAttendance() - то есть проверка присутствия/отсутствия на рабочем месте");
        if (this.attendance==true)
        return true;
        else return false;
    }

    @Override
    public boolean checkAlcohol() {
        System.out.println("Выполнен метод checkAlcohol() - то есть проверка алкогольного опьянения на рабочем месте");
        if (this.alcohol==true)
            return true;
        else return false;
    }

    @Override
    public boolean checkVacation() {
        System.out.println("Выполнен метод checkVacation() - то есть находится ли сотрудник в отпуске в данный момент");
        if (this.vacation==true)
            return true;
        else return false;
    }

    @Override
    public boolean checkSickLeave() {
        System.out.println("Выполнен метод checkSickLeave() - то есть находится ли сотрудник на больничном в данный момент");
        if (this.sickLeave==true)
            return true;
        else return false;
    }
}
