package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Komentar {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;
   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "Id_kupca", referencedColumnName = "Id")
    private Kupac kupac;//skontati
   // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "Id_restorana", referencedColumnName = "Id")
    //private Set<Restoran> restoran = new HashSet<Restoran>();//skontati
    @Column
    private String Tekst;
    @Column
    private int Ocena;

    public Komentar() {
    }

    public Komentar(Kupac kupac, String tekst, int ocena) {

        this.kupac = kupac;
        Tekst = tekst;
        Ocena = ocena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

   /* public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }*/

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
