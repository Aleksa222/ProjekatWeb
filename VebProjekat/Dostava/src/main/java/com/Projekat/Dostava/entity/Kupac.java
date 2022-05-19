package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @OneToMany(mappedBy = "kupac",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Porudzbina> Porudzbine = new HashSet<>();

    @Column(name = "BrojSakupljenihBodova")
    private int Broj_bodova;

    @ManyToOne
    @JoinColumn(name = "TitulaId")
    private Titula titula;

    public Kupac(){this.uloga = Enum_uloga.KUPAC;}

    public Kupac(Korisnik k,Set<Porudzbina> porudzbine,int broj_bodova,Titula t){
        super(k);
        this.Porudzbine = porudzbine;
        this.Broj_bodova = broj_bodova;
        this.titula = t;
        this.uloga = Enum_uloga.KUPAC;
    }

    public Set<Porudzbina> getPorudzbine(){return Porudzbine;}

    public void setPorudzbine(Set<Porudzbina> porudzbine){this.Porudzbine = porudzbine;}

    public double getBroj_bodova() {
        return Broj_bodova;
    }

    public void setBroj_bodova(int broj_bodova) {
        Broj_bodova = broj_bodova;
    }

    public Titula getTitula(){return titula;}

    public void setTitula(Titula titula){this.titula = titula;}
}
