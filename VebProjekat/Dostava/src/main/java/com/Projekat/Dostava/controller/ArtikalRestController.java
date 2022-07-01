package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.ArtikalDto;
import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.service.ArtikalService;
import com.Projekat.Dostava.service.SessionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
public class ArtikalRestController {
    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private SessionService sessionService;

    @PostMapping("/api/artikli/addArtikal")
    public ResponseEntity<Artikal> addArtikal(@RequestBody ArtikalDto artikalDto, HttpSession session) throws JsonProcessingException {
        String role = sessionService.getRole(session);

        if(!role.equals("Menadzer")){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        if(artikalDto.getNaziv().isEmpty() || artikalDto.getCena() <= 0 || artikalDto.getTip() == null){
            return new ResponseEntity("Ova polja ne smeju biti prazna!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(artikalService.addArtikal(artikalDto), HttpStatus.OK);
    }
}
