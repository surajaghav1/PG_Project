-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2025 at 06:22 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pg_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `bed`
--

CREATE TABLE `bed` (
  `bedid` varchar(30) NOT NULL,
  `roomno` varchar(20) NOT NULL,
  `customerid` varchar(30) NOT NULL,
  `bedstatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bed`
--

INSERT INTO `bed` (`bedid`, `roomno`, `customerid`, `bedstatus`) VALUES
('R-101-B-01', '101', '749856412314', 'occupied'),
('R-101-B-02', '101', '8896352145987', 'occupied'),
('R-102-B-01', '102', '456321789652', 'occupied');

-- --------------------------------------------------------

--
-- Table structure for table `beddetail`
--

CREATE TABLE `beddetail` (
  `roomno` varchar(10) DEFAULT NULL,
  `bedid` varchar(20) DEFAULT NULL,
  `bedstatus` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `beddetail`
--

INSERT INTO `beddetail` (`roomno`, `bedid`, `bedstatus`) VALUES
('101', 'R-101-B-01', 'occupied'),
('101', 'R-101-B-02', 'occupied'),
('102', 'R-102-B-01', 'occupied'),
('102', 'R-102-B-02', 'Available'),
('103', 'R-103-B-01', 'Available'),
('103', 'R-103-B-02', 'Available'),
('103', 'R-103-B-03', 'Available'),
('103', 'R-103-B-04', 'Available'),
('104', 'R-104-B-01', 'Available'),
('104', 'R-104-B-02', 'Available'),
('104', 'R-104-B-03', 'Available'),
('201', 'R-201-B-01', 'Available'),
('201', 'R-201-B-02', 'Available'),
('201', 'R-201-B-03', 'Available'),
('201', 'R-201-B-04', 'Available'),
('201', 'R-201-B-05', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `doctype` varchar(30) NOT NULL,
  `dateofjoin` varchar(30) NOT NULL,
  `mobileno` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `roomtype` varchar(20) NOT NULL,
  `facility` varchar(50) NOT NULL,
  `additionalfacility` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `name`, `gender`, `doctype`, `dateofjoin`, `mobileno`, `address`, `roomtype`, `facility`, `additionalfacility`) VALUES
('456321789652', 'Ram Jadhav', 'Male', 'Aadhaar Card', 'Sep 13, 2024', '7498404535', 'pune', '2 Sharing', 'Bed,WiFi,Cleaning,Breakfast,Dinner,', 'Lunch,'),
('749856412314', 'SURAJ AGHAV', 'Male', 'Aadhaar Card', 'Sep 24, 2024', '7498404835', 'nagar', '3 Sharing', 'Bed,WiFi,Cleaning,Breakfast,Dinner,', 'Lunch,Laundry,'),
('8896352145987', 'suraj Aghav', 'Male', 'Aadhaar Card', 'Sep 30, 2024', '7498563251', 'Nagar', '2 Sharing', 'Bed,WiFi,Cleaning,Breakfast,Dinner,', 'Lunch,Laundry,');

-- --------------------------------------------------------

--
-- Table structure for table `customerroomdetail`
--

CREATE TABLE `customerroomdetail` (
  `customerid` varchar(30) NOT NULL,
  `roomno` varchar(10) NOT NULL,
  `bedid` varchar(20) NOT NULL,
  `deposite` varchar(10) NOT NULL,
  `monthlyrent` varchar(10) NOT NULL,
  `totalamount` varchar(10) NOT NULL,
  `paymentstatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerroomdetail`
--

INSERT INTO `customerroomdetail` (`customerid`, `roomno`, `bedid`, `deposite`, `monthlyrent`, `totalamount`, `paymentstatus`) VALUES
('749856412314', '101', 'R-101-B-01', '3000', '12000', '15000', 'paid'),
('8896352145987', '101', 'R-101-B-01', '3000', '13000', '16000', 'paid'),
('8896352145987', '101', 'R-101-B-02', '3000', '13000', '16000', 'paid'),
('456321789652', '102', 'R-102-B-01', '3000', '12000', '15000', 'paid');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `passwd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `passwd`) VALUES
('suraj', 'suraj123');

-- --------------------------------------------------------

--
-- Table structure for table `paymentdetail`
--

CREATE TABLE `paymentdetail` (
  `paymentstatus` varchar(20) DEFAULT NULL,
  `deposite` varchar(20) DEFAULT NULL,
  `monthlyrent` varchar(20) DEFAULT NULL,
  `customerid` varchar(20) DEFAULT NULL,
  `paymentmethod` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paymentdetail`
--

INSERT INTO `paymentdetail` (`paymentstatus`, `deposite`, `monthlyrent`, `customerid`, `paymentmethod`) VALUES
('paid', '3000', '12000', '749856412314', 'cash'),
('paid', '3000', '13000', '8896352145987', 'cash'),
('paid', '3000', '12000', '456321789652', 'online');

-- --------------------------------------------------------

--
-- Table structure for table `removedcustomer`
--

CREATE TABLE `removedcustomer` (
  `customerid` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `mobileno` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `dateofjoin` varchar(30) NOT NULL,
  `dateofleave` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomno` varchar(10) NOT NULL,
  `capacity` varchar(10) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `bedid` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomno`, `capacity`, `status`, `bedid`) VALUES
('101', '2', 'Occupied', 'R-101-B-01,R-101-B-02,'),
('102', '2', 'Available', 'R-102-B-01,R-102-B-02,'),
('103', '4', 'Available', 'R-103-B-01,R-103-B-02,R-103-B-03,R-103-B-04,'),
('104', '3', 'Available', 'R-104-B-01,R-104-B-02,R-104-B-03,'),
('201', '5', 'Available', 'R-201-B-01,R-201-B-02,R-201-B-03,R-201-B-04,R-201-B-05,');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bed`
--
ALTER TABLE `bed`
  ADD PRIMARY KEY (`bedid`),
  ADD KEY `roomno` (`roomno`),
  ADD KEY `customerid` (`customerid`),
  ADD KEY `roomno_2` (`roomno`,`customerid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `customerroomdetail`
--
ALTER TABLE `customerroomdetail`
  ADD KEY `customerroomdetail_ibfk_1` (`customerid`);

--
-- Indexes for table `paymentdetail`
--
ALTER TABLE `paymentdetail`
  ADD KEY `paymentdetail_ibfk_1` (`customerid`);

--
-- Indexes for table `removedcustomer`
--
ALTER TABLE `removedcustomer`
  ADD KEY `removedcustomer_ibfk_1` (`customerid`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomno`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bed`
--
ALTER TABLE `bed`
  ADD CONSTRAINT `bed_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bed_ibfk_2` FOREIGN KEY (`roomno`) REFERENCES `room` (`roomno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `customerroomdetail`
--
ALTER TABLE `customerroomdetail`
  ADD CONSTRAINT `customerroomdetail_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentdetail`
--
ALTER TABLE `paymentdetail`
  ADD CONSTRAINT `paymentdetail_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `removedcustomer`
--
ALTER TABLE `removedcustomer`
  ADD CONSTRAINT `removedcustomer_ibfk_1` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
