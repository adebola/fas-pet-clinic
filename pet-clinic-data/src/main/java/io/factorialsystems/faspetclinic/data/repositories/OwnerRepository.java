package io.factorialsystems.faspetclinic.data.repositories;

import io.factorialsystems.faspetclinic.data.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
