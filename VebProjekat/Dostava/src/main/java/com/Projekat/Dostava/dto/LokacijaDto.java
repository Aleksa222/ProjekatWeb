package com.Projekat.Dostava.dto;

public class LokacijaDto {
    private double geografska_sirina,geografska_duzina;
    private String adresa;

    public LokacijaDto(double geografska_sirina, double geografska_duzina, String adresa) {
        this.geografska_sirina = geografska_sirina;
        this.geografska_duzina = geografska_duzina;
        this.adresa = adresa;
    }

    public double getGeografska_sirina() {
        return geografska_sirina;
    }

    public void setGeografska_sirina(double geografska_sirina) {
        this.geografska_sirina = geografska_sirina;
    }

    public double getGeografska_duzina() {
        return geografska_duzina;
    }

    public void setGeografska_duzina(double geografska_duzina) {
        this.geografska_duzina = geografska_duzina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
