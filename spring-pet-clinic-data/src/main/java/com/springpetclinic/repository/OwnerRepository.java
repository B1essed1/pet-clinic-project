package com.springpetclinic.repository;

import com.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long>
{
}
