-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2020 at 01:59 PM
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

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `account_name`, `isAdmin`, `status`, `password`, `bloodBank_id`) VALUES
(1, 'yorme', 'Yes', 'Active', '1', 1),
(3, 'Christian', 'Yes', 'Active', 'IloveJava1234567890', 1),
(4, 'YOLO12345678', 'Yes', 'Active', 'IloveJava1234567890', 1),
(5, 'OHYEAHTHEO', 'Yes', 'Active', 'Ohyeahaltheo10', 1),
(6, 'WazzupBene', 'Yes', 'Active', 'Hello10OHyeaah', 1),
(14, 'Benedick3637', 'Yes', 'Active', 'Hatdogkatheo10', 4),
(15, 'WazzupTheo', 'Yes', 'Active', 'Putabatanghabangpassword10', 4);

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

--
-- Dumping data for table `account_action`
--

INSERT INTO `account_action` (`id`, `account_id`, `action`, `date`, `admin_id`, `bloodBank_id`) VALUES
(1, 2, 'Added Account ID: ', '2020/04/24', 1, 0),
(2, 3, 'Added Account ID: ', '2020/04/24', 1, 0),
(3, 4, 'Added Account ID: ', '2020/04/24', 1, 0),
(4, 5, 'Added Account ID: ', '2020/04/24', 1, 0),
(5, 6, 'Added Account ID: ', '2020/04/24', 1, 0),
(6, 7, 'Added Account ID: ', '2020/04/24', 1, 0),
(7, 7, 'Deleted Account ID: ', '2020/04/24', 1, 0),
(8, 8, 'Added Account ID: ', '2020/04/24', 1, 0),
(9, 8, 'Deleted Account ID: ', '2020/04/24', 1, 0),
(10, 9, 'Added Account ID: ', '2020/04/24', 1, 0),
(11, 9, 'Deleted Account ID: ', '2020/04/24', 1, 0),
(12, 10, 'Added Account ID: ', '2020/04/24', 1, 0),
(13, 10, 'Deleted Account ID: ', '2020/04/24', 1, 0),
(14, 11, 'Added Account ID: ', '2020/04/24', 1, 0),
(15, 2, 'Deleted Account ID: ', '2020/04/25 18:31:08', 1, 1),
(16, 15, 'Added Account ID: ', '2020/04/30 18:22:48', 14, 4);

-- --------------------------------------------------------

--
-- Table structure for table `bloodbank`
--

CREATE TABLE `bloodbank` (
  `id` int(11) NOT NULL,
  `bloodBank_name` varchar(255) NOT NULL,
  `registration_key` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodbank`
--

INSERT INTO `bloodbank` (`id`, `bloodBank_name`, `registration_key`) VALUES
(1, 'BloodBank1', '123Yorme'),
(4, 'Yoyo Blood Bank', '1');

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

--
-- Dumping data for table `bloodpack`
--

INSERT INTO `bloodpack` (`id`, `packType_id`, `bloodType`, `donor_id`, `date_collected`, `date_registered`, `account_id`, `status`, `quantity`, `bloodBank_id`) VALUES
(10, 5, 'S+', 9, '2020/01/01', '2020/04/30', 1, 'Active', 1, 1),
(11, 5, 'A+', 10, '2020/01/10', '2020/04/30', 1, 'Active', 4, 1),
(12, 8, 'A=', 12, '2020/01/10', '2020/04/30', 14, 'Active', 1, 4),
(13, 8, 'S++', 11, '2020/10/01', '2020/04/30', 14, 'Active', 2, 4),
(14, 8, 'As', 13, '2020/01/01', '2020/04/30', 14, 'Active', 1, 4);

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

--
-- Dumping data for table `bloodpack_action`
--

INSERT INTO `bloodpack_action` (`id`, `bloodPack_id`, `action`, `date`, `account_id`, `bloodBank_id`) VALUES
(17, 10, 'Added Blood Pack ID: ', '2020/04/30 12:51:34', 1, 1),
(18, 11, 'Added Blood Pack ID: ', '2020/04/30 12:52:13', 1, 1),
(19, 12, 'Added Blood Pack ID: ', '2020/04/30 18:19:19', 14, 4),
(20, 13, 'Added Blood Pack ID: ', '2020/04/30 18:20:06', 14, 4),
(21, 14, 'Added Blood Pack ID: ', '2020/04/30 18:22:24', 14, 4);

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

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`id`, `donorName`, `contactNum`, `add1`, `add2`, `bloodType`, `age`, `status`, `bloodBank_id`) VALUES
(9, 'GG Benedick', '123456777', 'HEY Altheo ', 'Pogi ', 'S+', 12, 'Active', 1),
(10, 'Hey', '2839291', 'C-chan pappy', 'awoo awooooo', 'A+', 14, 'Active', 1),
(11, 'GG', '929228823393', 'hahahahaha HAKDOG KA THEO HABA NG PASSWORD DAPAT', 'HIRAP ITYPE ', 'S++', 69, 'Active', 4),
(12, 'hakdog', '134141241241', 'cascas', 'sacascas', 'A=', 1212, 'Active', 4),
(13, 'Benedicto', '1929929292', 'HAHAHAhA', 'dfsafas', 'As', 69, 'Active', 4);

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

--
-- Dumping data for table `donor_action`
--

INSERT INTO `donor_action` (`id`, `donor_id`, `action`, `date`, `account_id`, `bloodBank_id`) VALUES
(26, 9, 'Added Donor ID: ', '2020/04/30 12:50:32', 1, 1),
(27, 10, 'Added Donor ID: ', '2020/04/30 12:51:00', 1, 1),
(28, 10, 'Edited Donor: ', '2020/04/30 12:51:53', 1, 1),
(29, 11, 'Added Donor ID: ', '2020/04/30 18:15:44', 14, 4),
(30, 12, 'Added Donor ID: ', '2020/04/30 18:19:03', 14, 4),
(31, 11, 'Edited Donor: ', '2020/04/30 18:19:50', 14, 4),
(32, 13, 'Added Donor ID: ', '2020/04/30 18:22:06', 14, 4);

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

--
-- Dumping data for table `packtype`
--

INSERT INTO `packtype` (`id`, `packType`, `shelfLife`, `status`, `bloodBank_id`) VALUES
(5, 'Single', 41, 'Active', 1),
(6, 'Double', 41, 'Active', 1),
(7, 'Triple', 41, 'Active', 1),
(8, 'Single', 41, 'Active', 4);

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
-- Dumping data for table `packtype_action`
--

INSERT INTO `packtype_action` (`id`, `packType_id`, `action`, `date`, `account_id`, `bloodBank_id`) VALUES
(11, 5, 'added Pack Type ID: ', '2020/04/30 12:49:41', 1, 1),
(12, 6, 'added Pack Type ID: ', '2020/04/30 12:49:47', 1, 1),
(13, 7, 'added Pack Type ID: ', '2020/04/30 12:49:54', 1, 1),
(14, 8, 'added Pack Type ID: ', '2020/04/30 18:14:55', 14, 4);

-- --------------------------------------------------------

--
-- Table structure for table `registration_key`
--

CREATE TABLE `registration_key` (
  `id` int(11) NOT NULL,
  `rKey` varchar(255) NOT NULL
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
-- Indexes for table `registration_key`
--
ALTER TABLE `registration_key`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `account_action`
--
ALTER TABLE `account_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `bloodbank`
--
ALTER TABLE `bloodbank`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bloodpack`
--
ALTER TABLE `bloodpack`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `bloodpack_action`
--
ALTER TABLE `bloodpack_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `donor_action`
--
ALTER TABLE `donor_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `packtype`
--
ALTER TABLE `packtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `packtype_action`
--
ALTER TABLE `packtype_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `registration_key`
--
ALTER TABLE `registration_key`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
