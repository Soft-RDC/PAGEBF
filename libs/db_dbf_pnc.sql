-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2013 at 08:39 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_dbf_pnc`
--
CREATE DATABASE IF NOT EXISTS `db_dbf_pnc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_dbf_pnc`;

-- --------------------------------------------------------

--
-- Table structure for table `t_access`
--

CREATE TABLE IF NOT EXISTS `t_access` (
  `id_profile` int(11) NOT NULL,
  `id_module` int(11) NOT NULL,
  PRIMARY KEY (`id_profile`,`id_module`),
  KEY `id_module` (`id_module`),
  KEY `id_profile` (`id_profile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_access`
--

INSERT INTO `t_access` (`id_profile`, `id_module`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(6, 5),
(1, 6),
(1, 7),
(1, 8),
(6, 8);

-- --------------------------------------------------------

--
-- Table structure for table `t_arbitration`
--

CREATE TABLE IF NOT EXISTS `t_arbitration` (
  `arbitre_id` int(11) NOT NULL,
  `budget2_id` int(11) NOT NULL,
  `date_arbitrage` date NOT NULL,
  KEY `arbitre_id` (`arbitre_id`),
  KEY `budget2_id` (`budget2_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_besoins`
--

CREATE TABLE IF NOT EXISTS `t_besoins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unite_id` int(11) NOT NULL,
  `id_budgetary_year` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funite_id_idx` (`unite_id`),
  KEY `besoin_id` (`id`),
  KEY `annee_budgetaire_id` (`id_budgetary_year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='expressions des besoins des unites' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_budget1`
--

CREATE TABLE IF NOT EXISTS `t_budget1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_budgetary_year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `annee_budgetaire_id` (`id_budgetary_year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_budget1_expressions`
--

CREATE TABLE IF NOT EXISTS `t_budget1_expressions` (
  `budget1_id` int(11) NOT NULL,
  `ressource_id` int(11) NOT NULL,
  `qte` double DEFAULT NULL,
  `pu` double DEFAULT NULL,
  KEY `budget1_id` (`budget1_id`),
  KEY `ressource_id` (`ressource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_budget2`
--

CREATE TABLE IF NOT EXISTS `t_budget2` (
  `id` int(11) NOT NULL,
  `budget1_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `budget1_id` (`budget1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='budget1 arbitre';

-- --------------------------------------------------------

--
-- Table structure for table `t_budget2_expressions`
--

CREATE TABLE IF NOT EXISTS `t_budget2_expressions` (
  `budget2_id` int(11) NOT NULL,
  `ressource_id` int(11) NOT NULL,
  `qte` double DEFAULT NULL,
  `pu` double DEFAULT NULL,
  KEY `budget2_id` (`budget2_id`),
  KEY `ressource_id` (`ressource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_budgetary_year`
--

CREATE TABLE IF NOT EXISTS `t_budgetary_year` (
  `id_budgetary_year` int(11) NOT NULL,
  `status` text,
  PRIMARY KEY (`id_budgetary_year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tous les budget se trouvent dans une annee budgetaire';

-- --------------------------------------------------------

--
-- Table structure for table `t_elaboration_budget1`
--

CREATE TABLE IF NOT EXISTS `t_elaboration_budget1` (
  `user_id` int(11) NOT NULL,
  `budget1_id` int(11) NOT NULL,
  `date_elaboation` date NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `budget1_id` (`budget1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_expressions`
--

CREATE TABLE IF NOT EXISTS `t_expressions` (
  `besoin_id` int(11) NOT NULL,
  `ressource_id` int(11) NOT NULL,
  `qte` double NOT NULL,
  KEY `besoin_id` (`besoin_id`),
  KEY `ressource_id` (`ressource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='les expressions exprimees par les unites dans une annee budg';

-- --------------------------------------------------------

--
-- Table structure for table `t_manipulate`
--

CREATE TABLE IF NOT EXISTS `t_manipulate` (
  `id_user` int(11) NOT NULL,
  `id_submodule` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_submodule`),
  KEY `id_submodule` (`id_submodule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_module`
--

CREATE TABLE IF NOT EXISTS `t_module` (
  `id_module` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` text,
  PRIMARY KEY (`id_module`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `t_module`
--

INSERT INTO `t_module` (`id_module`, `module_name`) VALUES
(1, 'Préparation Budgétaire'),
(2, 'Exécution Budgétaire'),
(3, 'Suivi des Investissements'),
(4, 'Gestion des Recettes'),
(5, 'Gestion de la Trésorerie'),
(6, 'Gestion de Documents'),
(7, 'Reporting et Statistiques'),
(8, 'Administration Technique'),
(9, 'Configuration');

-- --------------------------------------------------------

--
-- Table structure for table `t_profile`
--

CREATE TABLE IF NOT EXISTS `t_profile` (
  `id_profile` int(11) NOT NULL AUTO_INCREMENT,
  `profile_name` text,
  PRIMARY KEY (`id_profile`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `t_profile`
--

INSERT INTO `t_profile` (`id_profile`, `profile_name`) VALUES
(1, 'Administrateur Informatique'),
(2, 'Administrateur Budgétaire'),
(3, 'Responsable Budgétaire'),
(4, 'Contrôleur Budgétaire'),
(5, 'Gestionnaire des recettes'),
(6, 'Trésorier');

-- --------------------------------------------------------

--
-- Table structure for table `t_referee`
--

CREATE TABLE IF NOT EXISTS `t_referee` (
  `id` int(11) NOT NULL,
  `noms` varchar(40) NOT NULL,
  `service_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `service_id` (`service_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='la commission creee pour arbitrer le budget1';

-- --------------------------------------------------------

--
-- Table structure for table `t_ressources`
--

CREATE TABLE IF NOT EXISTS `t_ressources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ressource_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ressource_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='les ressources voulues par les unites' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_service`
--

CREATE TABLE IF NOT EXISTS `t_service` (
  `id` int(11) NOT NULL,
  `service_texte` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `t_submodule`
--

CREATE TABLE IF NOT EXISTS `t_submodule` (
  `id_submodule` int(11) NOT NULL AUTO_INCREMENT,
  `id_module` int(11) NOT NULL,
  `submodule_name` text,
  `command` text NOT NULL,
  `icon` varchar(30) NOT NULL,
  PRIMARY KEY (`id_submodule`),
  KEY `id_module` (`id_module`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `t_submodule`
--

INSERT INTO `t_submodule` (`id_submodule`, `id_module`, `submodule_name`, `command`, `icon`) VALUES
(1, 9, 'Configuration Globale', '', 'ui-icon-wrench'),
(3, 9, 'Modifier compte', '', 'ui-icon-pencil'),
(4, 9, 'Editer Mot de passe', 'editPassword', 'ui-icon-locked'),
(6, 1, 'Budget Antérieur', '', 'ui-icon-clipboard'),
(8, 2, 'Dépenses et Autres', '', 'ui-icon-cart'),
(9, 2, 'Évolution Budgétaire', '', 'ui-icon-cart'),
(10, 7, 'Rapports Généraux', '', 'ui-icon-note'),
(11, 7, 'Statistiques', '', 'ui-icon-search');

-- --------------------------------------------------------

--
-- Table structure for table `t_unites`
--

CREATE TABLE IF NOT EXISTS `t_unites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `unite_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='les unites sont: les grandes ecoles, les bureau de comgen et les sites provinciaux' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_profile` int(11) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `familyname` varchar(50) NOT NULL,
  `othername` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fonction` varchar(50) NOT NULL,
  `grade` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `registration_date` datetime NOT NULL,
  `last_visit_date` datetime NOT NULL,
  `new_user` int(11) NOT NULL DEFAULT '1',
  `status` int(11) NOT NULL DEFAULT '1',
  `attempt` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_user`),
  KEY `id_profile` (`id_profile`),
  KEY `id_profile_2` (`id_profile`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id_user`, `id_profile`, `matricule`, `firstname`, `familyname`, `othername`, `phone`, `email`, `fonction`, `grade`, `username`, `password`, `registration_date`, `last_visit_date`, `new_user`, `status`, `attempt`) VALUES
(1, 1, 'ADA1312DFAS3423', 'Bob', 'Boseko', 'Bokanga', '+243814520766', 'bobnoblesse@gmail.com', 'Software developer', '', 'bboseko', 'bokanga', '2013-09-11 06:11:31', '2013-12-25 08:36:40', 0, 1, 0),
(2, 6, 'ADFAG134DSAF2343', 'Eddy', 'Bongwele', '', '', 'isbongwele@gmail.com', '', '', 'eddy', 'bongwele2', '2013-11-06 12:25:38', '2013-12-08 05:57:50', 0, 1, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_access`
--
ALTER TABLE `t_access`
  ADD CONSTRAINT `t_access_ibfk_1` FOREIGN KEY (`id_module`) REFERENCES `t_module` (`id_module`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_access_ibfk_2` FOREIGN KEY (`id_profile`) REFERENCES `t_profile` (`id_profile`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_arbitration`
--
ALTER TABLE `t_arbitration`
  ADD CONSTRAINT `t_arbitration_ibfk_1` FOREIGN KEY (`arbitre_id`) REFERENCES `t_referee` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_arbitration_ibfk_2` FOREIGN KEY (`budget2_id`) REFERENCES `t_budget2` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_besoins`
--
ALTER TABLE `t_besoins`
  ADD CONSTRAINT `t_besoins_ibfk_2` FOREIGN KEY (`unite_id`) REFERENCES `t_unites` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_budget1`
--
ALTER TABLE `t_budget1`
  ADD CONSTRAINT `t_budget1_ibfk_1` FOREIGN KEY (`id_budgetary_year`) REFERENCES `t_budgetary_year` (`id_budgetary_year`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_budget1_expressions`
--
ALTER TABLE `t_budget1_expressions`
  ADD CONSTRAINT `t_budget1_expressions_ibfk_1` FOREIGN KEY (`budget1_id`) REFERENCES `t_budget1` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_budget1_expressions_ibfk_2` FOREIGN KEY (`ressource_id`) REFERENCES `t_ressources` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_budget2`
--
ALTER TABLE `t_budget2`
  ADD CONSTRAINT `t_budget2_ibfk_1` FOREIGN KEY (`budget1_id`) REFERENCES `t_budget1` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_budget2_expressions`
--
ALTER TABLE `t_budget2_expressions`
  ADD CONSTRAINT `t_budget2_expressions_ibfk_1` FOREIGN KEY (`budget2_id`) REFERENCES `t_budget2` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_budget2_expressions_ibfk_2` FOREIGN KEY (`ressource_id`) REFERENCES `t_ressources` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_budgetary_year`
--
ALTER TABLE `t_budgetary_year`
  ADD CONSTRAINT `t_budgetary_year_ibfk_1` FOREIGN KEY (`id_budgetary_year`) REFERENCES `t_besoins` (`id_budgetary_year`);

--
-- Constraints for table `t_elaboration_budget1`
--
ALTER TABLE `t_elaboration_budget1`
  ADD CONSTRAINT `t_elaboration_budget1_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id_user`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_elaboration_budget1_ibfk_2` FOREIGN KEY (`budget1_id`) REFERENCES `t_budget1` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_expressions`
--
ALTER TABLE `t_expressions`
  ADD CONSTRAINT `t_expressions_ibfk_1` FOREIGN KEY (`besoin_id`) REFERENCES `t_besoins` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_expressions_ibfk_2` FOREIGN KEY (`ressource_id`) REFERENCES `t_ressources` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_manipulate`
--
ALTER TABLE `t_manipulate`
  ADD CONSTRAINT `t_manipulate_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `t_manipulate_ibfk_2` FOREIGN KEY (`id_submodule`) REFERENCES `t_submodule` (`id_submodule`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_referee`
--
ALTER TABLE `t_referee`
  ADD CONSTRAINT `t_referee_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `t_service` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_submodule`
--
ALTER TABLE `t_submodule`
  ADD CONSTRAINT `t_submodule_ibfk_1` FOREIGN KEY (`id_module`) REFERENCES `t_module` (`id_module`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `t_user`
--
ALTER TABLE `t_user`
  ADD CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `t_profile` (`id_profile`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
