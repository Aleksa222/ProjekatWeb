package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.KorpaDto;
import com.Projekat.Dostava.dto.PorudzbinaDto;
import com.Projekat.Dostava.entity.*;
import com.Projekat.Dostava.service.ArtikalService;
import com.Projekat.Dostava.service.KorisnikService;
import com.Projekat.Dostava.service.PorudzbinaService;
import com.Projekat.Dostava.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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

        if(!sessionService.validateRole(session, "KUPAC")){
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

        if(!sessionService.validateRole(session, "DOSTAVLJAC")){
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

        if(!sessionService.validateRole(session, "DOSTAVLJAC")){
            return new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }
        Dostavljac dostavljac = (Dostavljac) session.getAttribute("user");

        List<Porudzbina> njegovePorudzbine = this.porudzbinaService.findAllForDostavljac(dostavljac);

        return ResponseEntity.ok(njegovePorudzbine);

    }

    @PostMapping("/api/porudzbine-dodajArtikal/{id}")
    public ResponseEntity dodajUKorpu(@PathVariable Long id, HttpSession session){

        if(!sessionService.validateRole(session, "KUPAC")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Artikal artikal = artikalService.findOne(id);

        Kupac kupac = (Kupac) session.getAttribute("user");

        Porudzbina porudzbina = porudzbinaService.findByStatus(kupac, Enum_status.U_KORPI);

        if(!porudzbina.getPoruceno().contains(artikal)) {
            Artikal_za_Porudzbinu artikal_za_porudzbinu = new Artikal_za_Porudzbinu(artikal, 0);
            porudzbina.getPoruceno().add(artikal_za_porudzbinu);
        }else{
           for(Artikal_za_Porudzbinu a : porudzbina.getPoruceno()){
              if(a.getArtikal().equals(artikal)){
                   a.setBroj(a.getBroj() + 1);
                   break;
                }
            }
       }
        porudzbina.setKupac(kupac);
        porudzbina.setCena(artikal.getCena() + porudzbina.getCena());
        porudzbina.setDatum_i_vreme(LocalDateTime.now());
        porudzbina.setStatus(Enum_status.U_KORPI);
        porudzbinaService.save(porudzbina);

        kupac.getPorudzbine().add(porudzbina);

        korisnikService.save(kupac);
        return new ResponseEntity("Dodat artikal", HttpStatus.OK);
    }

    @PutMapping("/api/porudzbine-ukloniArtikal/{id}")
    public ResponseEntity izbaciIzKorpe(@PathVariable Long id, HttpSession session){

        if(!sessionService.validateRole(session,"KUPAC")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) session.getAttribute("user");

        Porudzbina porudzbina = porudzbinaService.findByStatus(kupac, Enum_status.U_KORPI);

        porudzbinaService.ukloniArtikal(porudzbina, kupac, id);

        return new ResponseEntity("Uspesno obrisan artikal", HttpStatus.OK);
    }

    @GetMapping("/api/porudzbine-pregledKorpe")
    public ResponseEntity<KorpaDto> pregledKorpe(HttpSession session){

        if(!sessionService.validateRole(session,"KUPAC")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) session.getAttribute("user");

        Porudzbina porudzbina = porudzbinaService.findByStatus(kupac,Enum_status.U_KORPI);

        KorpaDto korpaDto = new KorpaDto(porudzbina);

        return ResponseEntity.ok(korpaDto);
    }

    @PutMapping("/api/porudzbine-poruci")
    public ResponseEntity poruci(HttpSession session){

        if(!sessionService.validateRole(session,"Kupac")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) session.getAttribute("user");

        Porudzbina porudzbina = porudzbinaService.findByStatus(kupac,Enum_status.U_KORPI);

        porudzbina.setStatus(Enum_status.OBRADA);


        porudzbinaService.save(porudzbina);
        korisnikService.save(kupac);

        return new ResponseEntity("Uspesno poruceno.", HttpStatus.OK);
    }

    @PutMapping("/api/porudzbine-menadzerStatus")
    public ResponseEntity priprema(@RequestParam("korisnicko_ime") String korisnickoIme, HttpSession session){

        if(!sessionService.validateRole(session,"Menadzer")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) korisnikService.findOne(korisnickoIme);

        if(porudzbinaService.findByStatus(kupac,Enum_status.OBRADA) != null){
            Porudzbina porudzbina = porudzbinaService.findByStatus(kupac,Enum_status.OBRADA);
            porudzbina.setStatus(Enum_status.U_PRIPREMI);
            porudzbinaService.save(porudzbina);
            korisnikService.save(kupac);
            return new ResponseEntity("Porudzbina se priprema.", HttpStatus.OK);
        }
            Porudzbina porudzbina = porudzbinaService.findByStatus(kupac,Enum_status.U_PRIPREMI);
            porudzbina.setStatus(Enum_status.CEKA_DOSTAVLJACA);
            porudzbinaService.save(porudzbina);
            korisnikService.save(kupac);
            return new ResponseEntity("Porudzbina ceka dostavljaca.", HttpStatus.OK);

    }

    @PutMapping("/api/porudzbine-dostavljacStatus")
    public ResponseEntity preuzmiPorudzbinu(HttpSession session, @RequestParam("korisnicko_ime") String korisnickoIme){

        if(!sessionService.validateRole(session,"Dostavljac")){
            return  new ResponseEntity("Nemate potrebne privilegije!", HttpStatus.BAD_REQUEST);
        }

        Kupac kupac = (Kupac) korisnikService.findOne(korisnickoIme);

        if(porudzbinaService.findByStatus(kupac,Enum_status.CEKA_DOSTAVLJACA) != null) {
            Porudzbina porudzbina = porudzbinaService.findByStatus(kupac, Enum_status.OBRADA);
            porudzbina.setStatus(Enum_status.U_TRANSPORTU);
            porudzbinaService.save(porudzbina);
            korisnikService.save(kupac);
            return new ResponseEntity("Porudzbina je u transportu.", HttpStatus.OK);
        }
            Porudzbina porudzbina = porudzbinaService.findByStatus(kupac,Enum_status.U_PRIPREMI);
            porudzbina.setStatus(Enum_status.DOSTAVLJENA);
            porudzbinaService.save(porudzbina);
            kupac.setBroj_bodova((int) (kupac.getBroj_bodova() + (porudzbina.getCena() / 1000) * 133));
            korisnikService.save(kupac);
            return new ResponseEntity("Porudzbina je dostavljena.", HttpStatus.OK);
    }
}
