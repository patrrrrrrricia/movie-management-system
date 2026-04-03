package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// indica faptul ca este o clasa de test care incarca intregul context al aplicatiei spring boot
@SpringBootTest
class DemoApplicationTests {

    // marcheaza metoda ca fiind un test unitar
    @Test
    void contextLoads() {
        // metoda este goala dar simpla ei executie verifica daca aplicatia porneste corect fara erori de configurare
    }

}