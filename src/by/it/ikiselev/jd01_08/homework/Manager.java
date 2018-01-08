package by.it.ikiselev.jd01_08.homework;

class Manager extends Engineer{
    private int experienceYears;
    private int idProject;
    private String nameOfProject;

    Manager(String nameOfProject, int idProject){
        this.nameOfProject=nameOfProject;
        this.idProject=idProject;
    }

    Manager(String nameOfProject, int idProject, int experienceYears){
        this(nameOfProject,idProject);
        this.experienceYears=experienceYears;
    }
    Manager(){
        super(20180101,"Иванов",555.65);
    }

    @Override
    public void doWork() {
        if (this.experienceYears<5)
        super.doWork();
        else {
            int work=0;
            for (int i = 8; i < 18; i++) {
                if (i<11)work=work+30;
                else work=work+1;
            }
            System.out.println("Работы выполнено на "+work+"%");
        }
    }

    @Override
    public void demandSalaryIncrease() {
        if (this.experienceYears<5)
            System.out.println("Я требую повышения зарплаты в два раза");
        else  System.out.println("Я требую повышения зарплаты в три раза");
    }
}
