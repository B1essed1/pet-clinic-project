package com.springpetclinic.service.map;

import com.springpetclinic.model.Specialty;
import com.springpetclinic.service.SpecialtyService;

import java.util.Set;

public class SpecialtyMapService extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id)
    {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object)
    {
        super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findByID(Long aLong) {
        return super.findById(aLong);
    }
}
