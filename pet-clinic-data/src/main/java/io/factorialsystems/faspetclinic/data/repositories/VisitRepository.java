package io.factorialsystems.faspetclinic.data.repositories;

import io.factorialsystems.faspetclinic.data.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
