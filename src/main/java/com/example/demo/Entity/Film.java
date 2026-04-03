package com.example.demo.Entity;

import jakarta.persistence.*;

// defineste clasa ca entitate gestionata de hibernate pentru baza de date
@Entity
// precizeaza numele tabelei film din baza de date
@Table(name = "Film")
public class Film {

    // defineste campul id ca fiind cheia primara
    @Id
    // configureaza baza de date sa genereze automat valorile pentru id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // mapeaza variabila pe coloana titlu din tabela
    @Column(name = "titlu")
    private String titlu;

    // mapeaza variabila pe coloana an din tabela
    @Column(name = "an")
    private Integer an;

    // mapeaza variabila pe coloana durata din tabela
    @Column(name = "durata")
    private Integer durata;

    // mapeaza variabila pe coloana gen din tabela
    @Column(name = "gen")
    private String gen;

    // mapeaza variabila pe coloana studio din tabela
    @Column(name = "studio")
    private String studio;

    // mapeaza variabila pe coloana id_productor din tabela
    @Column(name = "id_productor")
    private Long idProductor;

    // metode getter si setter pentru a permite citirea si modificarea campurilor private
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public Integer getAn() { return an; }
    public void setAn(Integer an) { this.an = an; }

    public Integer getDurata() { return durata; }
    public void setDurata(Integer durata) { this.durata = durata; }

    public String getGen() { return gen; }
    public void setGen(String gen) { this.gen = gen; }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    public Long getIdProductor() { return idProductor; }
    public void setIdProductor(Long idProductor) { this.idProductor = idProductor; }

    // defineste modul in care obiectul film este afisat ca sir de caractere
    @Override
    public String toString() {
        return "Titlu: " + titlu + " | An: " + an + " | Durata: " + durata + " min | Gen: " + gen;
    }
}