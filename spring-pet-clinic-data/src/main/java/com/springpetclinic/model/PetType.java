package com.springpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name ="types")
public class PetType extends BaseEntity
{
    @Builder
    public PetType(Long id ,String name)
    {
        super(id);
        this.name=name;
    }
    @Column(name = "name")
    String name;

    @Override
    public String toString() {
        return name;
    }
}
