package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.MenadzerDto;
import com.Projekat.Dostava.entity.Enum_uloga;
import com.Projekat.Dostava.entity.Korisnik;
import com.Projekat.Dostava.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AdminRestController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/api/kreirajMenadzera")
    public ResponseEntity<String> kreirajMenadzera(@RequestBody MenadzerDto menadzerDto, HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("Korisnik");

        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity<>("Nije admin", HttpStatus.BAD_REQUEST);
        }
        adminService.createMenadzer(menadzerDto.getKorisnicko_ime(), menadzerDto.getLozinka(), menadzerDto.getIme(), menadzerDto.getPrezime(), menadzerDto.getPol(),menadzerDto.getDatum(),menadzerDto.getRestoran());
        return ResponseEntity.ok("Uspesno dodat novi Menadzer!");
    }
}
