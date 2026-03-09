-- =====================================================
-- INSERTION DES DONNÉES
-- =====================================================

-- CORRECTEURS
INSERT INTO correcteur (nom) VALUES
('Rakoto'),
('Rabe'),
('Rasoa'),
('Randria');

-- MATIÈRES
INSERT INTO matiere (nom) VALUES
('Math'),
('Physique'),
('SVT'),
('Philosophie');

-- CANDIDATS
INSERT INTO candidat (nom) VALUES
('Jean'),
('Marie'),
('Paul'),
('Luc');

-- RÉSOLUTIONS
INSERT INTO resolution (nom) VALUES
('plus_petit'),
('plus_grand'),
('moyenne');

-- OPÉRATEURS
INSERT INTO operateur (operateur) VALUES
('<'),
('>');

-- PARAMETRES DE CORRECTION
INSERT INTO parametre (id_matiere, diff, id_operateur, id_resolution) VALUES
-- Math
(1, 2.00, 1, 3), -- si ecart < 2 : moyenne
(1, 2.00, 2, 2), -- si ecart > 2 : plus grande note
-- Physique
(2, 3.00, 1, 3), -- si ecart < 3 : moyenne
(2, 3.00, 2, 1), -- si ecart > 3 : plus petite note
-- SVT
(3, 1.50, 1, 3), -- si ecart < 1.5 : moyenne
(3, 1.50, 2, 2), -- si ecart > 1.5 : plus grande note
-- Philosophie
(4, 4.00, 1, 3), -- si ecart < 4 : moyenne
(4, 4.00, 2, 1); -- si ecart > 4 : plus petite note

-- =====================================================
-- NOTES ATTRIBUÉES PAR LES CORRECTEURS
-- =====================================================

INSERT INTO note (id_candidat, id_matiere, id_correcteur, note) VALUES
-- Jean
(1,1,1,12),(1,1,2,13),
(1,2,1,10),(1,2,3,15),
(1,3,2,14),(1,3,4,13),
(1,4,3,8),(1,4,4,12),
-- Marie
(2,1,1,15),(2,1,2,14),
(2,2,2,9),(2,2,3,13),
(2,3,1,11),(2,3,4,12),
(2,4,3,16),(2,4,4,10),
-- Paul
(3,1,2,7),(3,1,3,11),
(3,2,1,12),(3,2,4,14),
(3,3,1,10),(3,3,2,10),
(3,4,3,9),(3,4,4,15),
-- Luc
(4,1,1,13),(4,1,4,17),
(4,2,2,11),(4,2,3,12),
(4,3,1,14),(4,3,3,16),
(4,4,2,7),(4,4,4,9);

-- =====================================================
-- NOTES FINALES (EXEMPLES)
-- =====================================================

INSERT INTO notefinal (id_candidat, id_matiere, notefinal) VALUES
(1,1,12.5),
(1,2,10),
(1,3,13.5),
(1,4,8),

(2,1,14.5),
(2,2,9),
(2,3,11.5),
(2,4,10),

(3,1,7),
(3,2,13),
(3,3,10),
(3,4,9),

(4,1,17),
(4,2,11.5),
(4,3,15),
(4,4,7);