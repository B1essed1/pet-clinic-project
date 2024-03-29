package com.springpetclinic.service.springdatajpa;

import com.springpetclinic.model.Specialty;
import com.springpetclinic.repository.SpecialtyRepository;
import com.springpetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService
{
     private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository)
    {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Specialty> findAll()
    {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findByID(Long aLong)
    {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(aLong);
        return specialtyOptional.orElse(null);
    }

    @Override
    public Specialty save(Specialty object)
    {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object)
    {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        specialtyRepository.deleteById(aLong);
    }
}
