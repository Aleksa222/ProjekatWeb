package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina,Long> {
}
