package com.turnover.turnoverapi.controller;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.Product;
import com.turnover.turnoverapi.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartController {
    private final DepartService departService;

    @Autowired
    public DepartController(DepartService departService) {
        this.departService = departService;
    }

    /**
     * Get all depart.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of products
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/depart")
    public List<Depart> getAllDepart() {
        return departService.getAllDepart();
    }

    /**@GetMapping("/depart/{type}")
    public List<Depart> getDepartByType(@PathVariable String type) {
        return departService.getDepartByType(type);
    }*/

    @GetMapping("/depart/between/{from}/{to}")
    public List<Depart> getDepartBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
        Timestamp timestampFrom = Timestamp.valueOf(from.atStartOfDay());
        Timestamp timestampTo = Timestamp.valueOf(to.atStartOfDay());
        return departService.getDepartBetween(timestampFrom, timestampTo);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/depart/centre/{code}")
    public List<Depart> getAllDepartByCentreCode(@PathVariable String code) {
        return departService.getDepartByCentreCode(code);
    }
}
