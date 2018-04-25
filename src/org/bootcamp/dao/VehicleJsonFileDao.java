package org.bootcamp.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VehicleJsonFileDao implements VehicleInfoDao {

    final private Map<String, VehicleInfo> vehicleInfoMap = new HashMap<>();

    public VehicleJsonFileDao(String filePath) {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<VehicleInfo> vehicleInfoList;
        try {
            final InputStream inputStream = new FileInputStream(new File(filePath));
            vehicleInfoList = objectMapper.readValue(inputStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, VehicleInfo.class));
            for (VehicleInfo info: vehicleInfoList) {
                vehicleInfoMap.put(info.getId(), info);
            }
        } catch (Exception e) {
            /*throw new IllegalStateException("Can not create instance of class "
                    + VehicleJsonFileDao.class.getSimpleName());*/
            e.printStackTrace();
        }
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        return new ArrayList<>(vehicleInfoMap.values());
    }

    @Override
    public VehicleInfo getVehicleById(String id) {
        return vehicleInfoMap.get(id);
    }
}