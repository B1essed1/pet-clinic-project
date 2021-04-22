package com.springpetclinic.service.springdatajpa;

import com.springpetclinic.model.Visit;
import com.springpetclinic.repository.VisitRepository;
import com.springpetclinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class VisitSDJpaService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll()
    {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findByID(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        return visitOptional.orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object)
    {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        visitRepository.deleteById(aLong);
    }
}
