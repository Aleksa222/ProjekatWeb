package com.Projekat.Dostava.entity;


import javax.persistence.*;

@Entity
public class Menadzer extends Korisnik{



    @Column
    private String zaduzenje;

    public Menadzer() {
    }

    public Menadzer(String zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

    public String getZaduzenje() {
        return zaduzenje;
    }

    public void setZaduzenje(String zaduzenje) {
        this.zaduzenje = zaduzenje;
    }
}
