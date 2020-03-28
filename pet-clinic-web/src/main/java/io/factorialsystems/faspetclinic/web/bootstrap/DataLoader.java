package io.factorialsystems.faspetclinic.web.bootstrap;

import io.factorialsystems.faspetclinic.data.model.*;
import io.factorialsystems.faspetclinic.data.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (petTypeService.findAll().size() == 0)
            LoadMapData();
    }

    private void LoadMapData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedDog = petTypeService.save(dog);
        PetType savedCat = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Adebola");
        owner1.setLastName("Omoboya");
        owner1.setAddress("25 Valerian, Northern Foreshore Estate");
        owner1.setCity("Lagos");
        owner1.setTelephone("08055572307");
        ownerService.save(owner1);

        Pet pet1 = new Pet();
        pet1.setPetType(savedDog);
        pet1.setName("Bingo");
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        petService.save(pet1);
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Koyejo");
        owner2.setLastName("Omoboya");
        owner2.setAddress("123 Illford Road");
        owner2.setCity("London");
        owner2.setTelephone("+447912 448 790");
        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setPetType(savedCat);
        pet2.setName("Tabby");
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);
        petService.save(pet2);

        Visit catVisit = new Visit();
        catVisit.setPet(pet2);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Plenty Talk");
        visitService.save(catVisit);

        Owner owner3 = Owner.builder().address("25 Valerian, Northern Forshore Estate")
                .city("Lagos").telephone("08055572307").firstName("Adebola").lastName("Omoboya").build();

        ownerService.save(owner3);
        Pet pet3 = Pet.builder().petType(savedCat).birthDate(LocalDate.now()).name("Who Knows").owner(owner3).build();
        owner3.getPets().add(pet3);
        petService.save(pet3);
        Visit visit = Visit.builder().pet(pet3).date(LocalDate.now()).description("had to Visit").build();
        visitService.save(visit);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Abiola");
        vet1.setLastName("Adekunle");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mojisola");
        vet2.setLastName("Aguda");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
