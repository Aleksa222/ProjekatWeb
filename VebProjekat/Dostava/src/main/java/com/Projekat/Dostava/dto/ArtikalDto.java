package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Enum_tip;

public class ArtikalDto {
    private String naziv;

    private double cena;

    private Enum_tip tip;

    private double kolicina;

    private String opis;

    public ArtikalDto() {
    }

    public ArtikalDto(String naziv, double cena, Enum_tip tip, double kolicina, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public ArtikalDto(Artikal artikal){
        this.naziv = artikal.getNaziv();
        this.cena = artikal.getCena();
        this.tip = artikal.getTip();
        this.kolicina = artikal.getKolicina();
        this.opis = artikal.getOpis();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
