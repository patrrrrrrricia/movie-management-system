--sectiune pt adaugarea datelor in tabela persoane
--contine informatii despre nume, adresa, email, sex, data nasterii si castiguri
INSERT INTO Persoana (nume, adresa, email, sex, data_nasterii, castig_net, moneda) VALUES
                                                                                       ('Cassian Alistair', 'Str. Principala nr. 10, Cluj-Napoca', 'cassian.alistair@mail.com', 'M', '1990-05-15', 5200.00, 'EUR'),
                                                                                       ('Seraphina Elara', 'Bd. Libertatii 45, București', 'seraphina.elara@mail.com', 'F', '1988-08-22', 5800.00, 'EUR'),
                                                                                       ('Perla Rose', 'Aleea Trandafirilor 3, Iasi', 'perla.rose@mail.com', 'F', '1992-03-10', 4700.00, 'USD'),
                                                                                       ('Thalassa Marin', 'Str. Marii 78, Constanta', 'thalassa.marin@mail.com', 'F', '1985-11-30', 6200.00, 'USD'),
                                                                                       ('Octavian Van', 'Calea Victoriei 120, Bucuresti', 'octavian.van@mail.com', 'M', '1978-07-04', 8500.00, 'EUR'),
                                                                                       ('Federico Wren', 'Piata Unirii 5, Timisoara', 'federico.wren@mail.com', 'M', '1995-01-20', 7200.00, 'USD'),
                                                                                       ('Arthur Ash', 'Str. Studio 1, Buftea', 'arthur.ash@mail.com', 'M', '1970-12-25', 15500.00, 'EUR'),
                                                                                       ('Toby Stephens', 'London, UK', 'toby.stephens@actor.com', 'M', '1969-04-21', 8000.00, 'USD'),
                                                                                       ('Humphrey Bogart', 'New York, USA', 'bogart@classic.com', 'M', '1899-12-25', 10000.00, 'USD'),
                                                                                       ('Hal B. Wallis', 'Hollywood, USA', 'wallis@producer.com', 'M', '1898-09-14', 12000.00, 'USD');

--sectiune pt definirea studiourilor cinematografice
--id_presedinte face legatura cu id-ul persoanei care conduce studioul
INSERT INTO Studio (nume, adresa, id_presedinte) VALUES
                                                     ('Aetheria Studio', 'Burbank, California', 7),
                                                     ('Nexus Studio', 'Hollywood', 7);

--sectiune pt introducerea filmelor in baza de date
--id_productor face legatura cu persoana care a finantat sau produs filmul
INSERT INTO Film (titlu, an, durata, gen, studio, id_productor) VALUES
                                                                    ('Die Another Day', 2002, 133, 'SF', 'Warner Bros.', 5),
                                                                    ('Film Drama 1', 2020, 120, 'drama', 'Warner Bros.', 5),
                                                                    ('Film Drama 2', 2019, 110, 'drama', 'Paramount', 5),
                                                                    ('Film Copii 1', 2021, 90, 'copii', 'Warner Bros.', 5),
                                                                    ('Film Copii 2', 2022, 95, 'copii', 'Paramount', 5),
                                                                    ('The Maltese Falcon', 1941, 100, 'drama', 'Warner Bros.', 5);

--sectiune pt tabela de legatura distributie
--asociaza un actor cu un anumit film folosind titlul si anul ca identificatori
INSERT INTO Distributie (titlu_film, an_film, id_actor) VALUES
                                                            ('Die Another Day', 2002, 4),
                                                            ('Film Copii 1', 2021, 4),
                                                            ('Film Copii 1', 2021, 2),
                                                            ('Film Copii 2', 2022, 2),
                                                            ('Film Drama 1', 2020, 1),
                                                            ('The Maltese Falcon', 1941, 6);

--add inregistrari suplimentare pt a testa perechile de actori (sex diferit)
--ii punem pe amandoi in filmul 'film drama 1' pentru a genera o pereche la interogari
INSERT INTO Distributie (titlu_film, an_film, id_actor) VALUES
                                                            ('Film Drama 1', 2020, 1);
INSERT INTO Distributie (titlu_film, an_film, id_actor) VALUES
                                                            ('Film Drama 1', 2020, 2);

--actualizarea producatorului pentru a testa cerinta unde o persoana este si actor si producator
--il facem pe Toby Stephens (id 8) producator pentru 'die another day'
UPDATE Film SET id_productor = 8 WHERE titlu = 'Die Another Day' AND an = 2002;

--add aceluiasi toby stephens in lista de actori pentru filmul respectiv
--astfel persoana cu id 8 apare si in film si in distributie
INSERT INTO Distributie (titlu_film, an_film, id_actor) VALUES
                                                            ('Die Another Day', 2002, 8);