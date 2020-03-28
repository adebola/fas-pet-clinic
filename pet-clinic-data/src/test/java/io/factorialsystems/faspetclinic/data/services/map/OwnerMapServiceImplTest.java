package io.factorialsystems.faspetclinic.data.services.map;

import io.factorialsystems.faspetclinic.data.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceImplTest {

    long ownerId = 1l;
    String firstName = "Adebola";
    String lastName = "Omoboya";
    String city = "lagos";
    OwnerMapServiceImpl ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapServiceImpl(new PetTypeMapServiceImpl(), new PetMapServiceImpl());
        ownerMapService.save(Owner.builder().id(ownerId).firstName(firstName).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().id(2l).build();
        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(2, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().firstName("Adebola").build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner adebola = ownerMapService.findByLastName(lastName);
        assertNotNull(adebola);
        assertEquals(1, adebola.getId());
        assertEquals("Adebola", adebola.getFirstName());
        assertEquals("Omoboya", adebola.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner notfound = ownerMapService.findByLastName("NotFound");
        assertNull(notfound);
    }
}
