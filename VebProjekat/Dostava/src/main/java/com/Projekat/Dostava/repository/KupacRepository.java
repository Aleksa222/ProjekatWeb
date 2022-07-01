package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KupacRepository extends JpaRepository<Kupac,Long> {
    Kupac getByKorisnicko(String korisnicko_ime);
}
