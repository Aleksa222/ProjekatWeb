package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.DostavljacDto;
import com.Projekat.Dostava.dto.MenadzerDto;
import com.Projekat.Dostava.dto.PostavkaMenadzeraDto;
import com.Projekat.Dostava.dto.RestoranDto;
import com.Projekat.Dostava.entity.Enum_uloga;
import com.Projekat.Dostava.entity.Korisnik;
import com.Projekat.Dostava.entity.Menadzer;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.repository.MenadzerRepository;
import com.Projekat.Dostava.service.AdminService;
import com.Projekat.Dostava.service.MenadzerService;
import com.Projekat.Dostava.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Set;

@RestController
public class AdminRestController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RestoranService restoranService;
    @Autowired
    private MenadzerService menadzerService;
    @Autowired
    private MenadzerRepository menadzerRepository;


    @GetMapping("/api/sviKorisnici")
    public ResponseEntity<Set<Korisnik>> korisnici(HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("user");
        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity("Ova funkcionalnost dostupna je samo Adminima.",HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(adminService.sviKorisnici());
    }

    @PostMapping("/api/kreirajMenadzera")
    public ResponseEntity<String> kreirajMenadzera(@RequestBody MenadzerDto menadzerDto, HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("user");

        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity<>("Ova funkcionalnost dostupna je samo Adminima.", HttpStatus.BAD_REQUEST);
        }
        adminService.createMenadzer(menadzerDto.getKorisnicko_ime(), menadzerDto.getLozinka(), menadzerDto.getIme(), menadzerDto.getPrezime(), menadzerDto.getPol(),menadzerDto.getDatum(),menadzerDto.getRestoran());
        return ResponseEntity.ok("Uspesno dodat novi Menadzer!");
    }

    @PostMapping("/api/kreirajDostavljaca")
    public ResponseEntity<String> kreirajDostavljaca(@RequestBody DostavljacDto dostavljacDto,HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("user");

        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity<>("Ova funkcionalnost dostupna je samo Adminima.", HttpStatus.BAD_REQUEST);
        }
        adminService.createDostavljac(dostavljacDto.getKorisnicko_ime(), dostavljacDto.getLozinka(), dostavljacDto.getIme(), dostavljacDto.getPrezime(), dostavljacDto.getPol(),dostavljacDto.getDatum(),dostavljacDto.getPorudzbine());
        return ResponseEntity.ok("Uspesno dodat novi Dostavljac!");
    }

    @PostMapping("/api/kreirajRestoran")
    public ResponseEntity<String> kreirajRestoran(@RequestBody RestoranDto restoranDto,HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("user");

        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity<>("Ova funkcionalnost dostupna je samo Adminima",HttpStatus.BAD_REQUEST);
        }
        adminService.createRestoran(restoranDto.getNaziv(), restoranDto.getTip_restorana(),restoranDto.getArtikli(),restoranDto.getLokacija());
        return ResponseEntity.ok("Uspesno dodat novi Restoran!");
    }

    @PostMapping("/api/postaviMenadzera")    
    public ResponseEntity postaviMenadzera(@RequestBody PostavkaMenadzeraDto postavkaMenadzeraDto, HttpSession session){
        Korisnik logged = (Korisnik) session.getAttribute("user");

        if(logged.getUloga() != Enum_uloga.ADMIN){
            return new ResponseEntity<>("Ova funkcionalnost dostupna je samo Adminima",HttpStatus.BAD_REQUEST);
        }
        Restoran restoran = restoranService.nadjiRestoran(postavkaMenadzeraDto.getNaziv());

        if(restoran == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Restoran ne postoji");
        }
        Menadzer menadzer = menadzerService.nadjiMenadzera(postavkaMenadzeraDto.getKorisnicko());
        menadzer.setRestoran(restoran);
        menadzerRepository.save(menadzer);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Uspesno je postavljen novi Menadzer restorana!");
    }


}
