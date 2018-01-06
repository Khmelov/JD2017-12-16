package by.it.patsko.jd01_08;

public class Neurosurgeon extends Surgeon {


    public Neurosurgeon() {
        super("neurosurgeon");
    }

    @Override
    public void examinePatient() {

    }

    @Override
    public double takeTemperature() {
        return 0;
    }

    @Override
    public String takePressure() {
        return null;
    }

    @Override
    public int takePulse() {
        return 0;
    }

    @Override
    public void giveInjection() {

    }

    @Override
    public String askQuestion() {
        return null;
    }

    @Override
    public String prescribeTreatment() {
        return null;
    }

    @Override
    public boolean checkHealthInsurance() {
        return false;
    }

    @Override
    public boolean checkBloodTest() {
        return false;
    }

    @Override
    public boolean checkUrineTest() {
        return false;
    }

    @Override
    public boolean checkStoolTest() {
        return false;
    }
}
