package com.turnover.turnoverapi.controller;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.Product;
import com.turnover.turnoverapi.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/depart")
    public List<Depart> getAllDepart() {
        return departService.getAllDepart();
    }

    @GetMapping("/depart/{type}")
    public List<Depart> getDepartByType(@PathVariable String type) {
        return departService.getDepartByType(type);
    }
}
