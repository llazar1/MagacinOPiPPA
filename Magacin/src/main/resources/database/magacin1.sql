-- Kreiranje baze podataka
CREATE DATABASE IF NOT EXISTS magacin;
USE magacin;

-- Kreiranje tabele radnik
CREATE TABLE radnik (
    radnik_id INT AUTO_INCREMENT PRIMARY KEY,
    ime_i_prezime VARCHAR(64) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(88) NOT NULL,
    telefon VARCHAR(45) UNIQUE
);

-- Kreiranje tabele prostor
CREATE TABLE prostor (
    prostor_id INT AUTO_INCREMENT PRIMARY KEY,
    radnik_id INT NOT NULL,
    ime_magacina VARCHAR(45),
    CONSTRAINT fk_prostor_radnik FOREIGN KEY (radnik_id) REFERENCES radnik(radnik_id)
);

-- Kreiranje tabele proizvod
CREATE TABLE proizvod (
    proizvod_id INT AUTO_INCREMENT PRIMARY KEY,
    prostor_id INT NOT NULL,
    naziv VARCHAR(45) NOT NULL,
    tip VARCHAR(45),
    tezina VARCHAR(45),
    kolicina INT NOT NULL,
    napomena VARCHAR(80),
    CONSTRAINT fk_proizvod_prostor FOREIGN KEY (prostor_id) REFERENCES prostor(prostor_id)
);

-- Dodavanje indeksa za tabele
CREATE UNIQUE INDEX uq_radnik_username ON radnik(username);
CREATE UNIQUE INDEX uq_radnik_telefon ON radnik(telefon);
CREATE INDEX fk_prostor_radnik_id_idx ON prostor(radnik_id);
CREATE INDEX fk_proizvod_prostor_id_idx ON proizvod(prostor_id);

