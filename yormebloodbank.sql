-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2020 at 12:38 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yormebloodbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `isAdmin` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `account_action`
--

CREATE TABLE `account_action` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `activationkeys`
--

CREATE TABLE `activationkeys` (
  `id` int(11) NOT NULL,
  `activationID` varchar(255) NOT NULL,
  `designation` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bloodbank`
--

CREATE TABLE `bloodbank` (
  `id` int(11) NOT NULL,
  `bloodBank_name` varchar(255) NOT NULL,
  `registration_key` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bloodpack`
--

CREATE TABLE `bloodpack` (
  `id` int(11) NOT NULL,
  `packType_id` int(11) NOT NULL,
  `bloodType` varchar(255) NOT NULL,
  `donor_id` int(11) NOT NULL,
  `date_collected` varchar(255) NOT NULL,
  `date_registered` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bloodpack_action`
--

CREATE TABLE `bloodpack_action` (
  `id` int(11) NOT NULL,
  `bloodPack_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `dev_accounts`
--

CREATE TABLE `dev_accounts` (
  `id` int(11) NOT NULL,
  `devUser` varchar(255) NOT NULL,
  `devPass` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dev_accounts`
--

INSERT INTO `dev_accounts` (`id`, `devUser`, `devPass`) VALUES
(1, 'yorme', '1');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `id` int(11) NOT NULL,
  `donorName` varchar(255) NOT NULL,
  `contactNum` varchar(255) NOT NULL,
  `add1` varchar(255) NOT NULL,
  `add2` varchar(255) NOT NULL,
  `bloodType` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `donor_action`
--

CREATE TABLE `donor_action` (
  `id` int(11) NOT NULL,
  `donor_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `packtype`
--

CREATE TABLE `packtype` (
  `id` int(11) NOT NULL,
  `packType` varchar(255) NOT NULL,
  `shelfLife` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `packtype_action`
--

CREATE TABLE `packtype_action` (
  `id` int(11) NOT NULL,
  `packType_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL,
  `bloodBank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `account_action`
--
ALTER TABLE `account_action`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `activationkeys`
--
ALTER TABLE `activationkeys`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bloodbank`
--
ALTER TABLE `bloodbank`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bloodpack`
--
ALTER TABLE `bloodpack`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bloodpack_action`
--
ALTER TABLE `bloodpack_action`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dev_accounts`
--
ALTER TABLE `dev_accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donor_action`
--
ALTER TABLE `donor_action`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `packtype`
--
ALTER TABLE `packtype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `packtype_action`
--
ALTER TABLE `packtype_action`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `account_action`
--
ALTER TABLE `account_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `activationkeys`
--
ALTER TABLE `activationkeys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `bloodbank`
--
ALTER TABLE `bloodbank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `bloodpack`
--
ALTER TABLE `bloodpack`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `bloodpack_action`
--
ALTER TABLE `bloodpack_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `dev_accounts`
--
ALTER TABLE `dev_accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `donor_action`
--
ALTER TABLE `donor_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `packtype`
--
ALTER TABLE `packtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `packtype_action`
--
ALTER TABLE `packtype_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
