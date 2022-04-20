package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Kupac extends Korisnik{


    private enum Ime{ZLATNI,SREBRNI,BRONZANI};//skontati
    @Column
    private double Popust;
    @Column
    private double Broj_bodova;

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
