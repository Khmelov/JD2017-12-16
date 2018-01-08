package by.it.patsko.jd01_08;

public class Neurosurgeon extends Surgeon {
    private String[] treatment = {"-Это не мой профиль", "-Могу посоветовать хорошего плотника.",
            "<выписывает рецепт на подорожник>", "<вскакивает> -Срочно в операционную!!!",
            "-Приходите ко мне через месяц. Посмотрим, что можно сделать", "-Поздровляю, вы здоровы!"};       //лечение

    Neurosurgeon(String name) {
        super("Hейрохирург", name);             //динамический полиморфизм, this, super (С)
    }

    String getTreatment(int i) {
        return treatment[i];
    }

    @Override
    void checkTests(Patient patient) {
        super.checkTests(patient);                       //динамический полиморфизм, this, super (С)
        checkMRItest(patient);
    }

    private void checkMRItest(Patient patient) {        //проверить МРТ мозга
        if (patient.isMriTest()) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public int definePatientCondition(Patient patient) {
        if (patient.getPainArea().equals("-Голова болит")) {
            super.definePatientCondition(patient);      //динамический полиморфизм, this, super (С)
        } else return -1;
        return 0;
    }

    @Override
    public void prescribeTreatment(int condition, boolean isHealthInsurance) {
        if (condition <= -3 && condition >= -7)
            System.out.println(isHealthInsurance ? treatment[3] : treatment[1]);
        else if (condition > -3 && condition <= 0) {
            this.giveInjection();
            System.out.println(isHealthInsurance ? treatment[4] : treatment[2]);
        } else if (condition > 0) System.out.println(treatment[5]);
        else System.out.println("Сестра! Вызывайте экзорциста!");
    }

    @Override
    public void prescribeTreatment(Patient patient) {           //статический полиморфизм, this (В)
        this.prescribeTreatment(patient.getPatientCondition(), patient.isHealthInsurance());
    }

    @Override
    public void giveInjection() {
        super.giveInjection();
        System.out.println("<" + this + " делает пациенту укол витамина 'B'>");
    }

    @Override
    public String toString() {                              //динамический полиморфизм, this, super (С)
        return super.toString();
    }
}
