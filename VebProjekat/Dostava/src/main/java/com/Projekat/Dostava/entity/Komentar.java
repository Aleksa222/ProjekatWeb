package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Komentar implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Long idKomentar;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Kupac_Komentar", referencedColumnName = "Id")
    private Kupac kupac;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Restoran_Komentar", referencedColumnName = "idRestoran")
    private Restoran restoran;


    @Column
    private String Tekst;

    @Column
    private int Ocena;

    public Komentar(){};

    public Komentar(Kupac k,Restoran r,String tekst,int ocena){
        this.kupac = k;
        this.restoran = r;
        this.Tekst = tekst;
        this.Ocena = ocena;

    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Long getIdKomentar(){return idKomentar;}

    public void setIdKomentar(Long idKomentar){this.idKomentar = idKomentar;}

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public String getTekst() {
        return Tekst;
    }

    public void setTekst(String tekst) {
        Tekst = tekst;
    }

    public int getOcena() {
        return Ocena;
    }

    public void setOcena(int ocena) {
        Ocena = ocena;
    }
}
