package io.factorialsystems.faspetclinic.data.services;

import io.factorialsystems.faspetclinic.data.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById();
    Vet save(Vet vet);
    Set<Vet> findAll();
}
