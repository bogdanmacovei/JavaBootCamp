package org.bootcamp.calculator;

import org.bootcamp.formula.Formula;
import org.bootcamp.vehicle.Vehicle;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();
    private InsurancePolicyCalculator() {

    }

    public int calculate(Vehicle vehicle, Formula formula) {
        return formula.calculate(vehicle);
    }
}
