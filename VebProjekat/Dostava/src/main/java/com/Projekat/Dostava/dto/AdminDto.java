package com.Projekat.Dostava.dto;

public class AdminDto {
    private String Korisnicko_ime;
    private String Lozinka;

    public AdminDto(String korisnicko_ime, String lozinka) {
        Korisnicko_ime = korisnicko_ime;
        Lozinka = lozinka;
    }

    public String getKorisnicko_ime() {
        return Korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        Korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String lozinka) {
        Lozinka = lozinka;
    }
}
