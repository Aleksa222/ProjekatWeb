package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;

    public Menadzer nadjiMenadzera(String korisnicko){
        Menadzer menadzer = menadzerRepository.getByKorisnicko(korisnicko);
        return menadzer;
    }
}
