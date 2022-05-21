package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.repository.KorisnikRepository;
import com.Projekat.Dostava.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
