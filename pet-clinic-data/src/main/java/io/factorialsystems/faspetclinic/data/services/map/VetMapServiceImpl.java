package io.factorialsystems.faspetclinic.data.services.map;

import io.factorialsystems.faspetclinic.data.model.Vet;
import io.factorialsystems.faspetclinic.data.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapServiceImpl extends AbstractMapService<Vet, Long> implements VetService {
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
