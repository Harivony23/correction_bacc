CREATE DATABASE bacc;

\c bacc;

CREATE TABLE correcteur (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255)
);

CREATE TABLE matiere (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255)
);

CREATE TABLE candidat (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255)
);

CREATE TABLE resolution (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) 
    -- 1 = plus petite note
    -- 2 = plus grande note
    -- 3 = moyenne
);

CREATE TABLE operateur (
    id SERIAL PRIMARY KEY,
    operateur VARCHAR(10) 
    -- < ou >
);

CREATE TABLE parametre (
    id SERIAL PRIMARY KEY,
    id_matiere INT,
    diff DECIMAL(10,2), -- seuil de différence entre les notes
    id_operateur INT,
    id_resolution INT,
    
    FOREIGN KEY (id_matiere) REFERENCES matiere(id),
    FOREIGN KEY (id_operateur) REFERENCES operateur(id),
    FOREIGN KEY (id_resolution) REFERENCES resolution(id)
);

-- =========================
-- NOTES DES CORRECTEURS
-- =========================
CREATE TABLE note (
    id SERIAL PRIMARY KEY,
    id_candidat INT,
    id_matiere INT,
    id_correcteur INT,
    note DECIMAL(10,2),

    FOREIGN KEY (id_candidat) REFERENCES candidat(id),
    FOREIGN KEY (id_matiere) REFERENCES matiere(id),
    FOREIGN KEY (id_correcteur) REFERENCES correcteur(id)
);

-- =========================
-- NOTE FINALE
-- =========================
CREATE TABLE notefinal (
    id SERIAL PRIMARY KEY,
    id_candidat INT,
    id_matiere INT,
    notefinal DECIMAL(10,2),

    FOREIGN KEY (id_candidat) REFERENCES candidat(id),
    FOREIGN KEY (id_matiere) REFERENCES matiere(id)
);