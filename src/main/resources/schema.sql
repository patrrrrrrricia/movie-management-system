--sterge tabelele daca exista pentru a putea recrea baza de date de la zero fara erori
DROP TABLE IF EXISTS Distributie;
DROP TABLE IF EXISTS Film;
DROP TABLE IF EXISTS Studio;
DROP TABLE IF EXISTS Persoana;

-- 02.01.c)crearea tabelei persoana pentru a stoca actori, producatori si presedinti
CREATE TABLE Persoana (
                          id_persoana INT PRIMARY KEY AUTO_INCREMENT, --cheie primara generata automat
                          nume VARCHAR(100),
                          adresa VARCHAR(200),
                          email VARCHAR(50),
                          sex CHAR(1) CHECK (sex IN ('M', 'F')), --restrictie pt a accepta doar m sau f
                          data_nasterii DATE,
                          castig_net DECIMAL(10,2), --nr zecimal pentru precizie financiara
                          moneda VARCHAR(10)
);

-- 02.01.d)crearea tabelei studio care reprezinta companiile de productie
CREATE TABLE Studio (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nume VARCHAR(100),
                        adresa VARCHAR(200),
                        id_presedinte INT,
    --legatura catre tabela persoana pentru a identifica cine conduce studioul
                        FOREIGN KEY (id_presedinte) REFERENCES Persoana(id_persoana)
);

-- 02.01.a)crearea tabelei film cu detaliile tehnice ale productiilor
CREATE TABLE Film (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      titlu VARCHAR(100),
                      an INT,
                      durata INT CHECK (durata > 0), --asigura ca durata este intotdeauna un numar pozitiv
                      gen VARCHAR(20) CHECK (gen IN ('drama', 'comedie', 'SF', 'copii')), --restrictie pentru genuri fixe
                      studio VARCHAR(100),
                      id_productor INT,
    --legatura catre persoana care are rolul de producator al filmului
                      FOREIGN KEY (id_productor) REFERENCES Persoana(id_persoana)
);

-- 02.01.b)crearea tabelei distributie pentru a gestiona relatia dintre actori si filme
CREATE TABLE Distributie (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             titlu_film VARCHAR(100),
                             an_film INT,
                             id_actor INT,
    --legatura catre persoana care joaca in filmul respectiv
                             FOREIGN KEY (id_actor) REFERENCES Persoana(id_persoana)
);