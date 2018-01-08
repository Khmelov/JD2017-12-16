package by.it.patsko.jd01_08;

class Patient {
    private String painArea;
    private boolean healthInsurance;
    private double temperature;
    private int pressureUp;
    private int pressureDown;
    private int pulse;
    private boolean physicalDamage;
    private boolean bloodSample;
    private boolean urineSample;
    private boolean stoolSample;
    private boolean mriTest;
    private int patientCondition = 0;


    Patient() {
        String[] painAreas = {"-Голова болит", "-Живот крутит", "-Рука дрожит", "-Нога дергается", "-Зуб сломался",
                "-Горло пересохло", "-Ухо не слышит", "-Спина не гнется"};
        painArea = painAreas[Math.random() <= 0.8 ? 0 : (int) (Math.random() * (painAreas.length - 1) + 1)];
        healthInsurance = ((int) (Math.random() * 2) == 0) ? false : true;
        physicalDamage = ((int) (Math.random() * 2) == 0) ? false : true;
        temperature = Math.random() * 15 + 30;             //[30;45)
        pressureUp = (int) (Math.random() * 61) + 120;     //[120;180]
        pressureDown = (int) (Math.random() * 41) + 80;    //[80;120]
        pulse = (int) (Math.random() * 61) + 40;           //[40;100]
        bloodSample = ((int) (Math.random() * 2) == 0) ? false : true;
        urineSample = ((int) (Math.random() * 2) == 0) ? false : true;
        stoolSample = ((int) (Math.random() * 2) == 0) ? false : true;
        mriTest = ((int) (Math.random() * 2) == 0) ? false : true;
    }

    //=====================================================================================================================
    void setPatientCondition(int patientCondition) {
        this.patientCondition = patientCondition;
    }

    int getPatientCondition() {
        return patientCondition;
    }

    String getPainArea() {
        return painArea;
    }

    boolean isHealthInsurance() {
        return healthInsurance;
    }

    boolean isPhysicalDamage() {
        return physicalDamage;
    }

    double getTemperature() {
        return temperature;
    }

    int getPressureUp() {
        return pressureUp;
    }

    int getPressureDown() {
        return pressureDown;
    }

    int getPulse() {
        return pulse;
    }

    boolean isBloodSample() {
        return bloodSample;
    }

    boolean isUrineSample() {
        return urineSample;
    }

    boolean isStoolSample() {
        return stoolSample;
    }

    boolean isMriTest() {
        return mriTest;
    }
}
