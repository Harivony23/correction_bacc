TRUNCATE TABLE notefinal RESTART IDENTITY CASCADE;
TRUNCATE TABLE note RESTART IDENTITY CASCADE;
TRUNCATE TABLE parametre RESTART IDENTITY CASCADE;
TRUNCATE TABLE operateur RESTART IDENTITY CASCADE;
TRUNCATE TABLE resolution RESTART IDENTITY CASCADE;
TRUNCATE TABLE candidat RESTART IDENTITY CASCADE;
TRUNCATE TABLE matiere RESTART IDENTITY CASCADE;
TRUNCATE TABLE correcteur RESTART IDENTITY CASCADE;

INSERT INTO correcteur (nom) VALUES 
('Monsieur Rova'), ('Madame Fidy'), ('Dr. Rakoto'), ('Pr. Lalaina');

INSERT INTO matiere (nom) VALUES 
('Philosophie'), ('Mathématiques'), ('Physique-Chimie'), ('SVT');

INSERT INTO candidat (nom) VALUES 
('Andry'), ('Miora'), ('Soa'), ('Tôni');

INSERT INTO operateur (operateur) VALUES 
('<'), ('>'), ('<='), ('>='), ('=');

INSERT INTO resolution (nom) VALUES 
('plus petit'), ('plus grand'), ('moyenne');

INSERT INTO parametre (id_matiere, diff, id_operateur, id_resolution) VALUES (1, 5, 1, 2);
INSERT INTO parametre (id_matiere, diff, id_operateur, id_resolution) VALUES (2, 3, 1, 3);
INSERT INTO parametre (id_matiere, diff, id_operateur, id_resolution) VALUES (3, 2, 2, 1);
INSERT INTO parametre (id_matiere, diff, id_operateur, id_resolution) VALUES (4, 4, 1, 2);

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES 
(1, 1, 1, 18), (1, 1, 2, 10);

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES 
(2, 2, 1, 12), (2, 2, 2, 14);

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES 
(3, 3, 1, 15), (3, 3, 2, 14), (3, 3, 3, 16);

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES 
(4, 4, 1, 08), (4, 4, 2, 14);

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES 
(1, 2, 3, 10), (1, 2, 4, 16);
