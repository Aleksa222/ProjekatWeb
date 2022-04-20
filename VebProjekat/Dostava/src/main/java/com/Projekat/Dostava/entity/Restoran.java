package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String Ime;
    @Column
    private String Tip_restorana ;

   // private Set<Artikal> Artikli = new HashSet<Artikal>();//Skontati


    public Restoran() {
    }

    public Restoran(String ime, String tip_restorana) {
        Ime = ime;
        Tip_restorana = tip_restorana;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getTip_restorana() {
        return Tip_restorana;
    }

    public void setTip_restorana(String tip_restorana) {
        Tip_restorana = tip_restorana;
    }

    /*public Set<Artikal> getArtikli() {
        return Artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        Artikli = artikli;
    }*/
}
