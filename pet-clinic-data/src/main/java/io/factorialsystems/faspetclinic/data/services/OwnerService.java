package io.factorialsystems.faspetclinic.data.services;

import io.factorialsystems.faspetclinic.data.model.Owner;

public interface OwnerService extends BaseService<Owner, Long> {

    Owner findByLastName(String lastName);
}
