CREATE DATABASE village_green;

USE village_green;

CREATE TABLE commercial (
   id_commercial INT AUTO_INCREMENT NOT NULL,
   nom_commercial VARCHAR(50), 
   prenom_commercial VARCHAR(50),
   tel_commercial VARCHAR(50), 
   mail_commercial VARCHAR(50),
   PRIMARY KEY(id_commercial)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;   

-- Jeu de test
INSERT INTO `commercial` (`id_commercial`,`nom_commercial`,`prenom_commercial`,`tel_commercial`,`mail_commercial`) 
                  VALUES (1, "Dupont", "Jean", "01 23 45 67 89", "jdupont@village-green.com"), (2, "Durand", "Michel", "01 98 76 54 32", "mdurand@village-green.com");
                  
ALTER TABLE `commercial`
ADD COLUMN mdp_commercial VARCHAR(255) AFTER `mail_commercial`;

CREATE TABLE rubrique(
   id_rubrique INT AUTO_INCREMENT NOT NULL,
   nom_rubrique VARCHAR(50),
   PRIMARY KEY(id_rubrique)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;   

-- Jeu de test
INSERT INTO `rubrique` (`id_rubrique`,`nom_rubrique`) VALUES (1,"Guit/Bass");

CREATE TABLE sous_rubrique(
   id_sous_rubrique INT AUTO_INCREMENT NOT NULL,
   nom_sous_rubrique VARCHAR(50),
   id_rubrique INT,
   PRIMARY KEY(id_sous_rubrique),
   FOREIGN KEY(id_rubrique) REFERENCES rubrique(id_rubrique)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- Jeu de test
INSERT INTO `sous_rubrique` (`id_sous_rubrique`,`nom_sous_rubrique`,`id_rubrique`) 
                     VALUES (1,"Guitares Electriques",1), (2,"Guitares Classique",1), 
							       (3,"Guitares Acoustiques & Electro-Acoustique",1), 
							       (4,"Basses Electriques",1), 
							       (5,"Basses Acoustiques",1), 
							       (6,"Basses Semi-Acoustiques",1), 
							       (7,"Ukulélés",1), 
							       (8,"Autres instruments à cordes pincées",1);
																														

CREATE TABLE fournisseur (
   id_fournisseur INT AUTO_INCREMENT NOT NULL,
   ref_fournisseur VARCHAR(50),
   nom_fournisseur VARCHAR(50) ,
   adresse_fournisseur VARCHAR(50),
   nom_contact_fournisseur VARCHAR(50),
   prenom_contact_fournisseur VARCHAR(50),
   tel_fournisseur VARCHAR(50),
   mail_fournisseur VARCHAR(50),
   PRIMARY KEY(id_fournisseur)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;  

-- Jeu de test
INSERT INTO `fournisseur` (`id_fournisseur`,`ref_fournisseur`,`nom_fournisseur`,`adresse_fournisseur`,`nom_contact_fournisseur`,`prenom_contact_fournisseur`,`tel_fournisseur`,`mail_fournisseur`) 
                   VALUES (1, "FOU0001", "Uppercut Guitars", "23 avenue de la Châtaigne 80000 Libertyland", "Durden", "Tyler", "03 75 66 28 47", "tdurden@uppercutguitars.com"), 
						        (2, "FOU0002", "Acoustic Dreams", "16 rue de la Méditation 80001 Zenville", "Marley", "Bob", "03 89 78 87 98", "bmarley@acousticdreams.com"), 
						        (3, "FOU0003", "Haloha Uku", "15 rue du Soleil et de la l'Océan 80002 Hawaïville", "Hepburn", "Audrey", "03 24 48 36 16", "ahepburn@halohauku.com"), 
						        (4, "FOU0004", "Pas d'idée musique", "8 rue Jesaipas 80003 Quelquepart", "Bond", "James", "03 75 48 65 64", "jbond@pasdideemusique.com");

CREATE TABLE client(
   id_client INT AUTO_INCREMENT NOT NULL,
   numero_client VARCHAR(50),
   coefficient_client VARCHAR(50),
   nom_client VARCHAR(50),
   prenom_client VARCHAR(50),
   adresse_client VARCHAR(255),
   comp_adresse_client VARCHAR(255),
   code_postal_client VARCHAR(5),
   ville_client VARCHAR(50),
   statut_client BOOL,
   tel_client VARCHAR(50),
   mail_client VARCHAR(50),
   mdp_client VARCHAR(255),
   reduction_client DECIMAL(4,2),
   adresse_livraison_client VARCHAR(255),
   adresse_facturation_client VARCHAR(255),
   id_commercial INT NOT NULL,
   PRIMARY KEY(id_client),
   FOREIGN KEY(id_commercial) REFERENCES commercial(id_commercial)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;   

-- Jeu de test
INSERT INTO `client` (`id_client`,`numero_client`,`coefficient_client`,`nom_client`,`prenom_client`,`adresse_client`, `comp_adresse_client`,`code_postal_client`,`ville_client`,`statut_client`,`tel_client`,`mail_client`,`mdp_client`,`reduction_client`,`adresse_livraison_client`,`adresse_facturation_client`,`id_commercial`) 
              VALUES (1, "CLI0001", "12", "DAVIS", "Jonathan", "4 rue du Leader", "Follow The", "80666", "Korn", 0, "06 66 66 66 66", "jdavis@korn.com", "daddy", 10.5,  "4 rue du Leader Follow The 80666 Korn", "4 rue du Leader Follow The 80666 Korn", 1), 
						   (2, "CLI0002", "12", "WELCH", "Brian", "8 rue du Meth", (NULL), "80666", "Korn", 0, "06 15 11 19 87", "bwelch@korn.com", "jesus", 10.5,  "8 rue du Meth 80666 Korn", "8 rue du Meth 80666 Korn", 2),
							(3, "CLI0003", "12", "YORKE", "Thom", "15 rue de la Pyramide", (NULL), "80967", "Radiohead", 0, "06 67 68 69 65", "tyorke@radiohead.com", "pyramide", 10.5, "15 rue de la Pyramide 80967 Radiohead", "15 rue de la Pyramide 80967 Radiohead", 1),
							(4, "CLI0004", "18", "AVENUE", "Music", "16 avenue de la musique", (NULL), "80000", "Amiens", 1, "03 80 71 93 64", "contact@musicavenue.com", "musicavenue", 12, "16 avenue de la Musique 80000 Amiens", "16 avenue de la Musique 80000 Amiens", 2),
							(5, "CLI0005", "12", "GIBBONS", "Beth", "23 rue du brouillard", (NULL), "81994", "Bristol", 0, "03 96 48 67 75", "bgibbons@portishead.com", "dummy", 10.5, "23 rue du Brouillard 81994 Bristol", "23 rue du Brouillard 81994 Bristol", 1),
							(6, "CLI0006", "12", "LOCKE", "JOHN", "42 rue de l'île", (NULL), "80010", "Lost", 0, "03 96 65 16 75", "jlocke@lost.com", "destin", 10.5, "42 rue de l'île 80010 Lost", "42 rue de l'île 80010 Lost", 2),
							(7, "CLI0007", "12", "SCHWAL", "Hans", "9 rue des Cordeliers", (NULL), "80000", "Amiens", 0, "06 61 38 81 71", "hschwal@afpa.com", "motdepasselol", 10.5, "9 rue des Cordeliers 80000 Amiens", "9 rue des Cordeliers 80000 Amiens", 1),
							(8, "CLI0008", "18", "MUSIC", "Royez", "22 rue des Vergeaux", (NULL), "80000", "Amiens", 1, "03 22 71 71 30", "contact@royezmusic.com", "royezmusic", 12, "22 rue des Vergeaux 80000 Amiens", "22 rue des Vergeaux 80000 Amiens", 2),
							(9, "CLI0009", "18", "NROLL", "Broc", "2 rue Flatters", (NULL), "80000", "Amiens", 1, "03 22 33 13 69", "contact@brocnroll.com", "brocnroll", 12, "2 rue Flatters 80000 Amiens", "2 rue Flatters 80000 Amiens", 1),							
							(10, "CLI0010", "18", "MUSIC", "Stars", "1 boulevard de Clichy", (NULL), "75009", "Paris", 1, "01 45 26 75 00", "contact@starsmusic.com", "starsmusic", 12, "1 boulevard de Clichy 75009 Paris", "1 boulevard de Clichy 75009 Paris", 2);
						
							
CREATE TABLE produit(
   id_produit INT AUTO_INCREMENT NOT NULL,
   ref_produit VARCHAR(255),
   ref_fournisseur VARCHAR(50),
   lien_photo_produit VARCHAR(255),
   designation_produit VARCHAR(50),
   description_produit VARCHAR(255),
   prix_achat_produit DECIMAL(6,2),
   prix_vente_produit DECIMAL(6,2),
   id_sous_rubrique INT NOT NULL,
   id_fournisseur INT NOT NULL,
   PRIMARY KEY(id_produit),
   FOREIGN KEY(id_sous_rubrique) REFERENCES sous_rubrique(id_sous_rubrique),
   FOREIGN KEY(id_fournisseur) REFERENCES fournisseur(id_fournisseur)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;  

-- Jeu de test
INSERT INTO `produit` (`id_produit`,`ref_produit`,`ref_fournisseur`,`lien_photo_produit`,`designation_produit`,`description_produit`,`prix_achat_produit`,`prix_vente_produit`,`id_sous_rubrique`,`id_fournisseur`) 
               VALUES (1, "PRO0001","FOU0001", "lien1", "Ibanez 7 cordes", "Une gratte taillée pour le gros son!", 899.90, 1290.00, 1,1),
               		 (2, "PRO0002","FOU0002", "lien2", "Yamaha Classique", "Un corps en acajou, des cordes en nylon, un plaisir sans nom", 399.90, 590.00, 2,2),
               		 (3, "PRO0003","FOU0002", "lien3", "Fender Acoustique", "Idéale pour jouer autour du feu!", 499.90, 650.00, 3,2),
               		 (4, "PRO0004","FOU0001", "lien4", "Ibanez 5 cordes", "Ca sent le groove là ou pas???!", 899.90, 1290.00, 4,1),
               		 (5, "PRO0005","FOU0002", "lien5", "Ibanez Basse Acoustique", "Pour jouer vos morceau unplugged, sous une lumière tamisée...", 699.90, 890.00, 5,2),
               		 (6, "PRO0006","FOU0002", "lien6", "Cort Basse Semi-Acoustique", "Une basse semi-acoustique, toujours utile en studio!", 799.90, 1090.00, 6,2),
               		 (7, "PRO0007","FOU0003", "lien7", "Kamaka", "Somewhere over the rainbow... un son pur, rond et chaud", 299.90, 490.00, 7,3),
               		 (8, "PRO0008","FOU0004", "lien8", "Sitar", "Pour les passionnés de musiques orientales, un petit bijou!", 1299.90, 1500.00, 8,4);


CREATE TABLE commande(
   id_commande INT AUTO_INCREMENT NOT NULL,
   numero_commande VARCHAR(50),
   date_commande DATETIME,
   adresse_livraison_commande VARCHAR(255),
   adresse_facturation_commande VARCHAR(255),
   statut_commande VARCHAR(50),
   numero_facture VARCHAR(50),
   date_facture DATE,
   tva DECIMAL(4,2),
   montant_ht DECIMAL(6,2),
   type_reglement VARCHAR(255),
   date_reglement_facture DATE NOT NULL,
   id_client INT NOT NULL,
   PRIMARY KEY(id_commande),
   FOREIGN KEY(id_client) REFERENCES client(id_client)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- Jeu de test  	
INSERT INTO `commande` (`id_commande`,`numero_commande`,`date_commande`,`adresse_livraison_commande`,`adresse_facturation_commande`,`statut_commande`,`numero_facture`,`date_facture`,`tva`,`montant_ht`,`type_reglement`,`date_reglement_facture`,`id_client`)
                VALUES (1,"COM0001", "2018-11-15 14:00:00", "4 rue du Leader Follow The 80666 Korn", "4 rue du Leader Follow The 80666 Korn", "Livrée", "FAC0001", "2018-11-15 14:00:00", 20.0, 1290.00, "carte bancaire", "2019-10-10", 1),
					        (2,"COM0002", "2019-10-12 14:00:00", "8 rue du Meth 80666 Korn", "8 rue du Meth 80666 Korn", "Livrée", "FAC0002", "2019-10-12 14:00:00", 20.0, 1290.00, "carte bancaire", "2019-10-12", 2),
							  (3,"COM0003", "2019-10-15 14:00:00", "15 rue de la Pyramide 80967 Radiohead", "15 rue de la Pyramide 80967 Radiohead", "Livrée", "FAC0003", "2019-10-15 14:00:00", 20.0, 1299.00, "carte bancaire", "2019-10-12", 3),
							  (4,"COM0004", "2019-10-01 14:00:00", "16 avenue de la Musique 80000 Amiens", "16 avenue de la Musique 80000 Amiens", "Livrée", "FAC0004", "2019-10-01 14:00:00", 20.0, 3250.00, "virement bancaire", "2019-11-01", 4),
							  (5,"COM0005", "2019-10-10 14:00:00", "9 rue des Cordeliers 80000 Amiens", "9 rue des Cordeliers 80000 Amiens", "En cours de livraison", "FAC0005", "2018-11-15 14:00:00", 20.0, 1290.00, "carte bancaire", "2019-11-01", 7),
							  (6, "COM0006", "2019-10-16 14:00:00", "4 rue du Leader Follow The 80666 Korn", "4 rue du Leader Follow The 80666 Korn", "En cours de livraison", "FAC0006", "2019-10-16 14:00:00", 20.0, 490.00, "carte bancaire", "2019-10-16", 1),
							  (7, "COM0007", "2019-10-17 14:00:00", "8 rue du Meth 80666 Korn", "8 rue du Meth 80666 Korn", "En cours de livraison", "FAC0007", "2019-10-17 14:00:00", 20.0, 1090.00, "carte bancaire", "2019-10-17", 2),
							  (8, "COM0008", "2019-10-17 14:00:00", "23 rue du Brouillard 81994 Bristol", "23 rue du Brouillard 81994 Bristol", "livrée", "FAC0008", "2019-10-17 14:00:00", 20.0, 590.00, "carte bancaire", "2019-10-17", 5),
							  (9, "COM0009", "2019-05-17 14:00:00", "22 rue des Vergeaux 80000 Amiens", "22 rue des Vergeaux 80000 Amiens", "livrée", "FAC0009", "2019-10-17 14:00:00", 20.0, 6010.00, "virement bancaire", "2019-06-17", 8),
						  	  (10, "COM0010", "2019-04-02 14:00:00", "42 rue de l'île 80010 Lost", "42 rue de l'île 80010 Lost", "livrée", "FAC0010", "2019-04-02 14:00:00", 20.0, 3080.00, "carte bancaire", "2019-04-02", 6),
							  (11, "COM0011", "2019-04-08 14:00:00", "2 rue Flatters 80000 Amiens", "2 rue Flatters 80000 Amiens", "livrée", "FAC0011", "2019-04-08 14:00:00", 20.0, 3520.00, "carte bancaire", "2019-04-08", 9),
					        (12, "COM0012", "2019-04-12 14:00:00", "1 boulevard de Clichy 75009 Paris", "1 boulevard de Clichy 75009 Paris", "livrée", "FAC0012", "2019-04-12 14:00:00", 20.0, 4080.00, "virement bancaire", "2019-05-12", 10);
						
		
CREATE TABLE livraison(
   id_bon_livraison INT AUTO_INCREMENT NOT NULL,
   date_livraison DATE,
   numero_livraison VARCHAR(50),
   id_commande INT NOT NULL,
   PRIMARY KEY(id_bon_livraison),
   FOREIGN KEY(id_commande) REFERENCES commande(id_commande)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8; 
 
-- Jeu de test 
INSERT INTO `livraison` (`id_bon_livraison`,`date_livraison`,`numero_livraison`,`id_commande`) 
                 VALUES (1, "2018-11-22","LIV0001", 1), 
                        (2, "2019-10-20","LIV0002", 2),
                        (3, "2019-10-20","LIV0003", 3),
                        (4, "2019-10-10","LIV0004", 4),
                        (5, (NULL),"LIV0005", 5),
                        (6, (NULL),"LIV0006", 6),
							   (7, (NULL), "LIV0007", 7),
							   (8, "2019-10-21", "LIV0008", 8),
							   (9, "2019-05-24", "LIV0009", 9),
								(10, "2019-05-26", "LIV0010", 9),
							   (11, "2019-04-09", "LIV0011", 10),
						      (12, "2019-04-15", "LIV0012", 11),
						      (13, "2019-04-19", "LIV0013", 12);  


CREATE TABLE ligne_de_commande(
   id_ligne_commande INT AUTO_INCREMENT NOT NULL,
   ref_produit_commande VARCHAR(50),
   designation_produit_commande VARCHAR(50),
   prix_unitaire_ht DECIMAL(6,2),
   quantite_produit SMALLINT,
   total_ttc DECIMAL(12,2),
   id_produit INT NOT NULL,
   id_commande INT NOT NULL,
   PRIMARY KEY(id_ligne_commande),
   FOREIGN KEY(id_produit) REFERENCES produit(id_produit),
   FOREIGN KEY(id_commande) REFERENCES commande(id_commande)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;   

-- Jeu de test
INSERT INTO `ligne_de_commande` (`id_ligne_commande`,`ref_produit_commande`,`designation_produit_commande`,`prix_unitaire_ht`,`quantite_produit`,`total_ttc`,`id_produit`,`id_commande`) 
                         VALUES (1,"PRO0001", "Ibanez 7 cordes", 1290.00, 1, 1548.00, 1, 1),
                                (2,"PRO0001", "Ibanez 7 cordes", 1290.00, 1, 1548.00, 1, 2),
                                (3,"PRO0008", "Sitar", 1500.00, 1, 1800.00, 8, 3),
                                (4,"PRO0003", "Yamaha Classique", 590.00, 5, 3540.00, 3, 4),
                                (5,"PRO0004", "Ibanez 5 cordes", 1290.00, 1, 1548.00, 4, 5),
                                (6,"PRO0007", "Kamaka", 490.00, 1, 588.00, 7, 6),
                                (7,"PRO0006", "Cort Basse Semi-Acoustique", 1090.00, 1, 1308.00, 6, 7),
                                (8,"PRO0002", "Yamaha Classique", 590.00, 1, 708.00, 2, 8),
                                (9,"PRO0001", "Ibanez 7 cordes", 1290.00, 2, 3960.00, 1, 9),
									     (10,"PRO0004", "Ibanez 5 cordes", 1290.00, 2, 3960.00, 4, 9), 	   
                                (11,"PRO0005", "Ibanez Basse Acoustique", 890.00, 1, 1068.00, 5, 9), 
                                (12,"PRO0006", "Cort Basse Semi-Acoustique", 1090.00, 1, 1308.00, 6, 10), 
                                (13,"PRO0007", "Kamaka", 490.00, 1, 588.00, 7, 10),
                                (14,"PRO0008", "Sitar", 1500.00, 1, 1800.00, 8, 10),
									     (15,"PRO0002", "Yamaha Classique", 590.00, 1, 708.00, 2, 11),
										  (16,"PRO0003", "Fender Acoustique", 650.00, 1, 780.00, 3, 11),
										  (17,"PRO0005", "Ibanez Basse Acoustique", 890.00, 1, 1068.00, 5, 11),	
										  (18,"PRO0006", "Cort Basse Semi-Acoustique", 1090.00, 1, 1308.00, 6, 11),
							      	  (19,"PRO0001", "Ibanez 7 cordes", 1290.00, 5, 7740.00, 1, 12),
										  (20,"PRO0004", "Ibanez 5 cordes", 1290.00, 5, 7740.00, 4, 12),
										  (21,"PRO0008", "Sitar", 1500.00, 3, 5400.00, 8, 12);




CREATE TABLE ligne_de_livraison(
   id_ligne_livraison INT AUTO_INCREMENT NOT NULL,
   ref_produit VARCHAR(50),
   designation_produit VARCHAR(50),
   quantite_produit SMALLINT,
   id_bon_livraison INT NOT NULL,
   id_produit INT NOT NULL,
   PRIMARY KEY(id_ligne_livraison),
   FOREIGN KEY(id_bon_livraison) REFERENCES livraison(id_bon_livraison),
   FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;  

-- Jeu de test
INSERT INTO `ligne_de_livraison` (`id_ligne_livraison`,`ref_produit`,`designation_produit`,`quantite_produit`,`id_bon_livraison`,`id_produit`) 
						        VALUES (1, "PRO0001", "Ibanez 7 cordes", 1, 1, 1),
                         			(2, "PRO0001", "Ibanez 7 cordes", 1, 2, 1),
                         			(3, "PRO0008", "Sitar", 1, 3, 8),
                         			(4, "PRO0003", "Yamaha Classique", 5, 4, 3),
                         			(5, "PRO0004", "Ibanez 5 cordes", 1, 5, 4),
                         		   (6, "PRO0007", "Kamaka", 1, 6, 7),
                         			(7, "PRO0006", "Cort Basse Semi-Acoustique", 1, 7, 6),	
                         		   (8, "PRO0002", "Yamaha Classique", 1, 8, 2),
                         		   (9, "PRO0001", "Ibanez 7 cordes", 2, 9, 1),
                         			(10, "PRO0005", "Ibanez Basse Acoustique", 1, 9, 5),
                         			(11, "PRO0004", "Ibanez 5 cordes", 2, 10, 4),
                         		   (12, "PRO0006", "Cort Basse Semi-Acoustique", 1, 11, 6),
                         			(13, "PRO0007", "Kamaka", 1, 11, 7),
                         			(14, "PRO0008", "Sitar", 1, 11, 8),
                         		   (15, "PRO0002", "Yamaha Classique", 1, 12, 2),
                         		   (16, "PRO0003", "Fender Acoustique", 1, 12, 3),
                         		   (17, "PRO0005", "Ibanez Basse Acoustique", 1, 12, 5),
										 	(18, "PRO0006", "Cort Basse Semi-Acoustique", 1, 12, 6),
									      (19, "PRO0001", "Ibanez 7 cordes", 5, 13, 1),
											(20, "PRO0004", "Ibanez 5 cordes", 5, 13, 4),
											(21, "PRO0008", "Sitar", 3, 13, 8);


                         			
-- Creation des profils de connexion
SELECT PASSWORD('radiohead');
CREATE USER IF NOT EXISTS 'visiteur'@'localhost' IDENTIFIED BY PASSWORD '*0F4F1573761079509A39584E8DDF122516EDE8E0';

SELECT PASSWORD('portishead');
CREATE USER if NOT EXISTS 'client'@'localhost' IDENTIFIED BY PASSWORD '*D05497C77677DCDF9DE713E4E2F4E5C7B9F1496E';

SELECT PASSWORD('slipknot');
CREATE USER if NOT EXISTS 'gestion'@'localhost' IDENTIFIED BY PASSWORD '*916D2A4935407F2381B009BA2A289364FA8851D6';

SELECT PASSWORD('korn');
CREATE USER if NOT EXISTS 'administrateur'@'localhost' IDENTIFIED BY PASSWORD '*989B41B0B48D6E37130386B797AE2988A5F45234';

-- Attribution des privilèges
GRANT SELECT ON village_green.rubrique TO 'visiteur'@'localhost';
GRANT SELECT ON village_green.sous_rubrique TO 'visiteur'@'localhost';
GRANT SELECT ON village_green.produit TO 'visiteur'@'localhost';

GRANT SELECT ON village_green.* TO 'client'@'%';
GRANT INSERT, UPDATE ON village_green.commande TO 'client'@'localhost';
GRANT INSERT, UPDATE ON village_green.`client` TO 'client'@'localhost';

GRANT SELECT, UPDATE ON village_green.* TO 'gestion'@'localhost';

GRANT SELECT, UPDATE, INSERT, DELETE ON village_green.* TO 'administrateur'@'localhost';



-- Crétion d'une vue pour la jointure Produit/Fournisseur 
CREATE VIEW produitEtFournisseur
AS 
SELECT fournisseur.ref_fournisseur, fournisseur.nom_fournisseur, produit.ref_produit, produit.designation_produit, produit.description_produit, produit.prix_achat_produit, produit.prix_vente_produit 
FROM produit
INNER JOIN fournisseur ON produit.id_fournisseur = fournisseur.id_fournisseur;
-- Requête d'affichage de la vue
SELECT * FROM produitEtFournisseur;

-- Création d'une vue pour la jointure Rubrique/Sous-rubrique/Produit
CREATE VIEW produitEtRubrique
AS
SELECT rubrique.nom_rubrique, sous_rubrique.nom_sous_rubrique, produit.designation_produit
FROM produit
INNER JOIN sous_rubrique ON produit.id_sous_rubrique = sous_rubrique.id_sous_rubrique
INNER JOIN rubrique ON sous_rubrique.id_rubrique = rubrique.id_rubrique;
-- Requête d'affichage de la vue
SELECT * FROM produitEtRubrique;

-- Création d'une vue "Historique de commande" contenant la jointure des tables 'client' et 'commande'
CREATE VIEW historiqueCommande
AS 
SELECT `client`.id_client, `client`.numero_client, `client`.nom_client, `client`.prenom_client, commande.numero_commande, commande.date_commande, commande.numero_facture, commande.date_facture, commande.date_reglement_facture
FROM commande
INNER JOIN `client` ON commande.id_client = `client`.id_client;
-- Requête d'affichage de la vue
SELECT * FROM historiqueCommande;



-- Procédure stockée permettant d'afficher les informations sur les commandes non soldées
DELIMITER |
	
CREATE PROCEDURE commandeNonSoldee()	
BEGIN	
    SELECT id_commande, numero_commande, date_commande, statut_commande FROM commande WHERE statut_commande = 'En cours de livraison';	
END |
	
DELIMITER ;
-- Appel de la procédure stockée
CALL commandeNonSoldee; 

-- Procédure stockée permettant d'afficher le délai moyen de livraison
DELIMITER |
	
CREATE PROCEDURE delaisMoyenDeLivraison()	
BEGIN	
    SELECT AVG(DATEDIFF(livraison.date_livraison, commande.date_commande)) AS delaisMoyenDeLivraison
	 FROM livraison, commande
    WHERE livraison.id_commande = commande.id_commande;
END |
	
DELIMITER ;
-- Appel de la procédure stockée
CALL delaisMoyenDeLivraison;


-- Jointure Commercial/CLIENT 
SELECT commercial.nom_commercial, commercial.prenom_commercial, `client`.nom_client, `client`.prenom_client
FROM `client`
INNER JOIN commercial ON `client`.id_commercial = commercial.id_commercial;

-- Jointure Client/Commande
SELECT `client`.numero_client, `client`.coefficient_client, `client`.nom_client, `client`.prenom_client, `client`.mail_client, `client`.reduction_client, 
`client`.adresse_livraison_client, `client`.adresse_facturation_client, commande.numero_commande, commande.date_commande, commande.statut_commande, 
commande.adresse_livraison_commande
FROM commande
JOIN `client` ON commande.id_client = `client`.id_client;

-- Jointure Commande/Ligne_de_Commande 
SELECT commande.numero_commande, commande.date_commande, commande.adresse_livraison_commande, 
ligne_de_commande.ref_produit_commande, ligne_de_commande.designation_produit_commande, ligne_de_commande.prix_unitaire_ht, ligne_de_commande.quantite_produit, ligne_de_commande.total_ttc 
FROM ligne_de_commande 
INNER JOIN commande ON ligne_de_commande.id_commande = commande.id_commande;

-- Jointure Produit/Ligne de Commande 
SELECT produit.ref_produit, produit.designation_produit, produit.description_produit, produit.prix_vente_produit, 
ligne_de_commande.ref_produit_commande, ligne_de_commande.designation_produit_commande, ligne_de_commande.prix_unitaire_ht
FROM ligne_de_commande
INNER JOIN produit ON ligne_de_commande.id_produit = produit.id_produit;

-- Jointure Commande/Livraison
SELECT commande.numero_commande, commande.date_commande, commande.adresse_livraison_commande, commande.numero_facture, livraison.date_livraison, livraison.numero_livraison
FROM livraison
INNER JOIN commande ON livraison.id_commande = commande.id_commande;

-- Jointure Livraison/Ligne de livraison 
SELECT livraison.numero_livraison, livraison.date_livraison, ligne_de_livraison.ref_produit, ligne_de_livraison.designation_produit, ligne_de_livraison.quantite_produit 
FROM ligne_de_livraison
INNER JOIN livraison ON ligne_de_livraison.id_bon_livraison = livraison.id_bon_livraison;

-- Jointure Ligne de livraison/Produit 
SELECT produit.ref_produit, produit.designation_produit, produit.prix_vente_produit, ligne_de_livraison.quantite_produit
FROM ligne_de_livraison
INNER JOIN produit ON ligne_de_livraison.id_produit = produit.id_produit;


-- Requêtes tableau de bord

-- Chiffre d'affaires mois par mois pour une année sélectionnée
SELECT MONTH(commande.date_commande) AS mois, SUM(ligne_de_commande.total_ttc) AS CA
FROM ligne_de_commande
INNER JOIN commande ON ligne_de_commande.id_commande = commande.id_commande
WHERE YEAR(commande.date_commande)=2019
GROUP BY MONTH(commande.date_commande);


-- Chiffre d'affaires généré pour un fournisseur
SELECT fournisseur.nom_fournisseur, SUM(produit.prix_achat_produit * ligne_de_commande.quantite_produit) AS CA
FROM fournisseur, produit, ligne_de_commande
WHERE ligne_de_commande.id_produit = produit.id_produit
AND produit.id_fournisseur = fournisseur.id_fournisseur
AND fournisseur.nom_fournisseur = 'Uppercut Guitars';


-- TOP 10 des produits les plus commandés pour une année sélectionnée (référence et nom du produit, quantité commandée, fournisseur)
SELECT produit.ref_produit, produit.designation_produit, SUM(ligne_de_commande.quantite_produit) AS toal_quantité, fournisseur.nom_fournisseur
FROM commande, produit, ligne_de_commande, fournisseur
WHERE ligne_de_commande.id_commande = commande.id_commande
AND ligne_de_commande.id_produit = produit.id_produit
AND produit.id_fournisseur = fournisseur.id_fournisseur
AND commande.date_commande BETWEEN '20190101' AND '20191212'
GROUP BY produit.ref_produit
ORDER BY SUM(ligne_de_commande.quantite_produit) DESC
LIMIT 5;


-- TOP 10 des produits les plus rémunérateurs pour une année sélectionnée (référence et nom du produit, marge, fournisseur)
SELECT produit.ref_produit, produit.designation_produit, (produit.prix_vente_produit - produit.prix_achat_produit) AS marge, fournisseur.nom_fournisseur
FROM commande, ligne_de_commande, produit, fournisseur
WHERE produit.id_fournisseur = fournisseur.id_fournisseur
AND ligne_de_commande.id_produit = produit.id_produit
AND ligne_de_commande.id_commande = commande.id_commande
AND commande.date_commande BETWEEN '20190101' AND '20191212'
GROUP BY produit.ref_produit
ORDER BY (produit.prix_vente_produit - produit.prix_achat_produit) DESC
LIMIT 10;

-- modif frc
SELECT produit.ref_produit, produit.designation_produit, SUM(quantite_produit), SUM(quantite_produit * (produit.prix_vente_produit - produit.prix_achat_produit)) AS marge, fournisseur.nom_fournisseur
FROM commande, ligne_de_commande, produit, fournisseur
WHERE produit.id_fournisseur = fournisseur.id_fournisseur
AND ligne_de_commande.id_produit = produit.id_produit
AND ligne_de_commande.id_commande = commande.id_commande
AND commande.date_commande BETWEEN '20190101' AND '20191212'
GROUP BY produit.ref_produit
ORDER BY SUM(produit.prix_vente_produit - produit.prix_achat_produit) DESC
LIMIT 10;


-- Top 10 des clients en nombre de commandes ou chiffre d'affaires
-- En nombre de commande
SELECT `client`.id_client, `client`.numero_client, `client`.statut_client, `client`.nom_client, `client`.prenom_client, COUNT(commande.id_commande) AS nombre_total_commandes
FROM `client`, commande
WHERE commande.id_client = `client`.id_client
GROUP BY `client`.numero_client
ORDER BY COUNT(commande.id_commande) DESC
LIMIT 5;

-- En chiffre d'affaires
SELECT `client`.id_client, `client`.numero_client, `client`.statut_client, `client`.nom_client, `client`.prenom_client, SUM(ligne_de_commande.total_ttc) AS CA
FROM `client`, commande, ligne_de_commande
WHERE commande.id_client = `client`.id_client
AND ligne_de_commande.id_commande = commande.id_commande
GROUP BY `client`.numero_client
ORDER BY SUM(ligne_de_commande.total_ttc) DESC
LIMIT 5;


-- Répartition du chiffre d'affaires par type de client
-- Pour les particuliers
/* SELECT `client`.numero_client, `client`.nom_client, `client`.prenom_client, `client`.statut_client, SUM(ligne_de_commande.total_ttc) AS CA
FROM ligne_de_commande
INNER JOIN commande ON ligne_de_commande.id_commande = commande.id_commande
INNER JOIN `client` ON commande.id_client = `client`.id_client
WHERE `client`.statut_client = 0
GROUP BY `client`.numero_client
ORDER BY SUM(ligne_de_commande.total_ttc) DESC; */

-- Pour les entreprises
/* SELECT `client`.numero_client, `client`.nom_client, `client`.prenom_client, `client`.statut_client, SUM(ligne_de_commande.total_ttc) AS CA
FROM ligne_de_commande
INNER JOIN commande ON ligne_de_commande.id_commande = commande.id_commande
INNER JOIN `client` ON commande.id_client = `client`.id_client
WHERE `client`.statut_client = 1
GROUP BY `client`.numero_client
ORDER BY SUM(ligne_de_commande.total_ttc) DESC; */

SELECT `client`.statut_client, SUM(ligne_de_commande.total_ttc) AS CA
FROM ligne_de_commande
INNER JOIN commande ON ligne_de_commande.id_commande = commande.id_commande
INNER JOIN `client` ON commande.id_client = `client`.id_client
GROUP BY `client`.statut_client
ORDER BY SUM(ligne_de_commande.total_ttc) DESC;

-- Nombre de commandes en cours de livraison.
SELECT COUNT(id_commande) AS commandes_en_cours_de_livraison
FROM commande
WHERE statut_commande = 'En cours de livraison';

-- Afficher la liste de commandes livrées partiellements
-- Afficher le numéro de commande, le numéro du produit, quantité commandée, quantité livrée
SELECT commande.numero_commande, commande.date_commande, ligne_de_commande.ref_produit_commande, ligne_de_commande.designation_produit_commande, ligne_de_commande.quantite_produit, livraison.numero_livraison, livraison.date_livraison, ligne_de_livraison.quantite_produit 
FROM commande, ligne_de_commande, produit, ligne_de_livraison, livraison
WHERE ligne_de_commande.id_commande = commande.id_commande
AND ligne_de_commande.id_produit = produit.id_produit
AND ligne_de_livraison.id_produit = produit.id_produit
AND ligne_de_livraison.id_bon_livraison = livraison.id_bon_livraison
AND livraison.id_commande = commande.id_commande
ORDER BY commande.numero_commande;