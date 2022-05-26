package com.Projekat.Dostava.dto;

public class LoginDto {
    private String Korisnicko_ime, Lozinka;

    public LoginDto(){}

    public LoginDto(String korisnicko_ime,String lozinka){
        this.Korisnicko_ime = korisnicko_ime;
        this.Lozinka = lozinka;
    }

    public String getKorisnicko_ime(){
        return Korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime){
        this.Korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka(){
        return Lozinka;
    }

    public void setLozinka(String lozinka){
        this.Lozinka = lozinka;
    }




}
