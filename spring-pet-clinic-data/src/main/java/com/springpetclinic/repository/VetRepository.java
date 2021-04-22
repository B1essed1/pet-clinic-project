package com.springpetclinic.repository;

import com.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;


public interface VetRepository extends CrudRepository<Vet,Long>
{
}
