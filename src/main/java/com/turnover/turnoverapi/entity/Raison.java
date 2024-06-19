package com.turnover.turnoverapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Raison")
public class Raison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    private String raisonOFS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getRaisonOFS() {
        return raisonOFS;
    }

    public void setRaisonOFS(String raisonOFS) {
        this.raisonOFS = raisonOFS;
    }
}
