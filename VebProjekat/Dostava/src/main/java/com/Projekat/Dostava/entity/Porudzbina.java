package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
@Entity
public class Porudzbina {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;
    @Column
    private int UUID;
  //  @Column
    //private ArrayList<Artikal> Poruceno;
   // @Column
   // private ArrayList<Restoran> Poruceno_iz;//jedna porudzbina jedan restoran
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum_i_vreme = new Date();
    @Column
    private double Cena;
    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private Kupac kupac;  //skontati

    @Enumerated(EnumType.STRING)
    private Enum_status status;

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }
/*
    public ArrayList<Artikal> getPoruceno() {
        return Poruceno;
    }

    public void setPoruceno(ArrayList<Artikal> poruceno) {
        Poruceno = poruceno;
    }

    public ArrayList<Restoran> getPoruceno_iz() {
        return Poruceno_iz;
    }

    public void setPoruceno_iz(ArrayList<Restoran> poruceno_iz) {
        Poruceno_iz = poruceno_iz;
    }*/

    public Date getDatum_i_vreme() {
        return datum_i_vreme;
    }

    public void setDatum_i_vreme(Date datum_i_vreme) {
        this.datum_i_vreme = datum_i_vreme;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

   /* public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }*/

    public Enum_status getStatus() {
        return status;
    }

    public void setStatus(Enum_status status) {
        this.status = status;
    }
}
