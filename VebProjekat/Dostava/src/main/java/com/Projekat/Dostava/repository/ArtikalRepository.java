package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikalRepository extends JpaRepository <Artikal,Long> {
}
