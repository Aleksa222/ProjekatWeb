package com.Projekat.Dostava.repository;

import com.Projekat.Dostava.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran,Long> {
    Restoran getByNaziv(String naziv);
}
