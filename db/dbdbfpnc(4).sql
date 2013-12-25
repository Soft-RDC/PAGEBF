-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2013 at 05:58 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbdbfpnc`
--
CREATE DATABASE IF NOT EXISTS `dbdbfpnc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbdbfpnc`;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

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
(8, 'Configuration');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `t_submodule`
--

INSERT INTO `t_submodule` (`id_submodule`, `id_module`, `submodule_name`, `command`, `icon`) VALUES
(1, 8, 'Configuration Globale', '', 'ui-icon-wrench'),
(2, 8, 'Nouveau compte', '', 'ui-icon-person'),
(3, 8, 'Modifier compte', '', 'ui-icon-pencil'),
(4, 8, 'Editer Mot de passe', 'editPassword', 'ui-icon-locked'),
(5, 8, 'Gestion de Profil Utilisateur', '', 'ui-icon-contact'),
(6, 1, 'Budget Antérieur', '', 'ui-icon-clipboard'),
(8, 2, 'Dépenses et Autres', '', 'ui-icon-cart'),
(9, 2, 'Évolution Budgétaire', '', 'ui-icon-cart'),
(10, 7, 'Rapports Généraux', '', 'ui-icon-note'),
(11, 7, 'Statistiques', '', 'ui-icon-search'),
(12, 8, 'Débloquer Compte', '', 'ui-icon-unlocked');

-- --------------------------------------------------------

--
-- Table structure for table `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_profile` int(11) NOT NULL,
  `reference_number` varchar(50) NOT NULL,
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
  `attempt` int(11) DEFAULT '0',
  PRIMARY KEY (`id_user`),
  KEY `id_profile` (`id_profile`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `t_user`
--

INSERT INTO `t_user` (`id_user`, `id_profile`, `reference_number`, `firstname`, `familyname`, `othername`, `phone`, `email`, `fonction`, `grade`, `username`, `password`, `registration_date`, `last_visit_date`, `new_user`, `status`, `attempt`) VALUES
(1, 1, 'ADA1312DFAS3423', 'Bob', 'Boseko', 'Bokanga', '+243814520766', 'bobnoblesse@gmail.com', 'Software developer', '', 'bboseko', 'bokanga', '2013-09-11 06:11:31', '2013-12-08 05:57:36', 0, 1, 0),
(2, 6, 'ADFAG134DSAF2343', 'Eddy', 'Bongwele', '', '', 'isbongwele@gmail.com', '', '', 'eddy', 'bongwele2', '2013-11-06 12:25:38', '2013-12-08 05:57:50', 0, 1, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_access`
--
ALTER TABLE `t_access`
  ADD CONSTRAINT `t_access_ibfk_1` FOREIGN KEY (`id_module`) REFERENCES `t_module` (`id_module`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_access_ibfk_2` FOREIGN KEY (`id_profile`) REFERENCES `t_profile` (`id_profile`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_manipulate`
--
ALTER TABLE `t_manipulate`
  ADD CONSTRAINT `t_manipulate_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_manipulate_ibfk_2` FOREIGN KEY (`id_submodule`) REFERENCES `t_submodule` (`id_submodule`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_submodule`
--
ALTER TABLE `t_submodule`
  ADD CONSTRAINT `t_submodule_ibfk_1` FOREIGN KEY (`id_module`) REFERENCES `t_module` (`id_module`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_user`
--
ALTER TABLE `t_user`
  ADD CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`id_profile`) REFERENCES `t_profile` (`id_profile`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
