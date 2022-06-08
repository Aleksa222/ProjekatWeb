package com.Projekat.Dostava.repository;

import com.Projekat.Dostava.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestoranRepository extends JpaRepository<Restoran,Long> {
    Restoran getByNaziv(String naziv);
}
