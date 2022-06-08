package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Enum_pol;
import com.Projekat.Dostava.entity.Porudzbina;

import java.util.Date;
import java.util.Set;

public class DostavljacDto {
    private String Korisnicko_ime, Lozinka, Ime, Prezime;
    private Enum_pol pol;
    private Date datum;
    private Set<Porudzbina> porudzbine;

    public DostavljacDto(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum, Set<Porudzbina> porudzbine) {
        Korisnicko_ime = korisnicko_ime;
        Lozinka = lozinka;
        Ime = ime;
        Prezime = prezime;
        this.pol = pol;
        this.datum = datum;
        this.porudzbine = porudzbine;
    }

    public String getKorisnicko_ime() {
        return Korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        Korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public Enum_pol getPol() {
        return pol;
    }

    public void setPol(Enum_pol pol) {
        this.pol = pol;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
