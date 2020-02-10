package io.factorialsystems.faspetclinic.web.bootstrap;

import io.factorialsystems.faspetclinic.data.model.Owner;
import io.factorialsystems.faspetclinic.data.model.Vet;
import io.factorialsystems.faspetclinic.data.services.OwnerService;
import io.factorialsystems.faspetclinic.data.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Adebola");
        owner1.setLastName("Omoboya");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Koyejo");
        owner2.setLastName("Omoboya");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Abiola");
        vet1.setLastName("Adekunle");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Mojisola");
        vet2.setLastName("Aguda");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
