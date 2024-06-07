package com.turnover.turnoverapi.service;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.Product;
import com.turnover.turnoverapi.repository.DepartRepository;
import com.turnover.turnoverapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DepartService {

    private final DepartRepository departRepository;

    @Autowired
    public DepartService(DepartRepository departRepository) {
        this.departRepository = departRepository;
    }

    /**
     * Get all the departs.
     *
     * @return the list of entities
     */
    public List<Depart> getAllDepart() {
        return departRepository.findAll();
    }

    /**
     * Get one depart by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Depart> getDepartById(Long id) {
        return departRepository.findById(id);
    }

    public List<Depart> getDepartByType(String type) {
        return departRepository.findAllByType(type);
    }

    public List<Depart> getDepartBetween(Timestamp from, Timestamp to) {
        return departRepository.findAllByDateBetween(from, to);
    }
}
