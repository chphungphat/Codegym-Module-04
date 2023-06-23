package com.codegym.customermanagementjpa.service;

import com.codegym.customermanagementjpa.model.Customer;
import com.codegym.customermanagementjpa.model.Province;

public interface CustomerService extends GeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
