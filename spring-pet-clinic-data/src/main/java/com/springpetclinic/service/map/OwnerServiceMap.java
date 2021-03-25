package com.springpetclinic.service.map;

import com.springpetclinic.model.Owner;
import com.springpetclinic.model.Pet;
import com.springpetclinic.service.CrudService;
import com.springpetclinic.service.OwnerService;
import com.springpetclinic.service.PetService;
import com.springpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByID(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {
        if (object !=null)
        {
            if (object.getPets() != null ) {
                object.getPets().forEach(pet -> {

                    if (pet.getPetType() !=null)
                    {
                        if (pet.getPetType().getId() == null)
                        {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else
                        {
                            throw  new RuntimeException("sertyuiopkjbhc vbn,.");
                        }

                    if (pet.getId() == null)
                    {
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());

                    }
                });
            }
            return super.save(object);
        }
        else return null;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
