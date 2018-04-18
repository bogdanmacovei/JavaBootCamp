package org.bootcamp;

public class MainApp {

    public static void main(String[] args) {
        final Car joesCar = new Car(5, 200000, true, "auto");
        final Bus stevesBus = new Bus (3, 100000, true, 31);
        final Tipper petersTipper = new Tipper (6, 80000, false, 15);

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final int joesInsurancePolicyCost = calculator.calculate(joesCar);
        final int stevesInsurancePolicyCost = calculator.calculate(stevesBus);
        final int petersInsurancePolicyCost = calculator.calculate(petersTipper);

        System.out.println("Joe's policy cost is " + joesInsurancePolicyCost);
        System.out.println("Steve's policy cost is " + stevesInsurancePolicyCost);
        System.out.println("Peter's policy cost is " + petersInsurancePolicyCost);
    }
}
