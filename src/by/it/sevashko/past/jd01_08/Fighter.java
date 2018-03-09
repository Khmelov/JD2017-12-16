package by.it.sevashko.jd01_08;

public class Fighter extends CombatPlane {

     private int rockets = 6;

     Fighter(){
         super(60, 100);
     }

    @Override
    void destroyTarget(String nameOfTarget) {
         while (rockets > 0) {
             System.out.println("Capturing of target");
             System.out.println("Rocket has been launched");
             rockets = rockets -1;
             int chance = (int) (Math.random() * 7);
             if (chance == 3) {
                 System.out.printf("%s destroyed", nameOfTarget);
                 return;
             }
             else System.out.println("Missed");
         }
         if (rockets == 0) System.out.println("No more rockets");
    }

    @Override
    public String getParameters() {
        StringBuilder line = new StringBuilder();
        line.append(super.getParameters());
        line.append("Count of rockets = " + rockets + "\n");
        return line.toString();
    }
}
