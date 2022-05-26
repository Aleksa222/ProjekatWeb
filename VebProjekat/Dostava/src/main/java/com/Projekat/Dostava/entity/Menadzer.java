package com.Projekat.Dostava.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable {

    @OneToOne
    @JoinColumn(name = "restoran_id", referencedColumnName = "idRestoran")
    private Restoran restoran;

    public Menadzer(){this.uloga = Enum_uloga.MENADZER;}

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum,Restoran restoran){
        super(korisnicko_ime,lozinka,ime,prezime,pol,datum,Enum_uloga.MENADZER);
        this.restoran = restoran;
    }

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

