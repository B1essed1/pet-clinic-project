package com.springpetclinic.service.map;

import com.springpetclinic.model.Visit;
import com.springpetclinic.service.VisitService;

import java.util.Set;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void delete(Visit object)
    {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object)
    {
        return super.save(object);
    }

    @Override
    public Visit findByID(Long aLong) {
        return super.findById(aLong);
    }
}
