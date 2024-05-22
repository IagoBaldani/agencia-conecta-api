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

-- Copiando dados para a tabela agencia_conecta.influenciadores: ~9 rows (aproximadamente)
INSERT INTO `influenciadores` (`id`, `ativo`, `celular`, `cidade_estado`, `cpf`, `data_contrato`, `data_nascimento`, `email`, `endereco`, `instagram`, `nome`, `tiktok`, `youtube`) VALUES
	(1, b'1', '(11)98765-4321', 'São Paulo/SP', '987.654.321-00', '2021-12-15', '1990-05-12', 'mariaoliveira@example.com', 'Rua das Flores, 456', '@mariaoliveira', 'Maria Oliveira', '@mariaoliveira', 'www.youtube.com/@mariaoliveira'),
	(2, b'1', '(31)98765-4321', 'Belo Horizonte/MG', '456.123.789-00', '2023-06-10', '1982-11-30', 'joaosantos@example.com', 'Avenida Central, 789', '@joaosantos', 'João Santos', '@joaosantos', 'www.youtube.com/@joaosantos'),
	(3, b'1', '(41)98765-4321', 'Curitiba/PR', '654.789.123-00', '2024-01-05', '1995-08-15', 'anasouza@example.com', 'Rua das Árvores, 987', '@anasouza', 'Ana Souza', '@anasouza', 'www.youtube.com/@anasouza'),
	(4, b'1', '(51)98765-4321', 'Porto Alegre/RS', '789.456.123-00', '2022-08-20', '1988-03-05', 'pedrolima@example.com', 'Rua dos Pinheiros, 321', '@pedrolima', 'Pedro Lima', '@pedrolima', 'www.youtube.com/@pedrolima'),
	(5, b'1', '(32)98765-4321', 'Juiz de Fora/MG', '852.369.741-00', '2023-11-30', '1992-07-10', 'fernandacosta@example.com', 'Rua das Palmeiras, 741', '@fernandacosta', 'Fernanda Costa', '@fernandacosta', 'www.youtube.com/@fernandacosta'),
	(6, b'1', '(62)98765-4321', 'Goiânia/GO', '369.741.852-00', '2024-04-02', '1980-12-25', 'rafaelapereira@example.com', 'Avenida das Rosas, 852', '@rafaelapereira', 'Rafaela Pereira', '@rafaelapereira', 'www.youtube.com/@rafaelapereira'),
	(7, b'1', '(21)98765-4321', 'Rio de Janeiro/RJ', '123.456.789-00', '2022-03-25', '1985-09-20', 'carlosilva@example.com', 'Avenida Atlântica, 123', '@carlosilva', 'Carlos Silva', '@carlosilva', 'www.youtube.com/@carlosilva'),
	(8, b'1', '(84)98765-4321', 'Natal/RN', '258.369.147-00', '2021-10-07', '1993-01-15', 'carolinasantos@example.com', 'Rua das Dunas, 369', '@carolinasantos', 'Carolina Santos', '@carolinasantos', 'www.youtube.com/@carolinasantos'),
	(9, b'1', '(91)98765-4321', 'Belém/PA', '369.147.258-00', '2024-02-12', '1984-06-28', 'gabrielsilva@example.com', 'Avenida dos Mangueirais, 147', '@gabrielsilva', 'Gabriel Silva', '@gabrielsilva', 'www.youtube.com/@gabrielsilva');

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

-- Copiando dados para a tabela agencia_conecta.servicos: ~19 rows (aproximadamente)
INSERT INTO `servicos` (`id`, `ativo`, `celular_contratante`, `data_fim`, `data_inicio`, `descricao_tipo_pagamento`, `email_contratante`, `exclusividade`, `impulsionamento`, `nome_contratante`, `porcentagem`, `proposta`, `uso_imagem`, `valor`, `influenciador_id`) VALUES
	(1, b'1', '(11)33333-2222', '2024-06-15', '2024-05-16', '100% antes', 'contato@betsson.com.br', b'0', b'1', 'Betsson - Apostas Esportivas', 45.00, '3 stories por semana - 1 mês - Destaque', b'0', 7500.00, 8),
	(2, b'1', '(11)88888-8888', '2024-06-09', '2024-05-10', '50% antes, 50% depois', 'comercial@vipbet.com.br', b'1', b'0', 'VipBet - Apostas Online', 40.00, '3 posts por semana - 1 mês - Destaque', b'1', 7000.00, 5),
	(3, b'1', '(11)77777-7777', '2024-06-05', '2024-05-15', '100% antes', 'contato@betmaster.com.br', b'0', b'1', 'BetMaster - Apostas Esportivas', 25.00, '1 post por dia - 3 semanas - Destaque', b'0', 3000.00, 3),
	(4, b'1', '(11)66666-6666', '2024-06-11', '2024-05-12', '70% antes, 30% depois', 'comercial@superbet.com.br', b'0', b'0', 'SuperBet - Apostas Online', 30.00, '4 stories por semana - 1 mês - Destaque', b'1', 6000.00, 8),
	(5, b'1', '(11)55555-5555', '2024-06-03', '2024-05-20', '100% antes', 'contato@betextreme.com.br', b'1', b'1', 'BetExtreme - Apostas Esportivas', 20.00, '2 posts por semana - 2 semanas - Destaque', b'0', 4000.00, 2),
	(6, b'1', '(11)44444-4444', '2024-06-16', '2024-05-17', '60% antes, 40% depois', 'comercial@betway.com.br', b'0', b'1', 'BetWay - Apostas Online', 35.00, '1 post por dia - 1 mês - Destaque', b'1', 5500.00, 6),
	(7, b'1', '(11)33333-3333', '2024-06-13', '2024-05-14', '100% antes', 'contato@betgold.com.br', b'1', b'0', 'BetGold - Apostas Esportivas', 45.00, '3 stories por semana - 1 mês - Destaque', b'0', 7500.00, 4),
	(8, b'1', '(11)22222-2222', '2024-06-01', '2024-05-11', '80% antes, 20% depois', 'comercial@betfair.com.br', b'1', b'1', 'BetFair - Apostas Online', 30.00, '2 posts por semana - 3 semanas - Destaque', b'1', 6000.00, 1),
	(9, b'1', '(11)99999-8888', '2024-06-15', '2024-05-16', '100% antes', 'contato@bet365.com.br', b'1', b'1', 'Bet365 - Apostas Esportivas', 25.00, '4 stories por semana - 2 semanas - Destaque', b'1', 5000.00, 9),
	(10, b'1', '(11)77777-9999', '2024-05-27', '2024-05-13', '90% antes, 10% depois', 'comercial@betsafe.com.br', b'0', b'0', 'BetSafe - Apostas Online', 35.00, '1 post por dia - 2 semanas - Destaque', b'1', 5500.00, 7),
	(11, b'1', '(11)66666-9999', '2024-06-07', '2024-05-18', '100% antes', 'contato@betsson.com.br', b'0', b'1', 'Betsson - Apostas Esportivas', 40.00, '3 posts por semana - 3 semanas - Destaque', b'1', 7000.00, 8),
	(12, b'1', '(11)88888-7777', '2024-06-04', '2024-05-21', '70% antes, 30% depois', 'comercial@betwinner.com.br', b'1', b'0', 'BetWinner - Apostas Online', 30.00, '2 stories por dia - 2 semanas - Destaque', b'1', 5500.00, 3),
	(13, b'0', '(11)77777-8888', '2024-06-13', '2024-05-14', '100% antes', 'contato@betclic.com.br', b'1', b'1', 'BetClic - Apostas Esportivas', 35.00, '3 posts por semana - 1 mês - Destaque', b'1', 6500.00, 6),
	(14, b'1', '(11)66666-5555', '2024-06-04', '2024-05-15', '80% antes, 20% depois', 'comercial@betfair.com.br', b'0', b'0', 'BetFair - Apostas Online', 25.00, '1 post por dia - 3 semanas - Destaque', b'0', 4000.00, 2),
	(15, b'1', '(11)55555-4444', '2024-06-03', '2024-05-20', '100% antes', 'contato@bethard.com.br', b'1', b'1', 'BetHard - Apostas Esportivas', 20.00, '2 stories por semana - 2 semanas - Destaque', b'1', 5000.00, 9),
	(16, b'1', '(11)44444-3333', '2024-06-02', '2024-05-13', '90% antes, 10% depois', 'comercial@bet365.com.br', b'0', b'0', 'Bet365 - Apostas Online', 30.00, '4 posts por semana - 3 semanas - Destaque', b'1', 6000.00, 4),
	(17, b'1', '(11)33333-2222', '2024-06-15', '2024-05-16', '100% antes', 'contato@betsson.com.br', b'0', b'1', 'Betsson - Apostas Esportivas', 45.00, '3 stories por semana - 1 mês - Destaque', b'0', 7500.00, 8),
	(18, b'1', '(11)22222-1111', '2024-06-01', '2024-05-17', '70% antes, 30% depois', 'comercial@betway.com.br', b'1', b'0', 'BetWay - Apostas Online', 35.00, '1 post por dia - 2 semanas - Destaque', b'1', 5500.00, 5);

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
