package org.bootcamp.service;

public final class InsuranceCalculationResult {
    private final String id;
    private final String vehicleTypeName;
    private final int cost;

    public InsuranceCalculationResult(String id, String vehicleTypeName, int cost) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public int getCost() {
        return cost;
    }
}
