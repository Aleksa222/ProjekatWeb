package com.Projekat.Dostava.dto;

public class PostavkaMenadzeraDto {
    String korisnicko,naziv;

    public PostavkaMenadzeraDto(String korisnicko, String naziv) {
        this.korisnicko = korisnicko;
        this.naziv = naziv;
    }

    public String getKorisnicko() {
        return korisnicko;
    }

    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
