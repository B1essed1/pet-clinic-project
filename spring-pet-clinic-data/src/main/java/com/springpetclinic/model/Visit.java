package com.springpetclinic.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit extends BaseEntity
{
    @Column(name = "date")
    LocalDate date;
    @Column(name = "description")
    String description;
    @ManyToOne
            @JoinTable(name = "pet_id")
    Pet pet;

}
