-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2022 at 03:04 AM
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
-- Table structure for table `academic_level`
--

CREATE TABLE `academic_level` (
  `academicId` int(11) NOT NULL,
  `academicLevel` int(11) NOT NULL,
  `academicName` varchar(255) NOT NULL,
  `academicDescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `academic_level`
--

INSERT INTO `academic_level` (`academicId`, `academicLevel`, `academicName`, `academicDescription`) VALUES
(1, 1, 'Freshman', 'First year'),
(2, 2, 'Sophomore', 'Second year'),
(3, 3, 'Junior', 'Third year'),
(4, 4, 'Senior', 'Fourth Year'),
(5, 5, 'Super Senior', 'Fifth year');

-- --------------------------------------------------------

--
-- Table structure for table `admin_info`
--

CREATE TABLE `admin_info` (
  `adminId` int(11) NOT NULL,
  `adminName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `degreeFinished` varchar(255) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `contactNumber` bigint(30) NOT NULL,
  `emergencyName` varchar(255) NOT NULL,
  `emergencyNumber` bigint(30) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_info`
--

INSERT INTO `admin_info` (`adminId`, `adminName`, `dateOfBirth`, `age`, `address`, `status`, `degreeFinished`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`, `userId`) VALUES
(1, 'Chemuel', '2000-12-13', 22, 'Can-avid E. Samar', 'Single', 'IT', 'Chemuelgodes@gmail.com', 9484917114, 'Cosme', 9631198435, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role_table`
--

CREATE TABLE `role_table` (
  `roleId` int(11) NOT NULL,
  `Role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role_table`
--

INSERT INTO `role_table` (`roleId`, `Role`) VALUES
(1, 'Admin'),
(2, 'Teacher'),
(3, 'Student');

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
(1, 'Lorgem Bosque', '2022-06-03', 21, 'Samjung', 'Single', 'lor@gmail.com', 96325874101, 'lore', 90123456789, 9, 7, 1, 2, '0', '0'),
(2, 'Janrae Fagaran', '2022-12-10', 30, 'catbalogan', 'Single', 'JanrAE@gmail.com', 96325632563, 'jarith', 98741014789, 2, 7, 1, 2, '0', '0'),
(3, 'Ethyl Sotero', '2022-07-12', 22, 'SAmung', 'Single', 'stos@gmail.com', 9585847473, 'oretos', 94521896351, 8, 1, 1, 4, '0', '0'),
(4, 'John rey calesa', '2022-12-01', 36, 'Catlbo', 'Single', 'rey@gmail.com', 96584258741, 'cals', 95874563258, 12, 5, 1, 5, 'INC', '1.0'),
(5, 'Via Enopia', '2017-12-14', 22, 'Lapu lapu', 'Single', 'Vi@gmail.com', 98576756461, 'Enops', 91234756253, 13, 4, 1, 2, '0', '0'),
(13, 'Via Enopia', '2017-12-14', 22, 'Lapu lapu', 'Single', 'Vi@gmail.com', 98576756461, 'Enops', 91234756253, 13, 1, 1, 2, '0', '0');

-- --------------------------------------------------------

--
-- Table structure for table `tblcourses`
--

CREATE TABLE `tblcourses` (
  `courseId` int(11) NOT NULL,
  `courseCode` varchar(255) NOT NULL,
  `courseDescription` varchar(255) NOT NULL,
  `courseUnit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblcourses`
--

INSERT INTO `tblcourses` (`courseId`, `courseCode`, `courseDescription`, `courseUnit`) VALUES
(1, 'C CT', 'Certificate of Computer Technology', 2.5),
(2, 'AB History', 'Bachelor of Arts in History', 3.5),
(3, 'AB Philosophy', 'Bachelor of Arts in Philosophy', 4),
(4, 'BSc', 'Bachelor Data Science', 4),
(5, 'BRE', 'Bachelor of Religious Education', 4),
(7, 'BSE', 'Bachelor of Science in Education', 3.4),
(8, 'BSc', 'Bachelor of Science in Human Biology', 2.2);

-- --------------------------------------------------------

--
-- Table structure for table `teacher_info`
--

CREATE TABLE `teacher_info` (
  `teacherId` int(11) NOT NULL,
  `teacherName` varchar(255) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `degreeFinished` varchar(255) NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `contactNumber` bigint(30) NOT NULL,
  `emergencyName` varchar(255) NOT NULL,
  `emergencyNumber` bigint(30) NOT NULL,
  `courseHandled` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher_info`
--

INSERT INTO `teacher_info` (`teacherId`, `teacherName`, `dateOfBirth`, `age`, `address`, `status`, `degreeFinished`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`, `courseHandled`, `userId`) VALUES
(1, 'Omne', '2001-09-12', 21, 'Negros', 'Single', 'Bachelor of Science in Education', 'OmneJeanPelingon@gmail.com', 97845263521, 'Jean', 96589625365, 'BSE', 2),
(2, 'Van', '2001-05-24', 21, 'Bohol', 'Single', 'Bachelor in Computer Science', 'Sagolili@gmail.com', 96325698154, 'Vanvan', 96589251563, 'C CT', 4),
(3, 'loren', '1999-01-08', 23, 'Dalaguete', 'Single', 'Bachelor of Religious Education', 'lorenfeCua@gmail.com', 96521586325, 'Cuadero', 95841256365, 'BRE', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users_info`
--

CREATE TABLE `users_info` (
  `userId` int(11) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_info`
--

INSERT INTO `users_info` (`userId`, `userEmail`, `userPassword`, `roleId`) VALUES
(1, 'Chemuel', '123', 1),
(2, 'Omne', '123', 2),
(3, 'Lorgem', '123', 3),
(4, 'Vanessa', '123', 2),
(5, 'Lorenfe', '123', 2),
(6, 'Janrae', '123', 3),
(7, 'Joshua', '147', 3),
(8, 'Ethyl', 'Sots', 3),
(9, 'lorgem23', '123', 3),
(10, 'Janrae', '123', 3),
(11, 'Ethyl', '123', 3),
(12, 'John rey', '123', 3),
(13, 'Via', '123', 3),
(14, 'Via', '123', 3),
(15, 'Via', '123', 3),
(16, 'Via', '123', 3),
(17, 'Via', '123', 3),
(18, 'Via', '123', 3),
(19, 'Via', '123', 3),
(20, 'Via', '123', 3),
(21, 'Via', '123', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_level`
--
ALTER TABLE `academic_level`
  ADD PRIMARY KEY (`academicId`);

--
-- Indexes for table `admin_info`
--
ALTER TABLE `admin_info`
  ADD PRIMARY KEY (`adminId`),
  ADD UNIQUE KEY `userId` (`userId`);

--
-- Indexes for table `role_table`
--
ALTER TABLE `role_table`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`studentId`),
  ADD KEY `teacherId` (`teacherId`) USING BTREE,
  ADD KEY `courseId` (`courseId`,`academicId`) USING BTREE,
  ADD KEY `usersId` (`usersId`);

--
-- Indexes for table `tblcourses`
--
ALTER TABLE `tblcourses`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `teacher_info`
--
ALTER TABLE `teacher_info`
  ADD PRIMARY KEY (`teacherId`),
  ADD UNIQUE KEY `userId` (`userId`);

--
-- Indexes for table `users_info`
--
ALTER TABLE `users_info`
  ADD PRIMARY KEY (`userId`),
  ADD KEY `roleId` (`roleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academic_level`
--
ALTER TABLE `academic_level`
  MODIFY `academicId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `admin_info`
--
ALTER TABLE `admin_info`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `role_table`
--
ALTER TABLE `role_table`
  MODIFY `roleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tblcourses`
--
ALTER TABLE `tblcourses`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `teacher_info`
--
ALTER TABLE `teacher_info`
  MODIFY `teacherId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users_info`
--
ALTER TABLE `users_info`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_info`
--
ALTER TABLE `student_info`
  ADD CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`academicId`) REFERENCES `academic_level` (`academicId`),
  ADD CONSTRAINT `student_info_ibfk_3` FOREIGN KEY (`courseId`) REFERENCES `tblcourses` (`courseId`),
  ADD CONSTRAINT `student_info_ibfk_4` FOREIGN KEY (`usersId`) REFERENCES `users_info` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
