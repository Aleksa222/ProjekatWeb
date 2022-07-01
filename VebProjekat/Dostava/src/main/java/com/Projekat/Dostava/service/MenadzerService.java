package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;


    public List<Menadzer> findAll(){
        return menadzerRepository.findAll();
    }
    public Menadzer nadjiMenadzera(String korisnicko){
        Menadzer menadzer = menadzerRepository.getByKorisnicko(korisnicko);
        return menadzer;
    }

    public void deleteMenadzerRestoran(Long id){
        List<Menadzer> menadzeri = this.findAll();

        for(Menadzer m : menadzeri){
            if(m.getRestoran().getIdRestoran().equals(id)){
                m.setRestoran(null);
            }
        }
    }
}
