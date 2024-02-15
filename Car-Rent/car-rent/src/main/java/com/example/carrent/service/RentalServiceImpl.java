package com.example.carrent.service;

import com.example.carrent.model.Rental;
import com.example.carrent.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public void rentVehicle(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental getRentalById(String id) {
        return rentalRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateRental(String id, Rental rental) {
        if (rentalRepository.existsById(id)) {
            rental.setId(id);
            rentalRepository.save(rental);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRental(String id) {
        if (rentalRepository.existsById(id)) {
            rentalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
