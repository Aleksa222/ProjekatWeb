package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dao.IRestoranDAO;
import com.Projekat.Dostava.dto.RestoranDto;
import com.Projekat.Dostava.dto.RestoranPrikazDto;
import com.Projekat.Dostava.entity.Komentar;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.service.KomentarService;
import com.Projekat.Dostava.service.MenadzerService;
import com.Projekat.Dostava.service.RestoranService;
import com.Projekat.Dostava.service.SessionService;
import com.Projekat.Dostava.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RestoranRestController {
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenadzerService menadzerService;

    @Autowired
    private SessionService sessionService;
    @Autowired
    private IRestoranDAO service;
    @Autowired
    private KomentarService komentarService;

    @GetMapping(value = "api/svi-restorani",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RestoranDto>> getRestorani(){
        List<Restoran> restorani = this.restoranService.findAll();

        List<RestoranDto> dtos = new ArrayList<>();
        for(Restoran r : restorani){
            RestoranDto dto = new RestoranDto(r);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);

    }

    @GetMapping("api/restorani")
    @ResponseBody
    public ResponseEntity<List<RestoranPrikazDto>> search(@RequestParam(value = "search") String search) {
        List<SearchCriteria> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return new ResponseEntity<>(service.search(params), HttpStatus.OK);
    }

    @GetMapping("/api/restorani/{id}")
    public ResponseEntity izborRestorana(@PathVariable(name = "id") Long id){

        Restoran restoran = restoranService.pronadjiJedan(id);

        if(restoran == null){
            return new ResponseEntity<>("Restoran ne postoji!", HttpStatus.BAD_REQUEST);
        }
        List<Komentar> listaKomentara = komentarService.findAll(restoran);

        RestoranPrikazDto prikazDto = new RestoranPrikazDto(restoran, listaKomentara);

        return ResponseEntity.ok(prikazDto);
    }

    @DeleteMapping("/api/restorani-delete/{id}")
    public ResponseEntity deleteRestoran(@PathVariable(name = "id") Long id, HttpSession session){
        Boolean provera = sessionService.validateRole(session, "Admin");

        if(!provera){
            return new ResponseEntity("Nemate potrebne privilegije!",HttpStatus.BAD_REQUEST);
        }

        menadzerService.deleteMenadzerRestoran(id);
        komentarService.deleteKomentarRestoran(id);
        restoranService.obrisiRestoran(id);

        return ResponseEntity.ok("Uspesno obrisan restoran!");
    }
}
