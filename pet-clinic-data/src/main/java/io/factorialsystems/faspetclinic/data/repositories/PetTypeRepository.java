package io.factorialsystems.faspetclinic.data.repositories;

import io.factorialsystems.faspetclinic.data.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
