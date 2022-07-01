package com.Projekat.Dostava.repository;
import com.Projekat.Dostava.entity.Komentar;
import com.Projekat.Dostava.entity.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar,Long> {
    Optional<List<Komentar>> getByRestoran(Restoran restoran);
}
