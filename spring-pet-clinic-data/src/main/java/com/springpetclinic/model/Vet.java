package com.springpetclinic.model;

import jdk.jfr.DataAmount;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person
{

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(name = "vets_specialties",joinColumns = @JoinColumn(name = "vet_id"),
                    inverseJoinColumns =@JoinColumn(name = "specialty_id"))
    Set<Specialty> specialties = new HashSet<>();

}