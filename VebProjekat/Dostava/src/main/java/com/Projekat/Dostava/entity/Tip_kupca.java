package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Tip_kupca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdTip_kupca;

    public Long getId() {
        return IdTip_kupca;
    }

    public void setId(Long id) {
        IdTip_kupca = id;
    }

}
