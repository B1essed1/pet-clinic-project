package com.springpetclinic.repository;

import com.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long>
{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String name);
}
