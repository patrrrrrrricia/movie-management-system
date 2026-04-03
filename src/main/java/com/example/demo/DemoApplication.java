package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// marcheaza clasa ca fiind punctul de pornire al aplicatiei spring boot
// activeaza configurarea automata si scanarea componentelor din proiect
@SpringBootApplication
public class DemoApplication {

    // metoda principala care ruleaza la pornirea programului java
    public static void main(String[] args) {
        // lanseaza aplicatia spring si porneste serverul web incorporat (tomcat)
        SpringApplication.run(DemoApplication.class, args);
    }

}