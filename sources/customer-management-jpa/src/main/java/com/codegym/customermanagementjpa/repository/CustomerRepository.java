package com.codegym.customermanagementjpa.repository;

import com.codegym.customermanagementjpa.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
