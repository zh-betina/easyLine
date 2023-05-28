-- Adminer 4.7.6 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE `adresse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` mediumtext NOT NULL,
  `ville` text NOT NULL,
  `code_postale` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `agence`;
CREATE TABLE `agence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_adresse` int NOT NULL,
  `nom` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_adresse` (`id_adresse`),
  CONSTRAINT `agence_ibfk_1` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `bagage`;
CREATE TABLE `bagage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `couleur` text NOT NULL,
  `poids` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `categorie`;
CREATE TABLE `categorie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `code_privilege`;
CREATE TABLE `code_privilege` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `handicape`;
CREATE TABLE `handicape` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `voyage_id` int NOT NULL,
  `date_creation` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `voyage_id` (`voyage_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`voyage_id`) REFERENCES `voyage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `voyage`;
CREATE TABLE `voyage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `agence_id` int NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `destination` text NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `agence_id` (`agence_id`),
  CONSTRAINT `voyage_ibfk_1` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `voyageur`;
CREATE TABLE `voyageur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categorie_id` int NOT NULL,
  `adresse_id` int NOT NULL,
  `bagage_id` int NOT NULL,
  `handicape_id` int NOT NULL,
  `code_privilege_id` int NOT NULL,
  `nom` text NOT NULL,
  `date_naissance` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categorie_id` (`categorie_id`),
  KEY `adresse_id` (`adresse_id`),
  KEY `bagage_id` (`bagage_id`),
  KEY `handicape_id` (`handicape_id`),
  KEY `code_privilege_id` (`code_privilege_id`),
  CONSTRAINT `voyageur_ibfk_1` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`),
  CONSTRAINT `voyageur_ibfk_2` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`),
  CONSTRAINT `voyageur_ibfk_3` FOREIGN KEY (`bagage_id`) REFERENCES `bagage` (`id`),
  CONSTRAINT `voyageur_ibfk_4` FOREIGN KEY (`handicape_id`) REFERENCES `handicape` (`id`),
  CONSTRAINT `voyageur_ibfk_5` FOREIGN KEY (`code_privilege_id`) REFERENCES `code_privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `voyageur_agence`;
CREATE TABLE `voyageur_agence` (
  `agence_id` int NOT NULL,
  `voyageur_id` int NOT NULL,
  KEY `agence_id` (`agence_id`),
  KEY `voyageur_id` (`voyageur_id`),
  CONSTRAINT `voyageur_agence_ibfk_1` FOREIGN KEY (`agence_id`) REFERENCES `agence` (`id`),
  CONSTRAINT `voyageur_agence_ibfk_2` FOREIGN KEY (`voyageur_id`) REFERENCES `voyageur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `voyageur_reservation`;
CREATE TABLE `voyageur_reservation` (
  `voyageur_id` int NOT NULL,
  `reservation_id` int NOT NULL,
  KEY `voyageur_id` (`voyageur_id`),
  KEY `reservation_id` (`reservation_id`),
  CONSTRAINT `voyageur_reservation_ibfk_1` FOREIGN KEY (`voyageur_id`) REFERENCES `voyageur` (`id`),
  CONSTRAINT `voyageur_reservation_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 2023-02-10 21:05:10
