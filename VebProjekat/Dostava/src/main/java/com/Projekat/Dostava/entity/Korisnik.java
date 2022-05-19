package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "KORISNIK")
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "KorisnickoIme",unique = true, nullable = false)
    protected String Korisnicko_ime;

    @Column(name = "Lozinka",nullable = false)
    protected String Lozinka;

    @Column(name="Ime", nullable = false)
    protected String Ime;

    @Column(name="Prezime", nullable = false)
    protected String Prezime;

    @Enumerated(EnumType.STRING)
    @Column(name = "Pol", nullable = false)
    protected Enum_pol pol;

    @Temporal(TemporalType.DATE)
    protected Date Datum_rodjenja;

    @Enumerated(EnumType.STRING)
    @Column(name = "Uloga", nullable = false)
    protected Enum_uloga uloga;

    public Korisnik() {
    }

    public Korisnik(Enum_uloga uloga){
        this.uloga = uloga;
    }

    public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum_rodjenja,Enum_uloga uloga) {
        this.Korisnicko_ime = korisnicko_ime;
        this.Lozinka = lozinka;
        this.Ime = ime;
        this.Prezime = prezime;
        this.pol = pol;
        this.Datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
    }

    public Korisnik(Korisnik k){
        Korisnicko_ime = k.getKorisnicko_ime();
        Lozinka = k.getLozinka();
        Ime = k.getIme();
        Prezime = k.getPrezime();
        pol = k.getPol();
        Datum_rodjenja = k.getDatum_rodjenja();
        uloga = k.getUloga();
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

    public Date getDatum_rodjenja() {
        return Datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        Datum_rodjenja = datum_rodjenja;
    }

    public Enum_uloga getUloga() {
        return uloga;
    }

    public void setUloga(Enum_uloga uloga) {
        this.uloga = uloga;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "Id=" + Id +
                ", korisnicko ime='" + Korisnicko_ime + '\'' +
                ", lozinka='" + Lozinka + '\'' +
                ", ime='" + Ime + '\'' +
                ", prezime='" + Prezime + '\'' +
                ", pol=" + pol +
                ", datum rodjenja=" + Datum_rodjenja +
                ", uloga=" + uloga +
                '}';
    }
}

