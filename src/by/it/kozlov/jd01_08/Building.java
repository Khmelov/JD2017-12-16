package by.it.kozlov.jd01_08;

interface Building {
    String theme();

    void buildingOpen();

    void buildingClose();

    void openDoor();

    void closeDoor();

    void playSpectacle(String spectacleTheme);

    void stopSpectacle();

    //Открытие занавеса
    void curtainOpen(String spectacleTheme);

    //Закрытие занавеса
    void curtainClose();
}
