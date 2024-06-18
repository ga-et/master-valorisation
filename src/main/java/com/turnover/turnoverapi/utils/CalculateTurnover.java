package com.turnover.turnoverapi.utils;

public class CalculateTurnover {

    public static Double turnover(Double nbDepart, Double effectifDebut) {
        return  nbDepart / effectifDebut * 100;
    }
}
