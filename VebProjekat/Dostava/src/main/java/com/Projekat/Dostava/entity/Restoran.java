package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long IdRestorana;
    @Column
    private String Ime;
    @Column
    private String Tip_restorana ;
    @Column
    private Set<Artikal> artikli = new HashSet<>();//Skontati


    public Restoran() {
    }

    public Restoran(String ime, String tip_restorana) {
        Ime = ime;
        Tip_restorana = tip_restorana;
    }
    public Long getId() {
        return IdRestorana;
    }

    public void setId(Long id) {
        IdRestorana = id;
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

    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }
}
