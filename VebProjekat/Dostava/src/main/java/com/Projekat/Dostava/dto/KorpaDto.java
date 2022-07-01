package com.Projekat.Dostava.dto;

import com.Projekat.Dostava.entity.Artikal;
import com.Projekat.Dostava.entity.Artikal_za_Porudzbinu;
import com.Projekat.Dostava.entity.Porudzbina;

import java.util.ArrayList;
import java.util.List;

public class KorpaDto {
    List<ArtikalKorpaDto> artikalKorpaDto = new ArrayList<>();

    double ukupnaCena;

    public KorpaDto(List<ArtikalKorpaDto> artikalKorpaDto, double ukupnaCena) {
        this.artikalKorpaDto = artikalKorpaDto;
        this.ukupnaCena = ukupnaCena;
    }

    public KorpaDto(Porudzbina porudzbina){
        for(Artikal_za_Porudzbinu a : porudzbina.getPoruceno()){
            this.artikalKorpaDto.add(new ArtikalKorpaDto(a.getArtikal()));
        }
        this.ukupnaCena = porudzbina.getCena();
    }

    public List<ArtikalKorpaDto> getArtikalKorpaDto() {
        return artikalKorpaDto;
    }

    public void setArtikalKorpaDto(List<ArtikalKorpaDto> artikalKorpaDto) {
        this.artikalKorpaDto = artikalKorpaDto;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }
}
