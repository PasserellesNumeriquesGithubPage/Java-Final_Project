-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2022 at 02:58 PM
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
-- Table structure for table `student_account_table`
--

CREATE TABLE `student_account_table` (
  `accountId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_account_table`
--

INSERT INTO `student_account_table` (`accountId`, `userId`, `studentId`) VALUES
(1, 6, 2),
(2, 5, 6);

-- --------------------------------------------------------

--
-- Table structure for table `student_grades`
--

CREATE TABLE `student_grades` (
  `gradesId` int(11) NOT NULL,
  `MG` float NOT NULL,
  `FG` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_grades`
--

INSERT INTO `student_grades` (`gradesId`, `MG`, `FG`) VALUES
(1, 0, 0),
(2, 2.1, 2.2);

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
  `courseId` int(11) NOT NULL,
  `academicId` int(11) NOT NULL,
  `MG` varchar(255) NOT NULL,
  `FG` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`studentId`, `studentName`, `dateOfBirth`, `age`, `address`, `status`, `emailAddress`, `contactNumber`, `emergencyName`, `emergencyNumber`, `courseId`, `academicId`, `MG`, `FG`) VALUES
(2, 'Lorgem', '2022-11-12', 22, 'Samjung', 'Single', 'lorgem@gmail.com', 98765432144, 'Bosque', 94613254876, 1, 1, '1', '1.3'),
(3, 'Oms', '2022-12-06', 11, 'Samjung', 'Single', 'oms@gmail.com', 97845125687, 'Pelingon', 94567849123, 1, 1, '1.3', '1.4'),
(5, 'jean', '2022-11-12', 22, 'Samjung', 'Single', 'oms@gmail.com', 94258888522, 'omms', 94513250815, 1, 1, '1.0', 'INC'),
(6, 'chem', '2022-12-20', 13, 'can-avid', 'single', 'che@gmail.com', 97257575746, 'Cosme', 90004512641, 5, 5, 'INC', '1.0');

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
  `roleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_info`
--

INSERT INTO `users_info` (`userId`, `userEmail`, `userPassword`, `roleId`) VALUES
(1, 'Admin', '123', 1),
(2, 'chem', '123', 1),
(3, 'omneTeacher', '123', 2),
(4, 'lorgemTeacher', '123', 2),
(5, 'chem', '111', 3),
(6, 'lorgemStudent', '123', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `academic_level`
--
ALTER TABLE `academic_level`
  ADD PRIMARY KEY (`academicId`);

--
-- Indexes for table `role_table`
--
ALTER TABLE `role_table`
  ADD PRIMARY KEY (`roleId`);

--
-- Indexes for table `student_account_table`
--
ALTER TABLE `student_account_table`
  ADD PRIMARY KEY (`accountId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `studentId` (`studentId`);

--
-- Indexes for table `student_grades`
--
ALTER TABLE `student_grades`
  ADD PRIMARY KEY (`gradesId`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`studentId`),
  ADD KEY `courseId` (`courseId`,`academicId`),
  ADD KEY `academicId` (`academicId`);

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
-- AUTO_INCREMENT for table `role_table`
--
ALTER TABLE `role_table`
  MODIFY `roleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student_account_table`
--
ALTER TABLE `student_account_table`
  MODIFY `accountId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_grades`
--
ALTER TABLE `student_grades`
  MODIFY `gradesId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_info`
--
ALTER TABLE `student_info`
  MODIFY `studentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_account_table`
--
ALTER TABLE `student_account_table`
  ADD CONSTRAINT `student_account_table_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users_info` (`userId`),
  ADD CONSTRAINT `student_account_table_ibfk_4` FOREIGN KEY (`studentId`) REFERENCES `student_info` (`studentId`);

--
-- Constraints for table `student_info`
--
ALTER TABLE `student_info`
  ADD CONSTRAINT `student_info_ibfk_1` FOREIGN KEY (`academicId`) REFERENCES `academic_level` (`academicId`),
  ADD CONSTRAINT `student_info_ibfk_3` FOREIGN KEY (`courseId`) REFERENCES `tblcourses` (`courseId`);

--
-- Constraints for table `users_info`
--
ALTER TABLE `users_info`
  ADD CONSTRAINT `users_info_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role_table` (`roleId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
