package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "customers_addresses")
public class Customer_Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "customer_customer_id",referencedColumnName = "customer_id")
//    @JsonBackReference
    private Customer customer;

//    @ManyToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "address_address_id",referencedColumnName = "address_id")
//    @JsonBackReference
    private Address address;

    public Customer_Address(Long id, Customer customer, Address address) {
        this.id = id;
        this.customer = customer;
        this.address = address;
    }

    public Customer_Address() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
