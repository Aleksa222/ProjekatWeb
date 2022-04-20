package com.Projekat.Dostava.entity;


import javax.persistence.*;

@Entity
public class Menadzer extends Korisnik{



    @Column
    private Restoran restoran;

    public Menadzer() {
    }

    public Menadzer(Restoran restoran) {
        this.restoran = restoran;
    }

    public Restoran getRestoran(){
        return restoran;
    }

    public void setRestoran(Restoran restoran)
    {
        this.restoran = restoran;
    }
}

