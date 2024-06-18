package com.turnover.turnoverapi.repository;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DepartRepository extends JpaRepository<Depart, Long> {
    List<Depart> findAllByDateBetween(Timestamp start, Timestamp end);

    @Query("select d from Depart d where d.centrecout.code = ?1")
    List<Depart> findAllByCentrecoutCode(String centrecoutCode);
}
