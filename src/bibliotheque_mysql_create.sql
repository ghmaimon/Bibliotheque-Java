use bibliotheque;

SELECT id,d.isbn, titre, d.auteur, d.cin_emprunteur, d.anneeEdition, d.editeur, d.numExemplaires,
                d.type, b.coloree, b.genre, di.langue, di.numTomes, l.livre_type, l.numPages,l.tome, m.jourEdition,
                m.moisEdition, m.periodicity FROM Document d INNER JOIN BandeDessinee b ON d.isbn = b.isbn
                INNER JOIN Dictionaire di ON di.isbn = d.isbn INNER JOIN Livre l ON d.isbn = l.isbn
            	INNER JOIN Magazine m ON m.isbn = d.isbn

CREATE TABLE `Document` (
	`isbn` varchar(13) NOT NULL,
	`auteur` varchar(50) NOT NULL,
	`editeur` varchar(50),
	`anneeEdition` varchar(4),
	`type` varchar(10) NOT NULL,
	`numExemplaires` int,
	`titre` varchar(50) NOT NULL,
	`cin_emprunteur` varchar(10),
	PRIMARY KEY (`isbn`)
);

CREATE TABLE `Person` (
	`nom` varchar(50) NOT NULL,
	`prenom` varchar(50) NOT NULL,
	`cin` varchar(10) NOT NULL,
	`address` varchar(50),
	`numTelefon` varchar(15) NOT NULL,
	`email` varchar(15) NOT NULL,
	`type` varchar(15) NOT NULL,
	PRIMARY KEY (`cin`)
);

CREATE TABLE `BandeDessinee` (
	`isbn` varchar(10) NOT NULL,
	`coloree` bool,
	`genre` varchar(15),
	PRIMARY KEY (`isbn`)
);

CREATE TABLE `Dictionaire` (
	`isbn` varchar(10) NOT NULL,
	`numTomes` int,
	`langue` varchar(15),
	PRIMARY KEY (`isbn`)
);

CREATE TABLE `Livre` (
	`isbn` varchar(10) NOT NULL,
	`numPages` int,
	`livre_type` varchar(15),
	`tome` varchar(15),
	PRIMARY KEY (`isbn`)
);

CREATE TABLE `Magazine` (
	`isbn` varchar(10) NOT NULL,
	`periodicity` int,
	`moisEdition` int,
	`jourEdition` int,
	PRIMARY KEY (`isbn`)
);

CREATE TABLE `Etudiant` (
	`cin` varchar(10) NOT NULL,
	`cne` varchar(10) NOT NULL UNIQUE,
	`filier` varchar(10),
	`niveau` int,
	`boursie` bool,
	PRIMARY KEY (`cin`)
);

CREATE TABLE `Professeur` (
	`cin` varchar(10) NOT NULL,
	`cours` varchar(10) NOT NULL UNIQUE,
	`grade` int,
	PRIMARY KEY (`cin`)
);

ALTER TABLE `Document` ADD CONSTRAINT `Document_fk0` FOREIGN KEY (`cin_emprunteur`) REFERENCES `Person`(`cin`);

ALTER TABLE `BandeDessinee` ADD CONSTRAINT `BandeDessinee_fk0` FOREIGN KEY (`isbn`) REFERENCES `Document`(`isbn`);

ALTER TABLE `Dictionaire` ADD CONSTRAINT `Dictionaire_fk0` FOREIGN KEY (`isbn`) REFERENCES `Document`(`isbn`);

ALTER TABLE `Livre` ADD CONSTRAINT `Livre_fk0` FOREIGN KEY (`isbn`) REFERENCES `Document`(`isbn`);

ALTER TABLE `Magazine` ADD CONSTRAINT `Magazine_fk0` FOREIGN KEY (`isbn`) REFERENCES `Document`(`isbn`);

ALTER TABLE `Etudiant` ADD CONSTRAINT `Etudiant_fk0` FOREIGN KEY (`cin`) REFERENCES `Person`(`cin`);

ALTER TABLE `Professeur` ADD CONSTRAINT `Professeur_fk0` FOREIGN KEY (`cin`) REFERENCES `Person`(`cin`);

ALTER TABLE `Person` ADD CONSTRAINT `types_person` CHECK (type IN ('etudiant','professeur'));

ALTER TABLE `Document` ADD CONSTRAINT `types_document` CHECK (type IN ('Bande Dessinée','Dictionaire','Livre','Magazine'));

