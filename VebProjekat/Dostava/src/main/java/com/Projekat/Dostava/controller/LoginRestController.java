package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.LoginDto;
import com.Projekat.Dostava.entity.Korisnik;
import com.Projekat.Dostava.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InvalidAttributeValueException;
import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;

@RestController
public class LoginRestController {
    @Autowired
    private LoginService loginService;

    @PostMapping(
            value = "api/login",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody LoginDto loginDto, HttpSession session){

        Hashtable<String,String> errorDic = new Hashtable<>();

        if (loginDto.getKorisnicko_ime() == null || loginDto.getKorisnicko_ime().isEmpty())
            errorDic.put("korisnickoIme" , "Korisnicko ime je obavezno");
        if(loginDto.getLozinka() == null || loginDto.getLozinka().isEmpty())
            errorDic.put("lozinka", "Lozinka je obavezna");

        if(!errorDic.isEmpty())
            return new ResponseEntity(errorDic, HttpStatus.BAD_REQUEST);

        Korisnik korisnik = null;

        try{
            korisnik = loginService.login(loginDto.getKorisnicko_ime(),loginDto.getLozinka());
        } catch (AccountNotFoundException e){
            errorDic.put("korisnickoIme", e.getMessage());
        } catch(InvalidAttributeValueException e){
            errorDic.put("lozinka", e.getMessage());
        }

        if(!errorDic.isEmpty() || korisnik==null)
            return new ResponseEntity(errorDic,HttpStatus.BAD_REQUEST);

        session.setAttribute("role",korisnik.getUloga());
        session.setAttribute("user", korisnik);

        return new ResponseEntity("Successfully login!",HttpStatus.OK);


    }

    @PostMapping("api/logout")
    public ResponseEntity<String> logout(HttpSession session){

        Korisnik ulogovanKorisnik = (Korisnik) session.getAttribute("user");

        if (ulogovanKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);

    }
}
