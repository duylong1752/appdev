-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 22, 2020 lúc 10:52 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appdev`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `appuser`
--

CREATE TABLE `appuser` (
  `userID` int(255) NOT NULL,
  `username` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `appuser`
--

INSERT INTO `appuser` (`userID`, `username`, `password`) VALUES
(1, 'admin', '$2y$10$mexikhOqWrFQuf/rmv854uZgi17m8oGB6TmUsShTvWX1VxCouE9Tq'),
(2, 'trainingstaff', '$2y$10$1XO3lrJJH3T9Mci9gVIZDO4kWwSCIkQTuDmh5edJ4P/eei.HfB//W'),
(3, 'trainer', '$2y$10$pTaWEt8TVWrDVBy87cNPKuhBouZaJQ9XBay53/QczP6/3DrprVHuO'),
(13, 'trainer1', '$2a$10$LA.DUu94XWbOij0D.Tw8feKqjj5DxLbjUOiGW20EK.cmTejvHTfHC'),
(16, 'chophuong', '$2a$10$pxkDpiPMa1wwIFkgIhWFiOMWc6qdYw4CwK644dVDx3ZCazyX/NTe6'),
(20, 'trainingstaff1', '$2a$10$WxOgi6J0/jW0O74iNKInHeOEFzY4.UpvHIqWO8wH.kw63CVU9VydS'),
(29, 'chimungvang002', '$2a$10$76wEzV.v7TPEYcqht3MuAeOuNe//K9ZKj5MpL3T1UtGpiqWODl6Mi'),
(30, 'longnd', '$2a$10$FbhrSYSMri9NYE32Jtx3WO7ZCPzn1ZYs59Kkyt3BH2d2/jHwf/qiW'),
(31, 'phuongcho', '$2a$10$10/OhIEKlh/kbaDyURlYFuGWFgyWajeSX5vDIOkvutHwO6kgHSKnu'),
(35, 'taolachinh', '$2a$10$Znzl0A5TmhCl7VByswq0WOF1atjnpt1exaCi.SQyN.K9UbDKrfRpC'),
(40, 'phuongne', '$2a$10$RNjWpCqXqLVJaTGX.UMFLOgLZmMR6U0s1rlgt4AUWfl2fQcLlSZ0q');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `categoryID` int(255) NOT NULL,
  `categoryName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Description` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`categoryID`, `categoryName`, `Description`) VALUES
(1, 'Computing', 'This contain Computing Courses'),
(2, 'Graphic Design', 'This contain Graphic Design Courses');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

CREATE TABLE `course` (
  `courseID` int(255) NOT NULL,
  `courseName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `categoryID` int(255) NOT NULL,
  `Description` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `course`
--

INSERT INTO `course` (`courseID`, `courseName`, `categoryID`, `Description`) VALUES
(1, 'BHAF1809', 1, 'Course for 2000er IT'),
(2, 'BHAF1810', 2, 'Course for 2001er GD'),
(3, 'BHAF1888', 1, 'Course for 1999er IT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roledetail`
--

CREATE TABLE `roledetail` (
  `roleID` int(255) NOT NULL,
  `roleName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `roledetail`
--

INSERT INTO `roledetail` (`roleID`, `roleName`) VALUES
(1, 'admin'),
(2, 'trainingstaff'),
(3, 'trainer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `topic`
--

CREATE TABLE `topic` (
  `topicID` int(255) NOT NULL,
  `topicName` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `courseID` int(255) NOT NULL,
  `Description` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `topic`
--

INSERT INTO `topic` (`topicID`, `topicName`, `courseID`, `Description`) VALUES
(1, 'Web Design', 1, 'Website Design and Development'),
(2, 'Application Development', 3, 'App Dev for 1999er IT'),
(3, 'Logo Design', 2, 'Logo Design for 1999er GD'),
(4, 'Programming', 1, 'First Topic for 2000er IT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trainee`
--

CREATE TABLE `trainee` (
  `traineeID` int(255) NOT NULL,
  `traineeName` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `userID` int(255) NOT NULL,
  `traineeDOB` date NOT NULL,
  `Education` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `ProLanguage` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `TOEICscore` double NOT NULL,
  `Exp` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Department` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `Location` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `trainee`
--

INSERT INTO `trainee` (`traineeID`, `traineeName`, `userID`, `traineeDOB`, `Education`, `ProLanguage`, `TOEICscore`, `Exp`, `Department`, `Location`) VALUES
(5, 'Duy Long', 29, '2000-01-03', 'College', 'C#, Java', 450, 'Junior', 'BHAF1809', 'Bac Ninh'),
(6, 'Long ND', 30, '2000-12-29', 'College', 'Java, C++', 750, 'Junior', 'BHAF', 'Ha Noi'),
(7, 'Phug Lien', 31, '2019-11-10', 'College', 'Java, Python', 800, 'Student', 'BH1810', 'Ha Noi 2'),
(11, 'Thu Phuong', 40, '2001-12-25', 'College', 'C++, C#', 741, 'Student', 'BHAF', 'Ha Noi 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `traineecourse`
--

CREATE TABLE `traineecourse` (
  `ID` int(255) NOT NULL,
  `traineeID` int(255) NOT NULL,
  `courseID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `traineecourse`
--

INSERT INTO `traineecourse` (`ID`, `traineeID`, `courseID`) VALUES
(1, 7, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trainer`
--

CREATE TABLE `trainer` (
  `trainerID` int(255) NOT NULL,
  `trainerName` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `userID` int(255) NOT NULL,
  `ExterorInter` varchar(10) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Education` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `WorkingPlace` varchar(100) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Telephone` varchar(20) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8_vietnamese_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `trainer`
--

INSERT INTO `trainer` (`trainerID`, `trainerName`, `userID`, `ExterorInter`, `Education`, `WorkingPlace`, `Telephone`, `Email`) VALUES
(2, 'Ten la Trainer ne kaka', 3, 'External', 'College', 'Ha Noi', '0999999988', 'sadsssad@gmail.com'),
(3, NULL, 13, NULL, NULL, NULL, NULL, NULL),
(4, 'Phuong Lien', 16, 'Internal', 'College', 'Ha Noi', '0123456789', 'sadsad@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `trainertopic`
--

CREATE TABLE `trainertopic` (
  `ID` int(11) NOT NULL,
  `trainerID` int(255) NOT NULL,
  `topicID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `trainertopic`
--

INSERT INTO `trainertopic` (`ID`, `trainerID`, `topicID`) VALUES
(1, 2, 1),
(3, 2, 2),
(4, 4, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `userrole`
--

CREATE TABLE `userrole` (
  `ID` int(255) NOT NULL,
  `userID` int(255) NOT NULL,
  `roleID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `userrole`
--

INSERT INTO `userrole` (`ID`, `userID`, `roleID`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(6, 13, 3),
(9, 16, 3),
(13, 20, 2),
(17, 35, 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `appuser`
--
ALTER TABLE `appuser`
  ADD PRIMARY KEY (`userID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`);

--
-- Chỉ mục cho bảng `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseID`);

--
-- Chỉ mục cho bảng `roledetail`
--
ALTER TABLE `roledetail`
  ADD PRIMARY KEY (`roleID`);

--
-- Chỉ mục cho bảng `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topicID`);

--
-- Chỉ mục cho bảng `trainee`
--
ALTER TABLE `trainee`
  ADD PRIMARY KEY (`traineeID`);

--
-- Chỉ mục cho bảng `traineecourse`
--
ALTER TABLE `traineecourse`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`trainerID`);

--
-- Chỉ mục cho bảng `trainertopic`
--
ALTER TABLE `trainertopic`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK8cwgmucp366rrlnqjyhk3c6hh` (`roleID`),
  ADD KEY `FKoc0gv2lsry9pjq5w8hd2lhi3f` (`userID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `appuser`
--
ALTER TABLE `appuser`
  MODIFY `userID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `course`
--
ALTER TABLE `course`
  MODIFY `courseID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `roledetail`
--
ALTER TABLE `roledetail`
  MODIFY `roleID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `topic`
--
ALTER TABLE `topic`
  MODIFY `topicID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `trainee`
--
ALTER TABLE `trainee`
  MODIFY `traineeID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `traineecourse`
--
ALTER TABLE `traineecourse`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `trainer`
--
ALTER TABLE `trainer`
  MODIFY `trainerID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `trainertopic`
--
ALTER TABLE `trainertopic`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `userrole`
--
ALTER TABLE `userrole`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `userrole`
--
ALTER TABLE `userrole`
  ADD CONSTRAINT `FK8cwgmucp366rrlnqjyhk3c6hh` FOREIGN KEY (`roleID`) REFERENCES `roledetail` (`roleID`),
  ADD CONSTRAINT `FKoc0gv2lsry9pjq5w8hd2lhi3f` FOREIGN KEY (`userID`) REFERENCES `appuser` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
