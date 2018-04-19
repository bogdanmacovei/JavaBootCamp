package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.*;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.util.List;


public class MainApp {

    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String[] args) {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        if (args.length >= 1) {
            final VehicleInfoDao vehicleInfoDao = new VehicleInfoPlainFileDao(args[0]);

            final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

            if (vehicleInfos.isEmpty()) {
                System.err.printf("No records found");
                return;
            } else {
                for (VehicleInfo info : vehicleInfos) {
                    final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                            info.getNumberOfMiles(), info.isDiesel());
                    final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());

                    final int totalCost = calculator.calculate(vehicle, formula);
                    final String output = String.format(OUTPUT_FORMAT, info.getId(), totalCost);

                    System.out.println(output);
                }
            }
        }
    }

    private static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) {
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleName.equals(carClassName)) {
            return new Car(age, numberOfMiles, isDiesel);
        }

        if (vehicleName.equals(busClassName)) {
            return new Bus(age, numberOfMiles, isDiesel);
        }

        if (vehicleName.equals(tipperClassName)) {
            return new Tipper(age, numberOfMiles, isDiesel);
        }

        return null;
    }
}
