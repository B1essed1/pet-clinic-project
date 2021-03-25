package com.springpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "pets")
public class Pet extends  BaseEntity
{
    @Column(name = "name")
    String name;

    @ManyToOne
    @Column(name = "owner_id")
    Owner owner;

    @ManyToOne
    @Column(name = "pet_id")
    PetType petType;
    @Column(name = "birth_date")
    LocalDate bithday;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    Set<Visit> visits = new HashSet<>();

    public Owner getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBithday() {
        return bithday;
    }

    public void setBithday(LocalDate bithday) {
        this.bithday = bithday;
    }

    public Set<Visit> getVisit() {
        return visits;
    }

    public void setVisit(Set<Visit> visits) {
        this.visits = visits;
    }
}
