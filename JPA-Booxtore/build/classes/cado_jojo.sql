-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 05 Novembre 2013 à 23:54
-- Version du serveur: 5.5.31
-- Version de PHP: 5.4.4-14+deb7u5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `booxtore`
--

-- --------------------------------------------------------

--
-- Structure de la table `ADRESSE`
--

DROP TABLE IF EXISTS `ADRESSE`;
CREATE TABLE IF NOT EXISTS `ADRESSE` (
  `ID_ADRESSE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENT` int(11) NOT NULL,
  `NOM_ADRESSE` varchar(63) DEFAULT NULL,
  `CP` varchar(6) DEFAULT NULL,
  `VILLE` varchar(63) DEFAULT NULL,
  `NOM_DESTINATAIRE` varchar(63) DEFAULT NULL,
  `PRENOM_DESTINATAIRE` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`ID_ADRESSE`),
  KEY `FK_HABITE` (`ID_CLIENT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `ADRESSE`
--

INSERT INTO `ADRESSE` (`ID_ADRESSE`, `ID_CLIENT`, `NOM_ADRESSE`, `CP`, `VILLE`, `NOM_DESTINATAIRE`, `PRENOM_DESTINATAIRE`) VALUES
(1, 1, '76 rue maryse bastié', '33520', 'Bruges', 'Baptiste', 'Velado'),
(2, 2, '65 place de la liberté', '33200', 'Bordeaux', 'Georges', 'Johnatan'),
(3, 3, 'Residence SEMI', '33290', 'Blanquefort', 'Faure', 'Yann'),
(4, 4, '98 quai des chartrons', '33200', 'Bordeaux', 'Mangin', 'Alexandre'),
(5, 5, '16 rue jean jaures', '33700', 'Merignac', 'Vigneau', 'Loic');

-- --------------------------------------------------------

--
-- Structure de la table `ARTICLE`
--

DROP TABLE IF EXISTS `ARTICLE`;
CREATE TABLE IF NOT EXISTS `ARTICLE` (
  `ID_ARTICLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TYPEARTICLE` int(11) NOT NULL,
  `ID_TVA` int(11) NOT NULL,
  `LIBELLE_ARTICLE` varchar(63) DEFAULT NULL,
  `DESCRIPTION_ARTICLE` varchar(255) DEFAULT NULL,
  `PRIXHT` decimal(10,0) DEFAULT NULL,
  `STOCK` decimal(6,2) NOT NULL,
  `SEUIL` decimal(6,2) NOT NULL,
  PRIMARY KEY (`ID_ARTICLE`),
  KEY `FK_IMPOSE` (`ID_TVA`),
  KEY `FK_POSSEDE` (`ID_TYPEARTICLE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `ARTICLE`
--

INSERT INTO `ARTICLE` (`ID_ARTICLE`, `ID_TYPEARTICLE`, `ID_TVA`, `LIBELLE_ARTICLE`, `DESCRIPTION_ARTICLE`, `PRIXHT`, `STOCK`, `SEUIL`) VALUES
(1, 1, 1, 'Le Petit Prince', NULL, 10, 0.00, 0.00),
(2, 1, 1, 'Dix petits negres', NULL, 14, 0.00, 0.00);

-- --------------------------------------------------------

--
-- Structure de la table `CARACTERISE`
--

DROP TABLE IF EXISTS `CARACTERISE`;
CREATE TABLE IF NOT EXISTS `CARACTERISE` (
  `ID_CARACTERISTIQUE` int(11) NOT NULL,
  `ID_ARTICLE` int(11) NOT NULL,
  PRIMARY KEY (`ID_CARACTERISTIQUE`,`ID_ARTICLE`),
  KEY `FK_CATEGORISE` (`ID_ARTICLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `CARACTERISE`
--

INSERT INTO `CARACTERISE` (`ID_CARACTERISTIQUE`, `ID_ARTICLE`) VALUES
(12, 1),
(14, 1),
(15, 1),
(17, 1),
(5, 2),
(7, 2),
(8, 2),
(16, 2),
(18, 2);

-- --------------------------------------------------------

--
-- Structure de la table `CARACTERISTIQUE`
--

DROP TABLE IF EXISTS `CARACTERISTIQUE`;
CREATE TABLE IF NOT EXISTS `CARACTERISTIQUE` (
  `ID_CARACTERISTIQUE` int(11) NOT NULL AUTO_INCREMENT,
  `PARENT_ID_CARACTERISTIQUE` int(11) DEFAULT NULL,
  `ID_TYPECARACTERISTIQUE` int(11) NOT NULL,
  `VALEUR_CARACTERISTIQUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CARACTERISTIQUE`),
  KEY `FK_DEFINIT` (`ID_TYPECARACTERISTIQUE`),
  KEY `FK_SUBDIVISE` (`PARENT_ID_CARACTERISTIQUE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `CARACTERISTIQUE`
--

INSERT INTO `CARACTERISTIQUE` (`ID_CARACTERISTIQUE`, `PARENT_ID_CARACTERISTIQUE`, `ID_TYPECARACTERISTIQUE`, `VALEUR_CARACTERISTIQUE`) VALUES
(5, NULL, 4, 'Litterature'),
(6, 5, 4, 'Poésie'),
(7, 5, 4, 'Polar'),
(8, 5, 4, 'Thriller/Suspense'),
(9, 5, 4, 'Roman d''espionnage'),
(12, NULL, 4, 'Jeunesse'),
(13, 12, 4, '1-3 ans'),
(14, 12, 4, '4-6 ans'),
(15, NULL, 2, '48'),
(16, NULL, 2, '186'),
(17, NULL, 1, 'Gallimard Jeunesse'),
(18, NULL, 3, '1939');

-- --------------------------------------------------------

--
-- Structure de la table `CLIENT`
--

DROP TABLE IF EXISTS `CLIENT`;
CREATE TABLE IF NOT EXISTS `CLIENT` (
  `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(63) DEFAULT NULL,
  `PRENOM` varchar(63) DEFAULT NULL,
  `EMAIL` varchar(63) DEFAULT NULL,
  `LOGIN` varchar(63) DEFAULT NULL,
  `PASSWORD` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `CLIENT`
--

INSERT INTO `CLIENT` (`ID_CLIENT`, `NOM`, `PRENOM`, `EMAIL`, `LOGIN`, `PASSWORD`) VALUES
(1, 'Velado', 'Baptiste', 'baptiste.velado@viacesi.fr', 'bvelado', 'pass1'),
(2, 'Georges', 'Johnatan', 'johnatan.georges@viacesi.fr', 'jgeorges', 'pass2'),
(3, 'Faure', 'Yann', 'yann.faure@viacesi.fr', 'yfaure', 'pass3'),
(4, 'Mangin', 'Alexandre', 'alexandre.mangin@viacesi.fr', 'amangin', 'pass4'),
(5, 'Vigneau', 'Loic', 'loic.vigneau@viacesi.fr', 'lvigneau', 'pass5');

-- --------------------------------------------------------

--
-- Structure de la table `COMMANDE`
--

DROP TABLE IF EXISTS `COMMANDE`;
CREATE TABLE IF NOT EXISTS `COMMANDE` (
  `ID_COMMANDE` int(11) NOT NULL,
  `ID_ETATCOMMANDE` int(11) NOT NULL,
  `ID_CLIENT` int(11) NOT NULL,
  `DATE` datetime DEFAULT NULL,
  `ID_ADDRESSE` int(11) NOT NULL,
  PRIMARY KEY (`ID_COMMANDE`),
  KEY `FK_ASSOCIATION_5` (`ID_ETATCOMMANDE`),
  KEY `FK_PASSE` (`ID_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ETATCOMMANDE`
--

DROP TABLE IF EXISTS `ETATCOMMANDE`;
CREATE TABLE IF NOT EXISTS `ETATCOMMANDE` (
  `ID_ETATCOMMANDE` int(11) NOT NULL,
  `LIBELLE_ETAT` varchar(63) DEFAULT NULL,
  `DESCRIPTION_ETAT` varchar(255) DEFAULT NULL,
  `DATE_ETAT` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_ETATCOMMANDE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `LIGNECOMMANDE`
--

DROP TABLE IF EXISTS `LIGNECOMMANDE`;
CREATE TABLE IF NOT EXISTS `LIGNECOMMANDE` (
  `ID_COMMANDE` int(11) NOT NULL,
  `ID_ARTICLE` int(11) NOT NULL,
  `PRIXTTC` decimal(10,0) DEFAULT NULL,
  `QUANTITE` decimal(5,2) NOT NULL,
  PRIMARY KEY (`ID_COMMANDE`,`ID_ARTICLE`),
  KEY `FK_LIGNECOMMANDE` (`ID_ARTICLE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `TVA`
--

DROP TABLE IF EXISTS `TVA`;
CREATE TABLE IF NOT EXISTS `TVA` (
  `ID_TVA` int(11) NOT NULL AUTO_INCREMENT,
  `LIBELLE_TVA` varchar(63) DEFAULT NULL,
  `TAUX` decimal(5,2) NOT NULL,
  PRIMARY KEY (`ID_TVA`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `TVA`
--

INSERT INTO `TVA` (`ID_TVA`, `LIBELLE_TVA`, `TAUX`) VALUES
(1, 'Taux réduit', 5.50),
(2, 'Taux intermédiaire', 7.00),
(3, 'Taux normal', 19.60);

-- --------------------------------------------------------

--
-- Structure de la table `TYPEARTICLE`
--

DROP TABLE IF EXISTS `TYPEARTICLE`;
CREATE TABLE IF NOT EXISTS `TYPEARTICLE` (
  `ID_TYPEARTICLE` int(11) NOT NULL AUTO_INCREMENT,
  `LIBELLE_TYPE_ARTICLE` varchar(63) DEFAULT NULL,
  `DESCRIPTION_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_TYPEARTICLE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `TYPEARTICLE`
--

INSERT INTO `TYPEARTICLE` (`ID_TYPEARTICLE`, `LIBELLE_TYPE_ARTICLE`, `DESCRIPTION_TYPE`) VALUES
(1, 'Livre', 'Un livre avec des pages et une couverture.');

-- --------------------------------------------------------

--
-- Structure de la table `TYPECARACTERISTIQUE`
--

DROP TABLE IF EXISTS `TYPECARACTERISTIQUE`;
CREATE TABLE IF NOT EXISTS `TYPECARACTERISTIQUE` (
  `ID_TYPECARACTERISTIQUE` int(11) NOT NULL AUTO_INCREMENT,
  `LIBELLE_TYPE_CARACTERISTIQUE` varchar(63) DEFAULT NULL,
  PRIMARY KEY (`ID_TYPECARACTERISTIQUE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `TYPECARACTERISTIQUE`
--

INSERT INTO `TYPECARACTERISTIQUE` (`ID_TYPECARACTERISTIQUE`, `LIBELLE_TYPE_CARACTERISTIQUE`) VALUES
(1, 'Editeur'),
(2, 'Nombre de pages'),
(3, 'Date de parution'),
(4, 'Catégorie');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vue_client`
--
DROP VIEW IF EXISTS `vue_client`;
CREATE TABLE IF NOT EXISTS `vue_client` (
`ID_CLIENT` int(11)
,`PRENOM` varchar(63)
,`NOM` varchar(63)
,`PRENOM_DESTINATAIRE` varchar(63)
,`NOM_DESTINATAIRE` varchar(63)
,`PASSWORD` varchar(63)
,`LOGIN` varchar(63)
,`VILLE` varchar(63)
,`CP` varchar(6)
,`NOM_ADRESSE` varchar(63)
,`EMAIL` varchar(63)
);
-- --------------------------------------------------------

--
-- Structure de la vue `vue_client`
--
DROP TABLE IF EXISTS `vue_client`;

CREATE ALGORITHM=UNDEFINED DEFINER=`booxtore`@`localhost` SQL SECURITY DEFINER VIEW `vue_client` AS select `c`.`ID_CLIENT` AS `ID_CLIENT`,`c`.`PRENOM` AS `PRENOM`,`c`.`NOM` AS `NOM`,`a`.`PRENOM_DESTINATAIRE` AS `PRENOM_DESTINATAIRE`,`a`.`NOM_DESTINATAIRE` AS `NOM_DESTINATAIRE`,`c`.`PASSWORD` AS `PASSWORD`,`c`.`LOGIN` AS `LOGIN`,`a`.`VILLE` AS `VILLE`,`a`.`CP` AS `CP`,`a`.`NOM_ADRESSE` AS `NOM_ADRESSE`,`c`.`EMAIL` AS `EMAIL` from (`CLIENT` `c` join `ADRESSE` `a` on((`a`.`ID_CLIENT` = `c`.`ID_CLIENT`)));

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `ADRESSE`
--
ALTER TABLE `ADRESSE`
  ADD CONSTRAINT `FK_HABITE` FOREIGN KEY (`ID_CLIENT`) REFERENCES `CLIENT` (`ID_CLIENT`);

--
-- Contraintes pour la table `ARTICLE`
--
ALTER TABLE `ARTICLE`
  ADD CONSTRAINT `FK_IMPOSE` FOREIGN KEY (`ID_TVA`) REFERENCES `TVA` (`ID_TVA`),
  ADD CONSTRAINT `FK_POSSEDE` FOREIGN KEY (`ID_TYPEARTICLE`) REFERENCES `TYPEARTICLE` (`ID_TYPEARTICLE`);

--
-- Contraintes pour la table `CARACTERISE`
--
ALTER TABLE `CARACTERISE`
  ADD CONSTRAINT `FK_CATEGORISE2` FOREIGN KEY (`ID_CARACTERISTIQUE`) REFERENCES `CARACTERISTIQUE` (`ID_CARACTERISTIQUE`),
  ADD CONSTRAINT `FK_CATEGORISE` FOREIGN KEY (`ID_ARTICLE`) REFERENCES `ARTICLE` (`ID_ARTICLE`);

--
-- Contraintes pour la table `CARACTERISTIQUE`
--
ALTER TABLE `CARACTERISTIQUE`
  ADD CONSTRAINT `FK_DEFINIT` FOREIGN KEY (`ID_TYPECARACTERISTIQUE`) REFERENCES `TYPECARACTERISTIQUE` (`ID_TYPECARACTERISTIQUE`),
  ADD CONSTRAINT `FK_SUBDIVISE` FOREIGN KEY (`PARENT_ID_CARACTERISTIQUE`) REFERENCES `CARACTERISTIQUE` (`ID_CARACTERISTIQUE`);

--
-- Contraintes pour la table `COMMANDE`
--
ALTER TABLE `COMMANDE`
  ADD CONSTRAINT `FK_PASSE` FOREIGN KEY (`ID_CLIENT`) REFERENCES `CLIENT` (`ID_CLIENT`),
  ADD CONSTRAINT `FK_ASSOCIATION_5` FOREIGN KEY (`ID_ETATCOMMANDE`) REFERENCES `ETATCOMMANDE` (`ID_ETATCOMMANDE`);

--
-- Contraintes pour la table `LIGNECOMMANDE`
--
ALTER TABLE `LIGNECOMMANDE`
  ADD CONSTRAINT `FK_LIGNECOMMANDE` FOREIGN KEY (`ID_ARTICLE`) REFERENCES `ARTICLE` (`ID_ARTICLE`),
  ADD CONSTRAINT `FK_LIGNECOMMANDE2` FOREIGN KEY (`ID_COMMANDE`) REFERENCES `COMMANDE` (`ID_COMMANDE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
