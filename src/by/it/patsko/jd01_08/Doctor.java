package by.it.patsko.jd01_08;

interface Doctor {
    void examinePatient();          //осмотреть пациента
    double takeTemperature();       //измерить температуру
    String takePressure();          //измерить давление
    int takePulse();                //измерить пульс

    void giveInjection();           //сделать укол
    String askQuestion();           //задать вопрос
//    void writePrescription();       //выписать рецепт
    String prescribeTreatment();    //назначить лечение
    boolean checkHealthInsurance(); //проверить страховку


    boolean checkBloodTest();      //проверить анализ крови
    boolean checkUrineTest();      //проверить анализ мочи
    boolean checkStoolTest();      //проверить анализ кала


}
