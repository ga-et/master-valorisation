package com.turnover.turnoverapi.repository;

import com.turnover.turnoverapi.entity.Centrecout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentrecoutRepository extends JpaRepository<Centrecout, Long> {
}
