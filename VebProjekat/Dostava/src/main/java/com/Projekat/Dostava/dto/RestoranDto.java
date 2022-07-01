package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Lokacija;
import com.Projekat.Dostava.entity.Restoran;

import java.util.Set;

public class RestoranDto {
    private String Naziv,Tip_restorana;
    private Set<Artikal> artikli;
    private Lokacija lokacija;

    public RestoranDto(String naziv, String tip_restorana) {
        Naziv = naziv;
        Tip_restorana = tip_restorana;
    }

    public RestoranDto(String naziv, String tip_restorana, Set<Artikal> artikli, Lokacija lokacija) {
        Naziv = naziv;
        Tip_restorana = tip_restorana;
        this.artikli = artikli;
        this.lokacija = lokacija;
    }

    public RestoranDto(Restoran restoran) {
        this.Naziv = restoran.getNaziv();
        this.Tip_restorana = restoran.getTip_restorana();
        this.artikli = restoran.getArtikli();
        this.lokacija = restoran.getLokacija();
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTip_restorana() {
        return Tip_restorana;
    }

    public void setTip_restorana(String tip_restorana) {
        Tip_restorana = tip_restorana;
    }

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public String toString() {
        return "RestoranDto{" +
                "Naziv='" + Naziv + '\'' +
                ", Tip_restorana='" + Tip_restorana + '\'' +
                ", artikli=" + artikli +
                ", lokacija=" + lokacija +
                '}';
    }
}
