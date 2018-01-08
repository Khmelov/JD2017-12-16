package by.it.patsko.jd01_08;

abstract class Surgeon implements Doctor {
    private String name;                                     //имя врача
    private String specialty;                                //специальность врача


    Surgeon(String specialty, String name) {
        this.name = name;
        this.specialty = specialty;
    }

    @Override
    public int definePatientCondition(Patient patient) {
        examinePatient(patient);
        takeTemperature(patient);
        takePressure(patient);
        takePulse(patient);
        checkTests(patient);
        return 0;
    }

    @Override
    public void askQuestion(String question) {
        System.out.println(question);
    }

    @Override
    public boolean checkHealthInsurance(Patient patient) {
        System.out.println("<" + this + " проверяет страховку пациента>");
        return patient.isHealthInsurance();
    }

    @Override
    public void examinePatient(Patient patient) {
        System.out.println("<" + this + " осматривает пациента>");
        if (patient.isPhysicalDamage()) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void takeTemperature(Patient patient) {
        System.out.println("<" + this + " измеряет температуру пациента>");
        if (patient.getTemperature() < 34 || patient.getTemperature() > 38.5)
            patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void takePressure(Patient patient) {
        System.out.println("<" + this + " измеряет давление пациента>");
        if (patient.getPressureUp() > 160) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);

        if (patient.getPressureDown() > 100) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void takePulse(Patient patient) {
        System.out.println("<" + this + " измеряет пульс пациента>");
        if (patient.getPulse() > 90 || patient.getPulse() < 50)
            patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    void checkTests(Patient patient) {
        System.out.println("<" + this + " проверяет анализы пациента>");
        checkBloodTest(patient);
        checkUrineTest(patient);
        checkStoolTest(patient);
    }

    @Override
    public void checkBloodTest(Patient patient) {
        if (patient.isBloodSample()) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void checkUrineTest(Patient patient) {
        if (patient.isUrineSample()) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void checkStoolTest(Patient patient) {
        if (patient.isStoolSample()) patient.setPatientCondition(patient.getPatientCondition() - 1);
        else patient.setPatientCondition(patient.getPatientCondition() + 1);
    }

    @Override
    public void giveInjection() {
        System.out.println("<" + this + " делает пациенту укол витамина 'С'>");
    }

    @Override
    public String toString() {
        return specialty + " " + name;
    }
}
