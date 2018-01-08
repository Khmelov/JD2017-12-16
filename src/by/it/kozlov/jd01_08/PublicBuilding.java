package by.it.kozlov.jd01_08;

public abstract class PublicBuilding implements Building {
    boolean buildingOpen;
    boolean door;
    boolean spectacle;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------\n");
        sb.append(buildingOpen ? "Building open\n" : "Building close\n");
        sb.append(door ? "Door open\n" : "Door close\n");
        sb.append(spectacle ? "Spectacle play\n" : "Spectacle stop\n");
        sb.append("-----------------------------\n");
        return sb.toString();
    }

    @Override
    public void buildingOpen() {
        buildingOpen = true;
        door = true;
    }

    @Override
    public void buildingClose() {
        buildingOpen = false;
        door = false;
        spectacle = false;
    }

    @Override
    public void openDoor() {
        door = true;
    }

    @Override
    public void closeDoor() {
        door = false;
        spectacle = false;
    }

    @Override
    public void playSpectacle() {
        buildingOpen = true;
        door = true;
        spectacle = true;
    }

    @Override
    public void stopSpectacle() {
        spectacle = false;
    }
}
