package io.factorialsystems.faspetclinic.data.repositories;

import io.factorialsystems.faspetclinic.data.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
