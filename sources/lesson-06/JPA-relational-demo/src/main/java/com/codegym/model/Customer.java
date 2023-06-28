package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @OneToMany(targetEntity = Customer_Address.class, mappedBy = "customer")
    private List<Customer_Address> customerAddresses;

    public Customer(Long id, String firstName, String lastName, List<Customer_Address> customerAddresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddresses = customerAddresses;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Customer_Address> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(List<Customer_Address> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }
}
