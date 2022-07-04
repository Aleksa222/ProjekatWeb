package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.ArtikalDto;
import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.service.ArtikalService;
import com.Projekat.Dostava.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class ArtikalRestController {
    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("/api/artikli/addArtikal")
    public ResponseEntity<Artikal> addArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session) {

        if(!sessionService.validateRole(session, "MENADZER")){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        if(artikalDto.getNaziv().isEmpty() || artikalDto.getCena() <= 0 || artikalDto.getTip() == null){
            return new ResponseEntity("Ova polja ne smeju biti prazna!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(artikalService.dodajArtikal(artikalDto), HttpStatus.OK);
    }

    @PutMapping("/api/artikli/updateArtikal/{id}")
    public ResponseEntity updateArtikal(@PathVariable(name = "id") Long id, @RequestBody ArtikalDto artikalDto, HttpSession session){

        if(!sessionService.validateRole(session, "MENADZER")){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        Menadzer menadzer = (Menadzer) session.getAttribute("user");

        artikalService.update(id, artikalDto, menadzer);

        return ResponseEntity.ok("Uspesno updated!");
    }

    @DeleteMapping("/api/artikli/deleteArtikal/{id}")
    public ResponseEntity deleteArtikal(@PathVariable(name = "id") Long id, HttpSession session){

        if(!sessionService.validateRole(session, "MENADZER")){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        Menadzer menadzer = (Menadzer) session.getAttribute("user");
        Restoran restoran = menadzer.getRestoran();

        artikalService.delete(id, restoran);

        return ResponseEntity.ok("Successfully deleted!");
    }
}
