package com.example.demo.Repository;

import com.example.demo.Entity.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// interfata pentru operatiile pe tabela persoana
@Repository
public interface PersoanaRepository extends JpaRepository<Persoana, Long> {

    // 02.03.b) cauta persoane al caror nume incepe cu o litera si emailul se termina cu un anumit domeniu
    @Query("SELECT p FROM Persoana p WHERE p.nume LIKE CONCAT(:litera, '%') AND p.email LIKE CONCAT('%', :domeniu) ORDER BY p.nume")
    List<Persoana> findPersoaneDupaInitialaSiEmail(@Param("litera") String litera, @Param("domeniu") String domeniu);

    // 02.05.a) selecteaza persoana care este presedinte de studio si are cel mai mare castig net din baza de date
    @Query("SELECT p FROM Persoana p WHERE p.idPersoana IN " +
            "(SELECT s.idPresedinte FROM Studio s) AND p.castigNet = " +
            "(SELECT MAX(p2.castigNet) FROM Persoana p2 WHERE p2.idPersoana IN " +
            "(SELECT s2.idPresedinte FROM Studio s2))")
    Persoana findPresedinteCuCastigMaxim();
}