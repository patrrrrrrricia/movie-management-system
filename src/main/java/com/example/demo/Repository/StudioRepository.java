package com.example.demo.Repository;

import com.example.demo.Entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marcheaza interfata ca repository pentru gestionarea tabelei studio
@Repository
// extinde jparepository pentru a permite operatii de baza pe entitatea studio
// foloseste entitatea studio si tipul string pentru cheia primara (numele studioului)
public interface StudioRepository extends JpaRepository<Studio, String> {
    // clasa este goala deoarece momentan folosim doar metodele standard de cautare si salvare
}