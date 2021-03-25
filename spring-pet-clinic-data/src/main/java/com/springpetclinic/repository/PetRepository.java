package com.springpetclinic.repository;

import com.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long>
{

}
