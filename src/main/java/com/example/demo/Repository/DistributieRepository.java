package com.example.demo.Repository;

import com.example.demo.Entity.Distributie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// marcheaza interfata ca fiind o componenta de tip repository pentru gestionarea datelor
@Repository
// extinde jparepository pentru a beneficia de metodele standard de tip crud (save, findall, delete etc.)
// foloseste entitatea distributie si tipul long pentru cheia primara
public interface DistributieRepository extends JpaRepository<Distributie, Long> {
    // interfata ramane momentan goala deoarece folosim doar metodele predefinite din jparepository
}