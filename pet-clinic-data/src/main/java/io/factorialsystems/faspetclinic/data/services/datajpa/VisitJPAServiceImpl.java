package io.factorialsystems.faspetclinic.data.services.datajpa;

import io.factorialsystems.faspetclinic.data.model.Visit;
import io.factorialsystems.faspetclinic.data.repositories.VisitRepository;
import io.factorialsystems.faspetclinic.data.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile("springdatajpa")
public class VisitJPAServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitJPAServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
