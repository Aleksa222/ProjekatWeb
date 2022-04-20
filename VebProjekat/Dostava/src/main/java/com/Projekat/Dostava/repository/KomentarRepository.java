package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarRepository extends JpaRepository<Komentar,Long> {
}
