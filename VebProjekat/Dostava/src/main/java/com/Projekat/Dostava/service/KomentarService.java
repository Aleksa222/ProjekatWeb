package com.Projekat.Dostava.service;

import com.Projekat.Dostava.entity.Komentar;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository komentarRepository;

    public List<Komentar> findAll() {
        return komentarRepository.findAll();
    }

    public List<Komentar> findAll(Restoran restoran) {
        List<Komentar> listaKomentara = new ArrayList<>();

        for (Komentar k : this.findAll()) {
            if (k.getRestoran() == restoran) {
                listaKomentara.add(k);
            }
        }
        return listaKomentara;
    }

    public void deleteKomentarRestoran(Long id) {
        List<Komentar> komentari = this.findAll();

        for (Komentar k : komentari) {
            if (k.getRestoran().getIdRestoran().equals(id)) {
                k.setRestoran(null);
            }
        }
    }
}
