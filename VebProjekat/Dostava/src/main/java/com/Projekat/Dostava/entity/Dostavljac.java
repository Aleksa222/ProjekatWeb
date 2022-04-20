package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Dostavljac extends Korisnik{


    @Column
    private String porudzbine;





    public Dostavljac(String porudzbine) {
        this.porudzbine = porudzbine;
    }

    public Dostavljac() {
    }

    public String getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(String porudzbine) {
        this.porudzbine = porudzbine;
    }
}
