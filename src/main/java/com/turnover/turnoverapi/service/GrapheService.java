package com.turnover.turnoverapi.service;

import com.turnover.turnoverapi.entity.*;
import com.turnover.turnoverapi.entity.dao.Graphe;
import com.turnover.turnoverapi.repository.CentrecoutRepository;
import com.turnover.turnoverapi.repository.DepartRepository;
import com.turnover.turnoverapi.repository.OFSTurnoverRepository;
import com.turnover.turnoverapi.utils.CalculateTurnover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GrapheService {

    private final DepartRepository departRepository;
    private final OFSTurnoverRepository ofsturnoverRepository;
    private final CentrecoutRepository centrecoutRepository;

    @Autowired
    public GrapheService(DepartRepository departRepository, OFSTurnoverRepository ofsturnoverRepository,CentrecoutRepository centrecoutRepository) {
        this.departRepository = departRepository;
        this.ofsturnoverRepository = ofsturnoverRepository;
        this.centrecoutRepository = centrecoutRepository;

    }

    public List<Graphe> getGroupByDepartement() {
        List<Depart> departs = this.departRepository.findAll();

        Map<Departement, Long> counted = departs.stream().collect(Collectors.groupingBy(Depart::getDepartement, Collectors.counting()));

        List<Graphe> graphes = new ArrayList<>();
        for (var entry : counted.entrySet()) {
            Graphe graphe = new Graphe();
            graphe.setCategorie(entry.getKey().getNom());
            graphe.setValeurY(entry.getValue().doubleValue());
            graphes.add(graphe);
        }
        graphes.sort(Comparator.comparing(Graphe::getValeurY));
        return graphes;
    }

    public List<Graphe> getGroupByCentreCout() {
        List<Depart> departs = this.departRepository.findAll();
        OFSTurnover ofsTurnover = this.ofsturnoverRepository.findByCategorieEquals("secteur");

        Map<Centrecout, Long> counted = departs.stream().collect(Collectors.groupingBy(Depart::getCentrecout, Collectors.counting()));

        List<Graphe> graphes = new ArrayList<>();

        for (var entry : counted.entrySet()) {
            Graphe graphe = new Graphe();
            graphe.setCategorie(entry.getKey().getCode());
            graphe.setLabelX(entry.getKey().getNom());

            // effectif du début
            Double turnover = CalculateTurnover.turnover(entry.getValue().doubleValue(), entry.getKey().getEffectif().doubleValue());
            graphe.setValeurY(turnover);

            graphe.setOfsTaux(ofsTurnover.getTaux());
            graphes.add(graphe);
        }
        graphes.sort(Comparator.comparing(Graphe::getValeurY));
        return graphes;
    }

    public List<Graphe> getAllRaisonByCentreCout(String code) {
        List<Depart> departs = this.departRepository.findAllByCentrecoutCode(code);
        List<Raison> raisons = new ArrayList<>();
        for (Depart depart : departs) {
            raisons.add(depart.getRaison());
        }

        Map<String, Long> counters = raisons.stream().collect(Collectors.groupingBy(Raison::getRaisonOFS, Collectors.counting()));
        List<Graphe> graphes = new ArrayList<>();
        for (Map.Entry<String, Long> entry : counters.entrySet()) {
            Graphe graphe = new Graphe();
            graphe.setCategorie(entry.getKey());
            graphe.setValeurY(entry.getValue().doubleValue());
            graphes.add(graphe);
        }
        graphes.sort(Comparator.comparing(Graphe::getValeurY));
        return graphes;
    }

    public List<Graphe> getAllRaison() {
        List<Depart> departs = this.departRepository.findAll();
        List<Raison> raisons = new ArrayList<>();
        for (Depart depart : departs) {
            raisons.add(depart.getRaison());
        }
        Map<String, Long> counters = raisons.stream().collect(Collectors.groupingBy(Raison::getRaisonOFS, Collectors.counting()));
        List<Graphe> graphes = new ArrayList<>();

        for (Map.Entry<String, Long> entry : counters.entrySet()) {
            Graphe graphe = new Graphe();
            graphe.setCategorie(entry.getKey());
            graphe.setValeurY(entry.getValue().doubleValue());
            graphes.add(graphe);
        }
        graphes.sort(Comparator.comparing(Graphe::getValeurY));
        return graphes;
    }

    // retourne le taux de départ par raison comparé au taux ofs par raison
    public List<Graphe> getAllRaisonTauxCompare() {
        List<Depart> departs = this.departRepository.findAll();
        List<Raison> raisons = new ArrayList<>();
        for (Depart depart : departs) {
            raisons.add(depart.getRaison());
        }
        Map<String, Long> counters = raisons.stream().collect(Collectors.groupingBy(Raison::getRaisonOFS, Collectors.counting()));
        List<Centrecout> centrecouts = this.centrecoutRepository.findAll();
        Integer totalEffectif = 0;
        for (Centrecout cc : centrecouts) {
            totalEffectif = totalEffectif + cc.getEffectif();
        }

        List<Graphe> graphes = new ArrayList<>();

        for (Map.Entry<String, Long> entry : counters.entrySet()) {
            Graphe graphe = new Graphe();
            graphe.setCategorie(entry.getKey());
            Double turnover = CalculateTurnover.turnover(entry.getValue().doubleValue(), totalEffectif.doubleValue());
            graphe.setValeurY(turnover);
            OFSTurnover ofsTurnover = this.ofsturnoverRepository.findByCategorieEquals(entry.getKey());
            graphe.setOfsTaux(ofsTurnover.getTaux());
            graphes.add(graphe);
        }
        return graphes;
    }

}
