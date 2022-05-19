package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idRestoran;

    @Column
    private String Naziv;

    @Column
    private String Tip_restorana ;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Artikal> Artikli = new HashSet<Artikal>();

    @OneToOne
    @JoinColumn(name = "lokacija_id",referencedColumnName = "idLokacija")
    private Lokacija Lokacija;

    public Restoran(){}

    public Restoran(String naziv,String tip_restorana, Set<Artikal> artikli, Lokacija lokacija){
        this.Naziv = naziv;
        this.Tip_restorana = tip_restorana;
        this.Artikli = artikli;
        this.Lokacija = lokacija;
    }

    public Long getIdRestoran(){return idRestoran;}

    public void setIdRestoran(Long idRestorana){this.idRestoran = idRestorana;}

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public String getTip_restorana() {
        return Tip_restorana;
    }

    public void setTip_restorana(String tip_restorana) {
        Tip_restorana = tip_restorana;
    }

    public Set<Artikal> getArtikli() {
        return Artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.Artikli = artikli;
    }

    public Lokacija getLokacija(){return Lokacija;}

    public void setLokacija(Lokacija lokacija){this.Lokacija = lokacija;}
}
