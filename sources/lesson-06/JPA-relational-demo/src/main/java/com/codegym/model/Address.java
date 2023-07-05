package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
//    @JsonManagedReference
    private List<Customer_Address> customerAddresses;

    public Address(Long id, String province, String country, List<Customer_Address> customerAddresses) {
        this.id = id;
        this.province = province;
        this.country = country;
        this.customerAddresses = customerAddresses;
    }

    public Address() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Customer_Address> getCustomerAddresses() {
        return customerAddresses;
    }

    @Transactional
    public void setCustomerAddresses(List<Customer_Address> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    @Override
    public String toString() {
        return this.getProvince() + " " + this.getCountry();
    }
}
