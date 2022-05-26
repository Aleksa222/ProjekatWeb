package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Artikal implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idArtikla;


    @Column
    private String naziv;

    @Column
    private double Cena;

    @Enumerated(EnumType.STRING)
    @Column
    private Enum_tip tip;


    @Column
    private double kolicina;


    @Column
    private String Opis;


    public Artikal(String naziv, double cena, Enum_tip tip, double kolicina, String opis) {
        this.naziv = naziv;
        Cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        Opis = opis;
    }

    public Artikal(){

    }

    public Long getId() {
        return IdArtikla;
    }

    public void setId(Long id) {
        IdArtikla = id;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {return Cena;}

    public void setCena(double cena) {
        Cena = cena;
    }

    public Enum_tip getTip() {
        return tip;
    }

    public void setTip(Enum_tip tip) {
        this.tip = tip;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }
}
