-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 06:07 AM
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
-- Table structure for table `student_grades`
--

CREATE TABLE `student_grades` (
  `gradesId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `academicId` int(11) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `MG` float NOT NULL,
  `FG` float NOT NULL,
  `totalGrade` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_grades`
--

INSERT INTO `student_grades` (`gradesId`, `studentId`, `userId`, `courseId`, `academicId`, `teacherId`, `MG`, `FG`, `totalGrade`) VALUES
(1, 2, 3, 2, 3, 1, 1, 1, 1),
(2, 5, 0, 3, 4, 2, 1, 1.2, 1.3);

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
  `contactNumber` int(11) NOT NULL,
  `emergencyName` varchar(255) NOT NULL,
  `emergencyNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`studentId`, `studentName`, `dateOfBirth`, `age`, `address`, `status`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`) VALUES
(2, 'Lorgem', '2022-11-12', 22, 'Samjung', 'Single', 'lorgem@gmail.com', 456789, 'C', 123456),
(5, 'jean', '2022-11-12', 22, 'Samjung', 'Single', 'oms@gmail.com', 456789, 'omms', 123456);

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
(4, 'BCE', 'Bachelor of Computer Engeneer', 4),
(5, 'BC EE', 'Bachelor of Computer Engeneer English', 4);

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
  `emergencyNumber` int(30) NOT NULL,
  `courseHandled` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher_info`
--

INSERT INTO `teacher_info` (`teacherId`, `teacherName`, `dateOfBirth`, `age`, `address`, `status`, `degreeFinished`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`, `courseHandled`) VALUES
(1, 'Omne', '2022-11-11', 12, 'Samjung', 'Single', 'Bachelor of Degree Secondary of Education', 'Oms@gmail.com', 9123212343, 'Jean', 96311984, 'C CT'),
(2, 'Chemuel', '2000-12-13', 22, 'Samjung Bldg. Nasipit road Talamban Cebu city', 'Single', 'Bachelor of Primary Education', 'chemuelgodes@gmail.com', 9876785432, 'Cosme', 948491711, 'Certificate of Computer Technology');

-- --------------------------------------------------------

--
-- Table structure for table `users_info`
--

CREATE TABLE `users_info` (
  `userId` int(11) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_info`
--

INSERT INTO `users_info` (`userId`, `userEmail`, `userPassword`, `userRole`) VALUES
(1, 'Omne@gmail.com', '123', 'Teacher'),
(2, 'chemuel', '123', 'Admin'),
(3, 'chem', '111', 'Student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_level`
--
ALTER TABLE `academic_level`
  ADD PRIMARY KEY (`academicId`);

--
-- Indexes for table `student_grades`
--
ALTER TABLE `student_grades`
  ADD PRIMARY KEY (`gradesId`),
  ADD UNIQUE KEY `userId` (`userId`),
  ADD KEY `courseId` (`courseId`),
  ADD KEY `studentId` (`studentId`),
  ADD KEY `academicId` (`academicId`),
  ADD KEY `teacherId` (`teacherId`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`studentId`);

--
-- Indexes for table `tblcourses`
--
ALTER TABLE `tblcourses`
  ADD PRIMARY KEY (`courseId`);

--
-- Indexes for table `teacher_info`
--
ALTER TABLE `teacher_info`
  ADD PRIMARY KEY (`teacherId`);

--
-- Indexes for table `users_info`
--
ALTER TABLE `users_info`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `academic_level`
--
ALTER TABLE `academic_level`
  MODIFY `academicId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `student_grades`
--
ALTER TABLE `student_grades`
  MODIFY `gradesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tblcourses`
--
ALTER TABLE `tblcourses`
  MODIFY `courseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `teacher_info`
--
ALTER TABLE `teacher_info`
  MODIFY `teacherId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users_info`
--
ALTER TABLE `users_info`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_grades`
--
ALTER TABLE `student_grades`
  ADD CONSTRAINT `student_grades_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `tblcourses` (`courseId`),
  ADD CONSTRAINT `student_grades_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student_info` (`studentId`),
  ADD CONSTRAINT `student_grades_ibfk_3` FOREIGN KEY (`academicId`) REFERENCES `academic_level` (`academicId`),
  ADD CONSTRAINT `student_grades_ibfk_5` FOREIGN KEY (`teacherId`) REFERENCES `teacher_info` (`teacherId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
