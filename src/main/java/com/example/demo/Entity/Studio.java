package com.example.demo.Entity;

import jakarta.persistence.*;

// defineste clasa ca entitate gestionata de framework-ul jpa pentru persistenta datelor
@Entity
// specifica numele tabelei studio din baza de date
@Table(name = "Studio")
public class Studio {

    // marcheaza campul ca fiind identificatorul unic (cheia primara)
    @Id
    // configureaza baza de date sa genereze automat valori unice pentru id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // mapeaza variabila pe coloana nume din tabela
    @Column(name = "nume")
    private String nume;

    // mapeaza variabila pe coloana adresa din tabela
    @Column(name = "adresa")
    private String adresa;

    // mapeaza variabila pe coloana id_presedinte din tabela
    @Column(name = "id_presedinte")
    private Long idPresedinte;

    // metode de tip getter si setter pentru a interactiona cu atributele private ale clasei
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public Long getIdPresedinte() { return idPresedinte; }
    public void setIdPresedinte(Long idPresedinte) { this.idPresedinte = idPresedinte; }

    // defineste reprezentarea sub forma de text a obiectului studio
    @Override
    public String toString() {
        return "Studio: " + nume + " | Adresa: " + adresa + " | ID Presedinte: " + idPresedinte;
    }
}