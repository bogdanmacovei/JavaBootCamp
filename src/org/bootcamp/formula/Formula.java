package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public enum Formula {
    CAR_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 100 * vehicle.getAge();
            cost += (vehicle.isDiesel()) ? 500 : 0;
            cost += (vehicle.getNumberOfMiles() > 200000) ? 500 : 0;
            return cost;
        }
    },

    BUS_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 200 * vehicle.getAge();
            cost += (vehicle.isDiesel()) ? 1000 : 0;

            if (vehicle.getNumberOfMiles() > 100000 && vehicle.getNumberOfMiles() <= 200000) {
                cost += 500;
            } else if (vehicle.getNumberOfMiles() > 200000) {
                cost += 1000;
            }

            return cost;
        }
    },

    TIPPER_BASIC_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 300 * vehicle.getAge();
            cost += (vehicle.getNumberOfMiles() > 80000) ? 700 : 0;

            return cost;
        }
    },

    CAR_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return (int)(CAR_BASIC_FORMULA.calculate(vehicle) * 0.95);
        }
    },

    BUS_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return (int)(BUS_BASIC_FORMULA.calculate(vehicle) * 0.9);
        }
    },

    TIPPER_CHRISTMAS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            return (int)(TIPPER_BASIC_FORMULA.calculate(vehicle) * 0.85);
        }
    };

    Formula() {

    }

    public abstract int calculate(Vehicle vehicle);
}
