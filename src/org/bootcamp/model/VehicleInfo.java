package org.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleInfo {
    private String id;
    private String vehicleTypeName;
    private String vehicleTypeFormula;
    private int age;
    private long numberOfMiles;
    @JsonProperty("diesel")
    private boolean isDiesel;

    private VehicleInfo() {
    }

    private VehicleInfo(String id, String vehicleTypeName, String vehicleTypeFormula, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.vehicleTypeFormula = vehicleTypeFormula;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public String getVehicleTypeFormula() {
        return vehicleTypeFormula;
    }

    public int getAge() {
        return age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public static final class Builder {
        private String id;
        private String vehicleTypeName;
        private String vehicleTypeFormula;
        private int age;
        private long numberOfMiles;
        private boolean isDiesel;

        private Builder() {

        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withVehicleTypeName(String vehicleTypeName) {
            this.vehicleTypeName = vehicleTypeName;
            return this;
        }

        public Builder withVehicleTypeFormula(String vehicleTypeFormula) {
            this.vehicleTypeFormula = vehicleTypeFormula;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withNumberOfMiles(long numberOfMiles) {
            this.numberOfMiles = numberOfMiles;
            return this;
        }

        public Builder withDiesel(boolean isDiesel) {
            this.isDiesel = isDiesel;
            return this;
        }

        public VehicleInfo build() {
            return new VehicleInfo(id, vehicleTypeName, vehicleTypeFormula, age, numberOfMiles, isDiesel);
        }

    }

}
