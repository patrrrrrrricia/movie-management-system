package com.example.demo.Entity;

import jakarta.persistence.*;
import java.util.Date;

// defineste clasa ca fiind o entitate jpa pentru baza de date
@Entity
// specifica numele tabelei persoana din baza de date
@Table(name = "Persoana")
public class Persoana {

    // marcheaza campul de mai jos ca fiind cheia primara
    @Id
    // seteaza baza de date sa incrementeze automat valoarea id-ului
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // mapeaza variabila pe coloana id_persoana
    @Column(name = "id_persoana")
    private Long idPersoana;

    // mapeaza variabila pe coloana nume
    @Column(name = "nume")
    private String nume;

    // mapeaza variabila pe coloana email
    @Column(name = "email")
    private String email;

    // mapeaza variabila pe coloana sex
    @Column(name = "sex")
    private String sex;

    // mapeaza variabila pe coloana data_nasterii folosind tipul date
    @Column(name = "data_nasterii")
    private Date dataNasterii;

    // mapeaza variabila pe coloana castig_net pentru valori zecimale
    @Column(name = "castig_net")
    private Double castigNet;

    // mapeaza variabila pe coloana moneda
    @Column(name = "moneda")
    private String moneda;

    // metode de tip getter si setter pentru accesul la atributele private ale clasei
    public Long getIdPersoana() { return idPersoana; }
    public void setIdPersoana(Long idPersoana) { this.idPersoana = idPersoana; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public Date getDataNasterii() { return dataNasterii; }
    public void setDataNasterii(Date dataNasterii) { this.dataNasterii = dataNasterii; }

    public Double getCastigNet() { return castigNet; }
    public void setCastigNet(Double castigNet) { this.castigNet = castigNet; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    // returneaza o descriere textuala a persoanei pentru afisare rapida
    @Override
    public String toString() {
        return "Nume: " + nume + " | Email: " + email + " | Sex: " + sex + " | Castig: " + castigNet;
    }
}