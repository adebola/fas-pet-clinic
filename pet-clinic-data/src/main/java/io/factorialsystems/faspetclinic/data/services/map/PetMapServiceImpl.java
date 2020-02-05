package io.factorialsystems.faspetclinic.data.services.map;

import io.factorialsystems.faspetclinic.data.model.Pet;
import io.factorialsystems.faspetclinic.data.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapServiceImpl extends AbstractMapService<Pet, Long> implements BaseService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.deleteByObject(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
