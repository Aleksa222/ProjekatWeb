package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin getByKorisnicko(String korisnicko_ime);
}
