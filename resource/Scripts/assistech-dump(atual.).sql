CREATE DATABASE  IF NOT EXISTS `assistech` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `assistech`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: assistech
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adm_financeiro`
--

DROP TABLE IF EXISTS `adm_financeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adm_financeiro` (
  `Matricula` varchar(13) NOT NULL,
  PRIMARY KEY (`Matricula`),
  CONSTRAINT `adm_financeiro_func_fk` FOREIGN KEY (`Matricula`) REFERENCES `funcionario` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm_financeiro`
--

LOCK TABLES `adm_financeiro` WRITE;
/*!40000 ALTER TABLE `adm_financeiro` DISABLE KEYS */;
INSERT INTO `adm_financeiro` VALUES ('3221219790127'),('3221219790128'),('3221219790129');
/*!40000 ALTER TABLE `adm_financeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `almoxarifado`
--

DROP TABLE IF EXISTS `almoxarifado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almoxarifado` (
  `Id` int(11) NOT NULL,
  `Entrada_mes` int(11) NOT NULL,
  `Saida_mes` int(11) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `Quantidade_total` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almoxarifado`
--

LOCK TABLES `almoxarifado` WRITE;
/*!40000 ALTER TABLE `almoxarifado` DISABLE KEYS */;
/*!40000 ALTER TABLE `almoxarifado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendente_solucionador_direcionador`
--

DROP TABLE IF EXISTS `atendente_solucionador_direcionador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendente_solucionador_direcionador` (
  `matricula` varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`matricula`),
  CONSTRAINT `atendente_soluc_direc_funciionario_fk` FOREIGN KEY (`matricula`) REFERENCES `tecnico` (`Matricula_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendente_solucionador_direcionador`
--

LOCK TABLES `atendente_solucionador_direcionador` WRITE;
/*!40000 ALTER TABLE `atendente_solucionador_direcionador` DISABLE KEYS */;
INSERT INTO `atendente_solucionador_direcionador` VALUES ('3221219790118'),('3221219790119'),('3221219790120'),('3221219790121'),('3221219790122'),('3221219790123'),('3221219790124'),('3221219790125'),('3221219790126'),('3221219790127'),('3221219790128'),('3221219790129'),('3221219790130'),('3221219790131'),('3221219790132');
/*!40000 ALTER TABLE `atendente_solucionador_direcionador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimento`
--

DROP TABLE IF EXISTS `atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendimento` (
  `id_atendimento` int(11) NOT NULL,
  `Sequencial_chamado` int(11) NOT NULL,
  `Mat_tec_campo` varchar(13) NOT NULL,
  PRIMARY KEY (`id_atendimento`),
  UNIQUE KEY `Sequencial_chamado` (`Sequencial_chamado`),
  UNIQUE KEY `Mat_tec_campo_UNIQUE` (`Mat_tec_campo`),
  CONSTRAINT `atendimento_chamado_fk` FOREIGN KEY (`Sequencial_chamado`) REFERENCES `chamado` (`Sequencial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tec_campo_chamado_fk` FOREIGN KEY (`Mat_tec_campo`) REFERENCES `tecnico_campo` (`matricula`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimento`
--

LOCK TABLES `atendimento` WRITE;
/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
INSERT INTO `atendimento` VALUES (43207177,326138,'3221219790123'),(80369101,455427,'3221219790124'),(80369102,721605,'3221219790125'),(80369103,414136,'3221219790126'),(80369106,449291,'');
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_problemas_kb`
--

DROP TABLE IF EXISTS `base_problemas_kb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_problemas_kb` (
  `Id_base_problemas` int(11) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `Procedimento` varchar(1023) NOT NULL,
  `Solucao` varchar(1023) NOT NULL,
  `Data_entrada` date NOT NULL,
  `Tempo_necessario` int(11) NOT NULL,
  `Obs` varchar(1023) NOT NULL,
  `Id_relacionado` int(11) NOT NULL,
  `Cod_servico` int(11) NOT NULL,
  PRIMARY KEY (`Id_base_problemas`),
  KEY `base_probs_relacionado_com_fk` (`Id_relacionado`),
  KEY `base_probs_servico_fk` (`Cod_servico`),
  CONSTRAINT `base_probs_relacionado_com_fk` FOREIGN KEY (`Id_relacionado`) REFERENCES `base_problemas_kb` (`Id_base_problemas`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `base_probs_servico_fk` FOREIGN KEY (`Cod_servico`) REFERENCES `servico` (`Cod_servico`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_problemas_kb`
--

LOCK TABLES `base_problemas_kb` WRITE;
/*!40000 ALTER TABLE `base_problemas_kb` DISABLE KEYS */;
INSERT INTO `base_problemas_kb` VALUES (139060,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-10',105,'-',139060,267080),(295099,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-11',105,'-',295099,613590),(337771,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-05',7,'-',337771,855547),(345877,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-16',10,'-',345877,613677),(551337,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-09',7,'-',551337,983704),(561412,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-07',1,'-',561412,215386),(576879,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-06',1,'-',576879,556703),(626060,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-15',7,'-',626060,193624),(663349,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-08',13,'-',663349,341250),(707902,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-03',1,'-',707902,204239),(793531,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-17',48,'-',793531,438841),(811100,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-14',105,'-',811100,904566),(811853,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-13',7,'-',811853,459121),(821136,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-12',1,'-',821136,605518),(877866,'Tela escura','Verificou-se em outro monitor','Foi efetuada a troca da tela/monitor','2012-11-04',13,'-',877866,461863);
/*!40000 ALTER TABLE `base_problemas_kb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baseou_em`
--

DROP TABLE IF EXISTS `baseou_em`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baseou_em` (
  `Id_base_prob` int(11) NOT NULL,
  `Numero_OS` int(11) NOT NULL,
  `Seq_instancia_servico` int(11) NOT NULL,
  `Cod_servico` int(11) NOT NULL,
  PRIMARY KEY (`Id_base_prob`,`Numero_OS`,`Seq_instancia_servico`,`Cod_servico`),
  KEY `baseou_em_servico_fk` (`Cod_servico`),
  CONSTRAINT `baseou_em_base_probs_fk` FOREIGN KEY (`Id_base_prob`) REFERENCES `base_problemas_kb` (`Id_base_problemas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `baseou_em_servico_fk` FOREIGN KEY (`Cod_servico`) REFERENCES `servico` (`Cod_servico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baseou_em`
--

LOCK TABLES `baseou_em` WRITE;
/*!40000 ALTER TABLE `baseou_em` DISABLE KEYS */;
INSERT INTO `baseou_em` VALUES (139060,901221,267080,8),(295099,702449,613590,9),(337771,109006,855547,3),(345877,498872,613677,14),(551337,977699,983704,7),(561412,293137,215386,5),(576879,538507,556703,4),(626060,812795,193624,13),(663349,579148,341250,6),(707902,628743,204239,1),(793531,746207,438841,15),(811100,251182,904566,12),(811853,640479,459121,11),(821136,743273,605518,10),(877866,896492,461863,2);
/*!40000 ALTER TABLE `baseou_em` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_insumo`
--

DROP TABLE IF EXISTS `categoria_insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_insumo` (
  `Cod_Cat_Insumo` varchar(20) NOT NULL,
  `Descricao` varchar(968) NOT NULL,
  PRIMARY KEY (`Cod_Cat_Insumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_insumo`
--

LOCK TABLES `categoria_insumo` WRITE;
/*!40000 ALTER TABLE `categoria_insumo` DISABLE KEYS */;
INSERT INTO `categoria_insumo` VALUES ('3705.90.0200','\"fotomÃ¡scaras sobre vidro plano, positivas, prÃ³prias para gravaÃ§Ã£o em pastilhas de silÃ­cio (chips) para fabricaÃ§Ã£o de microestruturas eletrÃ´nicas.\"\r\n3926.90.9900,Exclusivamente para malha de proteÃ§Ã£o para cabos de cabeÃ§ote de impressÃ£o\r\n6914.90.9900,Exclusivamente guia de agulhas de cerÃ¢mica para cabeÃ§ote de impressÃ£o\r\n7104.90.0100,Exclusivamente guia de rubi para cabeÃ§ote de impressÃ£o\r\n8471.93.0301,\"unidade de disco magnÃ©tico tipo flexÃ­vel (drive 3,5\" e 5,25\")\"\r\n8471.93.0399,qualquer unidade de disco magnÃ©tico (p. ex.: disco rÃ­gido)\r\n8473.29.0200,Exclusivamente das caixas registradoras elÃ©tricas\r\n8473.30.0100,Gabinete\r\n8473.30.0300,acionador (drive) de disco flexÃ­vel\r\n8473.30.0600,banco de martelos para impressÃ£o de linha\r\n8473.30.0800,cabeÃ§ote ou martelo de impressÃ£o\r\n8473.30.0900,cabeÃ§a de leitura e/ou gravaÃ§Ã£o magnÃ©tica\r\n8473.30.1300,mecanismo de impressÃ£o para impressora sem impacto\r\n8482.40.0000,Exclusivamente microro');
/*!40000 ALTER TABLE `categoria_insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria_servico`
--

DROP TABLE IF EXISTS `categoria_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria_servico` (
  `Cod` int(11) NOT NULL,
  `Tipo` varchar(80) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `Impacto` varchar(60) NOT NULL,
  `Urgencia` varchar(30) NOT NULL,
  PRIMARY KEY (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria_servico`
--

LOCK TABLES `categoria_servico` WRITE;
/*!40000 ALTER TABLE `categoria_servico` DISABLE KEYS */;
INSERT INTO `categoria_servico` VALUES (167317,'Sistema Operacional','RemoÃ§Ã£o de VÃ­rus','2','Baixa\r'),(236518,'Rede','','2','MÃ©dia\r'),(255289,'Rede','ReconfiguraÃ§Ã£o dos Roteadores','2','Alta\r'),(265068,'Rede','','2','MÃ©dia\r'),(273243,'Hardware','Troca de Placa MÃ£e','3','Baixa'),(310568,'Sistema Operacional','','1','Alta\r'),(525843,'Rede','','2','Baixa\r'),(558517,'Sistema Operacional','Medidas de SeguranÃ§a','1','Baixa\r'),(598303,'SeguranÃ§a','','3','Alta\r'),(608022,'Sistema Operacional','','1','Alta\r'),(679892,'Sistema Operacional','','2','MÃ©dia\r'),(696929,'Rede','ConfiguraÃ§Ã£o dos Roteadores','2','Alta\r'),(782015,'Rede','','1','Alta\r'),(899059,'Rede','','2','Baixa\r'),(932567,'Sistema Operacional','','2','Baixa\r');
/*!40000 ALTER TABLE `categoria_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chamado`
--

DROP TABLE IF EXISTS `chamado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chamado` (
  `Sequencial` int(11) NOT NULL,
  `Tipo` varchar(30) DEFAULT NULL,
  `Status_chamado` varchar(20) NOT NULL,
  `Descricao` varchar(100) NOT NULL,
  `Prioridade` varchar(20) NOT NULL,
  `Mat_supervisor` varchar(13) DEFAULT NULL,
  `Mat_tec_interno` varchar(13) DEFAULT NULL,
  `Mat_atendente` varchar(13) NOT NULL,
  `Num_ordem_servico` int(11) DEFAULT NULL,
  `Cod_cliente` int(11) NOT NULL,
  `Id_atendimento` int(11) NOT NULL,
  `Dta_abertura` date NOT NULL,
  PRIMARY KEY (`Sequencial`),
  KEY `chamado_supervisor_fk` (`Mat_supervisor`),
  KEY `chamado_tec_interno_fk` (`Mat_tec_interno`),
  KEY `chamado_atend_sol_direc_fk` (`Mat_atendente`),
  KEY `chamado_ordem_servico_fk` (`Num_ordem_servico`),
  KEY `chamado_cliente_fk_idx` (`Cod_cliente`),
  KEY `chamado_atendimento_fk_idx` (`Id_atendimento`),
  CONSTRAINT `chamado_atend_sol_direc_fk` FOREIGN KEY (`Mat_atendente`) REFERENCES `atendente_solucionador_direcionador` (`matricula`),
  CONSTRAINT `chamado_atendimento_fk` FOREIGN KEY (`Id_atendimento`) REFERENCES `atendimento` (`id_atendimento`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `chamado_cliente_fk` FOREIGN KEY (`Cod_cliente`) REFERENCES `cliente` (`Cod`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `chamado_ordem_servico_fk` FOREIGN KEY (`Num_ordem_servico`) REFERENCES `ordem_servico` (`Num_Ordem_Servico`),
  CONSTRAINT `chamado_supervisor_fk` FOREIGN KEY (`Mat_supervisor`) REFERENCES `supervisor` (`matricula`),
  CONSTRAINT `chamado_tec_interno_fk` FOREIGN KEY (`Mat_tec_interno`) REFERENCES `tecnico_interno` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chamado`
--

LOCK TABLES `chamado` WRITE;
/*!40000 ALTER TABLE `chamado` DISABLE KEYS */;
INSERT INTO `chamado` VALUES (127003,'Interno','Concluido','Sem descricao','Sim','3221219790121','4037469036387','2246705981087',538507,419036,0,'2010-12-15'),(142530,'Interno','Em processo','Sem descricao','Sim','3221219790118','4974678704490','6758517699760',628743,444272,0,'2014-04-19'),(285228,'Externo','Concluido','Sem descricao','NÃ£o','3221219790126','6857090937968','5968756780532',702449,444272,80369100,'2001-05-03'),(326138,'Externo','Concluido','Sem descricao','Sim','3221219790119','9607524394231','6977418034599',896492,419036,43207177,'2009-09-12'),(375295,'Interno','Em processo','Sem descricao','Sim','3221219790125','1013901989839','1539784638533',901221,494738,0,'2014-04-10'),(414136,'Externo','Na espera','Sem descricao','Sim','3221219790129','7336402053778','8182166689073',251182,754431,80369103,'2015-03-12'),(449291,'Interno','Em processo','Sem descricao','NÃ£o','3221219790132','2939681544360','5107105363576',746207,754431,0,'2001-05-03'),(455427,'Externo','Em processo','Sem descricao','Sim','3221219790127','7897223023730','6985312133607',743273,494738,80369101,'2012-07-15'),(469529,'Interno','Em processo','Sem descricao','Sim','3221219790123','5720417742894','2329300698267',579148,419036,0,'2015-03-12'),(474898,'Externo','Em processo','Sem descricao','NÃ£o','3221219790130','1877625217369','3033985495123',812795,754431,80369104,'2001-05-03'),(721605,'Externo','Concluido','Sem descricao','NÃ£o','3221219790128','5219251264524','1594092172270',640479,419036,80369102,'2014-04-10'),(831513,'Interno','Concluido','Sem descricao','Sim','3221219790131','4781915415583','2756836595671',498872,754431,0,'2014-04-10'),(857233,'Interno','Em processo','Sem descricao','NÃ£o','3221219790124','4101975791421','7006151265588',977699,494738,0,'2001-05-03'),(888642,'Interno','Em processo','Sem descricao','NÃ£o','3221219790120','7128959997536','6335131046868',109006,494738,0,'2001-05-03'),(993477,'Interno','Na espera','Sem descricao','NÃ£o','3221219790122','7067254094982','6248141194587',293137,419036,0,'2012-07-15');
/*!40000 ALTER TABLE `chamado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Cod` int(11) NOT NULL,
  `Prioridade` varchar(20) NOT NULL,
  `Endereco` varchar(200) NOT NULL,
  `Estado` varchar(50) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Fone` varchar(30) NOT NULL,
  PRIMARY KEY (`Cod`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (122211,'Baixa','P.O. Box 132, 5336 Tincidunt Street','PE','nonummy.ipsum.non@Morbiaccumsan.com','81324556612\r'),(141076,'Media','Rua Augusto Campos, 105.','MS','quinlan @email.com','81324556914'),(143693,'Media','9271 Donec Street','PC','sagittis.Duis@eleifendvitaeerat.net','81324556624\r'),(145281,'Media','Rua Alberico Morais, 72.','MS',NULL,'81324556715'),(216951,'Media','Rua Almeida Prado, 101.','PA',NULL,'81324556716'),(219478,'Baixa','8048 Dui. Rd.','BL','Nunc.lectus@sed.edu','81324556623\r'),(220323,'','Rua Augusto Moura, 107.','PA',NULL,'81324556717'),(236843,'Media','Ap #813-6435 Pellentesque Rd.','UR','Morbi.vehicula.Pellentesque@miDuisrisus.co.uk','81324556626'),(299644,'','Rua Mauro Mota, 27.','RU',NULL,'81324556718'),(300460,'','Rua Vidério Pessoa, 427.','MG',NULL,'81324556719'),(374702,'Baixa','767-7067 Et Street','AL','pretium@sitametconsectetuer.net','81324556618\r'),(419036,'Baixa','545-5308 Aliquam Rd.','BH','molestie.tellus.Aenean@etmagnisdis.com','81324556615\r'),(421804,'Media','P.O. Box 228, 5687 Fermentum Street','CA','dictum@ettristiquepellentesque.co.uk','81324556619\r'),(444272,'Baixa','P.O. Box 683, 1827 Magna. Street','SP','egestas.Duis.ac@nonvestibulumnec.ca','81324556614\r'),(448803,'Baixa','P.O. Box 774, 5509 Felis. Street','CH','scelerisque.sed.sapien@arcu.com','81324556625\r'),(467429,'','Rua Alberico Alves, 172.','MG',NULL,'81324556720'),(468928,'Baixa','Ap #108-1456 Nec, Street','RU','sem.Nulla@facilisislorem.co.uk','81324556617\r'),(494738,'Media','P.O. Box 852, 3735 Libero Avenue','TK','Aenean.euismod@estconguea.com','81324556616\r'),(546312,'Media','1128 Eget, Rd.','PA','Mauris.ut@nonjustoProin.com','81324556621\r'),(625728,'','Rua Mauro Alves, 271.','MG',NULL,'81324556721'),(631420,'','Rua Suzana Melo, 12.','PE',NULL,'81324556722'),(690810,'Baixa','Ap #428-6491 Curabitur Rd.','MG','at.pede.Cras@metus.co.uk','81324556622\r'),(754431,'Alta','9327 Sed, Road','AM','lobortis@interdumenim.ca','81324556620\r'),(782268,'','Rua Alfa Ribeiro, 270.','PE',NULL,'81324556723'),(834677,'','Rua Beta Campos, 171.','SC',NULL,'81324556724'),(898542,'','Rua Caetano Veloso, 198.','PE',NULL,'81324556725'),(921567,'Media','Ap #506-9024 Semper St.','MS','tempus@purusmauris.net','81324556613\r'),(925755,'','Rua Alto do Moura, 101.','MG',NULL,'81324556726'),(934833,'','Avenida Almeida Belo, 189.','PR',NULL,'81324556727'),(978804,'','Travessa Zé Ramalho, 451.','SP',NULL,'81324556728');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_fis`
--

DROP TABLE IF EXISTS `cliente_fis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_fis` (
  `Cod_cliente` int(11) NOT NULL,
  `Cpf` varchar(11) NOT NULL,
  `Nome` varchar(255) NOT NULL,
  PRIMARY KEY (`Cod_cliente`),
  CONSTRAINT `cliente_fis_cliente_fk` FOREIGN KEY (`Cod_cliente`) REFERENCES `cliente` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_fis`
--

LOCK TABLES `cliente_fis` WRITE;
/*!40000 ALTER TABLE `cliente_fis` DISABLE KEYS */;
INSERT INTO `cliente_fis` VALUES (141076,'19259570240','Quinlan Harris\r'),(145281,'92758354968','Brock Kaufman\r'),(216951,'31347097759','Maxwell Whitfield\r'),(220323,'88474497403','Brennan Buck\r'),(299644,'56354010375','Amos Park\r'),(300460,'91590170883','Callum Sutton\r'),(467429,'37373657682','Melvin Wade\r'),(625728,'61284091132','Paul Golden\r'),(631420,'82801587954','Tiger Stuart\r'),(782268,'90811376199','Marshall Hammond'),(834677,'37509548198','Brady Stokes\r'),(898542,'71431942027','Odysseus Oconnor\r'),(925755,'85360179529','Clinton Chang\r'),(934833,'66114713274','Carson Alvarado\r'),(978804,'76668539554','Felix Mack\r');
/*!40000 ALTER TABLE `cliente_fis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_jur`
--

DROP TABLE IF EXISTS `cliente_jur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_jur` (
  `Cod_cliente` int(11) NOT NULL,
  `Cnpj` bigint(14) NOT NULL,
  `Razao_social` varchar(100) NOT NULL,
  PRIMARY KEY (`Cod_cliente`),
  CONSTRAINT `cliente_jur_cliente_fk` FOREIGN KEY (`Cod_cliente`) REFERENCES `cliente` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_jur`
--

LOCK TABLES `cliente_jur` WRITE;
/*!40000 ALTER TABLE `cliente_jur` DISABLE KEYS */;
INSERT INTO `cliente_jur` VALUES (122211,14195624706335,'Enim Suspendisse Aliquet Corp.\r'),(143693,59350827294401,'Maecenas Ornare Limited\r'),(219478,89175855414941,'Ut Corp.\r'),(236843,80659098359756,'Mollis Phasellus Foundation'),(374702,48321955981664,'Lectus A Sollicitudin Industries\r'),(419036,40437113121151,'Sed Sapien Nunc Consulting\r'),(421804,86837971587665,'Nisi A Odio Industries\r'),(444272,95936731831170,'Duis Volutpat Foundation\r'),(448803,84513538032770,'Quisque Imperdiet Erat Industries\r'),(468928,18111112839542,'Elementum Ltd\r'),(494738,55055838939733,'A Purus Inc.\r'),(546312,27047773194499,'Sed Nec Metus Corporation\r'),(690810,45701316152699,'Amet Foundation\r'),(754431,13129212181083,'A Arcu Sed Limited\r'),(921567,76869739387184,'Ipsum Suspendisse Non Corp.\r');
/*!40000 ALTER TABLE `cliente_jur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente`
--

DROP TABLE IF EXISTS `componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente` (
  `Cod` int(11) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Fabricante` varchar(45) NOT NULL,
  `NumSerie` varchar(45) NOT NULL,
  `Onboard` varchar(3) NOT NULL,
  PRIMARY KEY (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente`
--

LOCK TABLES `componente` WRITE;
/*!40000 ALTER TABLE `componente` DISABLE KEYS */;
INSERT INTO `componente` VALUES (100499,'Software','Windows 7','Microsoft','761349','NÃ£'),(104793,'Hardware','Tower Combo PC','Cisco','909661','Sim'),(183952,'Rede','Windows 7','Cisco','606682','Sim'),(193096,'Hardware','Intel Core I3','Panasonic','277435','Sim'),(311419,'Hardware','VLC','AMD','129576','Sim'),(551114,'Software','Intel Core I3','Microsoft','741261','Sim'),(604581,'Rede','Tower Combo PC','Cisco','549997','Sim'),(693920,'Hardware','Tower Combo PC','Intel','373042','NÃ£'),(703113,'Hardware','Intel Core I3','Intel','262698','NÃ£'),(716794,'Hardware','Atlhon XP','AMD','295066','Sim'),(741632,'Software','VLC','Microsoft','673027','Sim'),(804251,'Software','Bulldozer','Nvidia','504125','Sim'),(862624,'Hardware','Windows 7','ItaliaExpress','835231','Sim'),(970926,'Hardware','FruitLoop','Nvidia','929354','NÃ£'),(988763,'Software','VLC','Apple','854204','Sim');
/*!40000 ALTER TABLE `componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computador`
--

DROP TABLE IF EXISTS `computador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computador` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `Sistema_operacional` varchar(20) NOT NULL,
  `Endereco_IP` varchar(15) NOT NULL,
  `Fabricante_Bios` varchar(45) DEFAULT NULL,
  `Versao_Bios` varchar(45) DEFAULT NULL,
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Cod_equipamento`),
  CONSTRAINT `computador_equipamento_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `equipamento` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computador`
--

LOCK TABLES `computador` WRITE;
/*!40000 ALTER TABLE `computador` DISABLE KEYS */;
INSERT INTO `computador` VALUES ('13508','Windows 10','192.168.100.08','Aopen','2.4.2558','Tablet'),('18398','Linux Cent OS','192.168.100.05','Gigabity','8.9.9915','handhelds'),('20790','Windows 10','192.168.100.01','Award/Phoenix','2.8.3356','Desktop'),('29476','Windows 7','192.168.100.07','Kinpo Electronics','4.6.6795','handhelds'),('34993','Windows 7','192.168.100.00','AMI','5.5.2478','Notebook'),('36512','Solaris','192.168.100.03','PCchips','2.1.4477','Tablet'),('41246','Ubuntu Lin','192.168.100.04','ECS','2.4.1244','Desktop'),('53435','Mac OS 8','192.168.100.02','Asus','1.4.3345','handhelds'),('79969','Linux Cent OS','192.168.100.06','MSI','7.6.5578','Desktop');
/*!40000 ALTER TABLE `computador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computador_componente`
--

DROP TABLE IF EXISTS `computador_componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computador_componente` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `Cod_Componente` int(11) NOT NULL,
  `data_instalacao` date NOT NULL,
  PRIMARY KEY (`Cod_equipamento`,`Cod_Componente`,`data_instalacao`),
  KEY `componente_fk` (`Cod_Componente`),
  CONSTRAINT `componente_fk` FOREIGN KEY (`Cod_Componente`) REFERENCES `componente` (`Cod`) ON UPDATE CASCADE,
  CONSTRAINT `computador_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `computador` (`Cod_equipamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computador_componente`
--

LOCK TABLES `computador_componente` WRITE;
/*!40000 ALTER TABLE `computador_componente` DISABLE KEYS */;
/*!40000 ALTER TABLE `computador_componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracheque`
--

DROP TABLE IF EXISTS `contracheque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contracheque` (
  `Codigo_contracheque` varchar(14) NOT NULL DEFAULT '',
  `Horas_extras` time NOT NULL,
  `Salario_Base` decimal(6,2) NOT NULL,
  `Adicional_Salario` decimal(6,2) NOT NULL DEFAULT '0.00',
  `Data_` date NOT NULL,
  `Matricula_Funcionario` varchar(13) NOT NULL,
  `Matricula_adm_financeiro` varchar(13) NOT NULL,
  PRIMARY KEY (`Codigo_contracheque`),
  KEY `contracheque_func_fk_idx` (`Matricula_Funcionario`),
  KEY `contracheque_adm_financ_fk_idx` (`Matricula_adm_financeiro`),
  CONSTRAINT `contracheque_adm_financ_fk` FOREIGN KEY (`Matricula_adm_financeiro`) REFERENCES `adm_financeiro` (`Matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contracheque_func_fk` FOREIGN KEY (`Matricula_Funcionario`) REFERENCES `funcionario` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracheque`
--

LOCK TABLES `contracheque` WRITE;
/*!40000 ALTER TABLE `contracheque` DISABLE KEYS */;
INSERT INTO `contracheque` VALUES ('106551','03:00:00',2500.00,300.01,'2001-05-03','900292','705412\r'),('203333','01:00:00',2500.00,100.00,'2014-04-10','949531','182903\r'),('264554','01:00:00',2500.00,100.00,'2001-05-03','470833','789764\r'),('335407','01:00:00',2500.00,200.00,'2001-05-03','479758','952073'),('402822','01:00:00',2500.00,100.00,'2014-04-10','927512','490233\r'),('437009','02:00:00',2500.00,200.00,'2012-07-15','543394','833511\r'),('471769','05:00:00',2500.00,100.00,'2015-03-12','609559','602912\r'),('820402','01:00:00',2500.00,100.00,'2012-07-15','645128','650957\r'),('869540','01:00:00',2500.00,100.00,'2014-04-10','976575','840978\r'),('882781','01:00:00',2500.00,100.00,'2010-12-15','316363','724843\r'),('900527','05:00:00',2500.00,500.00,'2015-03-12','665762','851386\r'),('903052','01:00:00',2500.00,100.00,'2009-09-12','619693','220635\r'),('944422','01:00:00',2500.00,100.00,'2001-05-03','547682','479836\r'),('967000','05:00:00',2500.00,500.00,'2014-04-19','270244','137556\r'),('986457','01:00:00',2500.00,100.00,'2001-05-03','793420','348776\r');
/*!40000 ALTER TABLE `contracheque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `Cod_contrato` varchar(15) NOT NULL,
  `Data_inicio` date NOT NULL,
  `Cod_cliente` int(11) NOT NULL,
  `Dt_fim` date NOT NULL,
  `Status_contrato` varchar(58) NOT NULL,
  `Cnpj_Unidade_Suporte` bigint(14) unsigned NOT NULL,
  `Id_tipo_contrato` int(10) NOT NULL,
  PRIMARY KEY (`Cod_contrato`),
  KEY `contrato_tipo_contrato_fk` (`Id_tipo_contrato`),
  KEY `contrato_cliente_jur_fk _idx` (`Cod_cliente`),
  KEY `contrato_unid_suporte_fk_idx` (`Cnpj_Unidade_Suporte`),
  CONSTRAINT `contrato_cliente_jur_fk ` FOREIGN KEY (`Cod_cliente`) REFERENCES `cliente_jur` (`Cod_cliente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `contrato_tipo_contrato_fk` FOREIGN KEY (`Id_tipo_contrato`) REFERENCES `tipo_contrato` (`Id_tipo_contrato`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `contrato_unid_suporte_fk` FOREIGN KEY (`Cnpj_Unidade_Suporte`) REFERENCES `unidade_de_suporte` (`CNPJ_empresa`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES ('1450279','2012-11-26',236843,'2020-11-26','Em andamento',13496314178472,1),('1759570','2012-03-19',122211,'2013-03-19','ConcluÃ­do',13496314178466,1),('3578660','2012-11-28',654214,'2019-11-28','ConcluÃ­do',13496314178475,2),('3727393','2012-11-27',221596,'2016-11-27','Em andamento',13496314178480,1),('4875344','2012-11-25',593141,'2017-11-25','Em andamento',13496314178478,1),('4914676','2012-11-25',448803,'2017-11-25','Em andamento',13496314178472,3),('6711649','2012-11-27',333493,'2016-11-27','ConcluÃ­do',13496314178472,2),('6787223','2012-11-22',419036,'2014-11-22','ConcluÃ­do',13496314178469,2),('6926065','2012-11-20',921567,'2016-11-20','ConcluÃ­do',13496314178467,2),('7917849','2012-11-24',468928,'2018-11-24','Em andamento',13496314178470,3),('8367571','2012-11-23',494738,'2015-11-23','ConcluÃ­do',13496314178470,1),('8393722','2012-11-26',706565,'2020-11-26','Em andamento',13496314178472,1),('8435024','2012-11-23',664879,'2015-11-23','ConcluÃ­do',13496314178476,2),('8560934','2012-11-24',483845,'2018-11-24','ConcluÃ­do',13496314178477,2),('9302429','2012-11-21',444272,'2020-11-21','Em andamento',13496314178467,2);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependente`
--

DROP TABLE IF EXISTS `dependente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependente` (
  `Sequencial` int(10) NOT NULL DEFAULT '0',
  `Matricula_funcionario` varchar(13) NOT NULL DEFAULT '',
  `Nome` varchar(50) NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Data_nascimento` date NOT NULL,
  `Parentesco` varchar(20) NOT NULL,
  `Idade` int(3) NOT NULL,
  PRIMARY KEY (`Sequencial`,`Matricula_funcionario`),
  KEY `dependente_funcionario_fk` (`Matricula_funcionario`),
  CONSTRAINT `dependente_funcionario_fk` FOREIGN KEY (`Matricula_funcionario`) REFERENCES `funcionario` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependente`
--

LOCK TABLES `dependente` WRITE;
/*!40000 ALTER TABLE `dependente` DISABLE KEYS */;
INSERT INTO `dependente` VALUES (11111,'3221219790123','José das Neves','M','1989-11-01','Irmão',28),(55555,'3221219790128','José Pereira Furtado','M','1989-11-01','Irmão',29),(77777,'3221219790123','Marina Souza','F','1989-11-01','Irmã',28),(264004,'3221219790128','Lynn Combs','F','1987-10-15','Esposa',22),(315209,'3221219790128','Bianca Wilcox','M','1987-10-14','Filho',29),(337485,'3221219790128','Teegan Mccray','F','1987-10-08','Filha',10),(412979,'3221219790128','Hayley Medina','F','1987-10-07','Filho',10),(459845,'3221219790129','Indira Spears','F','1987-10-21','Esposa',40),(498923,'3221219790121','Jordan Mercer','F','1954-10-11','Esposa',48),(557468,'3221219790121','Rae Roman','M','1987-10-20','Filha',4),(562315,'3221219790123','Afonso Pereira Souza','M','1989-11-01','Irmão',29),(633728,'3221219790123','Hannah Buck','F','1955-10-09','Filha',3),(686894,'3221219790123','Breanna Clay','M','1959-10-12','Filho',30),(701513,'3221219790123','Jolene House','F','1969-10-13','Filho',12),(760658,'3221219790123','Iris Mcbride','F','1987-10-19','Esposa',26),(783874,'3221219790125','Tatyana Haynes','F','1987-10-17','Esposa',27),(891118,'3221219790125','Allegra Reynolds','F','1977-10-10','Filho',43),(941065,'3221219790125','Sarah Duke','F','1987-10-16','Filho',55),(962050,'3221219790125','João Silva','M','1989-11-01','Filho',29),(962086,'3221219790125','Nora Baxter','M','1987-10-18','Filha',15),(962307,'3221219790123','Mauritânio Vieira','M','1989-11-01','Irmão',29),(962315,'3221219790128','Alexandra Maria Causa','F','1989-11-01','Irmã',28);
/*!40000 ALTER TABLE `dependente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger update_age
before insert on assistech.dependente
for each row
begin
	SET @ano_atual:=YEAR(curdate());
    SET @idade:=(@ano_atual) - YEAR(new.Data_nascimento);
    SET @mes_atual:=MONTH(curdate());
    SET @dia_atual:=DAY(curdate());
    SET @mes_nasc:=MONTH(new.Data_nascimento);
    SET @dia_nasc:=DAY(new.Data_nascimento);
   
    if  @mes_atual<@mes_nasc then
		set @idade:=@idade-1;
        elseif @mes_atual>=@mes_nasc and @dia_atual>=@dia_nasc then
			set @idade:=@idade;
    end if;
    
    set new.Idade=@idade;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `despesa_viagem`
--

DROP TABLE IF EXISTS `despesa_viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despesa_viagem` (
  `Cod` varchar(10) NOT NULL,
  `Valor` float(4,2) NOT NULL,
  `Id_tipo_despesa` int(11) DEFAULT NULL,
  `Mat_adm_financeiro` varchar(13) NOT NULL,
  `id_atend` int(11) NOT NULL,
  PRIMARY KEY (`Cod`),
  UNIQUE KEY `Mat_adm_financeiro` (`Mat_adm_financeiro`),
  KEY `despesa_tipo_despesa_fk` (`Id_tipo_despesa`),
  KEY `despesa_viag_atendimento_fk_idx` (`id_atend`),
  CONSTRAINT `despesa_adm_financeiro_fk` FOREIGN KEY (`Mat_adm_financeiro`) REFERENCES `adm_financeiro` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `despesa_tipo_despesa_fk` FOREIGN KEY (`Id_tipo_despesa`) REFERENCES `tipo_despesa` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `despesa_viag_atendimento_fk` FOREIGN KEY (`id_atend`) REFERENCES `atendimento` (`id_atendimento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesa_viagem`
--

LOCK TABLES `despesa_viagem` WRITE;
/*!40000 ALTER TABLE `despesa_viagem` DISABLE KEYS */;
INSERT INTO `despesa_viagem` VALUES ('1115896532',99.99,790842,'3221219790136',65817406),('1115896533',99.99,790840,'3221219790137',43207177),('1115896534',99.99,790839,'3221219790138',47147950),('1115896535',23.58,790839,'3221219790139',96495731),('1115896536',99.99,790840,'3221219790140',29048252),('1115896537',99.99,790839,'3221219790141',94514790),('1115896538',99.99,790840,'3221219790142',80369098);
/*!40000 ALTER TABLE `despesa_viagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dia`
--

DROP TABLE IF EXISTS `dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dia` (
  `sequencial` varchar(12) NOT NULL,
  `descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`sequencial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dia`
--

LOCK TABLES `dia` WRITE;
/*!40000 ALTER TABLE `dia` DISABLE KEYS */;
INSERT INTO `dia` VALUES ('1','Segunda-feira\r'),('2','Terça-feira\r'),('3','Quarta-feira\r'),('4','Quinta-feira\r'),('5','Sexta-feira\r'),('6','Sábado');
/*!40000 ALTER TABLE `dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `Id_documento` int(11) NOT NULL,
  `Tipo` varchar(60) NOT NULL,
  `Data_Criacao` date NOT NULL,
  `Arquivo` varchar(50) NOT NULL,
  `Versao` varchar(20) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Data_inicio` date NOT NULL,
  `Cod_cliente` int(11) NOT NULL,
  `Cnpj_Unidade_Suporte` bigint(14) NOT NULL,
  PRIMARY KEY (`Id_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (238911,'Fiscal','2013-11-09','Paudalho','1.0','Do Prazo de VigÃªncia do Contrato','0000-00-00',0,0),(272788,'Fiscal','2012-11-09','Boa Vista','3.0','Dos Contratantes','0000-00-00',0,0),(274294,'Fiscal','2021-11-09','Boa Vista','4.2','Da jornada de trabalho contratada','0000-00-00',0,0),(314526,'Fiscal','2015-11-09','Paulista','4.2','Dos Contratantes','0000-00-00',0,0),(469453,'Fiscal','2019-11-09','Boa Viagem','3.1.2002','Dos Contratantes','0000-00-00',0,0),(557666,'Fiscal','2011-11-09','Boa Viagem','5.0','Da jornada de trabalho contratada','0000-00-00',0,0),(573071,'Fiscal','2009-11-09','Boa Vista','1.3','Dos Contratantes','0000-00-00',0,0),(757612,'Fiscal','2020-11-09','Paulista','1.0','Do Contratado','0000-00-00',0,0),(781263,'Fiscal','2014-11-09','Imbiribeira','1.3','Do Prazo de VigÃªncia do Contrato','0000-00-00',0,0),(848454,'Fiscal','2010-11-09','Bom Pastor','1.4.2002','Do Contratado','0000-00-00',0,0),(857745,'Fiscal','2022-11-09','Paulista','3.1.2002','Do Contratado','0000-00-00',0,0),(860894,'Fiscal','2017-11-09','Paulista','2.1','Do Contratado','0000-00-00',0,0),(884060,'Fiscal','2016-11-09','Boa Viagem','2.1','Do Contratado','0000-00-00',0,0),(891266,'Fiscal','2018-11-09','Boa Viagem','4.2','Do Contratado','0000-00-00',0,0),(953531,'Fiscal','2023-11-09','Boa Vista','1.3','Do Contratado','0000-00-00',0,0);
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver` (
  `Cod_componente` int(11) NOT NULL,
  `sequencial` varchar(45) NOT NULL,
  `caminho` varchar(255) NOT NULL,
  `obs` varchar(700) NOT NULL,
  PRIMARY KEY (`Cod_componente`,`sequencial`),
  CONSTRAINT `componente_driver_fk` FOREIGN KEY (`Cod_componente`) REFERENCES `componente` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (100499,'8','http://www.samsung.com/br/support/downloadcenter/','Funcionando corretamente.\r'),(104793,'7','http://www.samsung.com/br/support/downloadcenter/','Funcionando corretamente.\r'),(183952,'11','https://support.hp.com/br-pt/drivers','Funcionando corretamente.\r'),(193096,'2','https://support.hp.com/br-pt/drivers','Funcionando corretamente. Mas precisa atualizar.\r'),(311419,'9','https://www.Samsung-Products/laptop?app=drivers','Funcionando corretamente.\r'),(551114,'3','https://support.hp.com/br-pt/drivers','NÃ£o estÃ¡ funcionando neste modelo.(Verificar)\r'),(604581,'10','https://www.Samsung-Products/laptop?app=drivers','Funcionando corretamente.\r'),(693920,'4','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','Funcionando corretamente.\r'),(703113,'1','https://support.hp.com/br-pt/drivers','Funcionando corretamente.\r'),(716794,'13','https://support.hp.com/br-pt/drivers','Funcionando corretamente. Mas precisa atualizar.\r'),(741632,'12','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','Funcionando corretamente. Mas precisa atualizar.\r'),(804251,'15','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','NÃ£o estÃ¡ funcionando neste modelo.(Verificar)'),(862624,'5','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','Funcionando corretamente.\r'),(970926,'14','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','Funcionando corretamente. Mas precisa atualizar.\r'),(988763,'6','http://www.dell.com/support/home/br/pt/brdhs1/Products/laptop?app=drivers','Funcionando corretamente.\r');
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver_impressora`
--

DROP TABLE IF EXISTS `driver_impressora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `driver_impressora` (
  `Cod_driver` varchar(45) NOT NULL,
  `Cod_equipamento` varchar(15) NOT NULL,
  `Caminho` varchar(255) NOT NULL,
  `Versao` varchar(35) NOT NULL,
  `Obs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Cod_driver`,`Cod_equipamento`),
  UNIQUE KEY `Cod_equipamento` (`Cod_equipamento`),
  CONSTRAINT `impressora_driver_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `impressora` (`Cod_equipamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver_impressora`
--

LOCK TABLES `driver_impressora` WRITE;
/*!40000 ALTER TABLE `driver_impressora` DISABLE KEYS */;
INSERT INTO `driver_impressora` VALUES ('126100','31115','https://support.hp.com/br-pt/drivers','0.24','NÃ£o estÃ¡ funcionando neste modelo.(Verificar)\r'),('489791','19703','http://support.lexmark.com/index?page=driversdownloads&userlocale=PT_BR&locale=PT','1.55','Funcionando corretamente.\r');
/*!40000 ALTER TABLE `driver_impressora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `CNPJ` bigint(14) unsigned NOT NULL,
  `Razao_social` varchar(60) NOT NULL,
  `Endereco` varchar(60) NOT NULL,
  `Fone` varchar(15) NOT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CNPJ`),
  UNIQUE KEY `Razao_social` (`Razao_social`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (13496314178466,'Proin Foundation','Ap #775-3538 Euismod Road','(81) 3031-2526','Bahia'),(13496314178467,'Ac Inc.','154-7105 A Ave','(81) 3031-2525','Ceará'),(13496314178468,'Euismod Mauris Eu Consulting','P.O. Box 135, 8214 Morbi St.','(81) 3031-2524','São Paulo'),(13496314178469,'Libero Morbi Industries','Ap #659-5123 Sit Street','(81) 3031-2523','São Paulo'),(13496314178470,'Sapien Molestie Orci LLP','332-3298 Interdum Road','(81) 3031-2522','Minas Gerais'),(13496314178471,'Proin Velit Company','4468 Sagittis Street','(81) 3031-2521','São Paulo'),(13496314178472,'Donec Tempus LLP','Ap #222-1785 Mauris Ave','(81) 3031-2520','São Paulo'),(13496314178473,'Duis Foundation','4658 Nulla Road','(81) 3031-2519','São Paulo'),(13496314178474,'Ullamcorper Duis At Inc.','P.O. Box 811, 504 Faucibus St.','(81) 3031-2518','Minas Gerais'),(13496314178475,'Orci Inc.','P.O. Box 866, 7025 Phasellus Road','(81) 3031-2517','Paraná'),(13496314178476,'Tristique Ltd','8234 Dui Av.','(81) 3031-2516','Bahia'),(13496314178477,'Nec Foundation','7075 In, St.','(81) 3031-2515','Paraíba'),(13496314178478,'Accumsan Laoreet Ipsum Institute','P.O. Box 158, 3772 Elit, Rd.','(81) 3031-2514','Goiás'),(13496314178479,'Eros Non Enim PC','676 Non, Rd.','(81) 3031-2513','Paraná'),(13496314178480,'Nec Urna Suscipit Institute','Ap #604-5978 Blandit St.','(81) 3031-2512','São Paulo');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `end_fornecedor`
--

DROP TABLE IF EXISTS `end_fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `end_fornecedor` (
  `Cnpj_Fornecedor` bigint(14) NOT NULL,
  `Endereco` varchar(255) NOT NULL,
  PRIMARY KEY (`Cnpj_Fornecedor`,`Endereco`),
  CONSTRAINT `end_fornecedor_fk` FOREIGN KEY (`Cnpj_Fornecedor`) REFERENCES `fornecedor` (`Cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `end_fornecedor`
--

LOCK TABLES `end_fornecedor` WRITE;
/*!40000 ALTER TABLE `end_fornecedor` DISABLE KEYS */;
INSERT INTO `end_fornecedor` VALUES (882287,'Avenida Padre Carapuceiro, 105, Boa Viagem, Recife, PE.\"\r\n361034,\"Avenida Mahado de Assis, 105 Barra da Tijuca, Rio de Janeiro, RJ.\"\r\n223144,\"Rua Alcides Castro, 77 Bexiga, SÃ£o Paulo, SP.\"\r\n842984,\"Rua Antonio Sobrinho, 99 SÃ£o Paulo, SP.\"\r\n691420,\"Rua C');
/*!40000 ALTER TABLE `end_fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envolveu`
--

DROP TABLE IF EXISTS `envolveu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `envolveu` (
  `Num_ordem_servico` int(11) NOT NULL,
  `Cod_equipamento` varchar(15) NOT NULL,
  PRIMARY KEY (`Num_ordem_servico`,`Cod_equipamento`),
  KEY `envolve_equipamento_fk` (`Cod_equipamento`),
  CONSTRAINT `envolve_equipamento_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `equipamento` (`Cod`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `envolveu_os_fk` FOREIGN KEY (`Num_ordem_servico`) REFERENCES `ordem_servico` (`Num_Ordem_Servico`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envolveu`
--

LOCK TABLES `envolveu` WRITE;
/*!40000 ALTER TABLE `envolveu` DISABLE KEYS */;
INSERT INTO `envolveu` VALUES (109006,'19703\r'),(251182,'20790\r'),(293137,'79969\r'),(498872,'75322\r'),(538507,'29476\r'),(579148,'18398\r'),(628743,'34993\r'),(640479,'99542\r'),(702449,'36512\r'),(743273,'53435\r'),(746207,'31115'),(812795,'44201\r'),(896492,'13508\r'),(901221,'41246\r'),(977699,'55377\r');
/*!40000 ALTER TABLE `envolveu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `equi_datas`
--

DROP TABLE IF EXISTS `equi_datas`;
/*!50001 DROP VIEW IF EXISTS `equi_datas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `equi_datas` AS SELECT 
 1 AS `Cod`,
 1 AS `Data_entrada`,
 1 AS `Setor`,
 1 AS `historico`,
 1 AS `Fabricante`,
 1 AS `Estado`,
 1 AS `Descricao`,
 1 AS `Cod_contrato`,
 1 AS `Cnpj_Unid_Suporte`,
 1 AS `Cod_Cliente`,
 1 AS `Data_inicio`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `Cod` varchar(15) NOT NULL,
  `Data_entrada` date NOT NULL,
  `Setor` varchar(50) NOT NULL,
  `historico` varchar(1023) NOT NULL,
  `Fabricante` varchar(20) NOT NULL,
  `Estado` varchar(255) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `Cod_contrato` varchar(15) NOT NULL,
  `Cnpj_Unid_Suporte` bigint(14) unsigned NOT NULL,
  `Cod_Cliente` int(11) NOT NULL,
  `Data_inicio` date NOT NULL,
  PRIMARY KEY (`Cod`),
  KEY `Cod_contrato_fk` (`Cod_contrato`),
  KEY `equipamento_contrato_fk1_idx` (`Cnpj_Unid_Suporte`),
  KEY `equipamento_contrato_fk2_idx` (`Cod_Cliente`),
  KEY `equipamento_contrato_fk3_idx` (`Data_inicio`),
  CONSTRAINT `Cod_contrato_fk` FOREIGN KEY (`Cod_contrato`) REFERENCES `contrato` (`Cod_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT INTO `equipamento` VALUES ('13508','2012-11-11','Automacao','O equipamento nunca foi aberto.','Gabinete Fonte MIMAX','Lenovo','Bahia','13496314178471',921567,2012,'0000-00-00'),('18398','2012-11-15','Automacao','O equipamento jÃ¡ passou por 1 manutenÃ§Ãµes.','MemÃ³ria RAM 2GB DDR','Positivo','Minas Gerais','13496314178471',468928,2012,'0000-00-00'),('19703','2012-11-12','Almoxarifado','O equipamento nunca foi aberto.','HD Western 1TB Sata ','Lexmark','Santa Catarina','13496314178471',444272,2012,'0000-00-00'),('20790','2012-11-21','Ferragens','O equipamento jÃ¡ deu problema de travamento suspeita do processador.','CartÃ£o de 16GB','HP','Rio de Janeiro','13496314178479',419036,2012,'0000-00-00'),('29476','2012-11-13','Almoxarifado','O equipamento nunca foi aberto.','MemÃ³ria RAM 2GB DDR','Lenovo','SÃ£o Paulo','13496314178469',419036,2012,'0000-00-00'),('31115','2012-11-24','Automacao','Falhas coloridas na imagem.','HD Western 1TB Sata ','HP','Bahia','13496314178469',221596,2012,'0000-00-00'),('34993','2012-11-10','Ferragens','O equipamento jÃ¡ passou por 3 manutenÃ§Ãµes.','Teclado Multimidia A','CCE','Rio de Janeiro','13496314178466',122211,2012,'0000-00-00'),('36512','2012-11-18','Almoxarifado','O equipamento jÃ¡ passou por 1 manutenÃ§Ãµes.','MemÃ³ria RAM 2GB DDR','CCE','SÃ£o Paulo','13496314178474',236843,2012,'0000-00-00'),('41246','2012-11-17','Recepcao','O equipamento jÃ¡ deu problema de travamento suspeita do processador.','Teclado Multimidia A','Itautech','Bahia','13496314178474',236843,2012,'0000-00-00'),('44201','2012-11-22','Recepcao','Esquentando muito.','MemÃ³ria RAM 2GB DDR','Microsol','ParanÃ¡','13496314178479',593141,2012,'0000-00-00'),('53435','2012-03-19','Automacao','O equipamento jÃ¡ passou por 1 manutenÃ§Ãµes.','Processador Intel I5','Philco','Rio Grande do Sul','13496314178475',236843,2012,'0000-00-00'),('55377','2012-11-16','Automacao','O equipamento jÃ¡ passou por 3 manutenÃ§Ãµes.','CartÃ£o de 16GB','Philco','ParÃ¡','13496314178472',122211,2012,'0000-00-00'),('75322','2012-11-23','Automacao','Falhas coloridas na imagem.','CartÃ£o de 16GB','Philco','SÃ£o Paulo','13496314178479',221596,2012,'0000-00-00'),('79969','2012-11-14','Automacao','O equipamento jÃ¡ passou por 3 manutenÃ§Ãµes.','Processador Intel I5','Philco','Rio Grande do Sul','13496314178470',921567,2012,'0000-00-00'),('99542','2012-11-20','Ferragens','O equipamento jÃ¡ passou por 1 manutenÃ§Ãµes.','Processador Intel I5','CCE','ParÃ¡','13496314178476',664879,2012,'0000-00-00');
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipe` (
  `Cod_equipe` varchar(15) NOT NULL DEFAULT '',
  `Nome` varchar(50) NOT NULL,
  `Obs` varchar(200) DEFAULT '',
  PRIMARY KEY (`Cod_equipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES ('1285','Bert','Folga\r'),('1903','Phillip','Externo\r'),('2033','Upton','Nada consta\r'),('2384','Deirdre','Escala\r'),('3481','Tana','ferias\r'),('3624','Matthew','Externo\r'),('4141','Ivor','Folga\r'),('5952','Plato','LicenÃ§a\r'),('6254','Jameson','Nada consta'),('7711','Jada','Transferido\r'),('7998','Winter','LicenÃ§a\r'),('9004','Deanna','Transferido\r'),('9045','Tanya','Nada consta\r'),('9090','Paul','Escala\r'),('9968','Hope','Externo\r');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fatura`
--

DROP TABLE IF EXISTS `fatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fatura` (
  `Cod` int(11) NOT NULL,
  `Num_parcelas` int(11) NOT NULL,
  `Valor_total` decimal(6,2) NOT NULL,
  `Status_` varchar(30) NOT NULL,
  `Cod_cliente` int(11) NOT NULL,
  PRIMARY KEY (`Cod`),
  KEY `fatura_cliente_fk` (`Cod_cliente`),
  CONSTRAINT `fatura_cliente_fk` FOREIGN KEY (`Cod_cliente`) REFERENCES `cliente` (`Cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fatura`
--

LOCK TABLES `fatura` WRITE;
/*!40000 ALTER TABLE `fatura` DISABLE KEYS */;
INSERT INTO `fatura` VALUES (111365,12,750.00,'Em andamento',754431),(117095,12,0.00,'Em andamento',122211),(125469,4,500.23,'Liquidada',444272),(133652,30,3054.26,'Em andamento',143693),(133965,6,1900.56,'Liquidada',421804),(139545,13,2500.00,'Em andamento',143693),(150619,12,0.00,'Liquidada',448803),(189562,20,450.00,'Em andamento',143693),(215469,17,1200.00,'Em andamento',754431),(223259,20,1030.56,'Liquidada',374702),(231307,12,0.00,'Em andamento',419036),(254807,12,0.00,'Liquidada',921567),(255898,30,2537.10,'Em andamento',444272),(332619,12,0.00,'Em andamento',546312),(417174,12,0.00,'Liquidada',494738),(525009,12,0.00,'Em andamento',468928),(544386,12,0.00,'Liquidada',421804),(559734,12,0.00,'Em andamento',236843),(592439,12,0.00,'Em andamento',219478),(629787,12,0.00,'Liquidada',690810),(743797,12,0.00,'Em andamento',444272),(805070,12,0.00,'Em andamento',374702),(857787,12,0.00,'Em andamento',754431),(875466,3,297.56,'Liquidada',444272),(913831,12,0.00,'Em andamento',143693),(923654,15,120.00,'Em andamento',143693);
/*!40000 ALTER TABLE `fatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornece`
--

DROP TABLE IF EXISTS `fornece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornece` (
  `Cnpj_Fornecedor` bigint(14) NOT NULL,
  `Cod_Insumo` varchar(15) NOT NULL,
  `Data_inicio` date NOT NULL,
  `Data_fim` date NOT NULL,
  `Valor_unitario` decimal(6,2) NOT NULL,
  PRIMARY KEY (`Cnpj_Fornecedor`),
  KEY `Cod_Insumo_fk` (`Cod_Insumo`),
  CONSTRAINT `Cnpj_Fornecedor_fk` FOREIGN KEY (`Cnpj_Fornecedor`) REFERENCES `fornecedor` (`Cnpj`),
  CONSTRAINT `Cod_Insumo_fk` FOREIGN KEY (`Cod_Insumo`) REFERENCES `insumo` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornece`
--

LOCK TABLES `fornece` WRITE;
/*!40000 ALTER TABLE `fornece` DISABLE KEYS */;
INSERT INTO `fornece` VALUES (125164,'778175','2008-12-15','2008-12-16',150.07),(190079,'736111','2006-11-15','2006-11-16',150.10),(239213,'487430','2001-06-15','2001-06-16',150.06),(300859,'689154','2002-09-15','2002-09-16',150.09),(371654,'284971','2008-12-15','2008-12-16',150.03),(377174,'876085','2002-09-15','2002-09-16',150.04),(427853,'531407','2008-12-15','2008-12-16',150.12),(501347,'277767','2006-11-15','2006-11-16',150.01),(558737,'242515','2006-11-15','2006-11-16',150.05),(566444,'997704','2003-12-15','2003-12-16',150.14),(622967,'362684','2001-06-15','2001-06-16',150.11),(657929,'800434','2004-07-15','2004-07-16',150.13),(769954,'888495','2002-09-15','2002-09-16',150.00),(788217,'312470','2001-06-15','2001-06-16',150.02),(919954,'595870','2002-09-15','2002-09-16',150.08);
/*!40000 ALTER TABLE `fornece` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `Cnpj` bigint(14) NOT NULL,
  `Razao_social` varchar(30) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`Cnpj`),
  UNIQUE KEY `Razao_social` (`Razao_social`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (452963,'Ferreira Costa','ferreira.costa@gmail.com','55813030-3030\r'),(551368,'HP','sony@sony.com','55813030-3031\r'),(630609,'Philips','philips@philips.com','55211901-0062\r'),(708431,'Panasonic','panasonic@panasonic.com','55112213-0909\r'),(731624,'INFOBOX','philips@philips.com','55211901-0062\r'),(829104,'Sony','sony@sony.com','55213456-1199\r');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `Matricula` varchar(13) NOT NULL DEFAULT '',
  `CPF` bigint(11) NOT NULL,
  `Login` varchar(15) NOT NULL,
  `Senha` varchar(15) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `CargaHoraria` int(8) NOT NULL,
  `MatriculaSupervisor` varchar(13) DEFAULT NULL,
  `IdJornada` varchar(8) DEFAULT NULL,
  `DataInicio` date NOT NULL,
  `CodigoUnidadeDeSuporte` int(11) DEFAULT NULL,
  PRIMARY KEY (`Matricula`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `Senha` (`Senha`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  UNIQUE KEY `Nome_UNIQUE` (`Nome`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `Id_jornada_UNIQUE` (`IdJornada`),
  KEY `funcionario_supervisiona_fk_idx` (`MatriculaSupervisor`),
  KEY `funcionario_unid_suporte_fk_idx` (`CodigoUnidadeDeSuporte`),
  CONSTRAINT `funcionario_jornada_fk` FOREIGN KEY (`IdJornada`) REFERENCES `jornada_de_trabalho` (`Id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `funcionario_supervisiona_fk` FOREIGN KEY (`MatriculaSupervisor`) REFERENCES `funcionario` (`Matricula`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `funcionario_unid_suporte_fk` FOREIGN KEY (`CodigoUnidadeDeSuporte`) REFERENCES `unidade_de_suporte` (`Cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('3221219790118',11898352001,'Kylan','131274509274058','Collier, Alexis Q.','non.hendrerit@quismassa.com',6,'3221219790123','32163328','1999-11-02',12369),('3221219790119',11898352002,'Finn','131274509274059','Thompson, David N.','sapien@Duisami.org',6,'3221219790118','33884623','2010-12-03',12369),('3221219790120',11898352003,'Harlan','131274509274060','Calhoun, Tatum V.','at.risus@pede.edu',4,'3221219790118','32163330','2001-11-04',12369),('3221219790121',11898352004,'Francis','131274509274061','Ayala, Francesca U.','aliquam@tempusnonlacinia.net',4,'3221219790118','32163331','2007-12-02',44665),('3221219790122',11898352005,'Minerva','131274509274062','Herman, Damian L.','tempus.lorem@tempor.net',4,'3221219790123','32163332','1994-10-20',44665),('3221219790123',11898352006,'Derek','131274509274063','Mcneil, Kendall S.','orci.lacus@gravidamolestiearcu.com',8,'3221219790118','32163333','2001-11-04',44665),('3221219790124',11898352007,'Isabella','131274509274064','Gould, Beatrice T.','neque@lacus.net',6,'3221219790118','32163334','2010-12-03',44665),('3221219790125',11898352008,'Jasper','131274509274065','Willis, Marny R.','adipiscing@luctuslobortisClass.ca',6,'3221219790130','32163335','1994-10-20',44665),('3221219790126',11898352009,'Kyra','131274509274066','Downs, Callum A.','nonummy@dolortempus.ca',6,'3221219790130','32163336','1994-10-20',44665),('3221219790127',11898352010,'Dane','131274509274067','Orr, Cain Z.','dictum.sapien@uteros.edu',4,'3221219790130','32163337','1994-10-20',44665),('3221219790128',11898352011,'Branden','131274509274068','Malone, Xena W.','magna.Cras@eulacus.ca',6,'3221219790130','32163338','1990-12-03',58994),('3221219790129',11898352012,'Dexter','131274509274069','Buckner, Martina X.','risus.In@ipsumDonecsollicitudin.edu',4,'3221219790130','32163339','2003-05-07',58994),('3221219790130',11898352013,'Leila','131274509274070','Downs, Athena Q.','nulla@Nam.org',6,'3221219790123','32163340','2003-05-07',58994),('3221219790131',11898352014,'Haviva','131274509274071','Kirk, Trevor H.','eu@nunc.co.uk',4,'3221219790123','32163341','2003-05-07',58994),('3221219790132',11898352015,'Molly','131274509274072','Coffey, Drew N.','Nullam@nec.net',4,'3221219790130','32163342','2003-05-07',58994),('3221219790133',11111111111,'augusto','123451','Silvio Carlos Augusto Melo','augusto.carlos@gmail.com',8,'3221219790130','32163329','2001-12-03',12369),('3221219790134',88888888888,'Alberto','11111111111','Alberto Jomard','alberto_jomard@email.com',8,'3221219790130','32163349','2007-11-07',12369),('3221219790136',99012341521,'TOC','94917178','Thiago Oliveira Cavalcante','thiago.oliveira@email.com',8,'3221219790118','32163352','2010-01-14',58994),('3221219790137',99012341522,'GD123','81949105','Gabriel Diniz Pontes','gabriel.diniz@email.com',8,'3221219790118','32163353','2009-10-03',58994),('3221219790138',99012341523,'Fe345','124156141','Fernado Marciel Lins','fernando.lins@email.com',8,'3221219790118','32163354','2008-09-10',12369),('3221219790139',99012341524,'Tulio','314156142','Tulio Guillherme Silva','tulio.silva@email.com',6,'3221219790123','32163355','2009-07-11',44665),('3221219790140',99012341525,'Carlosp','313156719','Carlos Prestes Nuca','carlos.nuca@email.com',8,'3221219790123','32163356','2010-12-15',44665),('3221219790141',99012341526,'Paulod','314413142','Paulo Cava da Luz','paulo.cava@email.com',6,'3221219790123','32163357','2001-05-08',12369),('3221219790142',99012341546,'Marcos','312156113','Marcos Rubens da Silva','marcos.rubens@email.com',4,'3221219790118','32163358','2002-01-09',58994),('3221219790143',99012341564,'Carine','100003123','Carine Neves Moraes','carine.neves@email.com',6,'3221219790118','32163380','2007-03-12',12369),('3221219790144',99012341570,'Lucia31','100003222','Lucia Catia de Lourdes','lucia.catia@email.com',6,'3221219790118','32163373','2010-08-30',12369),('3221219790145',32411673001,'ClauM','103203123','Claudia da Silva','claudia.silva@email.com',4,'3221219790118','32163382','2003-09-23',58994),('3221219790146',32411673002,'Mica','213003123','Micaele Moreira Alves','micaele.alves@email.com',8,'3221219790123','32163383','1999-12-05',12369),('3221219790147',32411673003,'Dudaa','105103123','Maria Eduarda Alves','maria.duda@email.com',8,'3221219790123','32163384','2002-08-20',44665),('3221219790148',32411673004,'Julio','100061123','Julio Pimentel Garlindo','julio.pi@email.com',8,'3221219790123','32163385','2005-09-22',12369),('3221219790149',32411673031,'JC123','100003144','Joao Carlos Marcillio','joca@email.com',4,'3221219790130','32163386','2010-08-25',58994),('3221219790150',32411674456,'Mateus','412003123','Mateus Richard Oliveira','mateus.r@email.com',6,'3221219790130','32163376','2006-12-03',44665),('3221219790176',44444444444,'JFA','888888','Jonas Fernando Alcarroci','jonas.fernando@email.com',8,'3221219790130','32163351','2011-03-05',58994);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger upd_num_funcionarios
after insert on assistech.funcionario
for each row
begin
	SET @num_func:=(select Nro_funcionarios from assistech.unidade_de_suporte where Cod=new.CodigoUnidadeDeSuporte);
    
	UPDATE assistech.unidade_de_suporte SET Nro_funcionarios = @num_func + 1 WHERE  Cod=new.CodigoUnidadeDeSuporte;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger upd_num_func_del
after delete on assistech.funcionario
for each row
begin
	SET @num_func:=(select Nro_funcionarios from assistech.unidade_de_suporte where Cod=old.CodigoUnidadeDeSuporte);
    UPDATE assistech.unidade_de_suporte SET Nro_funcionarios = @num_func - 1 WHERE  Cod=old.CodigoUnidadeDeSuporte;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `impressora`
--

DROP TABLE IF EXISTS `impressora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impressora` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `Modelo` varchar(15) NOT NULL,
  `end_ip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Cod_equipamento`),
  CONSTRAINT `impressora_equipamento_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `equipamento` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impressora`
--

LOCK TABLES `impressora` WRITE;
/*!40000 ALTER TABLE `impressora` DISABLE KEYS */;
INSERT INTO `impressora` VALUES ('19703','LL719009','192.162.100.1'),('31115','HP 0792','192.162.100.0\r');
/*!40000 ALTER TABLE `impressora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instancia_servico`
--

DROP TABLE IF EXISTS `instancia_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instancia_servico` (
  `Numero_OS` int(11) NOT NULL,
  `Cod_Servico` int(11) NOT NULL,
  `Sequencial` int(11) NOT NULL,
  `Prioridade` varchar(18) NOT NULL,
  `Status_` varchar(20) NOT NULL,
  PRIMARY KEY (`Numero_OS`,`Cod_Servico`,`Sequencial`),
  KEY `ordem_servico_servico_fk` (`Cod_Servico`),
  CONSTRAINT `ordem_servico_or_servico_fk` FOREIGN KEY (`Numero_OS`) REFERENCES `ordem_servico` (`Num_Ordem_Servico`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ordem_servico_servico_fk` FOREIGN KEY (`Cod_Servico`) REFERENCES `servico` (`Cod_servico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instancia_servico`
--

LOCK TABLES `instancia_servico` WRITE;
/*!40000 ALTER TABLE `instancia_servico` DISABLE KEYS */;
INSERT INTO `instancia_servico` VALUES (109006,855547,3,'Média','Pendente'),(251182,904566,12,'Alta','Em andamento'),(293137,215386,5,'Alta','Concluído'),(498872,613677,14,'Alta','Pendente'),(538507,556703,4,'Média','Pendente'),(579148,341250,6,'Baixa','Concluído'),(628743,204239,1,'Alta','Concluído'),(640479,459121,11,'Baixa','Concluído'),(702449,613590,9,'Alta','Concluído'),(743273,605518,10,'Baixa','Concluído'),(746207,438841,15,'Média','Concluído'),(812795,193624,13,'Alta','Pendente'),(896492,461863,2,'Baixa','Em andamento'),(901221,267080,8,'Média','Pendente'),(977699,983704,7,'Média','Em andamento');
/*!40000 ALTER TABLE `instancia_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo` (
  `Cod` varchar(15) NOT NULL,
  `Descricao` varchar(128) NOT NULL,
  `Cod_categoria` varchar(20) NOT NULL,
  `Mat_supervisor` varchar(13) NOT NULL,
  PRIMARY KEY (`Cod`),
  KEY `insumo_categoria_fk` (`Cod_categoria`),
  KEY `insumo_solicita_fk` (`Mat_supervisor`),
  CONSTRAINT `insumo_categoria_fk` FOREIGN KEY (`Cod_categoria`) REFERENCES `categoria_insumo` (`Cod_Cat_Insumo`),
  CONSTRAINT `insumo_solicita_fk` FOREIGN KEY (`Mat_supervisor`) REFERENCES `solicita` (`Mat_supervisor`),
  CONSTRAINT `insumo_supervisor_fk` FOREIGN KEY (`Mat_supervisor`) REFERENCES `supervisor` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
INSERT INTO `insumo` VALUES ('13720','Memória','2','3221219790120'),('16166','Eletrônico','3','3221219790132'),('18795','Eletrônico','2','3221219790128'),('21639','Eletrônico','1','3221219790127'),('31916','Fonte de Alimentação ATX 230W','1','3221219790124'),('34094','Toner','2','3221219790125'),('42541','Eletrônico','2','3221219790131'),('45737','Carcaça Notebook Positivo','2','3221219790122'),('47092','Cabeamento','2','3221219790119'),('55610','Tela LED Notebook','3','3221219790126'),('65412','Parafuso Notebook Acer 1149','1','3221219790121'),('67333','Antenas','1','3221219790130'),('70039','Teclado Notebook HP','2','3221219790130'),('74333','Eletrônico','1','3221219790130'),('75056','Eletrônico','3','3221219790129');
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo_usado_servico`
--

DROP TABLE IF EXISTS `insumo_usado_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo_usado_servico` (
  `Cod_Insumo` varchar(15) NOT NULL,
  `Cod_servico` int(11) NOT NULL,
  `Quantidade` varchar(29) NOT NULL,
  PRIMARY KEY (`Cod_Insumo`,`Cod_servico`),
  KEY `insumo_usado_servico_servico` (`Cod_servico`),
  CONSTRAINT `insumo_usado_servico_insumo_fk` FOREIGN KEY (`Cod_Insumo`) REFERENCES `insumo` (`Cod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `insumo_usado_servico_servico` FOREIGN KEY (`Cod_servico`) REFERENCES `servico` (`Cod_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo_usado_servico`
--

LOCK TABLES `insumo_usado_servico` WRITE;
/*!40000 ALTER TABLE `insumo_usado_servico` DISABLE KEYS */;
INSERT INTO `insumo_usado_servico` VALUES ('13720',855547,'33'),('16166',438841,'11'),('18795',459121,'35'),('21639',605518,'99'),('31916',983704,'22'),('34094',267080,'44'),('42541',613677,'99'),('45737',215386,'78'),('47092',461863,'65'),('55610',613590,'65'),('65412',556703,'65'),('67333',204239,'34'),('70039',341250,'96'),('74333',193624,'77'),('75056',904566,'75');
/*!40000 ALTER TABLE `insumo_usado_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_estoque`
--

DROP TABLE IF EXISTS `item_estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_estoque` (
  `Cod_Insumo` varchar(15) NOT NULL,
  `Id_almoxarifado` int(11) NOT NULL,
  `Sequencial` int(8) NOT NULL,
  `Quantidade_Atual` int(6) NOT NULL,
  `Data_validade` date NOT NULL,
  `Data_final` date NOT NULL,
  `Data_entrada` date NOT NULL,
  `Preco_compra` decimal(10,2) NOT NULL,
  `Quantidade_minima` int(6) NOT NULL,
  `Situacao` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`Cod_Insumo`,`Id_almoxarifado`,`Sequencial`),
  KEY `item_estoque_insumo_fk` (`Cod_Insumo`),
  KEY `item_estoque_almoxarifado_fk` (`Id_almoxarifado`),
  CONSTRAINT `item_estoque_almoxarifado_fk` FOREIGN KEY (`Id_almoxarifado`) REFERENCES `almoxarifado` (`Id`),
  CONSTRAINT `item_estoque_insumo_fk` FOREIGN KEY (`Cod_Insumo`) REFERENCES `insumo` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_estoque`
--

LOCK TABLES `item_estoque` WRITE;
/*!40000 ALTER TABLE `item_estoque` DISABLE KEYS */;
INSERT INTO `item_estoque` VALUES ('13720',983,50953612,3,'2020-09-13','2021-10-13','2011-05-01',350.00,5,NULL),('16166',509,50889810,10,'2019-05-01','2021-10-13','2011-05-01',400.00,5,NULL),('18795',341,25096988,29,'2019-05-01','2021-10-13','2013-08-01',120.00,15,NULL),('21639',277,12067497,34,'2019-05-01','2021-10-13','2013-08-01',260.00,100,NULL),('31916',634,93083774,37,'2019-05-01','2020-05-01','2015-09-13',60.00,300,NULL),('34094',582,79696878,60,'2018-08-01','2021-10-13','2011-05-01',85.00,20,NULL),('42541',610,45761419,29,'2019-05-01','2021-10-13','2013-08-01',400.00,20,NULL),('45737',704,55654892,74,'2019-05-01','2020-05-01','2011-05-01',85.00,20,NULL),('5412',141,15205417,88,'2020-09-13','2021-10-13','2015-09-13',260.00,100,NULL),('55610',336,78264600,27,'2020-09-13','2021-10-13','2013-08-01',120.00,15,NULL),('67333',955,31036336,52,'2020-09-13','2021-10-13','2013-08-01',350.00,20,NULL),('70039',780,47315474,90,'2019-05-01','2020-05-01','2015-09-13',125.55,5,NULL),('7092',983,23375147,73,'2020-09-13','2021-10-13','2015-09-13',400.00,5,NULL),('74333',549,42359917,98,'2019-05-01','2021-10-13','2013-08-01',120.00,20,NULL),('75056',857,78137666,79,'2019-05-01','2021-10-13','2013-08-01',125.55,30,NULL);
/*!40000 ALTER TABLE `item_estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornada_de_trabalho`
--

DROP TABLE IF EXISTS `jornada_de_trabalho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jornada_de_trabalho` (
  `Id` varchar(8) NOT NULL DEFAULT '',
  `Trabalha_sabado` varchar(3) NOT NULL DEFAULT 'NAO',
  `descricao` varchar(200) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornada_de_trabalho`
--

LOCK TABLES `jornada_de_trabalho` WRITE;
/*!40000 ALTER TABLE `jornada_de_trabalho` DISABLE KEYS */;
INSERT INTO `jornada_de_trabalho` VALUES ('32163328','Não','Não_Tem\r'),('32163329','Não','Não_Tem'),('32163330','Sim','Não_Tem'),('32163331','Sim','Não_Tem'),('32163332','Não','Não_Tem'),('32163333','Não','Não_Tem'),('32163334','Sim','Não_Tem'),('32163335','Não','Não_Tem'),('32163336','Não','Não_Tem'),('32163337','Não','Não_Tem'),('32163338','Não','Não_Tem'),('32163339','Sim','Não_Tem'),('32163340','Sim','Não_Tem'),('32163341','Sim','Não_Tem'),('32163342','Sim','Não_Tem'),('32163349','Sim','Não_tem'),('32163351','Sim','Não_tem'),('32163352','Sim','Não_tem'),('32163353','Sim','Não_tem'),('32163354','Não','Não_tem'),('32163355','Não','Não_tem'),('32163356','Sim','Não_tem'),('32163357','Não','Não_tem'),('32163358','Não','Não_tem'),('32163373','Sim','Não tem'),('32163376','Não','Não_tem'),('32163380','Sim','Não_tem'),('32163382','Sim','Não_tem'),('32163383','Sim','Não_tem'),('32163384','Não','Não_tem'),('32163385','Sim','Não_tem'),('32163386','Não','Não_tem'),('33884623','Não','Não_tem');
/*!40000 ALTER TABLE `jornada_de_trabalho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornada_de_trabalho_tem`
--

DROP TABLE IF EXISTS `jornada_de_trabalho_tem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jornada_de_trabalho_tem` (
  `Id_jornada` varchar(8) NOT NULL,
  `seq_dia` varchar(12) NOT NULL,
  `cod_turno` varchar(14) NOT NULL,
  PRIMARY KEY (`Id_jornada`,`seq_dia`,`cod_turno`),
  KEY `cod_turno_fk` (`cod_turno`),
  KEY `seq_dia_fk` (`seq_dia`),
  KEY `id_jornada_fk_idx` (`Id_jornada`),
  CONSTRAINT `cod_turno_fk` FOREIGN KEY (`cod_turno`) REFERENCES `turno` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `id_jornada_fk` FOREIGN KEY (`Id_jornada`) REFERENCES `jornada_de_trabalho` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seq_dia_fk` FOREIGN KEY (`seq_dia`) REFERENCES `dia` (`sequencial`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornada_de_trabalho_tem`
--

LOCK TABLES `jornada_de_trabalho_tem` WRITE;
/*!40000 ALTER TABLE `jornada_de_trabalho_tem` DISABLE KEYS */;
INSERT INTO `jornada_de_trabalho_tem` VALUES ('32163328','1','0\r'),('32163328','5','1'),('32163329','1','1'),('32163329','2','1\r'),('32163329','3','1'),('32163329','4','2'),('32163329','5','2'),('32163335','1','0\r'),('32163335','5','1');
/*!40000 ALTER TABLE `jornada_de_trabalho_tem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `jornada_fun`
--

DROP TABLE IF EXISTS `jornada_fun`;
/*!50001 DROP VIEW IF EXISTS `jornada_fun`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `jornada_fun` AS SELECT 
 1 AS `Id`,
 1 AS `Trabalha_sabado`,
 1 AS `descricao`,
 1 AS `Matricula`,
 1 AS `CPF`,
 1 AS `Login`,
 1 AS `Senha`,
 1 AS `Nome`,
 1 AS `Email`,
 1 AS `CargaHoraria`,
 1 AS `MatriculaSupervisor`,
 1 AS `IdJornada`,
 1 AS `DataInicio`,
 1 AS `CodigoUnidadeDeSuporte`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kpi`
--

DROP TABLE IF EXISTS `kpi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi` (
  `Sequencial` int(11) NOT NULL,
  `Matricula_tecnico` varchar(13) NOT NULL,
  `KPI_1` varchar(30) DEFAULT NULL,
  `KPI_2` varchar(30) DEFAULT NULL,
  `Dsc_KPI_1` varchar(100) DEFAULT NULL,
  `Dsk_KPI_2` varchar(100) DEFAULT NULL,
  `dt_inicio_periodo` date DEFAULT NULL,
  `dt_final_periodo` date DEFAULT NULL,
  `dt_criacao` date NOT NULL,
  PRIMARY KEY (`Sequencial`,`Matricula_tecnico`),
  KEY `kpi_tecnico_fk` (`Matricula_tecnico`),
  CONSTRAINT `kpi_tecnico_fk` FOREIGN KEY (`Matricula_tecnico`) REFERENCES `tecnico` (`Matricula_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi`
--

LOCK TABLES `kpi` WRITE;
/*!40000 ALTER TABLE `kpi` DISABLE KEYS */;
INSERT INTO `kpi` VALUES (11952,'3221219790146','13','34','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2010-11-14','2011-05-02','2013-07-08'),(16491,'3221219790138','3','6','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2016-03-03','2016-04-12','2010-11-03'),(25848,'3221219790136','10','59','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2014-01-02','2014-12-12','2012-11-03'),(26790,'3221219790150','32','58','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2011-05-06','2017-08-09','2018-01-02'),(32823,'3221219790144','60','22','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2008-12-12','2018-12-13','2018-11-05'),(44985,'3221219790143','47','23','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2015-06-08','2015-11-06','2017-03-04'),(50748,'3221219790141','10','29','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2018-12-12','2018-12-13','2018-11-05'),(52145,'3221219790148','1','9','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2016-03-03','2016-04-12','2010-11-03'),(54382,'3221219790140','11','56','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2017-05-06','2017-08-09','2018-01-02'),(61192,'3221219790149','32','34','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2005-01-15','2010-01-01','2011-02-13'),(64408,'3221219790145','24','36','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2015-06-08','2015-11-06','2017-03-04'),(69253,'3221219790147','51','49','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2007-02-11','2012-03-11','2011-12-11'),(74103,'3221219790139','49','38','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2009-01-12','2010-01-01','2011-02-13'),(93220,'3221219790137','52','50','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2012-02-11','2012-03-11','2011-12-11'),(94257,'3221219790142','9','9','Total de Máquinas Consertadas por Semana','Máquinas Consertadas sem Retorno por Mês','2011-12-12','2018-12-13','2018-11-05');
/*!40000 ALTER TABLE `kpi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacao`
--

DROP TABLE IF EXISTS `localizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacao` (
  `Cnpj_Unidade_Suporte` bigint(14) unsigned NOT NULL,
  `end_` varchar(255) NOT NULL,
  `estado` varchar(80) NOT NULL,
  PRIMARY KEY (`Cnpj_Unidade_Suporte`,`end_`,`estado`),
  CONSTRAINT `localizacao_unid_suport_fk` FOREIGN KEY (`Cnpj_Unidade_Suporte`) REFERENCES `unidade_de_suporte` (`CNPJ_empresa`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacao`
--

LOCK TABLES `localizacao` WRITE;
/*!40000 ALTER TABLE `localizacao` DISABLE KEYS */;
INSERT INTO `localizacao` VALUES (145566,'Avenida Nova Descoberta, 455.','Bahia\r'),(147715,'Rua Bexiga 70, Campos do Jordão.','São Paulo\r'),(273749,'Rua Bexiga 70, Campos do Jordão.','São Paulo\r'),(369839,'Rua Alves Castro, 101.','São Paulo'),(444828,'Avenida Carlos Chagas, SN.','Goiás\r'),(477372,'Rua Alves Castro, 101.','São Paulo'),(590234,'Rua Alves Ramalho, 47, Campina Grande.','Paraíba\r'),(681609,'Rua Augusto SIlva, 144, Rondonia.','Roraima\r'),(713041,'Rua Desembargador Carlos Alberto Ferreira da Silva, 277, Rio de Janeiro.','Rio de Janeiro\r'),(791398,'Avenida Carlos Chagas, SN.','Go¡ás\r'),(814246,'Avenida Ourives, 54.','Minas Gerais\r'),(831730,'Rua Carlos Motta, 107, São Paulo.','São Paulo\r'),(888411,'Avenida Nova Descoberta, 455.','Bahia\r'),(921870,'Avenida Ourives, 54.','Minas Gerais\r');
/*!40000 ALTER TABLE `localizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nobreak`
--

DROP TABLE IF EXISTS `nobreak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nobreak` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `KVA` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_equipamento`),
  CONSTRAINT `nobreak_equipamento_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `equipamento` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nobreak`
--

LOCK TABLES `nobreak` WRITE;
/*!40000 ALTER TABLE `nobreak` DISABLE KEYS */;
INSERT INTO `nobreak` VALUES ('44201','1000');
/*!40000 ALTER TABLE `nobreak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_fiscal`
--

DROP TABLE IF EXISTS `nota_fiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_fiscal` (
  `Cod_nota_fiscal` int(11) NOT NULL,
  `Cod_insumo` varchar(15) DEFAULT NULL,
  `Desc_insumo` varchar(45) DEFAULT NULL,
  `quantidade` int(11) NOT NULL,
  `valor_unitario` decimal(10,2) NOT NULL,
  `valor_total` decimal(10,2) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `data_expedicao` date NOT NULL,
  `calculo_issqn` float(4,2) NOT NULL,
  `cod_pagamento` int(11) NOT NULL,
  `cod_pedido` int(11) unsigned NOT NULL,
  PRIMARY KEY (`Cod_nota_fiscal`),
  KEY `cod_pagamento_fk` (`cod_pagamento`),
  KEY `pedido_nota_fiscal_fk` (`Cod_nota_fiscal`),
  KEY `cod_pedido_nota_fiscal_fk` (`cod_pedido`),
  CONSTRAINT `cod_pagamento_fk` FOREIGN KEY (`cod_pagamento`) REFERENCES `pagamento` (`Cod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cod_pedido_nota_fiscal_fk` FOREIGN KEY (`cod_pedido`) REFERENCES `pedido` (`Cod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_fiscal`
--

LOCK TABLES `nota_fiscal` WRITE;
/*!40000 ALTER TABLE `nota_fiscal` DISABLE KEYS */;
INSERT INTO `nota_fiscal` VALUES (122846,'18795','EletrÃ´nico',2,120.00,244.80,'Venda','2011-04-06',0.02,597855,198429),(146348,'75056','EletrÃ´nico',3,125.55,384.18,'Venda','2012-04-12',0.02,932253,894576),(149071,'70039','Teclado Notebook HP',1,125.55,129.32,'Venda','2015-12-11',0.03,836913,437029),(196025,'74333','EletrÃ´nico',2,120.00,249.60,'Venda','2012-11-15',0.04,832040,716048),(211275,'65412','Parafuso Notebook Acer 1149',3,260.00,795.60,'PretaÃ§Ã£o de ServiÃ§o','2012-11-15',0.02,131276,628399),(303441,'21639','EletrÃ´nico',4,260.00,1092.00,'PretaÃ§Ã£o de ServiÃ§o','2017-01-04',0.05,109549,147324),(417588,'67333','Antenas',3,350.00,1.10,'Venda','2018-09-29',0.05,417588,275918),(528522,'47092','Cabeamento',4,400.00,1680.00,'PretaÃ§Ã£o de ServiÃ§o','2018-11-04',0.05,802482,259986),(553703,'45737','CarcaÃ§a Notebook Positivo',7,85.00,606.90,'Venda','2018-11-04',0.02,436936,441646),(623540,'31916','Fonte de AlimentaÃ§Ã£o ATX 230W',2,60.00,123.60,'Venda','2014-03-27',0.03,532472,777120),(664845,'55610','Tela LED Noetbook',6,120.00,756.00,'PretaÃ§Ã£o de ServiÃ§o','2018-11-04',0.05,385644,344769),(666462,'16166','EletrÃ´nico',3,400.00,1248.00,'PretaÃ§Ã£o de ServiÃ§o','2017-11-04',0.03,366527,846698),(775024,'13720','MemÃ³ria',6,350.00,2205.00,'PretaÃ§Ã£o de ServiÃ§o','2012-04-12',0.05,842446,322050),(877342,'34094','Toner',1,85.00,88.40,'PretaÃ§Ã£o de ServiÃ§o','2018-09-29',0.04,177197,764203),(961532,'42541','EletrÃ´nico',10,4000.00,41600.00,'PretaÃ§Ã£o de ServiÃ§o','2018-11-04',0.04,699303,821398);
/*!40000 ALTER TABLE `nota_fiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento`
--

DROP TABLE IF EXISTS `orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orcamento` (
  `Cod` int(11) unsigned NOT NULL,
  `Data_emissao` date NOT NULL,
  `Validade_num_dias` int(11) NOT NULL,
  `ultima_data` date NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `Data_abertura` date NOT NULL,
  PRIMARY KEY (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento`
--

LOCK TABLES `orcamento` WRITE;
/*!40000 ALTER TABLE `orcamento` DISABLE KEYS */;
INSERT INTO `orcamento` VALUES (107695,'2018-12-26',60,'2019-01-07','Referente a troca de dois módulos de memória DDR3  em Notebook.','2018-11-17'),(111091,'2018-12-03',90,'2019-01-05','Referente a formatação de 30 pcs HP.','2018-11-05'),(124565,'2017-12-01',90,'2017-12-03','Referente a troca de capacitores e resistores SMD das TVs da praça de alimentação.','2017-11-22'),(130254,'2030-09-05',5,'2029-12-06','Sem descricao','2010-01-16'),(135698,'2015-02-12',90,'2015-02-17','Referente a instalação de SO em 50 máquinas do laboratório de Biologia da FURGS.','2015-02-07'),(154258,'2016-02-12',90,'2016-02-22','Referente a troca da resistência de 3 bebedouros da unidade Camará.','2016-02-09'),(155624,'2018-12-03',90,'2019-01-19','Referente a troca de placa Mãe Notebook Hp dv6-6c30br.','2018-12-23'),(203114,'2021-06-05',5,'2029-12-06','Sem descricao','2001-10-16'),(233654,'2017-12-22',90,'2017-12-12','Referente a manutenção de peças de avião do jato 5936 da Azul.','2017-12-07'),(255897,'2019-01-05',90,'2019-01-17','Referente a troca de gabinete de 12 pcs de mesa.','2018-12-22'),(272995,'2031-08-05',5,'2029-12-06','Sem descricao','2012-09-16'),(326744,'2024-07-05',5,'2029-12-06','Sem descricao','2015-03-16'),(408327,'2003-10-05',5,'2029-12-06','Sem descricao','2005-09-15'),(412926,'2002-09-05',5,'2029-12-06','Sem descricao','2012-09-16'),(438497,'2030-08-05',5,'2029-12-06','Sem descricao','2010-09-10'),(578698,'2006-07-05',5,'2029-12-06','Sem descricao','2012-09-16'),(603251,'2019-01-02',31,'2019-01-07','Sem descricao','2019-01-02'),(604439,'2013-07-05',5,'2029-12-06','Sem descricao','2012-09-16'),(736090,'2019-06-05',5,'2029-12-06','Sem descricao','2001-10-16'),(756250,'2021-09-05',5,'2029-12-06','Sem descricao','2015-03-16'),(758001,'2015-08-05',5,'2029-12-06','Sem descricao','2015-03-16'),(809677,'2006-10-05',5,'2029-12-06','Sem descricao','2015-03-16'),(815265,'2017-03-12',90,'2017-03-27','Referente a troca de Placa Mãe em 27 PCs de Mesa.','2017-03-10'),(852467,'2017-03-03',90,'2017-03-05','Referente a manutenção preventiva de 120 PCs de mesa dos 3 laboratórios de Química da FURG.','2017-02-17'),(896738,'2026-08-05',5,'2029-12-06','Sem descricao','2010-09-10'),(905543,'2011-10-05',5,'2029-12-06','Sem descricao','2015-03-16');
/*!40000 ALTER TABLE `orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_servico`
--

DROP TABLE IF EXISTS `ordem_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordem_servico` (
  `Num_Ordem_Servico` int(11) NOT NULL DEFAULT '0',
  `Dt_devida` date NOT NULL,
  `Prazo_em_dias` int(11) NOT NULL,
  `Dt_criacao` date NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Cod_orcamento` int(11) unsigned DEFAULT NULL,
  `Cod_fatura` int(11) DEFAULT NULL,
  PRIMARY KEY (`Num_Ordem_Servico`),
  UNIQUE KEY `Cod_orcamento` (`Cod_orcamento`),
  UNIQUE KEY `Cod_fatura_UNIQUE` (`Cod_fatura`),
  KEY `ord_servico_fatura_fk_idx` (`Cod_fatura`),
  KEY `ord_servico_orcamento_fk_idx` (`Cod_orcamento`),
  CONSTRAINT `ord_servico_fatura_fk` FOREIGN KEY (`Cod_fatura`) REFERENCES `fatura` (`Cod`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ord_servico_orcamento_fk` FOREIGN KEY (`Cod_orcamento`) REFERENCES `orcamento` (`Cod`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_servico`
--

LOCK TABLES `ordem_servico` WRITE;
/*!40000 ALTER TABLE `ordem_servico` DISABLE KEYS */;
INSERT INTO `ordem_servico` VALUES (109006,'2013-10-14',3,'2019-01-15','Em Curso',130254,743797),(123457,'2018-01-02',14,'2017-12-19','Concluída',124565,125469),(123658,'2020-03-03',14,'2020-02-18','Em Curso',905543,117095),(136958,'2019-03-03',14,'2019-02-19','Em Curso',107695,189562),(144568,'2016-03-04',14,'2016-02-19','Em Curso',154258,875466),(226587,'2019-03-02',14,'2019-02-19','Em Curso',111091,139545),(251182,'2022-10-14',3,'2028-01-15','Em Curso',578698,592439),(256598,'2019-03-05',14,'2019-02-19','Em Curso',255897,111365),(276894,'2019-03-03',14,'2019-02-19','Em Curso',155624,133652),(293137,'2015-10-14',3,'2021-01-15','Em Curso',438497,417174),(452265,'2015-03-05',14,'2015-02-19','Concluída',135698,223259),(456254,'2017-11-02',14,'2017-10-19','Concluída',233654,133965),(498872,'2024-10-14',3,'2030-01-15','Em Curso',736090,150619),(579148,'2016-10-14',3,'2022-01-15','Em Curso',272995,525009),(635452,'2017-04-02',14,'2017-03-19','Em Curso',852467,255898),(654525,'2017-05-03',14,'2017-04-19','Em Curso',815265,215469),(702449,'2019-10-14',3,'2025-01-15','Em Curso',408327,857787),(743273,'2020-10-14',3,'2026-01-15','Em Curso',758001,332619),(746207,'2025-10-14',3,'2031-01-15','Em Curso',203114,559734),(812795,'2023-10-14',3,'2029-01-15','Em Curso',809677,913831),(896492,'2012-10-14',3,'2018-01-15','Em Curso',326744,254807),(901221,'2018-10-14',3,'2024-01-15','Em Curso',896738,544386),(963325,'2019-03-02',14,'2019-02-19','Em Curso',603251,923654),(977699,'0000-00-00',14,'2019-02-19','Em Curso',412926,805070);
/*!40000 ALTER TABLE `ordem_servico` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger set_dta_devida
before insert on assistech.ordem_servico
for each row
begin
	 #SET @bissexto:=(YEAR(new.Dt_criacao) %4 = 0) AND (YEAR(new.Dt_criacao) % 100 != 0) OR (YEAR(new.Dt_criacao) % 400 = 0);
     #SELECT MONTH(LAST_DAY("2017-02-12"));
 
		IF DAY(LAST_DAY(new.Dt_criacao))=30 AND (new.Prazo_em_dias + day(new.Dt_criacao)) > 30 then
			set @diferenca:=abs(30 - ( new.Prazo_em_dias + day(new.Dt_criacao) ) );   
            set new.Dt_devida=CONCAT(YEAR(new.Dt_criacao), '-',MONTH(new.Dt_criacao)+1, '-',@diferenca);
        END IF;  
        
        IF EXTRACT(MONTH from new.Dt_criacao)=12 AND (new.Prazo_em_dias + day(new.Dt_criacao)) > 31 then
				set @diferenca:=abs(31 - ( new.Prazo_em_dias + day(new.Dt_criacao) ) );   
				set new.Dt_devida=CONCAT(YEAR(new.Dt_criacao)+1, '-','01', '-',@diferenca);
        END IF;
        
        IF EXTRACT(MONTH from new.Dt_criacao)!=12 AND DAY(LAST_DAY(new.Dt_criacao))=31 AND (new.Prazo_em_dias + day(new.Dt_criacao)) > 31 then
			set @diferenca:=abs(31 - ( new.Prazo_em_dias + day(new.Dt_criacao) ) );   
            set new.Dt_devida=CONCAT(YEAR(new.Dt_criacao), '-',MONTH(new.Dt_criacao)+1, '-',@diferenca);
		END IF;
        
        IF DAY(LAST_DAY(new.Dt_criacao))=28 AND (new.Prazo_em_dias + day(new.Dt_criacao)) > 28 then
			set @diferenca:=abs(28 - ( new.Prazo_em_dias + day(new.Dt_criacao) ) );
            set new.Dt_devida=CONCAT(YEAR(new.Dt_criacao), '-','03', '-',@diferenca);
        END IF;    
        
        #ano bissexto. Fevereiro tem 29 dias.
        IF DAY(LAST_DAY(new.Dt_criacao))=29 AND (new.Prazo_em_dias + day(new.Dt_criacao)) > 29 then
			set @diferenca:=abs(29 - ( new.Prazo_em_dias + day(new.Dt_criacao) ) );
            set new.Dt_devida=CONCAT(YEAR(new.Dt_criacao), '-','03', '-',@diferenca);     
        END IF;    
       
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `os`
--

DROP TABLE IF EXISTS `os`;
/*!50001 DROP VIEW IF EXISTS `os`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `os` AS SELECT 
 1 AS `Num_Ordem_Servico`,
 1 AS `Dt_devida`,
 1 AS `Prazo_em_dias`,
 1 AS `Dt_criacao`,
 1 AS `Status`,
 1 AS `Cod_orcamento`,
 1 AS `Cod_fatura`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `os_fatura_andamento`
--

DROP TABLE IF EXISTS `os_fatura_andamento`;
/*!50001 DROP VIEW IF EXISTS `os_fatura_andamento`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `os_fatura_andamento` AS SELECT 
 1 AS `Num_Ordem_Servico`,
 1 AS `Dt_devida`,
 1 AS `Prazo_em_dias`,
 1 AS `Cod_orcamento`,
 1 AS `Cod_fatura`,
 1 AS `Valor_total`,
 1 AS `Cod_cliente`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(10) NOT NULL,
  `Data_` date NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Matricula_AdmFinanceiro` varchar(13) NOT NULL,
  PRIMARY KEY (`Cod`),
  KEY `Matricula_AdmFinanceiro` (`Matricula_AdmFinanceiro`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`Matricula_AdmFinanceiro`) REFERENCES `adm_financeiro` (`Matricula`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=932254 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (109549,'Credito','2013-12-11',170.00,'3221219790129'),(131276,'Credito','2012-11-15',120.00,'3221219790127'),(177197,'DÃ©bito','2018-09-29',199.30,'3221219790129'),(366527,'DÃ©bito','2017-11-04',125.67,'3221219790128'),(385644,'DÃ©bito','2018-11-04',192.74,'3221219790129'),(417588,'DÃ©bito','2017-01-04',126.63,'3221219790127'),(436936,'DÃ©bito','2018-11-04',111.23,'3221219790128'),(532472,'Credito','2014-03-27',196.45,'3221219790128'),(597855,'Credito','2013-03-27',1796.00,'3221219790129'),(699303,'Credito','2018-09-29',563.20,'3221219790127'),(802482,'Credito','2011-04-06',129.60,'3221219790127'),(832040,'DÃ©bito','2015-03-27',750.70,'3221219790127'),(836913,'Credito','2015-12-11',500.60,'3221219790128'),(842446,'Credito','2012-04-12',639.80,'3221219790127'),(932253,'DÃ©bito','0000-00-00',300.00,'3221219790127');
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parcela_pagto_fatura`
--

DROP TABLE IF EXISTS `parcela_pagto_fatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parcela_pagto_fatura` (
  `Seq_parcela_pagto_fatura` int(11) NOT NULL,
  `Cod_fatura` int(11) NOT NULL,
  `Data_pagamento` date NOT NULL,
  `Data_parcela` date NOT NULL,
  `Juros` float(2,2) NOT NULL,
  `Valor_total` float(4,2) NOT NULL,
  `Valor_pg_parcela` float(4,2) NOT NULL,
  PRIMARY KEY (`Seq_parcela_pagto_fatura`,`Cod_fatura`),
  KEY `parcela_pagamento_fatura_fk` (`Cod_fatura`),
  CONSTRAINT `parcela_pagamento_fatura_fk` FOREIGN KEY (`Cod_fatura`) REFERENCES `fatura` (`Cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parcela_pagto_fatura`
--

LOCK TABLES `parcela_pagto_fatura` WRITE;
/*!40000 ALTER TABLE `parcela_pagto_fatura` DISABLE KEYS */;
INSERT INTO `parcela_pagto_fatura` VALUES (186637,332619,'2012-11-13','2012-11-13',0.02,99.99,99.99),(209895,629787,'2012-11-14','2012-11-14',0.70,90.00,55.00),(258868,544386,'2012-11-11','2012-11-11',0.70,90.00,99.99),(404938,743797,'2012-11-06','2012-11-06',0.03,39.00,99.99),(553192,913831,'2012-11-16','2012-11-16',0.01,90.00,55.00),(584790,805070,'2012-11-10','2012-11-10',0.03,90.00,99.99),(705602,117095,'2012-11-04','2012-11-04',0.03,99.99,30.00),(708697,525009,'2012-11-09','2012-11-09',0.70,99.99,25.00),(717795,417174,'2012-11-08','2012-11-08',0.02,99.99,55.00),(726793,559734,'2012-11-18','2012-11-18',0.01,99.99,55.00),(797332,857787,'2012-11-12','2012-11-12',0.70,90.00,13.00),(808630,592439,'2012-11-15','2012-11-15',0.03,90.00,25.00),(873814,231307,'2012-11-07','2012-11-07',0.01,99.99,99.99),(874591,254807,'2012-11-05','2012-11-05',0.70,99.99,30.00),(988224,150619,'2012-11-17','2012-11-17',0.03,99.99,13.00);
/*!40000 ALTER TABLE `parcela_pagto_fatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `Cod` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Dt_pedido` date NOT NULL,
  `Vl_total` decimal(10,2) DEFAULT NULL,
  `Dt_atendimento` date NOT NULL,
  `Status_` varchar(40) NOT NULL,
  `Mat_adm_financeiro` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `pedido_adm_financ_fk` (`Mat_adm_financeiro`),
  KEY `cod_pedido_nota_fiscal_fk` (`Cod`),
  CONSTRAINT `pedido_adm_financ_fk` FOREIGN KEY (`Mat_adm_financeiro`) REFERENCES `adm_financeiro` (`Matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=894577 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (147324,'2011-06-08',392.31,'2011-09-08','Em espera','3221219790127'),(198429,'2009-01-07',1745.21,'2009-09-16','Ativo','3221219790127'),(259986,'2011-02-08',561.22,'2011-03-18','Em espera','3221219790128'),(275918,'2016-11-12',2047.32,'2016-12-11','Aprovado','3221219790127'),(322050,'2010-03-08',2928.95,'2011-04-15','Assinatura','3221219790129'),(344769,'2016-04-04',1245.21,'2016-10-20','Assinatura','3221219790127'),(437029,'2011-01-08',2223.47,'2011-02-08','Ativo','3221219790129'),(441646,'2016-04-04',887.90,'2017-03-08','Ativo','3221219790128'),(628399,'2012-04-11',2758.87,'2013-01-16','Em espera','3221219790128'),(716048,'2009-01-07',3245.21,'2009-09-16','Em espera','3221219790128'),(764203,'2017-06-30',1500.21,'2018-05-31','Ativo','3221219790128'),(777120,'2009-01-07',1045.21,'2009-12-30','Em espera','3221219790129'),(821398,'2017-06-30',2245.27,'2018-03-22','Ativo','3221219790128'),(846698,'2016-04-04',545.21,'2016-08-18','Ativo','3221219790128'),(894576,'2017-06-30',1000.21,'2017-12-14','Ativo','3221219790128');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plano_orcamento`
--

DROP TABLE IF EXISTS `plano_orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plano_orcamento` (
  `Cod_plano_orcamento` varchar(10) NOT NULL,
  `Descricao` varchar(150) NOT NULL,
  `Valor` int(11) NOT NULL,
  `Aprovado` varchar(3) NOT NULL,
  `Data_` date NOT NULL,
  `Seq_chamado` int(11) NOT NULL,
  KEY `fk_plano_orcamento_chamado` (`Seq_chamado`),
  CONSTRAINT `fk_plano_orcamento_chamado` FOREIGN KEY (`Seq_chamado`) REFERENCES `chamado` (`Sequencial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plano_orcamento`
--

LOCK TABLES `plano_orcamento` WRITE;
/*!40000 ALTER TABLE `plano_orcamento` DISABLE KEYS */;
INSERT INTO `plano_orcamento` VALUES ('524702','',2047,'Sim','2018-09-29',142530),('517471','',561,'Não','2018-11-04',326138),('933776','',2929,'Sim','2012-04-12',888642),('916786','',2759,'Não','2012-11-15',127003),('906403','',888,'Não','2018-11-04',993477),('647245','',2223,'Não','2015-12-11',469529),('441943','',1045,'Sim','2014-03-27',857233),('304653','',1500,'Não','2018-09-29',375295),('246040','',1245,'Sim','2018-11-04',285228),('544881','',392,'Não','2017-01-04',455427),('138653','',1745,'Sim','2011-04-06',721605),('727557','',1000,'Não','2012-04-12',414136),('950012','',3245,'Sim','2012-11-15',474898),('361195','',2245,'Não','2018-11-04',831513),('219922','',545,'Sim','2017-11-04',449291);
/*!40000 ALTER TABLE `plano_orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pri_alta_cliente`
--

DROP TABLE IF EXISTS `pri_alta_cliente`;
/*!50001 DROP VIEW IF EXISTS `pri_alta_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `pri_alta_cliente` AS SELECT 
 1 AS `Cod`,
 1 AS `prioridade`,
 1 AS `endereco`,
 1 AS `email`,
 1 AS `fone`,
 1 AS `cpf_cnpj`,
 1 AS `nome_razao_social`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `pri_chamado`
--

DROP TABLE IF EXISTS `pri_chamado`;
/*!50001 DROP VIEW IF EXISTS `pri_chamado`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `pri_chamado` AS SELECT 
 1 AS `Sequencial`,
 1 AS `Tipo`,
 1 AS `Status_chamado`,
 1 AS `Descricao`,
 1 AS `Prioridade`,
 1 AS `Mat_supervisor`,
 1 AS `Mat_tec_interno`,
 1 AS `Mat_atendente`,
 1 AS `Num_ordem_servico`,
 1 AS `Cod_cliente`,
 1 AS `Id_atendimento`,
 1 AS `Dta_abertura`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `Cod_servico` int(11) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  `Valor` decimal(10,2) NOT NULL,
  `Status_servico` varchar(255) NOT NULL,
  `Cod_Categoria_Servico` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_servico`),
  KEY `servico_tipo_servic_fk` (`Cod_Categoria_Servico`),
  CONSTRAINT `servico_tipo_servic_fk` FOREIGN KEY (`Cod_Categoria_Servico`) REFERENCES `categoria_servico` (`Cod`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (193624,'-',123.00,'Incompleto',167317),(204239,'-',263.00,'Incompleto',255289),(215386,'-',55.00,'ConcluÃ­do',273243),(267080,'-',125.00,'ConcluÃ­do',558517),(341250,'-',15.00,'Em andamento',273243),(438841,'-',275.00,'Em andamento',167317),(459121,'-',15.00,'ConcluÃ­do',255289),(461863,'-',123.00,'ConcluÃ­do',558517),(556703,'-',65.00,'Incompleto',167317),(605518,'-',133.00,'Incompleto',558517),(613590,'-',300.00,'Em andamento',273243),(613677,'-',150.00,'ConcluÃ­do',167317),(855547,'-',300.00,'Em andamento',696929),(904566,'-',55.00,'Em andamento',255289),(983704,'-',65.00,'Incompleto',167317);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sist_op`
--

DROP TABLE IF EXISTS `sist_op`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sist_op` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `Nome` varchar(15) NOT NULL,
  `Versão` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_equipamento`,`Nome`,`Versão`),
  CONSTRAINT `sist_op_equipto_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `computador` (`Cod_equipamento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sist_op`
--

LOCK TABLES `sist_op` WRITE;
/*!40000 ALTER TABLE `sist_op` DISABLE KEYS */;
/*!40000 ALTER TABLE `sist_op` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicita`
--

DROP TABLE IF EXISTS `solicita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicita` (
  `Mat_supervisor` varchar(13) NOT NULL,
  `Quantidade` int(4) DEFAULT NULL,
  PRIMARY KEY (`Mat_supervisor`),
  CONSTRAINT `solicita_supervisor_fk` FOREIGN KEY (`Mat_supervisor`) REFERENCES `supervisor` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicita`
--

LOCK TABLES `solicita` WRITE;
/*!40000 ALTER TABLE `solicita` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervisor` (
  `matricula` varchar(13) NOT NULL DEFAULT '',
  PRIMARY KEY (`matricula`),
  CONSTRAINT `funcionario_supervisor_fk` FOREIGN KEY (`matricula`) REFERENCES `funcionario` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
INSERT INTO `supervisor` VALUES ('3221219790118'),('3221219790119'),('3221219790120'),('3221219790121'),('3221219790122'),('3221219790123'),('3221219790124'),('3221219790125'),('3221219790126'),('3221219790127'),('3221219790128'),('3221219790129'),('3221219790130'),('3221219790131'),('3221219790132');
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnico` (
  `Matricula_tecnico` varchar(13) NOT NULL DEFAULT '',
  `Dias_Trabalhados` int(11) NOT NULL DEFAULT '0',
  `Nro_Consertos` int(11) NOT NULL DEFAULT '0',
  `Voltas` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Matricula_tecnico`),
  CONSTRAINT `tecnico_funcionario_fk` FOREIGN KEY (`Matricula_tecnico`) REFERENCES `funcionario` (`Matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES ('3221219790136',17,19,15),('3221219790137',8,66,17),('3221219790138',24,17,10),('3221219790139',20,88,23),('3221219790140',12,7,28),('3221219790141',3,23,6),('3221219790142',18,68,21),('3221219790143',14,47,3),('3221219790144',16,7,22),('3221219790145',8,30,22),('3221219790146',10,30,29),('3221219790147',12,60,6),('3221219790148',7,21,24),('3221219790149',10,83,24),('3221219790150',16,62,12);
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico_campo`
--

DROP TABLE IF EXISTS `tecnico_campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnico_campo` (
  `matricula` varchar(13) NOT NULL DEFAULT '',
  `tel_movel` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `tel_movel` (`tel_movel`),
  CONSTRAINT `tecnico_campo_tecnico_fk` FOREIGN KEY (`matricula`) REFERENCES `tecnico` (`Matricula_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico_campo`
--

LOCK TABLES `tecnico_campo` WRITE;
/*!40000 ALTER TABLE `tecnico_campo` DISABLE KEYS */;
INSERT INTO `tecnico_campo` VALUES ('3221219790126','(81)998990-0108'),('3221219790125','(81)998990-0109\r'),('3221219790124','(81)998990-0110\r'),('3221219790123','(81)998990-0111\r');
/*!40000 ALTER TABLE `tecnico_campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico_esta_em_equipe`
--

DROP TABLE IF EXISTS `tecnico_esta_em_equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnico_esta_em_equipe` (
  `Cod_Equipe` varchar(15) NOT NULL DEFAULT '',
  `Matricula_Tecnico` varchar(13) NOT NULL DEFAULT '',
  `dta_inicio` date NOT NULL,
  `dta_fim` date DEFAULT NULL,
  `eh_lider` varchar(3) NOT NULL,
  PRIMARY KEY (`Cod_Equipe`,`Matricula_Tecnico`),
  KEY `tec_equipe_Tecnico_fk` (`Matricula_Tecnico`),
  CONSTRAINT `tec_equipe_Equipe_fk` FOREIGN KEY (`Cod_Equipe`) REFERENCES `equipe` (`Cod_equipe`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `tec_equipe_Tecnico_fk` FOREIGN KEY (`Matricula_Tecnico`) REFERENCES `tecnico` (`Matricula_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico_esta_em_equipe`
--

LOCK TABLES `tecnico_esta_em_equipe` WRITE;
/*!40000 ALTER TABLE `tecnico_esta_em_equipe` DISABLE KEYS */;
INSERT INTO `tecnico_esta_em_equipe` VALUES ('5952','3221219790140','2016-04-04','2018-11-04','NÃ£'),('5952','3221219790141','0000-00-00','2015-12-11','Sim'),('5952','3221219790142','2009-01-07','2014-03-27','NÃ£'),('5952','3221219790143','2017-06-30','2018-09-29','NÃ£'),('5952','3221219790144','2016-04-04','2018-11-04','NÃ£'),('5952','3221219790145','0000-00-00','2013-12-11','NÃ£'),('9090','3221219790146','2009-01-07','2013-03-27','Sim'),('9090','3221219790147','2017-06-30','0000-00-00','NÃ£'),('9090','3221219790148','2009-01-07','2015-03-27','NÃ£'),('9090','3221219790149','2017-06-30','2018-09-29','NÃ£'),('9090','3221219790150','2016-04-04','2017-11-04','NÃ£'),('9968','3221219790136','2016-11-12','2017-01-04','Sim'),('9968','3221219790137','2011-02-08','2011-04-06','NÃ£'),('9968','3221219790138','2010-03-08','2012-04-12','NÃ£'),('9968','3221219790139','2012-04-11','2012-11-15','NÃ£');
/*!40000 ALTER TABLE `tecnico_esta_em_equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico_interno`
--

DROP TABLE IF EXISTS `tecnico_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnico_interno` (
  `matricula` varchar(13) NOT NULL DEFAULT '',
  `Ramall` varchar(20) DEFAULT NULL,
  `Grau_tec` varchar(30) NOT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `tec_interno_tecnico_fk` FOREIGN KEY (`matricula`) REFERENCES `tecnico` (`Matricula_tecnico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico_interno`
--

LOCK TABLES `tecnico_interno` WRITE;
/*!40000 ALTER TABLE `tecnico_interno` DISABLE KEYS */;
INSERT INTO `tecnico_interno` VALUES ('218017','3131','TÃ©cnico em InformÃ¡tica\r'),('231493','3123','TÃ©cnico em EletrÃ´nica\r'),('3221219790156','3122','Técnico em Eletrônica'),('3221219790157','3123','Técnico em Eletrônica'),('3221219790158','3124','Técnico em Informática'),('3221219790159','3125','Técnico em Informática'),('3221219790160','3126','Técnico em Eletrônica'),('3221219790161','3127','Técnico em Eletrônica'),('3221219790162','3128','Técnico em Informática'),('3221219790163','3129','Técnico em Eletrônica'),('3221219790164','3130','Técnico em Eletrônica'),('3221219790165','3131','Técnico em Informática'),('3221219790166','3132','Técnico em Informática'),('3221219790167','3133','Técnico em Informática'),('3221219790168','3134','Técnico em Informática'),('3221219790169','3135','Técnico em Eletrônica'),('3221219790170','3136','Técnico em Eletrônica'),('3221219790171','3137','Técnico em Informática'),('3221219790172','3138','Técnico em Informática'),('3221219790173','3139','Técnico em Eletrônica'),('3221219790174','3140','Técnico em Informática'),('3221219790175','3141','Técnico em Informática'),('344091','3129','TÃ©cnico em EletrÃ´nica\r'),('382837','3122','TÃ©cnico em EletrÃ´nica\r'),('408667','3127','TÃ©cnico em EletrÃ´nica\r'),('460563','3132','TÃ©cnico em InformÃ¡tica\r'),('471743','3135','TÃ©cnico em EletrÃ´nica\r'),('501846','3126','TÃ©cnico em EletrÃ´nica\r'),('647527','3125','TÃ©cnico em InformÃ¡tica\r'),('658924','3128','TÃ©cnico em InformÃ¡tica\r'),('705548','3124','TÃ©cnico em InformÃ¡tica\r'),('893494','3133','TÃ©cnico em InformÃ¡tica\r'),('912516','3136','TÃ©cnico em EletrÃ´nica'),('919952','3130','TÃ©cnico em EletrÃ´nica\r'),('938749','3134','TÃ©cnico em InformÃ¡tica\r');
/*!40000 ALTER TABLE `tecnico_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_contrato`
--

DROP TABLE IF EXISTS `tipo_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_contrato` (
  `Id_tipo_contrato` int(10) NOT NULL,
  `Descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`Id_tipo_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_contrato`
--

LOCK TABLES `tipo_contrato` WRITE;
/*!40000 ALTER TABLE `tipo_contrato` DISABLE KEYS */;
INSERT INTO `tipo_contrato` VALUES (1,'ManutenÃ§Ã£o\r'),(2,'ManutenÃ§Ã£o de Sistema Operacional\r'),(3,'Treinamento');
/*!40000 ALTER TABLE `tipo_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_despesa`
--

DROP TABLE IF EXISTS `tipo_despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_despesa` (
  `Id` int(11) NOT NULL,
  `Descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_despesa`
--

LOCK TABLES `tipo_despesa` WRITE;
/*!40000 ALTER TABLE `tipo_despesa` DISABLE KEYS */;
INSERT INTO `tipo_despesa` VALUES (221412,'Estadia\r'),(223372,'Transporte Urbano\r'),(226201,'Estadia'),(318128,'Transporte Urbano\r'),(429363,'Transporte Interurbano\r'),(550140,'Transporte Urbano\r'),(552159,'Transporte Interurbano\r'),(572372,'Estadia\r'),(656429,'Transporte Interurbano\r'),(752524,'Transporte Interurbano\r'),(753887,'Estadia\r'),(790839,'AlimentaÃ§Ã£o\r'),(790840,'Transporte Urbano\r'),(790841,'Transporte Interurbano\r'),(790842,'Estadia\r');
/*!40000 ALTER TABLE `tipo_despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `codigo` varchar(14) NOT NULL,
  `descricao` varchar(20) NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_final` time NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES ('0','Manhã','07:00:00','15:00:00'),('1','Tarde','14:00:00','22:00:00'),('2','Noite','21:00:00','05:00:00');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tv`
--

DROP TABLE IF EXISTS `tv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tv` (
  `Cod_equipamento` varchar(15) NOT NULL,
  `Modelo` varchar(15) NOT NULL,
  PRIMARY KEY (`Cod_equipamento`),
  CONSTRAINT `tv_equipamento_fk` FOREIGN KEY (`Cod_equipamento`) REFERENCES `equipamento` (`Cod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tv`
--

LOCK TABLES `tv` WRITE;
/*!40000 ALTER TABLE `tv` DISABLE KEYS */;
INSERT INTO `tv` VALUES ('55377','PH31639'),('75322','PH31639\r'),('99542','C1349670\r');
/*!40000 ALTER TABLE `tv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `uniao`
--

DROP TABLE IF EXISTS `uniao`;
/*!50001 DROP VIEW IF EXISTS `uniao`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `uniao` AS SELECT 
 1 AS `Cod_cliente`,
 1 AS `cpf_cnpj`,
 1 AS `Nome_Razao_social`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `unidade_de_suporte`
--

DROP TABLE IF EXISTS `unidade_de_suporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidade_de_suporte` (
  `CNPJ_empresa` bigint(14) unsigned NOT NULL,
  `Cod` int(11) NOT NULL,
  `Nro_funcionarios` int(11) DEFAULT NULL,
  `Nome` varchar(50) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Matriz` varchar(20) NOT NULL,
  `Endereco` varchar(1024) NOT NULL,
  `FONE` varchar(16) NOT NULL,
  PRIMARY KEY (`CNPJ_empresa`,`Cod`),
  UNIQUE KEY `Cod_UNIQUE` (`Cod`),
  KEY `fk_unid_suporte_empresa` (`CNPJ_empresa`),
  CONSTRAINT `fk_unid_suporte_empresa` FOREIGN KEY (`CNPJ_empresa`) REFERENCES `empresa` (`CNPJ`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade_de_suporte`
--

LOCK TABLES `unidade_de_suporte` WRITE;
/*!40000 ALTER TABLE `unidade_de_suporte` DISABLE KEYS */;
INSERT INTO `unidade_de_suporte` VALUES (13496314178466,12369,11,'Posuere Vulputate Industries','Bahia','Bahia','114-4625 Sed Ave','(81) 3031-2509\r'),(13496314178466,44665,470,'Varius Et LLC','São Paulo','São Paulo','Ap #333-7229 Pellentesque Avenue','(81) 3031-2508\r'),(13496314178466,58994,11,'Fermentum Convallis Incorporated','São Paulo','São Paulo','P.O. Box 295, 5585 Quam Street','(81) 3031-2507\r'),(13496314178469,12365,285,'Sed Neque Sed Associates','São Paulo','São Paulo','7595 Curabitur St.','(81) 3031-2506\r'),(13496314178469,45639,130,'Quisque Tincidunt Pede Incorporated','Minas Gerais','Minas Gerais','Ap #560-3318 Eget Ave','(81) 3031-2504\r'),(13496314178469,89874,102,'Ligula Aenean Euismod LLC','Rio de Janeiro','Rio de Janeiro','3905 Semper. St.','(81) 3031-2505\r'),(13496314178472,11111,999,'Quisque PC','Bahia','Bahia','Ap #317-4665 Lorem, St.','(81) 3031-2503\r'),(13496314178473,12032,27,'A PC','Paraíba','Paraíba','P.O. Box 129, 1164 Cras Road','(81) 3031-2502\r'),(13496314178474,89872,40,'Interdum Enim Non LLP','Rio de Janeiro','Rio de Janeiro','166-1000 Libero. Av.','(81) 3031-2501\r'),(13496314178475,12360,381,'Porttitor Eros Foundation','Minas Gerais','Minas Gerais','P.O. Box 581, 6377 Natoque Road','(81) 3031-2500\r'),(13496314178476,45632,347,'In Scelerisque Scelerisque LLP','Goiás','Goiás','4466 Vitae, Av.','(81) 3031-2499\r'),(13496314178477,78965,492,'A Limited','Bahia','Bahia','P.O. Box 699, 9231 Commodo St.','(81) 3031-2498\r'),(13496314178478,12366,293,'Vitae Sodales Institute','Rio Grande do Sul','Rio Grande do Sul','9472 Nunc Rd.','(81) 3031-2497\r'),(13496314178479,78963,215,'Nonummy Ac Foundation','Minas Gerais','Minas Gerais','Ap #910-3882 Praesent Avenue','(81) 3031-2496\r'),(13496314178480,12368,411,'Nec Luctus Foundation','Rio de Janeiro','Rio de Janeiro','5142 Aliquet Rd.','(81) 3031-2495');
/*!40000 ALTER TABLE `unidade_de_suporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'assistech'
--

--
-- Dumping routines for database 'assistech'
--
/*!50003 DROP FUNCTION IF EXISTS `fn_hora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_hora`(m VARCHAR(13)) RETURNS int(11)
    DETERMINISTIC
BEGIN

DECLARE CargaHoraria int(8);
DECLARE Trabalha_sabado VARCHAR(3);
DECLARE aux INT (11);
DECLARE r INT (11);

SET aux = ( SELECT CargaHoraria
FROM assistech.funcionario F
INNER JOIN assistech.jornada_de_trabalho J 
ON F.IdJornada=J.Id
WHERE Matricula = m) ;

IF (SELECT Trabalha_sabado from jornada_de_trabalho JOIN assistech.funcionario ON Id=( SELECT IdJornada
FROM assistech.funcionario F
INNER JOIN assistech.jornada_de_trabalho J 
ON F.IdJornada=J.Id
WHERE Matricula = m) = 'sim') THEN

SET r = aux*6;
ELSE
SET r= aux*5;
END IF;
RETURN r;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `equi_datas`
--

/*!50001 DROP VIEW IF EXISTS `equi_datas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `equi_datas` AS select `e`.`Cod` AS `Cod`,`e`.`Data_entrada` AS `Data_entrada`,`e`.`Setor` AS `Setor`,`e`.`historico` AS `historico`,`e`.`Fabricante` AS `Fabricante`,`e`.`Estado` AS `Estado`,`e`.`Descricao` AS `Descricao`,`e`.`Cod_contrato` AS `Cod_contrato`,`e`.`Cnpj_Unid_Suporte` AS `Cnpj_Unid_Suporte`,`e`.`Cod_Cliente` AS `Cod_Cliente`,`e`.`Data_inicio` AS `Data_inicio` from `equipamento` `e` where (`e`.`Data_entrada` between '2012-11-10' and '2012-11-18') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `jornada_fun`
--

/*!50001 DROP VIEW IF EXISTS `jornada_fun`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `jornada_fun` AS select `jt`.`Id` AS `Id`,`jt`.`Trabalha_sabado` AS `Trabalha_sabado`,`jt`.`descricao` AS `descricao`,`f`.`Matricula` AS `Matricula`,`f`.`CPF` AS `CPF`,`f`.`Login` AS `Login`,`f`.`Senha` AS `Senha`,`f`.`Nome` AS `Nome`,`f`.`Email` AS `Email`,`f`.`CargaHoraria` AS `CargaHoraria`,`f`.`MatriculaSupervisor` AS `MatriculaSupervisor`,`f`.`IdJornada` AS `IdJornada`,`f`.`DataInicio` AS `DataInicio`,`f`.`CodigoUnidadeDeSuporte` AS `CodigoUnidadeDeSuporte` from (`jornada_de_trabalho` `jt` join `funcionario` `f` on((`jt`.`Id` = `f`.`IdJornada`))) where ((`jt`.`Trabalha_sabado` = 'Sim') and (`f`.`CargaHoraria` = 8)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `os`
--

/*!50001 DROP VIEW IF EXISTS `os`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `os` AS select `ordem_servico`.`Num_Ordem_Servico` AS `Num_Ordem_Servico`,`ordem_servico`.`Dt_devida` AS `Dt_devida`,`ordem_servico`.`Prazo_em_dias` AS `Prazo_em_dias`,`ordem_servico`.`Dt_criacao` AS `Dt_criacao`,`ordem_servico`.`Status` AS `Status`,`ordem_servico`.`Cod_orcamento` AS `Cod_orcamento`,`ordem_servico`.`Cod_fatura` AS `Cod_fatura` from `ordem_servico` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `os_fatura_andamento`
--

/*!50001 DROP VIEW IF EXISTS `os_fatura_andamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `os_fatura_andamento` AS select `os`.`Num_Ordem_Servico` AS `Num_Ordem_Servico`,`os`.`Dt_devida` AS `Dt_devida`,`os`.`Prazo_em_dias` AS `Prazo_em_dias`,`os`.`Cod_orcamento` AS `Cod_orcamento`,`os`.`Cod_fatura` AS `Cod_fatura`,`f`.`Valor_total` AS `Valor_total`,`f`.`Cod_cliente` AS `Cod_cliente` from (`ordem_servico` `os` join `fatura` `f` on((`os`.`Cod_fatura` = `f`.`Cod`))) where (`f`.`Status_` = 'Em andamento') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pri_alta_cliente`
--

/*!50001 DROP VIEW IF EXISTS `pri_alta_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pri_alta_cliente` AS select `c`.`Cod` AS `Cod`,`c`.`Prioridade` AS `prioridade`,`c`.`Endereco` AS `endereco`,`c`.`Email` AS `email`,`c`.`Fone` AS `fone`,`u`.`cpf_cnpj` AS `cpf_cnpj`,`u`.`Nome_Razao_social` AS `nome_razao_social` from (`cliente` `c` join `uniao` `u` on((`c`.`Cod` = `u`.`Cod_cliente`))) where (`c`.`Prioridade` = 'alta') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pri_chamado`
--

/*!50001 DROP VIEW IF EXISTS `pri_chamado`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pri_chamado` AS select `c`.`Sequencial` AS `Sequencial`,`c`.`Tipo` AS `Tipo`,`c`.`Status_chamado` AS `Status_chamado`,`c`.`Descricao` AS `Descricao`,`c`.`Prioridade` AS `Prioridade`,`c`.`Mat_supervisor` AS `Mat_supervisor`,`c`.`Mat_tec_interno` AS `Mat_tec_interno`,`c`.`Mat_atendente` AS `Mat_atendente`,`c`.`Num_ordem_servico` AS `Num_ordem_servico`,`c`.`Cod_cliente` AS `Cod_cliente`,`c`.`Id_atendimento` AS `Id_atendimento`,`c`.`Dta_abertura` AS `Dta_abertura` from `chamado` `c` where ((`c`.`Status_chamado` = 'Em processo') and (`c`.`Prioridade` = 'Sim')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `uniao`
--

/*!50001 DROP VIEW IF EXISTS `uniao`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `uniao` AS select `cliente_fis`.`Cod_cliente` AS `Cod_cliente`,`cliente_fis`.`Cpf` AS `cpf_cnpj`,`cliente_fis`.`Nome` AS `Nome_Razao_social` from `cliente_fis` union select `cliente_jur`.`Cod_cliente` AS `Cod_cliente`,`cliente_jur`.`Cnpj` AS `Cnpj`,`cliente_jur`.`Razao_social` AS `Razao_social` from `cliente_jur` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-09 16:13:44
