package com.turnover.turnoverapi.repository;

import com.turnover.turnoverapi.entity.Depart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartRepository extends JpaRepository<Depart, Long> {
    List<Depart> findAllByType(String name);
}
