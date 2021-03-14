package com.springpetclinic.bootstrap;

import com.springpetclinic.model.Owner;
import com.springpetclinic.model.Vet;
import com.springpetclinic.service.OwnerService;
import com.springpetclinic.service.PetService;
import com.springpetclinic.service.VetService;
import com.springpetclinic.service.map.OwnerServiceMap;
import com.springpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Gundogan");
        owner1.setLastName("Ilkay");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Leo");
        owner2.setLastName("Messi");


        ownerService.save(owner2);

        Vet vet1 =  new Vet();
        vet1.setFirstName("McTominay");
        vet1.setLastName("Scott");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setLastName("Suarez");
        vet2.setFirstName("Luiz");

        vetService.save(vet2);


    }
}
