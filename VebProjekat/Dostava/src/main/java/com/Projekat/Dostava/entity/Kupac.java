package com.Projekat.Dostava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends Korisnik implements Serializable {

    @OneToMany(mappedBy = "kupac",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
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

    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum_rodjenja, int brojBodova) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja,Enum_uloga.KUPAC);
        this.Broj_bodova = brojBodova;
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
