package com.Projekat.Dostava.service;

import com.Projekat.Dostava.dto.ArtikalDto;
import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.entity.Porudzbina;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.ArtikalRepository;
import com.Projekat.Dostava.repository.MenadzerRepository;
import com.Projekat.Dostava.repository.PorudzbinaRepository;
import com.Projekat.Dostava.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {
    @Autowired
    private ArtikalRepository artikalRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public Artikal save(Artikal artikal) { return artikalRepository.save(artikal); }

    public Restoran saveRestoran(Restoran restoran){
        return restoranRepository.save(restoran);
    }

    public Artikal findOne(Long id){
        Optional<Artikal> pronadjenArtikal = artikalRepository.findById(id);
        if (pronadjenArtikal.isPresent())
            return pronadjenArtikal.get();
        return null;
    }

    public List<Artikal> findAll() { return artikalRepository.findAll(); }

    public Artikal dodajArtikal(ArtikalDto dto){
        Artikal artikal = new Artikal(dto.getNaziv(), dto.getCena(), dto.getTip(), dto.getKolicina(), dto.getOpis());

        this.save(artikal);

        return artikal;
    }

    public void update(Long id, ArtikalDto artikalDto, Menadzer menadzer){
        Artikal artikal = this.findOne(id);

        menadzer.getRestoran().getArtikli().remove(artikal);

        if(!artikalDto.getNaziv().isEmpty()){
            artikal.setNaziv(artikalDto.getNaziv());
        }
        if(artikalDto.getCena() > 0){
            artikal.setCena(artikalDto.getCena());
        }
        if(artikalDto.getTip() != null){
            artikal.setTip(artikalDto.getTip());
        }
        if(artikalDto.getKolicina() > 0){
            artikal.setKolicina(artikalDto.getKolicina());
        }
        if(!artikalDto.getOpis().isEmpty()){
            artikal.setOpis(artikalDto.getOpis());
        }

        this.save(artikal);

        menadzer.getRestoran().getArtikli().add(artikal);

        restoranRepository.save(menadzer.getRestoran());
    }

    public void delete(Long id, Restoran restoran) {
        List<Porudzbina> porudzbine = porudzbinaRepository.findAll();

        for(Porudzbina p : porudzbine){
            if(p.getPoruceno().contains(id)){
                p.getPoruceno().remove(id);
            }
        }
        for (Artikal artikal : restoran.getArtikli()) {
            if (artikal.getId().equals(id)) {
                restoran.getArtikli().remove(artikal);
                artikalRepository.delete(artikal);
                this.saveRestoran(restoran);
            }
        }
    }
}
