package by.it.patsko.jd01_08;

interface Doctor {
    int definePatientCondition(Patient patient);                               //определить состояние пациента

    void prescribeTreatment(int condition, boolean isHealthInsurance);         //назначить лечение

    void prescribeTreatment(Patient patient);                                  //назначить лечение

    void askQuestion(String question);                                         //задать вопрос

    void giveInjection();                                                      //сделать укол

    boolean checkHealthInsurance(Patient patient);                             //проверить страховку

    void examinePatient(Patient patient);                                      //осмотреть пациента

    void takeTemperature(Patient patient);                                     //измерить температуру

    void takePressure(Patient patient);                                        //измерить давление

    void takePulse(Patient patient);                                           //измерить пульс

    void checkBloodTest(Patient patient);                                      //проверить анализ крови

    void checkUrineTest(Patient patient);                                      //проверить анализ мочи

    void checkStoolTest(Patient patient);                                      //проверить анализ кала
}
