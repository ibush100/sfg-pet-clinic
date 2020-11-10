package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.service.OwnerService;
import com.example.sfgpetclinic.service.PetTypeService;
import com.example.sfgpetclinic.service.SpecialtyService;
import com.example.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

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

        int count =petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Cairo");
        PetType savedDogType = petTypeService.save(dog);


        PetType car = new PetType();
        dog.setName("Smokey");
        PetType savedCatType = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery= specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry= specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("1234 this address");
        owner1.setCity("a city");
        owner1.setTelephone("8675309");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setAddress("1234 this other address");
        owner1.setCity("another city");
        owner1.setTelephone("0985748593");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Pet tomsPet = new Pet();
        tomsPet.setPetType(savedCatType);
        tomsPet.setOwner(owner2);
        tomsPet.setBirthday(LocalDate.now());
        tomsPet.setName("smokey");
        owner2.getPets().add(tomsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);


        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
