package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.*;
import com.Projekat.Dostava.repository.AdminRepository;
import com.Projekat.Dostava.repository.DostavljacRepository;
import com.Projekat.Dostava.repository.KorisnikRepository;
import com.Projekat.Dostava.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private DostavljacRepository dostavljacRepository;

    public Admin login(String korisnicko_ime,String lozinka){
        Admin admin = adminRepository.getByKorisnicko(korisnicko_ime);
        if(admin == null || !admin.getLozinka().equals(lozinka)){
            return null;
        }
        return admin;
    }

    public Menadzer createMenadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum, Restoran restoran){
        Menadzer noviMenadzer = new Menadzer(korisnicko_ime,lozinka,ime,prezime,pol,datum,restoran);
        menadzerRepository.save(noviMenadzer);
        korisnikRepository.save(noviMenadzer);
        return noviMenadzer;
    }

    public Dostavljac createDostavljac(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum, Set<Porudzbina> porudzbine){
        Dostavljac noviDostavljac = new Dostavljac(korisnicko_ime,lozinka,ime,prezime,pol,datum,porudzbine);
        dostavljacRepository.save(noviDostavljac);
        korisnikRepository.save(noviDostavljac);
        return noviDostavljac;
    }
}
