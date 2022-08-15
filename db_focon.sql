-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 15, 2022 at 06:18 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_focon`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Total` ()   BEGIN
SELECT
SUM(tb_keranjang.Jumlah_Pembelian*tb_keranjang.Harga_Barang)AS Total FROM tb_keranjang;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `tanggal` varchar(100) NOT NULL,
  `kode_part` varchar(100) NOT NULL,
  `nama_part` varchar(100) NOT NULL,
  `kategori` varchar(100) NOT NULL,
  `jumlah` varchar(100) NOT NULL,
  `Harga` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`tanggal`, `kode_part`, `nama_part`, `kategori`, `jumlah`, `Harga`, `keterangan`) VALUES
('15/08/2022', 'MN001', 'Minyak Sovia', 'Minyak', '5', '14000', '1/2 Liter');

-- --------------------------------------------------------

--
-- Table structure for table `tb_gudang`
--

CREATE TABLE `tb_gudang` (
  `ID` int(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `kode_gudang` varchar(100) NOT NULL,
  `nama_gudang` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_kategori`
--

CREATE TABLE `tb_kategori` (
  `tanggal` varchar(100) NOT NULL,
  `kode_kategori` varchar(100) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kategori`
--

INSERT INTO `tb_kategori` (`tanggal`, `kode_kategori`, `nama_kategori`, `keterangan`) VALUES
('15/08/2022', 'MN', 'Minyak', 'Semua Jenis Minyak');

-- --------------------------------------------------------

--
-- Table structure for table `tb_keranjang`
--

CREATE TABLE `tb_keranjang` (
  `ID` int(100) NOT NULL,
  `Tanggal` varchar(100) NOT NULL,
  `Kode_Tranksaksi` varchar(100) NOT NULL,
  `Nama_Barang` varchar(100) NOT NULL,
  `Harga_Barang` int(100) NOT NULL,
  `Jumlah_Pembelian` int(11) NOT NULL,
  `Total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_keranjang`
--

INSERT INTO `tb_keranjang` (`ID`, `Tanggal`, `Kode_Tranksaksi`, `Nama_Barang`, `Harga_Barang`, `Jumlah_Pembelian`, `Total`) VALUES
(2, '15/08/2022', 'MN001', 'Minyak Sovia', 14000, 3, 42000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `ID` int(100) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `ID_User` varchar(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `No_telp_user` varchar(100) NOT NULL,
  `Alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `ID` int(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`ID`, `Username`, `Password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tranksaksi`
--

CREATE TABLE `tranksaksi` (
  `ID` int(100) NOT NULL,
  `Tanggal` varchar(100) NOT NULL,
  `Kode_Tranksaksi` varchar(100) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Harga` varchar(100) NOT NULL,
  `Jumlah` varchar(100) NOT NULL,
  `Total` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tranksaksi`
--

INSERT INTO `tranksaksi` (`ID`, `Tanggal`, `Kode_Tranksaksi`, `Nama`, `Harga`, `Jumlah`, `Total`) VALUES
(1, '15/08/2022', 'MN001', 'Minyak Sovia', '14000', '4', '56000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD UNIQUE KEY `kode_part` (`kode_part`);

--
-- Indexes for table `tb_gudang`
--
ALTER TABLE `tb_gudang`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`,`kode_gudang`);

--
-- Indexes for table `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIQUE` (`ID_User`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIQUE` (`Username`);

--
-- Indexes for table `tranksaksi`
--
ALTER TABLE `tranksaksi`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIQUE` (`Kode_Tranksaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_gudang`
--
ALTER TABLE `tb_gudang`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tranksaksi`
--
ALTER TABLE `tranksaksi`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
