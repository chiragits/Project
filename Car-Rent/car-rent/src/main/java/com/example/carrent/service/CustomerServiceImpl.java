package com.example.carrent.service;

import com.example.carrent.model.Customer;
import com.example.carrent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCustomer(String id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
