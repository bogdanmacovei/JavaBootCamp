package org.bootcamp.service;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleExcelFileDao;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.dao.VehicleJsonFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.bootcamp.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {
    private final VehicleInfoDao vehicleInfoDao;

    public InsuranceCalculatorService(String filePath) {
        this.vehicleInfoDao = new VehicleJsonFileDao(filePath);
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

        final List<InsuranceCalculationResult> resultList = new LinkedList<InsuranceCalculationResult>();

        if (vehicleInfos.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo info : vehicleInfos) {
                final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                        info.getNumberOfMiles(), info.isDiesel());
                final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());

                final int totalCost = calculator.calculate(vehicle, formula);

                final InsuranceCalculationResult result = new InsuranceCalculationResult(info.getId(),
                        info.getVehicleTypeName(), totalCost);

                resultList.add(result);
            }
        }

        return resultList;
    }

    public InsuranceCalculationResult calculateById(String id) {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final VehicleInfo vehicleInfo = vehicleInfoDao.getVehicleById(id);
        InsuranceCalculationResult result = null;

        if (vehicleInfo == null) {
            return null;
        } else {
            final Vehicle vehicle = getVehicle(vehicleInfo.getVehicleTypeName(), vehicleInfo.getAge(),
                    vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
            final Formula formula = Formula.valueOf(vehicleInfo.getVehicleTypeFormula());
            final int totalCost = calculator.calculate(vehicle, formula);
            result = new InsuranceCalculationResult(vehicleInfo.getId(), vehicleInfo.getVehicleTypeName(), totalCost);
        }

        return result;
    }

    public List<InsuranceCalculationResult> getCostsHigherThan(double cost) {
        return calculateAll()
                .stream()
                .filter(i -> i.getCost() > cost)
                .collect(Collectors.toList());
    }
}
