package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Enum_pol;
import com.Projekat.Dostava.entity.Korisnik;
import com.Projekat.Dostava.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KupacService kupacService;


    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

    public Korisnik register(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol){
        return kupacService.register(korisnicko_ime,lozinka,ime,prezime,pol,new java.util.Date(System.currentTimeMillis()));
    }

    public Korisnik login(String korisnicko,String lozinka){
        Korisnik korisnik = korisnikRepository.getByKorisnicko(korisnicko);
        if (korisnik == null || !korisnik.getLozinka().equals(lozinka)){
            return null;
        }
        return korisnik;
    }
}
