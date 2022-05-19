package com.Projekat.Dostava.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Titula implements Serializable {

    public enum titulaKupca {
        ZLATNI,SREBRNI,BRONZANI,NOVI_CLAN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTitula;

    @Column
    private titulaKupca titula;

    @Column
    private float popust;

    @Column
    private int trazeni_broj_bodova;

    public Titula(titulaKupca TITULA){this.titula = TITULA;}

    public Long getIdTitula(){return idTitula;}

    public void setIdTitula(Long idtitula){this.idTitula = idtitula;}

    public titulaKupca getTitulaKupca(){return titula;}

    public void setTitulaKupca(titulaKupca titula){this.titula = titula;}

    public float getPopust(){return popust;}

    public void setPopust(float popust){this.popust = popust;}

    public int getTrazeni_broj_bodova(){return trazeni_broj_bodova;}

    public void setTrazeni_broj_bodova(int trazeniBrojBodova){this.trazeni_broj_bodova = trazeniBrojBodova;}

}
