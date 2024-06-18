package com.turnover.turnoverapi.controller;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.Raison;
import com.turnover.turnoverapi.entity.dao.Graphe;
import com.turnover.turnoverapi.service.DepartService;
import com.turnover.turnoverapi.service.GrapheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GrapheController {

    private final GrapheService grapheService;

    @Autowired
    public GrapheController(GrapheService grapheService) {
        this.grapheService = grapheService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/graphe/departement")
    public List<Graphe> getByDepartement() {
        return this.grapheService.getGroupByDepartement();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/graphe/centrecout")
    public List<Graphe> getByCentreCout() {
        return this.grapheService.getGroupByCentreCout();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/graphe/centrecout/{code}/raison")
    public List<Graphe> getAllRaisonByCentreCout(@PathVariable String code) {
        return this.grapheService.getAllRaisonByCentreCout(code);
    }
}
