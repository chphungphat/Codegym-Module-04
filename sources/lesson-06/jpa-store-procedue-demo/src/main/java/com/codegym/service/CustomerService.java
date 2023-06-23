package com.codegym.service;

import com.codegym.model.Customer;

public interface CustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
