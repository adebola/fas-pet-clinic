package io.factorialsystems.faspetclinic.data.services.datajpa;

import io.factorialsystems.faspetclinic.data.model.PetType;
import io.factorialsystems.faspetclinic.data.repositories.PetTypeRepository;
import io.factorialsystems.faspetclinic.data.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJPAServiceImpl implements PetTypeService {

    private final PetTypeRepository typeRepository;

    public PetTypeJPAServiceImpl(PetTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new HashSet<>();
        typeRepository.findAll().forEach(types::add);
        return types;
    }

    @Override
    public PetType findById(Long id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return typeRepository.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        typeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }
}
