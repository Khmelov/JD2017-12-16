package by.it.kozlov.jd01_08;

public class Theater extends PublicBuilding {

    private boolean curtain;

    @Override
    //Открытие занавеса
    public void curtainOpen(String spectacleTheme) {
        curtain = true;
        super.playSpectacle(spectacleTheme);
    }

    @Override
    //Закрытие занавеса
    public void curtainClose() {
        curtain = false;
        super.stopSpectacle();
    }

    @Override
    public void buildingClose() {
        super.buildingClose();
        this.curtain = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(curtain ? "Curtain open\n" : "Curtain close\n");
        sb.append("-----------------------------\n");
        return sb.toString();
    }

    public void stopSpectacle() {
        super.stopSpectacle();
        curtain = false;
    }
}
