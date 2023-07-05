package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Customer_Address;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> findAll() {
        List<Customer> customers =customerRepository.findAll();
        List<Customer_Address> customerAddress = customers.get(0).getCustomerAddresses();
        return customers;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
