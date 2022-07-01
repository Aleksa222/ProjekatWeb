package com.Projekat.Dostava.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Artikal_za_Porudzbinu> poruceno = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @Column
    private LocalDateTime datum_i_vreme;

    @Column
    private double Cena;

    @ManyToOne
    @JoinColumn(name="korisnicko_ime")
    private Kupac kupac;

    @Enumerated(EnumType.STRING)
    @Column
    private Enum_status status;


    public Porudzbina(){
        this.status = Enum_status.U_KORPI;
        this.datum_i_vreme =  LocalDateTime.now();
    }


    public Porudzbina(Set<Artikal_za_Porudzbinu> poruceno, Restoran restoran, LocalDateTime datum_i_vreme, double cena,Kupac kupac, Enum_status status){
        this.poruceno = poruceno;
        this.restoran = restoran;
        this.datum_i_vreme = datum_i_vreme;
        this.Cena = cena;
        this.kupac = kupac;
        this.status = status;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Artikal_za_Porudzbinu> getPoruceno(){return poruceno;}

    public void setPoruceno(Set<Artikal_za_Porudzbinu> poruceno){this.poruceno = poruceno;}

    public Restoran getRestoran(){return restoran;}

    public void setRestoran(Restoran restoran){this.restoran = restoran;}

    public LocalDateTime getDatum_i_vreme() {
        return datum_i_vreme;
    }

    public void setDatum_i_vreme(LocalDateTime datum_i_vreme) {
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
