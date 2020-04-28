-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2020 at 02:07 PM
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
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `account_name`, `isAdmin`, `status`, `password`) VALUES
(1, 'yorme', 'Yes', 'Active', '1'),
(3, 'Christian', 'Yes', 'Active', 'IloveJava1234567890'),
(4, 'YOLO12345678', 'Yes', 'Active', 'IloveJava1234567890'),
(5, 'OHYEAHTHEO', 'Yes', 'Active', 'Ohyeahaltheo10'),
(6, 'WazzupBene', 'Yes', 'Active', 'Hello10OHyeaah');

-- --------------------------------------------------------

--
-- Table structure for table `account_action`
--

CREATE TABLE `account_action` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account_action`
--

INSERT INTO `account_action` (`id`, `account_id`, `action`, `date`, `admin_id`) VALUES
(1, 2, 'Added Account ID: ', '2020/04/24', 1),
(2, 3, 'Added Account ID: ', '2020/04/24', 1),
(3, 4, 'Added Account ID: ', '2020/04/24', 1),
(4, 5, 'Added Account ID: ', '2020/04/24', 1),
(5, 6, 'Added Account ID: ', '2020/04/24', 1),
(6, 7, 'Added Account ID: ', '2020/04/24', 1),
(7, 7, 'Deleted Account ID: ', '2020/04/24', 1),
(8, 8, 'Added Account ID: ', '2020/04/24', 1),
(9, 8, 'Deleted Account ID: ', '2020/04/24', 1),
(10, 9, 'Added Account ID: ', '2020/04/24', 1),
(11, 9, 'Deleted Account ID: ', '2020/04/24', 1),
(12, 10, 'Added Account ID: ', '2020/04/24', 1),
(13, 10, 'Deleted Account ID: ', '2020/04/24', 1),
(14, 11, 'Added Account ID: ', '2020/04/24', 1),
(15, 2, 'Deleted Account ID: ', '2020/04/25 18:31:08', 1);

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
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodpack`
--

INSERT INTO `bloodpack` (`id`, `packType_id`, `bloodType`, `donor_id`, `date_collected`, `date_registered`, `account_id`, `status`, `quantity`) VALUES
(5, 1, 'BLOOODTYPE', 0, '2020/01/01', '2020/04/26', 1, 'Active', 1),
(6, 1, 'BLOOODTYPE', 0, '2020/01/01', '2020/04/26', 1, 'Active', 2),
(9, 1, 'A+', 7, '2020/01/01', '2020/04/26', 1, 'Active', 2);

-- --------------------------------------------------------

--
-- Table structure for table `bloodpack_action`
--

CREATE TABLE `bloodpack_action` (
  `id` int(11) NOT NULL,
  `bloodPack_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodpack_action`
--

INSERT INTO `bloodpack_action` (`id`, `bloodPack_id`, `action`, `date`, `account_id`) VALUES
(1, 1, 'Added Blood Pack ID: ', '2020/04/24', 1),
(2, 2, 'Added Blood Pack ID: ', '2020/04/24', 1),
(3, 2, 'Edited Blood Pack ID: ', '2020/04/25 12:35:16', 1),
(4, 2, 'Edited Blood Pack ID: ', '2020/04/25 12:37:32', 1),
(5, 2, 'Edited Blood Pack ID: ', '2020/04/25 12:47:42', 1),
(6, 2, 'Edited Blood Pack ID: ', '2020/04/25 13:48:17', 1),
(7, 3, 'AddedBlood Pack ID: ', '2020/04/26 19:11:18', 1),
(8, 4, 'Added Blood Pack ID: ', '2020/04/26 19:14:06', 1),
(9, 5, 'Added Blood Pack ID: ', '2020/04/26 19:15:36', 1),
(10, 6, 'Added Blood Pack ID: ', '2020/04/26 19:17:30', 1),
(11, 7, 'Added Blood Pack ID: ', '2020/04/26 19:36:46', 1),
(12, 7, 'Deleted Blood Pack ID: ', '2020/04/26 19:42:26', 1),
(13, 8, 'Added Blood Pack ID: ', '2020/04/26 19:43:02', 1),
(14, 8, 'Deleted Blood Pack ID: ', '2020/04/26 19:45:41', 1),
(15, 9, 'Added Blood Pack ID: ', '2020/04/26 19:52:48', 1),
(16, 9, 'Edited Blood Pack ID: ', '2020/04/26 19:53:03', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bloodtype`
--

CREATE TABLE `bloodtype` (
  `id` int(11) NOT NULL,
  `bloodType` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodtype`
--

INSERT INTO `bloodtype` (`id`, `bloodType`, `status`) VALUES
(1, 'A', 'Active'),
(3, 'D', 'Not Active');

-- --------------------------------------------------------

--
-- Table structure for table `bloodtype_action`
--

CREATE TABLE `bloodtype_action` (
  `id` int(11) NOT NULL,
  `bloodType_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodtype_action`
--

INSERT INTO `bloodtype_action` (`id`, `bloodType_id`, `action`, `date`, `account_id`) VALUES
(1, 1, 'Added Blood Type ID: ', '2020/04/24', 1),
(2, 2, 'Added Blood Type ID: ', '2020/04/24', 1),
(3, 3, 'Added Blood Type ID: ', '2020/04/25 15:35:00', 1),
(4, 3, 'Edited Blood Type: ', '2020/04/25 15:35:08', 1);

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
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`id`, `donorName`, `contactNum`, `add1`, `add2`, `bloodType`, `age`, `status`) VALUES
(7, 'HELLO', '123', 'AASSSSSSAAAAAASSSSS', '', 'A+', 2, 'Active'),
(8, 'Benedick', '09173144931', 'Molino Bitches....Cavite boi toh', 'Sarap mo theo SHET', 'S++', 69, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `donor_action`
--

CREATE TABLE `donor_action` (
  `id` int(11) NOT NULL,
  `donor_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donor_action`
--

INSERT INTO `donor_action` (`id`, `donor_id`, `action`, `date`, `account_id`) VALUES
(14, 5, 'Added Donor ID: ', '2020/04/26 18:32:06', 1),
(15, 0, 'Edited Donor: ', '2020/04/26 18:32:55', 1),
(16, 5, 'Deleted Donor: ', '2020/04/26 18:37:12', 1),
(17, 6, 'Added Donor ID: ', '2020/04/26 18:37:33', 1),
(18, 6, 'Deleted Donor: ', '2020/04/26 18:39:01', 1),
(19, 0, 'Edited Donor: ', '2020/04/26 18:40:57', 1),
(20, 1, 'Deleted Donor: ', '2020/04/26 18:41:49', 1),
(21, 7, 'Added Donor ID: ', '2020/04/26 18:42:21', 1),
(22, 0, 'Edited Donor: ', '2020/04/26 18:43:32', 1),
(23, 8, 'Added Donor ID: ', '2020/04/26 20:00:57', 1),
(24, 8, 'Edited Donor: ', '2020/04/26 20:01:03', 1),
(25, 8, 'Edited Donor: ', '2020/04/26 20:05:50', 1);

-- --------------------------------------------------------

--
-- Table structure for table `packtype`
--

CREATE TABLE `packtype` (
  `id` int(11) NOT NULL,
  `packType` varchar(255) NOT NULL,
  `shelfLife` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `packtype`
--

INSERT INTO `packtype` (`id`, `packType`, `shelfLife`, `status`) VALUES
(1, 'single', 41, 'Active'),
(2, 'double', 41, 'DeActive'),
(3, 'triple', 41, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `packtype_action`
--

CREATE TABLE `packtype_action` (
  `id` int(11) NOT NULL,
  `packType_id` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `packtype_action`
--

INSERT INTO `packtype_action` (`id`, `packType_id`, `action`, `date`, `account_id`) VALUES
(1, 1, 'added Pack Type ID: ', '2020/04/24', 1),
(2, 2, 'added Pack Type ID: ', '2020/04/24', 1),
(3, 3, 'added Pack Type ID: ', '2020/04/24', 1),
(4, 2, 'Edited Pack Type ID: ', '2020/04/24', 1),
(5, 1, 'Edited Pack Type ID: ', '2020/04/25 10:54:29', 1),
(6, 1, 'Edited Pack Type ID: ', '2020/04/25 10:54:35', 1);

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
-- Indexes for table `bloodtype`
--
ALTER TABLE `bloodtype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bloodtype_action`
--
ALTER TABLE `bloodtype_action`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `account_action`
--
ALTER TABLE `account_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `bloodpack`
--
ALTER TABLE `bloodpack`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `bloodpack_action`
--
ALTER TABLE `bloodpack_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `bloodtype`
--
ALTER TABLE `bloodtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bloodtype_action`
--
ALTER TABLE `bloodtype_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `donor_action`
--
ALTER TABLE `donor_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `packtype`
--
ALTER TABLE `packtype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `packtype_action`
--
ALTER TABLE `packtype_action`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
