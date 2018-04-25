package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class VehicleInfoPlainFileDao implements VehicleInfoDao {
    private static final String SEPARATOR = ";";
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;

    private final VehicleInfo.Builder builder = VehicleInfo.builder();
    private final Map<String, VehicleInfo> vehicleInfoMap = new HashMap<String, VehicleInfo>();

    public VehicleInfoPlainFileDao(String filePath) {
        VehicleInfo vehicleInfo;
        try {
            final File inputFile = new File(filePath);
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);

                vehicleInfo = builder.withId(tokens[VEHICLE_ID])
                        .withVehicleTypeName(tokens[VEHICLE_TYPE])
                        .withVehicleTypeFormula(tokens[VEHICLE_FORMULA])
                        .withAge(Integer.parseInt(tokens[VEHICLE_AGE]))
                        .withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES]))
                        .withDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]))
                        .build();

                vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo);
            }
            scanner.close();

        } catch (FileNotFoundException ex) {
            throw new IllegalStateException ("Can not create instance of class " +
                VehicleInfoPlainFileDao.class.getSimpleName());
        }
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        return new ArrayList<VehicleInfo>(vehicleInfoMap.values());
    }

    public VehicleInfo getVehicleById(String id) {
        return vehicleInfoMap.get(id);
    }
}
