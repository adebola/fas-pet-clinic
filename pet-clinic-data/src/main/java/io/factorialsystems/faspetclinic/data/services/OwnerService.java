package io.factorialsystems.faspetclinic.data.services;

import io.factorialsystems.faspetclinic.data.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
