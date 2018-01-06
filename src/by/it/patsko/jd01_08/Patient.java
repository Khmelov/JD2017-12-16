package by.it.patsko.jd01_08;

import java.util.Arrays;

class Patient {
    private String painArea;
    private String[] painAreas={"Голова", "Живот","Рука","Нога","Зуб","Горло","Ухо","Спина"};
    private boolean healthInsurance;

    public double temperature;
    public int pressureUp;
    public int pressureDown;
    public int pulse;
    public int patientCondition=0;

    Patient(){
        painArea=painAreas[(int)(Math.random()*painAreas.length)];
        healthInsurance=((int)(Math.random()*2)==0)?false:true;

        temperature=Math.random()*15+30;            //[30;45)
        if(temperature<34||temperature>38.5) patientCondition--;
        else patientCondition++;

        pressureUp=(int)(Math.random()*61)+120;     //[120;180]
        if(pressureUp>160) patientCondition--;
        else patientCondition++;

        pressureDown=(int)(Math.random()*41)+80;    //[80;120]
        if(pressureDown>100) patientCondition--;
        else patientCondition++;

        pulse=(int)(Math.random()*61)+40;           //[40;100]
        if(pulse>90||pulse<50) patientCondition--;
        else patientCondition++;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "painArea='" + painArea + '\'' +
                ", healthInsurance=" + healthInsurance +
                ", temperature=" + temperature +
                ", pressureUp=" + pressureUp +
                ", pressureDown=" + pressureDown +
                ", pulse=" + pulse +
                ", patientCondition=" + patientCondition +
                '}';
    }
}
