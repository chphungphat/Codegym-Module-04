package com.codegym.repository;

import com.codegym.model.Customer;

public interface CustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
