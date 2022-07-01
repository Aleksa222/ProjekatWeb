package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer,Long> {
    Menadzer getByKorisnicko(String korisnicko_ime);
}
