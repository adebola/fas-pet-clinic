package io.factorialsystems.faspetclinic.data.services.map;

import io.factorialsystems.faspetclinic.data.model.Specialty;
import io.factorialsystems.faspetclinic.data.model.Vet;
import io.factorialsystems.faspetclinic.data.services.SpecialtyService;
import io.factorialsystems.faspetclinic.data.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    @Autowired
    public VetMapServiceImpl(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (vet == null ) {
            return null;
        } else {
            if (vet.getSpecialties().size() > 0 ) {
                vet.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
        }

        return super.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        super.deleteByObject(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
