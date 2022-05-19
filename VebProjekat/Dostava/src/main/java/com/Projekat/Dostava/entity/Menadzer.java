package com.Projekat.Dostava.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Menadzer extends Korisnik implements Serializable {

    @OneToOne
    @JoinColumn(name = "restoran_id", referencedColumnName = "idRestoran")
    private Restoran restoran;

    public Menadzer(){this.uloga = Enum_uloga.MENADZER;}

    public Menadzer(Korisnik k,Restoran restoran){
        super(k);
        this.restoran = restoran;
        this.uloga = Enum_uloga.MENADZER;
    }

    public Restoran getRestoran(){
        return restoran;
    }

    public void setRestoran(Restoran restoran){
        this.restoran = restoran;
    }


}
