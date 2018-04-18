package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.formula.BusBasicFormula;
import org.bootcamp.formula.CarBasicFormula;
import org.bootcamp.formula.Formula;
import org.bootcamp.formula.TipperBasicFormula;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

public class MainApp {

    public static void main(String[] args) {
        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        final Formula carBasicFormula = new CarBasicFormula();
        final Formula busBasicFormula = new BusBasicFormula();
        final Formula tipperBasicFormula = new TipperBasicFormula();

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final int joesInsurancePolicyCost = calculator.calculate(joesCar, carBasicFormula);
        final int stevesInsurancePolicyCost = calculator.calculate(stevesBus, busBasicFormula);
        final int petersInsurancePolicyCost = calculator.calculate(petersTipper, tipperBasicFormula);

        System.out.println("Joe's policy cost is " + joesInsurancePolicyCost);
        System.out.println("Steve's policy cost is " + stevesInsurancePolicyCost);
        System.out.println("Peter's policy cost is " + petersInsurancePolicyCost);
    }
}
