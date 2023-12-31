package com.codegym.service.impl;

import com.codegym.model.Address;
import com.codegym.repository.AddressRepository;
import com.codegym.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void save(Address address) {

    }

    @Override
    public void remove(Long id) {

    }
}
