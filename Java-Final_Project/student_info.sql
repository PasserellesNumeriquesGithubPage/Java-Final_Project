-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2022 at 01:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_record_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

CREATE TABLE `student_info` (
  `studentId` int(11) NOT NULL,
  `studentName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `contactNumber` bigint(11) NOT NULL,
  `emergencyName` varchar(255) NOT NULL,
  `emergencyNumber` bigint(11) NOT NULL,
  `usersId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `academicId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `MG` varchar(255) NOT NULL,
  `FG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`studentId`, `studentName`, `dateOfBirth`, `age`, `address`, `status`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`, `usersId`, `courseId`, `academicId`, `teacherId`, `MG`, `FG`) VALUES
(1, 'Lorgem', '2029-09-19', 20, 'Cebu', 'Single', 'Bosque@gmail.com', 97845263521, 'gema', 96589625365, 1, 1, 1, 1, 'INC', '1.3'),
(2, 'Mark Joseph Molina', '2011-12-02', 20, 'Leyte', 'Widowed', 'JosephPIYOS@gmail.com', 95847364532, 'chemss', 95746535243, 8, 5, 1, 2, '1.2', '3.0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`studentId`),
  ADD KEY `teacherId` (`teacherId`) USING BTREE,
  ADD KEY `courseId` (`courseId`,`academicId`) USING BTREE,
  ADD KEY `usersId` (`usersId`),
  ADD KEY `student_info_ibfk_1` (`academicId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_info`
--
ALTER TABLE `student_info`
  ADD CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`academicId`) REFERENCES `academic_level` (`academicId`),
  ADD CONSTRAINT `student_info_ibfk_3` FOREIGN KEY (`courseId`) REFERENCES `tblcourses` (`courseId`),
  ADD CONSTRAINT `student_info_ibfk_4` FOREIGN KEY (`usersId`) REFERENCES `users_info` (`userId`),
  ADD CONSTRAINT `student_info_ibfk_5` FOREIGN KEY (`teacherId`) REFERENCES `teacher_info` (`teacherId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
