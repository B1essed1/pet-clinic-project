package com.springpetclinic.bootstrap;

import com.springpetclinic.model.*;
import com.springpetclinic.service.OwnerService;
import com.springpetclinic.service.PetTypeService;
import com.springpetclinic.service.SpecialtyService;
import com.springpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{
     private final OwnerService ownerService;
     private final VetService vetService;
     private final PetTypeService petTypeService;
     private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        dataLoader();


    }

    private void dataLoader() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology  = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery  = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry  = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Gundogan");
        owner1.setLastName("Ilkay");
        owner1.setAddress("bakers Street 223b ");
        owner1.setCity("London");
        owner1.setPhoneNumber("123548965");
        Pet Ilkayspet = new Pet();
        Ilkayspet.setPetType(savedDogPetType);
        Ilkayspet.setOwner(owner1);
        Ilkayspet.setBithday(LocalDate.now());
        Ilkayspet.setName("alibobo");
        owner1.getPets().add(Ilkayspet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Leo");
        owner2.setLastName("Messi");
        owner2.setCity("London");
        owner2.setPhoneNumber("65415465321");
        owner2.setAddress("Hattington 223b");
        Pet leosPet = new Pet();
        leosPet.setName("kabooom ");
        leosPet.setPetType(savedCatPetType);
        leosPet.setOwner(owner2);
        leosPet.setBithday(LocalDate.now());
        owner2.getPets().add(leosPet);

        ownerService.save(owner2);

        Vet vet1 =  new Vet();
        vet1.setFirstName("McTominay");
        vet1.setLastName("Scott");
        vet1.getSpecialties().add(dentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Suarez");
        vet2.setFirstName("Luiz");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);
    }
}
