package com.Projekat.Dostava.repository;

import com.Projekat.Dostava.entity.Artikal_za_Porudzbinu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Artikal_za_PorudzbinuRepository extends JpaRepository<Artikal_za_Porudzbinu,Long> {
}
