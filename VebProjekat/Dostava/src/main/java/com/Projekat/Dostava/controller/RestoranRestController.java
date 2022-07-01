package com.Projekat.Dostava.controller;

import com.Projekat.Dostava.dto.RestoranDto;
import com.Projekat.Dostava.dto.RestoranPrikazDto;
import com.Projekat.Dostava.entity.Komentar;
import com.Projekat.Dostava.entity.Restoran;
import com.Projekat.Dostava.service.KomentarService;
import com.Projekat.Dostava.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RestoranRestController {
    @Autowired
    private RestoranService restoranService;

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
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
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
}
