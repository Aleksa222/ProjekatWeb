package com.Projekat.Dostava.repository;

import com.Projekat.Dostava.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik,Long> {
    Korisnik getByKorisnicko(String korisnicko_ime);
}
