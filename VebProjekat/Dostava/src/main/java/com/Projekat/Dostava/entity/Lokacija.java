package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idLokacija;

    @Column
    private double Geografska_sirina;

    @Column
    private double Geografska_duzina;

    @Column
    private String Adresa;

    public Lokacija(){}

    public Lokacija(double geografska_sirina,double geografska_duzina,String adresa){
        this.Geografska_sirina = geografska_sirina;
        this.Geografska_duzina = geografska_duzina;
        this.Adresa = adresa;
    }

    public double getGeografska_sirina() {
        return Geografska_sirina;
    }

    public void setGeografska_sirina(double geografska_sirina) {
        Geografska_sirina = geografska_sirina;
    }

    public double getGeografska_duzina() {
        return Geografska_duzina;
    }

    public void setGeografska_duzina(double geografska_duzina) {
        Geografska_duzina = geografska_duzina;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }
}
