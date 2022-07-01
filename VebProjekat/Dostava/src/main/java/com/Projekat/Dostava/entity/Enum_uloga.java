package com.Projekat.Dostava.entity;

public enum Enum_uloga {
    ADMIN("Admin"),
    MENADZER("Menadzer"),
    DOSTAVLJAC("Dostavljac"),
    KUPAC("Kupac");

    private final String uloga;

    private Enum_uloga(String uloga){
        this.uloga = uloga;
    }

    public String getUloga() {
        return uloga;
    }
}
