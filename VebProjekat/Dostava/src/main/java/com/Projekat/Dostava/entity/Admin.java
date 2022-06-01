package com.Projekat.Dostava.entity;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import javax.persistence.*;
import java.util.Date;
//EEEE

@Entity
public class Admin extends Korisnik {

    public Admin(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum_rodjenja) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja, Enum_uloga.ADMIN);
    }

    public Admin(){
        super();
    }

    public Admin(Korisnik k){
        super(k);
    }



}
