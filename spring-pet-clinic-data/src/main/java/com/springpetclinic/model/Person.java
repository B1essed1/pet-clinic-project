package com.springpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity
{
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
