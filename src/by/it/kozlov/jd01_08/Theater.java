package by.it.kozlov.jd01_08;

public class Theater extends PublicBuilding {

    boolean curtain;

    @Override
    //Открытие занавеса
    public void curtainOpen() {
        curtain = true;
        super.buildingOpen = true;
        super.door = true;
        super.spectacle = true;
    }

    @Override
    //Закрытие занавеса
    public void curtainClose() {
        curtain = false;
        super.spectacle = false;
    }

    @Override
    public void buildingClose() {
        super.buildingOpen = false;
        super.door = false;
        super.spectacle = false;
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
}
