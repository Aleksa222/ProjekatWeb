package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.LoginDto;
import com.Projekat.Dostava.dto.RegisterDto;
import com.Projekat.Dostava.entity.Korisnik;
import com.Projekat.Dostava.repository.KorisnikRepository;
import com.Projekat.Dostava.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class KorisnikRestController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @GetMapping("/api/")
    public String welcome() {
        return "Pozdrav iz apija!";
    }

    @GetMapping("/api/korisnici/")
    public List<Korisnik> sviKorisnici(){
        List<Korisnik> korisnici = korisnikService.findAll();
        return korisnici;
    }

    @PostMapping("/api/register/")
    public  ResponseEntity<String> register(@RequestBody RegisterDto registerDto, HttpSession session){
        if(registerDto.getKorisnicko_ime().isEmpty() ||
                registerDto.getLozinka().isEmpty() ||
                registerDto.getIme().isEmpty()     ||
                registerDto.getPrezime().isEmpty() ||
                !registerDto.getPol().getDeclaringClass().isEnum())
        {
            return new ResponseEntity<>("Invalid login data", HttpStatus.BAD_REQUEST);
        }

        Korisnik registeredKorisnik = korisnikService.register(registerDto.getKorisnicko_ime(),registerDto.getLozinka(),registerDto.getIme(),registerDto.getPrezime(),registerDto.getPol());

        if(registeredKorisnik == null){
            return new ResponseEntity<>("Korisnik vec postoji!", HttpStatus.BAD_REQUEST);
        }
        session.setAttribute("Korisnik", registeredKorisnik); //kasnije se moze pristupiti Korisniku uz pomoc stringa "Korisnik"
        return ResponseEntity.ok("Uspesna registracija");
    }

    @PostMapping("/api/login/")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session) {
        if (loginDto.getKorisnicko_ime().isEmpty() || loginDto.getLozinka().isEmpty()) {
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        }
        Korisnik loggedKorisnik = korisnikService.login(loginDto.getKorisnicko_ime(), loginDto.getLozinka());
        if (loggedKorisnik == null) {
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);
        }
        session.setAttribute("Korisnik", loggedKorisnik);


        return ResponseEntity.ok("Uspesno ste se prijavili!");

    }



}
