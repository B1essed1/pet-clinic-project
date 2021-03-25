package com.springpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person
{
    @Column(name = "city")
    String city;
    @Column(name = "address")
    String address;
    @Column(name = "telephone")
    String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owners")
    Set<Pet> pets = new HashSet<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
