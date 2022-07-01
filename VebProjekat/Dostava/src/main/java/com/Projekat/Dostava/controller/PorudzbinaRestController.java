package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.PorudzbinaDto;
import com.Projekat.Dostava.entity.Dostavljac;
import com.Projekat.Dostava.entity.Enum_status;
import com.Projekat.Dostava.entity.Kupac;
import com.Projekat.Dostava.entity.Porudzbina;
import com.Projekat.Dostava.service.ArtikalService;
import com.Projekat.Dostava.service.KorisnikService;
import com.Projekat.Dostava.service.PorudzbinaService;
import com.Projekat.Dostava.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class PorudzbinaRestController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private ArtikalService artikalService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping("api/porudzbine-kupac")
    public ResponseEntity<List<PorudzbinaDto>> getPorudzbineKupac(HttpSession session){
        Boolean proveraSesije = sessionService.validateRole(session, "Kupac");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) session.getAttribute("user");
        List<Porudzbina> porudzbine = this.porudzbinaService.findAll();
        List<PorudzbinaDto> dtos = new ArrayList<>();

        for(Porudzbina p : porudzbine){
            if(p.getKupac().getKorisnicko().equals(kupac.getKorisnicko())){
                PorudzbinaDto dto = new PorudzbinaDto(p);
                dtos.add(dto);
            }

        }

        return ResponseEntity.ok(dtos);

    }




    @GetMapping("api/porudzbine-cekaDostavljaca")
    public ResponseEntity<List<PorudzbinaDto>> getPorudzbineCekaDostavljaca(HttpSession session){
        Boolean proveraSesije = sessionService.validateRole(session, "Dostavljac");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }


        List<Porudzbina> porudzbine = this.porudzbinaService.findAll();
        List<PorudzbinaDto> porudzbineCekaju = new ArrayList<>();

        for(Porudzbina p : porudzbine){
            if(p.getStatus().equals(Enum_status.CEKA_DOSTAVLJACA)){
                PorudzbinaDto dto = new PorudzbinaDto(p);
                porudzbineCekaju.add(dto);
            }
        }

        return ResponseEntity.ok(porudzbineCekaju);

    }
    @GetMapping("api/porudzbine-dostavljac")
    public ResponseEntity<List<Porudzbina>> getPorudzbineDostavljac(HttpSession session){
        Boolean proveraSesije = sessionService.validateRole(session, "Dostavljac");

        if(!proveraSesije){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }
        Dostavljac dostavljac = (Dostavljac) session.getAttribute("user");

        List<Porudzbina> njegovePorudzbine = this.porudzbinaService.findAllForDostavljac(dostavljac);

        return ResponseEntity.ok(njegovePorudzbine);

    }


}
