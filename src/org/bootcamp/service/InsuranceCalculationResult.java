package org.bootcamp.service;

public final class InsuranceCalculationResult {
    private final String id;
    private final int cost;

    public InsuranceCalculationResult(String id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}
