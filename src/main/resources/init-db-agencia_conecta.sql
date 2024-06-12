-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           11.3.2-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para agencia_conecta
CREATE DATABASE IF NOT EXISTS `agencia_conecta` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */;
USE `agencia_conecta`;

-- Copiando estrutura para tabela agencia_conecta.influenciadores
CREATE TABLE IF NOT EXISTS `influenciadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `cidade_estado` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_contrato` date DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `instagram` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tiktok` varchar(255) DEFAULT NULL,
  `youtube` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Copiando estrutura para tabela agencia_conecta.servicos
CREATE TABLE IF NOT EXISTS `servicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL,
  `celular_contratante` varchar(255) DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `descricao_tipo_pagamento` varchar(255) DEFAULT NULL,
  `email_contratante` varchar(255) DEFAULT NULL,
  `exclusividade` bit(1) NOT NULL,
  `impulsionamento` bit(1) NOT NULL,
  `nome_contratante` varchar(255) DEFAULT NULL,
  `porcentagem` decimal(38,2) DEFAULT NULL,
  `proposta` varchar(255) DEFAULT NULL,
  `uso_imagem` bit(1) NOT NULL,
  `valor` decimal(38,2) DEFAULT NULL,
  `influenciador_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19xbsn3eqggxcntnmpcmliowx` (`influenciador_id`),
  CONSTRAINT `FK19xbsn3eqggxcntnmpcmliowx` FOREIGN KEY (`influenciador_id`) REFERENCES `influenciadores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Copiando estrutura para tabela agencia_conecta.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- Copiando dados para a tabela agencia_conecta.usuarios: ~1 rows (aproximadamente)
INSERT INTO `usuarios` (`id`, `login`, `senha`) VALUES
	(1, 'admin', '$2y$10$L9/NyGzJNYS9I4RnGcbOoenNVxDW6jrBLP0q.ZZ/HhU0psMm0B4b.');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
