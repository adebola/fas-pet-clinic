package io.factorialsystems.faspetclinic.data.services;

import io.factorialsystems.faspetclinic.data.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
