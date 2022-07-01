package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Dostavljac;
import com.Projekat.Dostava.entity.Porudzbina;
import com.Projekat.Dostava.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PorudzbinaService {

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public List<Porudzbina> findAll(){
        return porudzbinaRepository.findAll();
    }

    public List<Porudzbina> findAllForDostavljac(Dostavljac dostavljac){
        List<Porudzbina> porudzbine = new ArrayList<>();
        for(Porudzbina porudzbina : dostavljac.getPorudzbine()){
            porudzbine.add(porudzbina);
        }
        return porudzbine;
    }
}
