package by.it.patsko.jd01_08;
/*
Создать и реализовать интерфейсы в три (A) пять (В) или семь (С) методов. Необходимо использовать:
■	наследование (A)
■	статический полиморфизм, this (В)
■	динамический полиморфизм, this, super (С)
Каждый метод делает вывод в консоль с текстом сути метода.

interface Врач <-- abstract class Хирург <-- class Нейрохирург.
 */

public class Runner {
    public static void main(String[] args) {
        Patient[] patient = new Patient[20];
        Doctor neurosurgeon = new Neurosurgeon("Иванов");     //динамический полиморфизм, this, super (С)

        for (int i = 0; i < patient.length; i++) {
            patient[i] = new Patient();
            neurosurgeon.askQuestion("-На что жалуетесь?");
            System.out.println(patient[i].getPainArea());
            if (neurosurgeon.definePatientCondition(patient[i]) < 0)
                System.out.println(((Neurosurgeon) neurosurgeon).getTreatment(0)); //приведение типа!!!
//            else neurosurgeon.prescribeTreatment(patient[i].getPatientCondition(),neurosurgeon.checkHealthInsurance(patient[i]));
            else neurosurgeon.prescribeTreatment(patient[i]);

            System.out.println();
        }
    }
}
