package io.factorialsystems.faspetclinic.data.services.map;

import io.factorialsystems.faspetclinic.data.model.Owner;
import io.factorialsystems.faspetclinic.data.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapServiceImpl extends AbstractMapService<Owner, Long> implements BaseService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.deleteByObject(owner);
    }
}
