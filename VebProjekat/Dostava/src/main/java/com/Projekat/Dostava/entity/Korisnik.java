package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Korisnik {
 @Id
 @GeneratedValue(strategy =  GenerationType.IDENTITY)
 private Long Id;
 @Column(unique = true, nullable = false)
   private String Korisnicko_ime;
    @Column(nullable = false)
    private String Lozinka;
    @Column
    private String Ime;
    @Column
    private String Prezime;
    @Enumerated(EnumType.STRING)
    protected Enum_pol pol;
    @Column
    private String Datum_rodjenja;

    @Enumerated(EnumType.STRING)
    protected Enum_uloga uloga;

 public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, String datum_rodjenja) {
  Korisnicko_ime = korisnicko_ime;
  Lozinka = lozinka;
  Ime = ime;
  Prezime = prezime;
  Datum_rodjenja = datum_rodjenja;
 }

 public Korisnik() {
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

 public String getIme() {
  return Ime;
 }

 public void setIme(String ime) {
  Ime = ime;
 }

 public String getPrezime() {
  return Prezime;
 }

 public void setPrezime(String prezime) {
  Prezime = prezime;
 }

 public Enum_pol getPol() {
  return pol;
 }

 public void setPol(Enum_pol pol) {
  this.pol = pol;
 }

 public String getDatum_rodjenja() {
  return Datum_rodjenja;
 }

 public void setDatum_rodjenja(String datum_rodjenja) {
  Datum_rodjenja = datum_rodjenja;
 }

 public Enum_uloga getUloga() {
  return uloga;
 }

 public void setUloga(Enum_uloga uloga) {
  this.uloga = uloga;
 }
}
