package com.Projekat.Dostava.entity;

import javax.persistence.*;

@Entity
public class Tip_kupca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
