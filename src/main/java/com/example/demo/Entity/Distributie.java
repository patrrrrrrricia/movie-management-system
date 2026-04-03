package com.example.demo.Entity;

import jakarta.persistence.*;

// defineste clasa ca fiind o entitate jpa mapata pe o tabela din baza de date
@Entity
// specifica numele exact al tabelei din baza de date
@Table(name = "distributie")
public class Distributie {

    // marcheaza campul de mai jos ca fiind cheia primara a tabelei
    @Id
    // seteaza generarea automata a id ului de catre baza de date (autoincrement)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // mapeaza variabila pe coloana titlu_film din baza de date
    @Column(name = "titlu_film")
    private String titluFilm;

    // mapeaza variabila pe coloana an_film din baza de date
    @Column(name = "an_film")
    private Integer anFilm;

    // mapeaza variabila pe coloana id_actor din baza de date
    @Column(name = "id_actor")
    private Long idActor;

    // metode de tip getter si setter pentru accesarea si modificarea datelor private
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitluFilm() { return titluFilm; }
    public void setTitluFilm(String titluFilm) { this.titluFilm = titluFilm; }

    public Integer getAnFilm() { return anFilm; }
    public void setAnFilm(Integer anFilm) { this.anFilm = anFilm; }

    public Long getIdActor() { return idActor; }
    public void setIdActor(Long idActor) { this.idActor = idActor; }

    // metoda folosita pentru a afisa datele obiectului sub forma de text
    @Override
    public String toString() {
        return "Film: " + titluFilm + " | An: " + anFilm + " | ID Actor: " + idActor;
    }
}