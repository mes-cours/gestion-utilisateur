DROP TABLE IF EXISTS utilisateurs;

CREATE TABLE utilisateurs (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  dateNaissance DATE NOT NULL,
  paysResidence VARCHAR(250) NOT NULL,
  telephone VARCHAR(250) DEFAULT NULL,
  genre VARCHAR(250) DEFAULT NULL
);

INSERT INTO utilisateurs (nom, dateNaissance, paysResidence, telephone, genre) VALUES
  ('Anta FALL', TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'France','',''),
  ('Khalifa NDIAYE', TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'Senegal','',''),
  ('Abdou DIOP', TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'Maroc','','');