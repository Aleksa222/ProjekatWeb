package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Enum_pol;
import com.Projekat.Dostava.entity.Korisnik;

import java.util.Date;

public class KorisnikDto {
    private String Korisnicko_ime, Lozinka, Ime, Prezime;
    private Enum_pol pol;
    private Date datum;

    public KorisnikDto(Korisnik k){
        this.Korisnicko_ime = k.getKorisnicko_ime();
        this.Lozinka = k.getLozinka();
        this.Ime = k.getIme();
        this.Prezime = k.getPrezime();
        this.pol = k.getPol();
        this.datum = k.getDatum_rodjenja();
    }

    public KorisnikDto(String korisnicko_ime,String lozinka,String ime, String prezime, Enum_pol pol){
        this.Korisnicko_ime = korisnicko_ime;
        this.Lozinka = lozinka;
        this.Ime = ime;
        this.Prezime = prezime;
        this.pol = pol;
        this.datum = new java.util.Date(System.currentTimeMillis());
    }

    public String getKorisnicko_ime(){
        return Korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime){
        this.Korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka(){
        return Lozinka;
    }

    public void setLozinka(String lozinka){
        this.Lozinka = lozinka;
    }

    public String getIme(){
        return Ime;
    }

    public void setIme(String ime){
        this.Ime = ime;
    }

    public String getPrezime(){
        return Prezime;
    }

    public void setPrezime(String prezime){
        this.Prezime = prezime;
    }

    public Enum_pol getPol(){
        return pol;
    }

    public void setPol(Enum_pol pol){
        this.pol = pol;
    }

    public Date getDatum(){
        return datum;
    }

    public void setDatum(Date datum){
        this.datum = datum;
    }
}
