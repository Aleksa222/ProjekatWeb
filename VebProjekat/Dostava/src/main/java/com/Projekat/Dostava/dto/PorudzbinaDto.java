package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PorudzbinaDto {
    Set<Artikal_za_Porudzbinu> poruceniArtikli = new HashSet<>();
    Restoran restoran;
    Date datumIVreme;
    double cena;
    Enum_status status;
    String korisnickoIme;

    public PorudzbinaDto(Set<Artikal_za_Porudzbinu> poruceniArtikli, Restoran restoran, Date datumIVreme, double cena, Enum_status status, String korisnickoIme) {
        this.poruceniArtikli = poruceniArtikli;
        this.restoran = restoran;
        this.datumIVreme = datumIVreme;
        this.cena = cena;
        this.status = status;
        this.korisnickoIme = korisnickoIme;
    }

    public PorudzbinaDto(Porudzbina porudzbina){
        this.poruceniArtikli = porudzbina.getPoruceno();
        this.restoran = porudzbina.getRestoran();
        this.datumIVreme = porudzbina.getDatum_i_vreme();
        this.cena = porudzbina.getCena();
        this.status = porudzbina.getStatus();
        this.korisnickoIme = porudzbina.getKupac().getIme();
    }

    public Set<Artikal_za_Porudzbinu> getPoruceniArtikli() {
        return poruceniArtikli;
    }

    public void setPoruceniArtikli(Set<Artikal_za_Porudzbinu> poruceniArtikli) {
        this.poruceniArtikli = poruceniArtikli;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Enum_status getStatus() {
        return status;
    }

    public void setStatus(Enum_status status) {
        this.status = status;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}
