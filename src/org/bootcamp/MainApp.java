package org.bootcamp;

public class MainApp {

    public static void main(String[] args) {
        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevesBus = new Bus (3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper (6, 80000, false, 15);

        int joesInsurancePolicyCost = 100 * joesCar.getAge();
        joesInsurancePolicyCost += (joesCar.isDiesel()) ? 500 : 0;
        joesInsurancePolicyCost += (joesCar.getNumberOfMiles() > 200000) ? 500 : 0;

        int stevesInsurancePolicyCost = 200 * stevesBus.getAge();
        stevesInsurancePolicyCost += (stevesBus.isDiesel()) ? 1000 : 0;

        if (stevesBus.getNumberOfMiles() > 100000 && stevesBus.getNumberOfMiles() <= 200000) {
            stevesInsurancePolicyCost += 500;
        }
        else if (stevesBus.getNumberOfMiles() > 200000) {
            stevesInsurancePolicyCost += 1000;
        }

        int petersInsurancePolicyCost = 300 * petersTipper.getAge();
        petersInsurancePolicyCost += (petersTipper.getNumberOfMiles() > 80000) ? 700 : 0;

        System.out.println("Joe's policy cost is " + joesInsurancePolicyCost);
        System.out.println("Steve's policy cost is " + stevesInsurancePolicyCost);
        System.out.println("Peter's policy cost is " + petersInsurancePolicyCost);
    }
}
