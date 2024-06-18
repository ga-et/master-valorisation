package com.turnover.turnoverapi.repository;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.OFSTurnover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OFSTurnoverRepository extends JpaRepository<OFSTurnover, Long> {

    OFSTurnover findByCategorieEquals(String categorie);
}
