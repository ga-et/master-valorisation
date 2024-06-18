package com.turnover.turnoverapi.entity.dao;

public class Graphe {
    private String categorie;

    private Double valeurX;

    private Double valeurY;

    private String labelX;

    private Double ofsTaux;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getValeurX() {
        return valeurX;
    }

    public void setValeurX(Double valeurX) {
        this.valeurX = valeurX;
    }

    public Double getValeurY() {
        return valeurY;
    }

    public void setValeurY(Double valeurY) {
        this.valeurY = valeurY;
    }

    public String getLabelX() {
        return labelX;
    }

    public void setLabelX(String labelX) {
        this.labelX = labelX;
    }

    public Double getOfsTaux() {
        return ofsTaux;
    }

    public void setOfsTaux(Double ofsTaux) {
        this.ofsTaux = ofsTaux;
    }
}
