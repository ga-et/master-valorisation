package com.turnover.turnoverapi.controller;

import com.turnover.turnoverapi.entity.Depart;
import com.turnover.turnoverapi.entity.OFSTurnover;
import com.turnover.turnoverapi.service.GrapheService;
import com.turnover.turnoverapi.service.OFSTurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OFSTurnoverController {

    private final OFSTurnoverService ofsTurnoverService;

    @Autowired
    public OFSTurnoverController(OFSTurnoverService ofsTurnoverService) {
        this.ofsTurnoverService = ofsTurnoverService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/ofs/categorie/{cat}")
    public OFSTurnover getDepartBetween(@PathVariable String cat) {
        return ofsTurnoverService.findByCategorie(cat);
    }
}
