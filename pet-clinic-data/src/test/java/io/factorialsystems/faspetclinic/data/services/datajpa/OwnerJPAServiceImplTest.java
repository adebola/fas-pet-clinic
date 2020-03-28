package io.factorialsystems.faspetclinic.data.services.datajpa;

import io.factorialsystems.faspetclinic.data.model.Owner;
import io.factorialsystems.faspetclinic.data.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceImplTest {

    public static final String FIRSTNAME = "Foluke";
    public static final String LASTNAME = "Omoboya";
    public static final long ID = 1;

    private Owner owner;
    private Set<Owner> owners = new HashSet<>();

    @Mock
    OwnerRepository ownerRepository;

   @InjectMocks
    OwnerJPAServiceImpl ownerService;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).firstName(FIRSTNAME).lastName(LASTNAME).build();
        owners.add(owner);
    }

    @Test
    void findByLastName() {
       when(ownerRepository.findByLastName(any())).thenReturn(owner);
       Owner adebola = ownerRepository.findByLastName(LASTNAME);
       assertEquals(ID, adebola.getId());
       assertEquals(LASTNAME, adebola.getLastName());
       verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        owners.add(Owner.builder().firstName("Koyejo").lastName("Omoboya").id(2l).build());
        owners.add(Owner.builder().firstName("Oyindamola").lastName("Omoboya").id(3l).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> owners = ownerService.findAll();
        assertEquals(3, owners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner returnedOwner = ownerService.findById(ID);
        assertEquals(ID, returnedOwner.getId());
    }

    @Test
    void findByIdNotFound() {

        //when(ownerRepository.findById(any())).thenReturn(null);
        Owner returnedOwner = ownerService.findById(ID);
        assertNull(returnedOwner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(4l).firstName("Enoch").lastName("Omoboya").build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerService.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerService.delete(owner);
        verify(ownerRepository, times(1)).delete(any());

    }

    @Test
    void deleteById() {
        ownerService.deleteById(ID);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}
