package com.example.carrent.service;

import com.example.carrent.model.Vehicle;
import com.example.carrent.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateVehicle(String id, Vehicle vehicle) {
        if (vehicleRepository.existsById(id)) {
            vehicle.setId(id);
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVehicle(String id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
