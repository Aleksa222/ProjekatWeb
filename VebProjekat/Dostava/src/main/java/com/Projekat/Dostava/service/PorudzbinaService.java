package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.*;
import com.Projekat.Dostava.repository.KupacRepository;
import com.Projekat.Dostava.repository.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PorudzbinaService {

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private KupacRepository kupacRepository;

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

    public Porudzbina save(Porudzbina porudzbina) { return porudzbinaRepository.save(porudzbina);}

    public Porudzbina findByStatus(Kupac kupac, Enum_status status) {
        for(Porudzbina p : kupac.getPorudzbine()){
            if(p.getStatus() == status){
                return p;
            }
        }
        return new Porudzbina();
    }

    public void ukloniArtikal(Porudzbina porudzbina, Kupac kupac, Long id){

        for(Artikal_za_Porudzbinu a : porudzbina.getPoruceno()){
            if(a.getArtikal().getId().equals(id)){
                if(a.getBroj() - 1 > 0) {
                    a.setBroj(a.getBroj() - 1);
                }else{
                    porudzbina.getPoruceno().remove(a);
                }
                porudzbina.setCena(porudzbina.getCena() - a.getArtikal().getCena());
                break;
            }
        }


        porudzbinaRepository.save(porudzbina);

        kupacRepository.save(kupac);
    }
}
