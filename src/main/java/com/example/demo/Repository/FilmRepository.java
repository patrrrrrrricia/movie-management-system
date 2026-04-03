package com.example.demo.Repository;

import com.example.demo.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// interfata pentru operatiile pe tabela film
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    // 02.03.a) selecteaza filmele dupa gen si le ordoneaza crescator dupa an si descrescator dupa titlu
    @Query("SELECT f FROM Film f WHERE f.gen = :gen ORDER BY f.an ASC, f.titlu DESC")
    List<Film> findFilmeByGen(@Param("gen") String gen);

    // 02.04.a) gaseste filmele unde o persoana este in acelasi timp si actor si producator (sql nativ)
    @Query(value = """

            SELECT f.* FROM Film f 
        INNER JOIN Distributie d ON f.titlu = d.titlu_film AND f.an = d.an_film
        INNER JOIN Persoana a ON d.id_actor = a.id_persoana
        WHERE a.nume = :numeActor AND f.id_productor = a.id_persoana
        """, nativeQuery = true)
    List<Film> findFilmeActorSiProducator(@Param("numeActor") String numeActor);

    // 02.04.b) selecteaza perechi unice de actori de sex diferit care apar in acelasi film
    @Query(value = """
    SELECT DISTINCT d1.id_actor AS id1, d2.id_actor AS id2
    FROM Distributie d1
    JOIN Distributie d2 ON d1.titlu_film = d2.titlu_film AND d1.an_film = d2.an_film
    JOIN Persoana p1 ON d1.id_actor = p1.id_persoana
    JOIN Persoana p2 ON d2.id_actor = p2.id_persoana
    WHERE d1.id_actor < d2.id_actor 
      AND p1.sex <> p2.sex
    """, nativeQuery = true)
    List<Object[]> findPerechiActoriSexDiferit();

    // 02.05.b) selecteaza filmele care au durata mai mica decat durata unui anumit film dat prin titlu si an
    @Query("SELECT f FROM Film f WHERE f.durata < " +
            "(SELECT f2.durata FROM Film f2 WHERE f2.titlu = :titlu AND f2.an = :an)")
    List<Film> findFilmeCuDurataMaiMica(@Param("titlu") String titlu, @Param("an") Integer an);

    // 02.06.a) numara filmele dintr-un anumit gen pentru fiecare actor si le sorteaza descrescator
    @Query(value = """
        SELECT p.nume, COUNT(DISTINCT d.titlu_film) as numar_filme
        FROM Persoana p
        INNER JOIN Distributie d ON p.id_persoana = d.id_actor
        INNER JOIN Film f ON d.titlu_film = f.titlu AND d.an_film = f.an
        WHERE f.gen = :gen
        GROUP BY p.id_persoana, p.nume
        ORDER BY numar_filme DESC
        """, nativeQuery = true)
    List<Object[]> findActoriFilmeDupaGen(@Param("gen") String gen);

    // 02.06.b) calculeaza minimul, media si maximul castigurilor doar pentru cei care sunt exclusiv actori
    @Query(value = """
    SELECT MIN(castig_net), AVG(castig_net), MAX(castig_net) 
    FROM Persoana 
    WHERE id_persoana IN (SELECT DISTINCT id_actor FROM Distributie) 
    AND id_persoana NOT IN (SELECT id_productor FROM Film UNION SELECT id_presedinte FROM Studio)
    """, nativeQuery = true)
    Object findStatisticiCastiguriActori(); // Schimbat din Object[] în Object
}