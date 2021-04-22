package com.springpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "pets")
public class Pet extends  BaseEntity
{
    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits == null || visits.size() > 0 ) {
            this.visits = visits;
        }
    }
    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    Owner owner;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    PetType petType;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    Set<Visit> visits = new HashSet<>();


}
