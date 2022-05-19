package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.*;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private UUID UUID;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Artikal_za_Porudzbinu> poruceno = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date datum_i_vreme = new Date();

    @Column
    private double Cena;

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    private Kupac kupac;

    @Enumerated(EnumType.STRING)
    private Enum_status status;

    public Porudzbina(){}

    public Porudzbina(UUID uuid, Set<Artikal_za_Porudzbinu> poruceno, Restoran restoran, Date datum_i_vreme, double cena,Kupac kupac, Enum_status status){
        this.UUID = uuid;
        this.poruceno = poruceno;
        this.restoran = restoran;
        this.datum_i_vreme = datum_i_vreme;
        this.Cena = cena;
        this.kupac = kupac;
        this.status = status;
    }

    public UUID getUUID() {
        return UUID;
    }

    public void setUUID(UUID UUID) {
        this.UUID = UUID;
    }

    public Set<Artikal_za_Porudzbinu> getPoruceno(){return poruceno;}

    public void setPoruceno(Set<Artikal_za_Porudzbinu> poruceno){this.poruceno = poruceno;}

    public Restoran getRestoran(){return restoran;}

    public void setRestoran(Restoran restoran){this.restoran = restoran;}

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

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Enum_status getStatus() {
        return status;
    }

    public void setStatus(Enum_status status) {
        this.status = status;
    }
}
