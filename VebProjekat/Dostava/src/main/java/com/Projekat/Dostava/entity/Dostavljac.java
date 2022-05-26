package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Dostavljac extends Korisnik implements Serializable {


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDostavljaca",nullable = false)
    private Set<Porudzbina> porudzbine = new HashSet<>();


    public Dostavljac(){this.uloga = Enum_uloga.DOSTAVLJAC;}

    public Dostavljac(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum, Set<Porudzbina> porudzbine){
        super(korisnicko_ime,lozinka,ime,prezime,pol,datum,Enum_uloga.DOSTAVLJAC);
        this.porudzbine = porudzbine;
    }

    public Dostavljac(Korisnik k,Set<Porudzbina> porudzbine){
        super(k);
        this.porudzbine = porudzbine;
        this.uloga = Enum_uloga.DOSTAVLJAC;
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}
