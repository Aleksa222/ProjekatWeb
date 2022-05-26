package com.Projekat.Dostava.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Artikal_za_Porudzbinu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_ArtikalzaP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artikal")
    private Artikal artikal;

    @Column
    private int broj;

    public Artikal_za_Porudzbinu(){}

    public Artikal_za_Porudzbinu(Artikal artikal,int broj){
        this.artikal = artikal;
        this.broj = broj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Long getId_ArtikalzaP() {
        return id_ArtikalzaP;
    }

    public void setId_stavke(Long id_ArtikalzaP) {
        this.id_ArtikalzaP = id_ArtikalzaP;
    }
}



