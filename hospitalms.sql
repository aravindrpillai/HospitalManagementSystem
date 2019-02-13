-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 20, 2015 at 03:11 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hospitalms`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(50) NOT NULL,
  `qualification` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `doctor_name`, `qualification`) VALUES
(1, 'Aravind', 'MBBS MD FRCS'),
(2, 'Ahalya', 'BDS'),
(6, 'Ehan Vedhas Dev', 'MBBS MD'),
(7, 'Vishnu', 'MD Physician'),
(0, 'No Doctor Selected', '0');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `last_update` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`, `last_update`) VALUES
(1, 'username', 'password', 'Not Available');

-- --------------------------------------------------------

--
-- Table structure for table `nurses`
--

CREATE TABLE IF NOT EXISTS `nurses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nurse_name` varchar(50) NOT NULL,
  `qualification` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `nurses`
--

INSERT INTO `nurses` (`id`, `nurse_name`, `qualification`) VALUES
(1, 'Sasikala VK', 'BSC Nursing'),
(2, 'Vimala', 'BSC, MSC Nursing'),
(0, 'No Nurse In Charge', '0');

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `house_name` varchar(100) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`id`, `patient_name`, `dob`, `house_name`, `street_address`) VALUES
(1, 'Vivek Shanker Shajilal', '1999-01-14', 'Viveks house', 'yeroor, kollam'),
(2, 'Pavan Babu', '2015-10-13', 'Pavans house', 'Kottarakara, kollam'),
(0, 'No Patient', '0000-00-00', '0', '0'),
(5, 'Atul prakash', '1993-10-08', 'Atul Bhavan', 'Erode');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE IF NOT EXISTS `receptionist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `qualification` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`id`, `name`, `qualification`) VALUES
(1, 'Bindu PK', 'BA English'),
(3, 'RaKhi Cyril', 'Bcom');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE IF NOT EXISTS `reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL DEFAULT '0',
  `doctor_id` int(11) NOT NULL DEFAULT '0',
  `room_number` int(11) NOT NULL DEFAULT '0',
  `report` varchar(300) NOT NULL DEFAULT '0',
  `admitted` varchar(5) NOT NULL DEFAULT 'No',
  `admitted_date` date NOT NULL DEFAULT '0000-00-00',
  `discharge_date` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`id`, `patient_id`, `doctor_id`, `room_number`, `report`, `admitted`, `admitted_date`, `discharge_date`) VALUES
(1, 0, 0, 0, '0', 'No', '0000-00-00', '0000-00-00'),
(3, 2, 7, 103, 'Tired due to heavy Intake', 'Yes', '2014-01-01', '2015-01-03'),
(5, 1, 1, 104, 'Scoliosis', 'Yes', '2015-10-07', '2015-10-05'),
(6, 5, 7, 0, 'Omiting', 'No', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `room_number` int(11) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'Non AC',
  `nurse_id` int(11) NOT NULL,
  UNIQUE KEY `room_number` (`room_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_number`, `type`, `nurse_id`) VALUES
(101, 'AC', 1),
(102, 'Non AC', 0),
(103, 'AC', 1),
(104, 'Non AC', 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
