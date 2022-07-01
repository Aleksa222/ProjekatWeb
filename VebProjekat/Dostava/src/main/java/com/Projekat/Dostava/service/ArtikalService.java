package com.Projekat.Dostava.service;

import com.Projekat.Dostava.dto.ArtikalDto;
import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.ArtikalRepository;
import com.Projekat.Dostava.repository.MenadzerRepository;
import com.Projekat.Dostava.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;


    public Artikal save(Artikal artikal) { return artikalRepository.save(artikal); }

    public Artikal findOne(Long id){
        Optional<Artikal> pronadjenArtikal = artikalRepository.findById(id);
        if (pronadjenArtikal.isPresent())
            return pronadjenArtikal.get();
        return null;
    }

    public List<Artikal> findAll() { return artikalRepository.findAll(); }

    public Artikal addArtikal(ArtikalDto dto){
        Artikal artikal = new Artikal(dto.getNaziv(), dto.getCena(), dto.getTip(), dto.getKolicina(), dto.getOpis());

        this.save(artikal);

        return artikal;
    }
}
