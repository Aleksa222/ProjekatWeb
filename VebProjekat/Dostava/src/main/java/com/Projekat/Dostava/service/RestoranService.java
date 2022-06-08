package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Lokacija;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RestoranService {
    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran nadjiRestoran(String naziv){
        Restoran restoran = restoranRepository.getByNaziv(naziv);
        return restoran;
    }

    public Set<Restoran> restorani(){
        Set<Restoran> restorani = new HashSet<>(restoranRepository.findAll());
        return restorani;
    }

    public Set<Restoran> pretrazipoNazivu(String naziv){
        Set<Restoran> restorani = new HashSet<>(restoranRepository.findAll());
        Set<Restoran> odgovarajuciNaziv = new HashSet<>();
        for(Restoran r:restorani){
            if(r.getNaziv().equals(naziv)){
                odgovarajuciNaziv.add(r);
            }
        }
        return odgovarajuciNaziv;
    }

    public Set<Restoran> pretrazipoTipu(String tip_restorana){
        Set<Restoran> restorani = new HashSet<>(restoranRepository.findAll());
        Set<Restoran> odgovarajuciTip = new HashSet<>();
        for(Restoran r:restorani){
            if(r.getTip_restorana().equals(tip_restorana)){
                odgovarajuciTip.add(r);
            }
        }
        return odgovarajuciTip;
    }

    public Set<Restoran> pretrazipoLokaciji(Lokacija lokacija){
        Set<Restoran> restorani = new HashSet<>(restoranRepository.findAll());
        Set<Restoran> odgovarajucaLokacija = new HashSet<>();
        for(Restoran r:restorani){
            if(r.getLokacija() == lokacija){
                odgovarajucaLokacija.add(r);
            }
        }
        return odgovarajucaLokacija;
    }


}
