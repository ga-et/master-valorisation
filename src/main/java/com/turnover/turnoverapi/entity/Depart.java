package com.turnover.turnoverapi.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Depart")
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String hrbp;

    @Column(nullable = false)
    private Date entree;

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String typecontrat;

    @Column(nullable = false)
    private double taux;

    @Column(nullable = false)
    private String lieutravail;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private double anciennete;

    @ManyToOne
    @JoinColumn(name = "raison_id")
    private Raison raison;

    @ManyToOne
    @JoinColumn(name = "societe_id")
    private Societe societe;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "centrecout_id")
    private Centrecout centrecout;

    @ManyToOne
    @JoinColumn(name = "entite_id")
    private Entite entite;

    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHrbp() {
        return hrbp;
    }

    public void setHrbp(String hrbp) {
        this.hrbp = hrbp;
    }

    public Date getEntree() {
        return entree;
    }

    public void setEntree(Date entree) {
        this.entree = entree;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getTypecontrat() {
        return typecontrat;
    }

    public void setTypecontrat(String typecontrat) {
        this.typecontrat = typecontrat;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public String getLieutravail() {
        return lieutravail;
    }

    public void setLieutravail(String lieutravail) {
        this.lieutravail = lieutravail;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public double getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(double anciennete) {
        this.anciennete = anciennete;
    }

    public Raison getRaison() {
        return raison;
    }

    public void setRaison(Raison raison) {
        this.raison = raison;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Centrecout getCentrecout() {
        return centrecout;
    }

    public void setCentreCout(Centrecout centrecout) {
        this.centrecout = centrecout;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }
}
