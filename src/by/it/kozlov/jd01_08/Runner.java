package by.it.kozlov.jd01_08;

public class Runner {
    public static void main(String[] args) {
        PublicBuilding theater = new Theater();
        theater.buildingOpen();
        System.out.println(theater);
        theater.closeDoor();
        System.out.println(theater);
        theater.playSpectacle("Life of Galileo");
        theater.curtainOpen(theater.theme());
        System.out.println(theater);
        theater.buildingClose();
        System.out.println(theater);
    }
}
