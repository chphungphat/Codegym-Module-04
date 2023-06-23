package com.codegym.customermanagementjpa.service;

import com.codegym.customermanagementjpa.model.Customer;
import com.codegym.customermanagementjpa.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService extends GeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
