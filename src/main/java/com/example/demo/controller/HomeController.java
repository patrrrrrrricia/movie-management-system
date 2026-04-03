package com.example.demo.controller;

import com.example.demo.Entity.Film;
import com.example.demo.Entity.Persoana;
import com.example.demo.Repository.DistributieRepository;
import com.example.demo.Repository.FilmRepository;
import com.example.demo.Repository.PersoanaRepository;
import com.example.demo.Repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

@Controller
public class HomeController {

    // injectarea repository urilor pentru a comunica cu baza de date
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private PersoanaRepository persoanaRepository;

    @Autowired
    private DistributieRepository distributieRepository;

    @Autowired
    private StudioRepository studioRepository;

    // afiseaza pagina principala a aplicatiei
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // rute pentru a afisa formularele de introducere date pentru fiecare cerinta
    @GetMapping("/form-23a")
    public String form23a() {
        return "queries/form-23a";
    }

    @GetMapping("/form-23b")
    public String form23b() {
        return "queries/form-23b";
    }

    @GetMapping("/form-24a")
    public String form24a() {
        return "queries/form-24a";
    }

    @GetMapping("/form-25b")
    public String form25b() {
        return "queries/form-25b";
    }

    @GetMapping("/form-26a")
    public String form26a() {
        return "queries/form-26a";
    }


    // cauta filmele care apartin unui anumit gen primit ca parametru
    @GetMapping("/executa-23a")
    public String executa23a(@RequestParam String gen, Model model) {
        // trimitem lista de obiecte film direct, fara sa le mai transformam in string
        model.addAttribute("lista", filmRepository.findFilmeByGen(gen));
        model.addAttribute("titlu", "Filme de genul: " + gen);
        return "queries/tabel-generic";
    }

    // cauta persoane dupa initiala numelui si domeniul adresei de email
    @GetMapping("/executa-23b")
    public String executa23b(@RequestParam String litera, @RequestParam String domeniu, Model model) {
        // luam lista de obiecte direct din repository
        List<Persoana> rezultate = persoanaRepository.findPersoaneDupaInitialaSiEmail(litera, domeniu);

        model.addAttribute("lista", rezultate);
        model.addAttribute("titlu", "Persoane: Initiala " + litera + " si Email ." + domeniu);
        return "queries/tabel-generic";
    }

    // gaseste filmele in care o persoana este si actor si producator in acelasi timp
    @GetMapping("/executa-24a")
    public String executa24a(@RequestParam(defaultValue = "Toby Stephens") String numeActor, Model model) {
        // luam lista completa de obiecte film din repository
        List<Film> rezultate = filmRepository.findFilmeActorSiProducator(numeActor);

        model.addAttribute("lista", rezultate);
        model.addAttribute("titlu", "Filme unde " + numeActor + " este si actor si producator");

        // trimitem catre tabel-generic care stie sa afiseze coloanele obiectului film
        return "queries/tabel-generic";
    }

    // gaseste perechi de actori de sex diferit care au jucat in acelasi film
    @GetMapping("/rezultat-24b")
    public String rezultat24b(Model model) {
        // obtinem datele brute (perechi de id-uri/obiecte)
        List<Object[]> perechiRaw = filmRepository.findPerechiActoriSexDiferit();

        // trimitem lista bruta direct catre tabel-generic
        model.addAttribute("lista", perechiRaw);
        model.addAttribute("titlu", "Perechi Actori Sex Diferit");
        return "queries/tabel-generic";
    }

    // identifica presedintele de studio care are cel mai mare castig net
    @GetMapping("/rezultat-25a")
    public String rezultat25a(Model model) {
        Persoana p = persoanaRepository.findPresedinteCuCastigMaxim();
        if (p != null) {
            model.addAttribute("numePresedinte", p.getNume());
        } else {
            model.addAttribute("numePresedinte", "Nu a fost gasit");
        }
        return "queries/form-25a";
    }

    // cauta filmele care au durata mai mica decat un film specificat (titlu si an)
    @GetMapping("/executa-25b")
    public String executa25b(@RequestParam String titlu, @RequestParam Integer an, Model model) {
        model.addAttribute("lista", filmRepository.findFilmeCuDurataMaiMica(titlu, an));
        model.addAttribute("titlu", "Filme mai scurte decat " + titlu);
        return "queries/tabel-generic";
    }

    // afiseaza actorii si numarul de filme in care au jucat pentru un anumit gen
    @GetMapping("/executa-26a")
    public String executa26a(@RequestParam String gen, Model model) {
        // luam lista bruta (fiecare element este un object[] cu [nume, numar])
        List<Object[]> rezultateRaw = filmRepository.findActoriFilmeDupaGen(gen);

        model.addAttribute("lista", rezultateRaw);
        model.addAttribute("titlu", "Statistici actori gen: " + gen);
        return "queries/tabel-generic";
    }

    // calculeaza valorile minime, medii si maxime ale castigurilor pentru actori
    @GetMapping("/rezultat-26b")
    public String rezultat26b(Model model) {
        Object result = filmRepository.findStatisticiCastiguriActori();

        if (result != null) {
            Object[] stats = (Object[]) result;
            // stats[0] = min, stats[1] = avg, stats[2] = max
            model.addAttribute("minim", stats[0]);
            model.addAttribute("mediu", String.format("%.2f", stats[1])); // formatam cu 2 zecimale
            model.addAttribute("maxim", stats[2]);
        }

        model.addAttribute("titlu", "Statistici Castiguri Detaliate");
        return "queries/form-26b";
    }

    // --- tabele brute pentru vizualizarea intregului continut al bazei de date ---

    // afiseaza toate filmele din baza de date
    @GetMapping("/tabel-film")
    public String afiseazaFilm(Model model) {
        model.addAttribute("lista", filmRepository.findAll());
        model.addAttribute("titlu", "FILME");
        return "queries/tabel-generic";
    }

    // afiseaza toate persoanele din baza de date
    @GetMapping("/tabel-persoana")
    public String tabelPersoana(Model model) {
        model.addAttribute("lista", persoanaRepository.findAll());
        model.addAttribute("titlu", "PERSOANA");
        return "queries/tabel-generic"; // folosim tabelul universal
    }

    // afiseaza toate studiourile din baza de date
    @GetMapping("/tabel-studio")
    public String tabelStudio(Model model) {
        model.addAttribute("lista", studioRepository.findAll());
        model.addAttribute("titlu", "STUDIO");
        return "queries/tabel-generic";
    }

    // afiseaza toate inregistrarile din tabela de distributie
    @GetMapping("/tabel-distributie")
    public String tabelDistributie(Model model) {
        // preia toate inregistrarile din tabela de distributie prin repository
        model.addAttribute("lista", distributieRepository.findAll());
        // seteaza titlul care va aparea in partea de sus a paginii
        model.addAttribute("titlu", "DISTRIBUTIE");
        // returneaza numele fisierului html care va afisa tabelul (aflat in templates/queries/)
        return "queries/tabel-generic";
    }
}