package com.turnover.turnoverapi.service;

import com.turnover.turnoverapi.entity.OFSTurnover;
import com.turnover.turnoverapi.entity.dao.Graphe;
import com.turnover.turnoverapi.repository.OFSTurnoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OFSTurnoverService {

    private final OFSTurnoverRepository ofsTurnoverRepository;

    @Autowired
    public OFSTurnoverService(OFSTurnoverRepository ofsTurnoverRepository) {
        this.ofsTurnoverRepository = ofsTurnoverRepository;
    }

    public OFSTurnover findByCategorie(String categorie){
        return ofsTurnoverRepository.findByCategorieEquals(categorie);
    }
}
