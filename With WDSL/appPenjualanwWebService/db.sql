/*
SQLyog Ultimate v8.61 
MySQL - 5.5.23 : Database - penjualan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`penjualan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `penjualan`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `kodebarang` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `namabarang` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `Stok` int(11) DEFAULT NULL,
  `HargaStandard` double DEFAULT NULL,
  PRIMARY KEY (`kodebarang`),
  UNIQUE KEY `kodebarang` (`kodebarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `barang` */

insert  into `barang`(`kodebarang`,`namabarang`,`Stok`,`HargaStandard`) values ('G001','ABG Umur 15',10,1000000),('G002','Tante Girang',2,500000),('G003','Alay',5,10000);

/*Table structure for table `faktur` */

DROP TABLE IF EXISTS `faktur`;

CREATE TABLE `faktur` (
  `NomorFaktur` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `KodePelanggan` varchar(5) COLLATE latin1_general_ci DEFAULT '',
  `TanggalFaktur` date DEFAULT NULL,
  PRIMARY KEY (`NomorFaktur`),
  KEY `FK_faktur` (`KodePelanggan`),
  CONSTRAINT `FK_faktur_KodePelanggan` FOREIGN KEY (`KodePelanggan`) REFERENCES `pelanggan` (`kodepelanggan`),
  CONSTRAINT `FK_faktur` FOREIGN KEY (`KodePelanggan`) REFERENCES `pelanggan` (`kodepelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `faktur` */

insert  into `faktur`(`NomorFaktur`,`KodePelanggan`,`TanggalFaktur`) values ('F0213','G01','2013-01-30'),('F0214','G01','2013-01-30'),('F0215','G01','2013-01-31');

/*Table structure for table `fakturdetail` */

DROP TABLE IF EXISTS `fakturdetail`;

CREATE TABLE `fakturdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NomorFaktur` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `KodeBarang` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `Qty` int(11) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fakturdetail` (`NomorFaktur`),
  KEY `FK_fakturdetail_barang` (`KodeBarang`),
  CONSTRAINT `FK_fakturdetail_NomorFaktur` FOREIGN KEY (`NomorFaktur`) REFERENCES `faktur` (`NomorFaktur`),
  CONSTRAINT `FK_fakturdetail` FOREIGN KEY (`NomorFaktur`) REFERENCES `faktur` (`NomorFaktur`),
  CONSTRAINT `FK_fakturdetail_barang` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`kodebarang`),
  CONSTRAINT `FK_fakturdetail_KodeBarang` FOREIGN KEY (`KodeBarang`) REFERENCES `barang` (`kodebarang`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `fakturdetail` */

insert  into `fakturdetail`(`id`,`NomorFaktur`,`KodeBarang`,`Qty`,`Harga`) values (10,'F0213','G001',1,1000000),(11,'F0214','G001',3,1000000),(12,'F0215','G002',1,500000),(13,'F0215','G001',2,1000000);

/*Table structure for table `kwitansi` */

DROP TABLE IF EXISTS `kwitansi`;

CREATE TABLE `kwitansi` (
  `NomorKwitansi` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `TanggalKwitansi` date DEFAULT NULL,
  `NomorFaktur` varchar(5) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`NomorKwitansi`),
  KEY `FK_kwitansi` (`NomorFaktur`),
  CONSTRAINT `FK_kwitansi_NomorFaktur` FOREIGN KEY (`NomorFaktur`) REFERENCES `faktur` (`NomorFaktur`),
  CONSTRAINT `FK_kwitansi` FOREIGN KEY (`NomorFaktur`) REFERENCES `faktur` (`NomorFaktur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `kwitansi` */

insert  into `kwitansi`(`NomorKwitansi`,`TanggalKwitansi`,`NomorFaktur`) values ('K0001','2013-01-31','F0215');

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `kodepelanggan` varchar(5) COLLATE latin1_general_ci NOT NULL,
  `namapelanggan` varchar(20) COLLATE latin1_general_ci DEFAULT NULL,
  `Alamat` varchar(100) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`kodepelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`kodepelanggan`,`namapelanggan`,`Alamat`) values ('G01','Gary Keren','Jl. Rahasia, nanti pada mampir lagi.'),('G02','Gary Keren Banget','Jl. Kasih tau gak ya.');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
