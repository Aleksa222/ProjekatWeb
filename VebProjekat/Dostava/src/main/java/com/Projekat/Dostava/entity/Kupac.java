package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Kupac extends Korisnik{


    private enum Ime{ZLATNI,SREBRNI,BRONZANI};//skontati
    @Column
    private double Popust;
    @Column
    private double Broj_bodova;

    public Kupac() {
    }

    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, String datum_rodjenja, double popust, double broj_bodova) {
        super(korisnicko_ime, lozinka, ime, prezime, datum_rodjenja);
        Popust = popust;
        Broj_bodova = broj_bodova;
    }

    public Kupac(double popust, double broj_bodova) {
        Popust = popust;
        Broj_bodova = broj_bodova;
    }

    public double getPopust() {
        return Popust;
    }

    public void setPopust(double popust) {
        Popust = popust;
    }

    public double getBroj_bodova() {
        return Broj_bodova;
    }

    public void setBroj_bodova(double broj_bodova) {
        Broj_bodova = broj_bodova;
    }
}
