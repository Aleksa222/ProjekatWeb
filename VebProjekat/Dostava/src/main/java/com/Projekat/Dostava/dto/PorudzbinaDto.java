package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PorudzbinaDto {
    Set<Artikal_za_Porudzbinu> poruceniArtikli = new HashSet<>();
    Restoran restoran;
    String datumIVreme;
    double cena;
    Enum_status status;
    String korisnickoIme;

    public PorudzbinaDto(Set<Artikal_za_Porudzbinu> poruceniArtikli, Restoran restoran, double cena, Enum_status status, String korisnickoIme) {
        this.poruceniArtikli = poruceniArtikli;
        this.restoran = restoran;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        datumIVreme = dtf.format(now);
        this.datumIVreme = datumIVreme;
        this.cena = cena;
        this.status = status;
        this.korisnickoIme = korisnickoIme;
    }

    public PorudzbinaDto(Porudzbina porudzbina){
        this.poruceniArtikli = porudzbina.getPoruceno();
        this.restoran = porudzbina.getRestoran();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        datumIVreme = dtf.format(now);
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

    public String getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(String datumIVreme) {
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
