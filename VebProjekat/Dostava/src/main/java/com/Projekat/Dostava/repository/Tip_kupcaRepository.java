package com.Projekat.Dostava.repository;

import com.Projekat.Dostava.entity.Tip_kupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Tip_kupcaRepository extends JpaRepository<Tip_kupca, Long> {
}
