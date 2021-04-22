package com.springpetclinic.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "specialties")
public class Specialty extends BaseEntity {
    @Column(name = "description")
    String description;

}
