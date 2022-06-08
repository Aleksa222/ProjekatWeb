package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Enum_pol;

import java.util.Date;

public class IzmenaPodatakaDto {
    private String Korisnicko_ime, Lozinka, Ime, Prezime;
    private Enum_pol pol;
    private Date datum;

    public IzmenaPodatakaDto(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum) {
        Korisnicko_ime = korisnicko_ime;
        Lozinka = lozinka;
        Ime = ime;
        Prezime = prezime;
        this.pol = pol;
        this.datum = datum;
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
}
