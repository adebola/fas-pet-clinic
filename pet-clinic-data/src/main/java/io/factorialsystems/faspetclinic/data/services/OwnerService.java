package io.factorialsystems.faspetclinic.data.services;

import io.factorialsystems.faspetclinic.data.model.Owner;

import java.util.List;

public interface OwnerService extends BaseService<Owner, Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
