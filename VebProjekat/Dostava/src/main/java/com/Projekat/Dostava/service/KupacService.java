package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Enum_pol;
import com.Projekat.Dostava.entity.Kupac;
import com.Projekat.Dostava.entity.Titula;
import com.Projekat.Dostava.repository.KorisnikRepository;
import com.Projekat.Dostava.repository.KupacRepository;
import com.Projekat.Dostava.repository.TitulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KupacService {
    @Autowired
    private KupacRepository kupacRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private TitulaRepository titulaRepository;

    public Kupac register(String korisnicko_ime, String lozinka, String ime, String prezime, Enum_pol pol, Date datum_rodjenja){
        if(kupacRepository.getByKorisnicko(korisnicko_ime) != null){
            return null;                 //ako vec postoji takav vrati null
        }
        Kupac noviKupac = new Kupac(korisnicko_ime,lozinka,ime,prezime,pol,datum_rodjenja,0);
        Titula titula = new Titula(Titula.titulaKupca.NOVI_CLAN);
        titulaRepository.save(titula);
        noviKupac.setTitula(titula);
        kupacRepository.save(noviKupac);
        korisnikRepository.save(noviKupac);

        return noviKupac;
    }

    public List<Kupac> findAll(){
        return kupacRepository.findAll();
    }
}
