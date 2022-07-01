package com.Projekat.Dostava.configuration;

import com.Projekat.Dostava.entity.*;
import com.Projekat.Dostava.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

    @Autowired
    private KupacRepository kupacRepository;
    @Autowired
    private LokacijaRepository lokacijaRepository;
    @Autowired
    private MenadzerRepository menadzerRepository;

    @Bean
    public boolean instantiate(){
        Korisnik korisnik = new Korisnik("Aleksa22","Lozinka123","Aleksa","Vuckovic", Enum_pol.MUSKI,new java.util.Date(System.currentTimeMillis()),Enum_uloga.ADMIN);
        korisnikRepository.save(korisnik);



        Lokacija lokacija = new Lokacija(5000,3600,"Trg Mladenaca");
        lokacijaRepository.save(lokacija);

        Restoran restoran = new Restoran();
        restoran.setNaziv("Tortilla Casa");
        restoran.setTip_restorana("Meksicka Hrana");
        restoran.setLokacija(lokacija);
        restoranRepository.save(restoran);
        Restoran restoran2 = new Restoran();
        restoran2.setNaziv("Gyros Master");
        restoran2.setTip_restorana("Grcka Hrana");
        restoranRepository.save(restoran2);


        Artikal artikal1 = new Artikal("Burito",400,Enum_tip.HRANA,250,"Sjajan Burito");
        Artikal artikal2 = new Artikal("Crunch Wrap",450,Enum_tip.HRANA,350,"Ukusno");
        artikalRepository.save(artikal1);
        artikalRepository.save(artikal2);

        restoran.getArtikli().add(artikal1);
        restoran.getArtikli().add(artikal2);
        restoranRepository.save(restoran);

        Korisnik korisnik2 = new Korisnik("Korisnik123","Sifra123","Marko","Milosevic",Enum_pol.MUSKI,new java.util.Date(System.currentTimeMillis()),Enum_uloga.DOSTAVLJAC);
        korisnikRepository.save(korisnik2);

        Menadzer menadzer = new Menadzer("Loha12","sifra","Uros","Lohinski",Enum_pol.MUSKI,new java.util.Date(System.currentTimeMillis()),restoran);
        menadzerRepository.save(menadzer);
        korisnikRepository.save(menadzer);


        Kupac kupac = new Kupac("mare", "mare123", "Marko", "Markovic", Enum_pol.MUSKI, new Date(91, Calendar.SEPTEMBER, 14), 20);
        korisnikRepository.save(kupac);
        kupacRepository.save(kupac);

        return true;
    }


}
