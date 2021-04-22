package com.springpetclinic.service.springdatajpa;

import com.springpetclinic.model.Pet;
import com.springpetclinic.repository.PetRepository;
import com.springpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class PetSDJpsService implements PetService {
    private  final PetRepository petRepository;

    public PetSDJpsService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findByID(Long aLong)
    {
        Optional<Pet> petOptional = petRepository.findById(aLong);
        return petOptional.orElse(null);
    }

    @Override
    public Pet save(Pet object)
    {

        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
petRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
