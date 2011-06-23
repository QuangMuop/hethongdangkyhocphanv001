/*
MySQL Data Transfer
Source Host: localhost
Source Database: dangkyhocphan
Target Host: localhost
Target Database: dangkyhocphan
Date: 6/23/2011 10:15:14 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `UserName` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Passwords` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `FullName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IsLocked` tinyint(4) NOT NULL,
  `IsLogin` tinyint(4) NOT NULL,
  `Type` tinyint(4) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ClassName` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Semester` int(11) NOT NULL,
  `Year` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `LectuerCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfWeek` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Room` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `NumOfStudent` int(11) NOT NULL,
  `Time` tinyint(4) NOT NULL,
  `TestDate` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TestTime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TestRoom` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ClassName`,`Semester`,`Year`),
  KEY `foreign_class_lec` (`LectuerCode`),
  KEY `foreign_class_sub` (`SubCode`),
  CONSTRAINT `foreign_class_lec` FOREIGN KEY (`LectuerCode`) REFERENCES `lecturer` (`LectuterCode`),
  CONSTRAINT `foreign_class_sub` FOREIGN KEY (`SubCode`) REFERENCES `subject` (`SubCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for classname
-- ----------------------------
DROP TABLE IF EXISTS `classname`;
CREATE TABLE `classname` (
  `Class` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `MSSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Author` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CourseCode` int(11) NOT NULL,
  `YearIn` int(11) NOT NULL,
  `YearOut` int(11) NOT NULL,
  `NumOfStudent` int(11) NOT NULL,
  `ProCode` int(11) NOT NULL,
  PRIMARY KEY (`CourseCode`),
  KEY `ProCode` (`ProCode`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`ProCode`) REFERENCES `pro` (`ProCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for lecturer
-- ----------------------------
DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer` (
  `LectuterCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `FullName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `BirthDay` date NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `HocHam` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Degree` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Gender` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`LectuterCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Content` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Author` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for pro
-- ----------------------------
DROP TABLE IF EXISTS `pro`;
CREATE TABLE `pro` (
  `ProCode` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ProCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for program
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `ProCode` int(11) NOT NULL,
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Semester` tinyint(4) NOT NULL,
  PRIMARY KEY (`ProCode`,`SubCode`),
  KEY `foreign_pro_sub` (`SubCode`),
  CONSTRAINT `foreign_pro_program` FOREIGN KEY (`ProCode`) REFERENCES `pro` (`ProCode`),
  CONSTRAINT `foreign_pro_sub` FOREIGN KEY (`SubCode`) REFERENCES `subject` (`SubCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for registry
-- ----------------------------
DROP TABLE IF EXISTS `registry`;
CREATE TABLE `registry` (
  `MSSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ClassName` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Semester` int(11) NOT NULL,
  `Year` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Mark` float DEFAULT NULL,
  PRIMARY KEY (`MSSV`,`ClassName`,`Semester`,`Year`),
  KEY `foreign_reg_class` (`ClassName`),
  CONSTRAINT `foreign_reg_class` FOREIGN KEY (`ClassName`) REFERENCES `class` (`ClassName`),
  CONSTRAINT `foreign_reg_Stu` FOREIGN KEY (`MSSV`) REFERENCES `student` (`MSSV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `STT` tinyint(4) NOT NULL,
  `MaxTC` int(11) NOT NULL,
  `MinTC` int(11) NOT NULL,
  `MaxStudentAge` int(11) NOT NULL,
  `MinStudentAge` int(11) NOT NULL,
  `MaxNumOfStudent` int(11) NOT NULL,
  `MinNumOfStudent` int(11) NOT NULL,
  `MarkPass` float NOT NULL,
  `MaxLecturerAge` int(11) NOT NULL,
  `MinLecturerAge` int(11) NOT NULL,
  PRIMARY KEY (`STT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `FullName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MSSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `BirthDay` date NOT NULL,
  `Class` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Address` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Home` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `IsStuding` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `CourseCode` int(11) NOT NULL,
  `NhapHoc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Gender` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `BacHoc` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Note` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`MSSV`),
  KEY `foreign_stu_course` (`CourseCode`),
  CONSTRAINT `foreign_stu_course` FOREIGN KEY (`CourseCode`) REFERENCES `course` (`CourseCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for studyresult
-- ----------------------------
DROP TABLE IF EXISTS `studyresult`;
CREATE TABLE `studyresult` (
  `MSSV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Mark` float NOT NULL,
  `Year` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Semester` tinyint(4) NOT NULL,
  PRIMARY KEY (`MSSV`,`SubCode`),
  KEY `foreign_res_subject` (`SubCode`),
  CONSTRAINT `foreign_res_stu` FOREIGN KEY (`MSSV`) REFERENCES `student` (`MSSV`),
  CONSTRAINT `foreign_res_subject` FOREIGN KEY (`SubCode`) REFERENCES `subject` (`SubCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `SubName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NumTC` tinyint(4) NOT NULL,
  `NumTCLT` tinyint(4) NOT NULL,
  `NumTCTH` tinyint(4) NOT NULL,
  PRIMARY KEY (`SubCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for subjectdetail
-- ----------------------------
DROP TABLE IF EXISTS `subjectdetail`;
CREATE TABLE `subjectdetail` (
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `PreSubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`SubCode`,`PreSubCode`),
  KEY `foreign_sub_detail2` (`PreSubCode`),
  CONSTRAINT `foreign_sub_detail1` FOREIGN KEY (`SubCode`) REFERENCES `subject` (`SubCode`),
  CONSTRAINT `foreign_sub_detail2` FOREIGN KEY (`PreSubCode`) REFERENCES `subject` (`SubCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Procedure structure for select_account
-- ----------------------------
DROP PROCEDURE IF EXISTS `select_account`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_account`(users varchar(30), pass varchar(30))
begin
select UserName, Passwords from  dangkyhocphan.Accounts
where UserName=users and Passwords=pass;
end;;
DELIMITER ;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `accounts` VALUES ('07520001', '07520001', 'Chu Văn An', '1', '0', '0');
INSERT INTO `accounts` VALUES ('07520012', '07520012', 'Lê Đức Anh', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520020', '07520020', 'Đặng Bảo Ân', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520087', '07520087', 'Phạm Hải Đường', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520098', '07520098', 'Đoàn Hữu Hạnh', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520106', '07520106', 'Hoàng Nam Hải', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520111', '07520111', 'Trương Thanh Tùng', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520112', '07520112', 'Nguyễn Đắc Thắng', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520113', '07520113', 'Trịnh Hoàng Việt Quốc', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520128', '07520128', 'Nguyễn Bảo Duy', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520210', '07520210', 'Nguyễn Văn Lộc', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520222', '07520222', 'Nguyễn Hữu Hải', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520234', '07520234', 'Chu Hoàng Nhật', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520235', '07520235', 'Nguyên Văn Nam', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520313', '07520313', 'Nguyễn Văn Tí', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520319', '07520319', 'Nguyễn Trung Thành', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520356', '07520356', 'Võ Như Thông', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520420', '07520420', 'Mai Đức An', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520444', '07520444', 'Nguyễn Đức Hạnh', '0', '0', '0');
INSERT INTO `accounts` VALUES ('admin', 'admin', 'admin', '0', '0', '1');
INSERT INTO `class` VALUES ('CNET1.B11', '1', '2009-2010', 'CNET1', 'GV05', '2', '203', '0', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('CNET1.B11', '1', '2010-2011', 'CNET1', 'GV05', '2', '204', '1', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('MAT04.B12', '1', '2010-2011', 'MAT04', 'GV07', '4', '302', '0', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('MLPE1.B25', '1', '2010-2011', 'MLPE1', 'GV08', '3', '207', '2', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('OSYS1.B12', '1', '2010-2011', 'OSYS1', 'GV07', '2', '108', '1', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('SE101.B11', '1', '2010-2011', 'SE101', 'GV01', '5', '106', '1', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('SE104.B13', '1', '2010-2011', 'SE104', 'GV02', '3', '201', '1', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('SE417.B12', '1', '2010-2011', 'SE417', 'GV01', '5', '108', '1', '1', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('SE418.B11', '1', '2010-2011', 'SE418', 'GV02', '6', '108', '0', '2', 'Null', 'Null', 'Null');
INSERT INTO `class` VALUES ('SMET2.B21', '1', '2010-2011', 'SMET2', 'GV09', '2', '208', '0', '1', 'Null', 'Null', 'Null');
INSERT INTO `classname` VALUES ('CNPM01');
INSERT INTO `classname` VALUES ('CNPM02');
INSERT INTO `comment` VALUES ('1', '########', 'Nguyen Trung Thanh', 'thanhnt28@gmail.com', 'Đề nghị khoa dạy nhiều môn học chuyên ngành trong học kỳ hè cho sinh viên học để kịp thời gian ra trường', '2011-05-07');
INSERT INTO `comment` VALUES ('2', '07520210', 'Nguyễn Văn Lộc', 'loc.uit@gmail.com', 'Comment này dùng để thử', '2011-06-16');
INSERT INTO `comment` VALUES ('3', '07520190', 'Nguyễn Đức Lê', 'lenguyen@gmail.com', 'Ý kiến về việc đóng học phí của phòng kế hoạch tài chính', '2011-06-16');
INSERT INTO `course` VALUES ('1', '2006', '2011', '2', '1');
INSERT INTO `course` VALUES ('2', '2007', '2012', '17', '2');
INSERT INTO `lecturer` VALUES ('GV01', 'Vũ Thanh Nguyên', '1956-01-01', 'nguyenvt@uit.edu.vn', '0989567432', 'Tp.HCM', 'Null', 'Tiến sĩ', 'Nam', '1234567890');
INSERT INTO `lecturer` VALUES ('GV02', 'Trần Anh Dũng', '1976-02-03', 'dungta@uit.edu.vn', '0977346123', 'Tp.HCm', 'null', 'Cao Học', 'Nam', '1234567890');
INSERT INTO `lecturer` VALUES ('GV04', 'Nguyễn Hữu Thương', '1984-04-16', 'thuongnh@uit.edu.vn', '0988456278', 'Hồ Chí Minh', 'Null', 'Thạc sĩ', 'Nam', '57686786786');
INSERT INTO `lecturer` VALUES ('GV05', 'Đàm Quang Hồng Hải', '1955-04-15', 'haidg@uit.edu.vn', '0989765432', 'Hồ Chí Minh', 'Null', 'Tiến sĩ', 'Nam', '45435464366');
INSERT INTO `lecturer` VALUES ('GV06', 'Huỳnh Ngọc Tín', '1971-04-08', 'tinhn@uit.edu.vn', '0989765432', 'Hồ Chí Minh', 'Null', 'Thạc sĩ', 'Nam', '123456789');
INSERT INTO `lecturer` VALUES ('GV07', 'Vũ Đức Lung', '1959-09-14', 'lungvd@uit.edu.vn', '0906456321', 'Hồ Chí Minh', 'Null', 'Tiến sĩ', 'Nam', '123456789');
INSERT INTO `lecturer` VALUES ('GV08', 'Đào Trọng Tấn', '1956-11-16', 'tandt@uit.edu.vn', '0937894521', 'Hồ Chí Minh', 'Null', 'Null', 'Nam', '1423353454');
INSERT INTO `lecturer` VALUES ('GV09', 'Hoàng Văn Kiếm', '1955-05-04', 'kiemhv@gmail.com', '0978563721', 'Hồ Chí Minh', 'Giáo sư', 'Tiến sĩ', 'Nam', '12325454');
INSERT INTO `lecturer` VALUES ('GV10', 'Nguyễn Trần Minh Khuê', '1978-06-12', 'khuentm@uit.edu.vn', '1683508402', 'Hồ Chí Minh', 'Null', 'Thạc sĩ', 'Nữ', '16454534654');
INSERT INTO `lecturer` VALUES ('GV11', 'Đinh Thị Thanh Trúc', '1978-06-13', 'trucdtt@uit.edu.vn', '1683508402', 'Hồ Chí Minh', 'Null', 'Thạc sĩ', 'Nữ', '12548798588');
INSERT INTO `lecturer` VALUES ('GV12', 'Phạm Thi Vương', '1978-06-14', 'vuongpt@uit.edu.vn', '1683508402', 'Hồ Chí Minh', 'Null', 'Thạc sĩ', 'Nam', '46553216544');
INSERT INTO `pro` VALUES ('1');
INSERT INTO `pro` VALUES ('2');
INSERT INTO `program` VALUES ('1', 'CARC1', '1');
INSERT INTO `program` VALUES ('1', 'CNET1', '3');
INSERT INTO `program` VALUES ('1', 'CSC21', '1');
INSERT INTO `program` VALUES ('1', 'DBSS1', '2');
INSERT INTO `program` VALUES ('1', 'DSAL1', '2');
INSERT INTO `program` VALUES ('1', 'HCMT1', '4');
INSERT INTO `program` VALUES ('1', 'ITEM1', '4');
INSERT INTO `program` VALUES ('1', 'ITEW1', '3');
INSERT INTO `program` VALUES ('1', 'LIA01', '3');
INSERT INTO `program` VALUES ('1', 'MAT04', '4');
INSERT INTO `program` VALUES ('1', 'MAT21', '1');
INSERT INTO `program` VALUES ('1', 'MAT22', '2');
INSERT INTO `program` VALUES ('1', 'OOPT1', '3');
INSERT INTO `program` VALUES ('1', 'OSYS1', '2');
INSERT INTO `program` VALUES ('1', 'PHIL2', '1');
INSERT INTO `program` VALUES ('1', 'PHY01', '1');
INSERT INTO `program` VALUES ('1', 'PHY02', '2');
INSERT INTO `program` VALUES ('1', 'SE101', '5');
INSERT INTO `program` VALUES ('1', 'SE102', '5');
INSERT INTO `program` VALUES ('1', 'SE103', '6');
INSERT INTO `program` VALUES ('1', 'SE104', '5');
INSERT INTO `program` VALUES ('1', 'SE105', '5');
INSERT INTO `program` VALUES ('1', 'SE106', '5');
INSERT INTO `program` VALUES ('1', 'SE207', '6');
INSERT INTO `program` VALUES ('1', 'SE208', '6');
INSERT INTO `program` VALUES ('1', 'SE209', '7');
INSERT INTO `program` VALUES ('1', 'SE210', '7');
INSERT INTO `program` VALUES ('1', 'SE211', '7');
INSERT INTO `program` VALUES ('1', 'SE212', '7');
INSERT INTO `program` VALUES ('1', 'SE213', '6');
INSERT INTO `program` VALUES ('1', 'SE31*', '5');
INSERT INTO `program` VALUES ('1', 'SE32*', '7');
INSERT INTO `program` VALUES ('1', 'SE33*', '8');
INSERT INTO `program` VALUES ('1', 'SE34*', '8');
INSERT INTO `program` VALUES ('1', 'SE417', '7');
INSERT INTO `program` VALUES ('1', 'SE418', '8');
INSERT INTO `program` VALUES ('1', 'SE501', '8');
INSERT INTO `program` VALUES ('1', 'SE502', '9');
INSERT INTO `program` VALUES ('1', 'SE503', '9');
INSERT INTO `program` VALUES ('1', 'SE504', '9');
INSERT INTO `program` VALUES ('1', 'SE505', '9');
INSERT INTO `program` VALUES ('1', 'SMET2', '4');
INSERT INTO `program` VALUES ('1', 'STA01', '4');
INSERT INTO `program` VALUES ('1', 'VCPL1', '4');
INSERT INTO `program` VALUES ('1', 'WINP1', '4');
INSERT INTO `program` VALUES ('2', 'CARC1', '2');
INSERT INTO `program` VALUES ('2', 'CNET1', '4');
INSERT INTO `program` VALUES ('2', 'CSC21', '1');
INSERT INTO `program` VALUES ('2', 'DBSS1', '3');
INSERT INTO `program` VALUES ('2', 'DSAL1', '2');
INSERT INTO `program` VALUES ('2', 'HCMT1', '4');
INSERT INTO `program` VALUES ('2', 'ITEM1', '3');
INSERT INTO `program` VALUES ('2', 'ITEW1', '2');
INSERT INTO `program` VALUES ('2', 'LIA01', '1');
INSERT INTO `program` VALUES ('2', 'MAT04', '4');
INSERT INTO `program` VALUES ('2', 'MAT21', '1');
INSERT INTO `program` VALUES ('2', 'MAT22', '2');
INSERT INTO `program` VALUES ('2', 'OOPT1', '3');
INSERT INTO `program` VALUES ('2', 'OSYS1', '3');
INSERT INTO `program` VALUES ('2', 'PHIL2', '2');
INSERT INTO `program` VALUES ('2', 'PHY01', '1');
INSERT INTO `program` VALUES ('2', 'PHY02', '2');
INSERT INTO `program` VALUES ('2', 'SE101', '5');
INSERT INTO `program` VALUES ('2', 'SE102', '5');
INSERT INTO `program` VALUES ('2', 'SE103', '5');
INSERT INTO `program` VALUES ('2', 'SE104', '5');
INSERT INTO `program` VALUES ('2', 'SE105', '5');
INSERT INTO `program` VALUES ('2', 'SE106', '6');
INSERT INTO `program` VALUES ('2', 'SE207', '6');
INSERT INTO `program` VALUES ('2', 'SE208', '6');
INSERT INTO `program` VALUES ('2', 'SE209', '6');
INSERT INTO `program` VALUES ('2', 'SE210', '7');
INSERT INTO `program` VALUES ('2', 'SE211', '7');
INSERT INTO `program` VALUES ('2', 'SE212', '7');
INSERT INTO `program` VALUES ('2', 'SE213', '7');
INSERT INTO `program` VALUES ('2', 'SE31*', '6');
INSERT INTO `program` VALUES ('2', 'SE32*', '7');
INSERT INTO `program` VALUES ('2', 'SE33*', '8');
INSERT INTO `program` VALUES ('2', 'SE34*', '8');
INSERT INTO `program` VALUES ('2', 'SE417', '7');
INSERT INTO `program` VALUES ('2', 'SE418', '8');
INSERT INTO `program` VALUES ('2', 'SE501', '8');
INSERT INTO `program` VALUES ('2', 'SE502', '9');
INSERT INTO `program` VALUES ('2', 'SE503', '9');
INSERT INTO `program` VALUES ('2', 'SE504', '9');
INSERT INTO `program` VALUES ('2', 'SE505', '9');
INSERT INTO `program` VALUES ('2', 'SMET2', '8');
INSERT INTO `program` VALUES ('2', 'STA01', '5');
INSERT INTO `program` VALUES ('2', 'VCPL1', '3');
INSERT INTO `program` VALUES ('2', 'WINP1', '4');
INSERT INTO `registry` VALUES ('07520210', 'CNET1.B11', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520210', 'MLPE1.B25', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'MLPE1.B25', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'OSYS1.B12', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE101.B11', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE104.B13', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE417.B12', '1', '2010-2011', null);
INSERT INTO `rule` VALUES ('1', '24', '14', '30', '15', '100', '30', '4.5', '60', '26');
INSERT INTO `student` VALUES ('Nguyễn Văn Tí', '06520313', '1989-01-17', 'CNPM01', 'cute@gmail.com', '0989568743', 'Quận Bình Thạnh', 'Nghệ An', 'Đang học', '1', '2006-9-10', 'Nam', '123456789', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Mai Đức An', '06520420', '1989-03-28', 'CNPM01', 'ducan@gmail.com', '2423435454', 'Ký túc xá ĐHQG Tp.HCm', 'Vĩnh Long', 'Đang học', '1', '2006-2-19', 'Nam', '242535434346', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Chu Văn An', '07520001', '1989-11-21', 'CNPm02', 'ancv@gmail.com', '142525525253', 'Quận 2', 'Khánh Hòa', 'Đang học', '2', '2007-09-12', 'Nam', '23525235235', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Lê Đức Anh', '07520012', '1989-12-12', 'CNPM02', 'anhld@gmail.com', '23423532532', 'Thủ Đức', 'Hà Nội', 'Đang học', '2', '2007-09-09', 'Nam', '2343253241', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Hải Đường', '07520087', '1989-11-12', 'CNPM02', 'duongnh@gmail.com', '124234424', 'Ký túc xá ', 'Tiền Giang', 'Đang học', '2', '2007-08-09', 'Nữ', '23423235252', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Đoàn Hữu Hạnh', '07520098', '1989-02-03', 'CNPM02', 'hanhdh@gmail.com', '34235235325', 'Quận Thủ Đức', 'Tiền Giang', 'Đang học', '2', '2007-08-11', 'Nam', '235325322532', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Hoàng Nam Hải', '07520106', '1989-05-17', 'CNPM02', 'cute@gmail.com', '325325325353', 'Thủ Đức', 'Lâm Đồng', 'Đang học', '2', '2007-9-10', 'Nam', '14423523535', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Trương Thanh Tùng', '07520111', '1989-09-09', 'CNPM02', 'locnv.uit@gmail.com', '1683508402', 'TP. Cà Mau', 'TP. Daklac', 'Đang học', '2', '2007-09-06', 'Nam', '123456789', 'Chính Qui', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Đắc Thắng', '07520112', '1989-07-27', 'CNPM02', 'thangnd@gmail.com', '1141241241', 'Quận Gò Vấp', 'ĐakLak', 'Đang học', '2', '2007-09-12', 'Nam', '423423423423', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Trịnh Hoàng Việt Quốc', '07520113', '1989-09-21', 'CNPM02', 'vietquoc@gmail.com', '35235235552', 'Thủ Đức', 'Phú Yên', 'Đang học', '2', '2007-08-09', 'Nam', '3432235325', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Bảo Duy', '07520128', '1989-04-23', 'CNPM02', 'duynb@gmail.com', '42423424424', 'Quận 3, Tp. HCM', 'Hồ Chí Minh', 'Đang học', '2', '2007-05-06', 'Nam', '235435454434', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Đức Lê', '07520190', '1989-01-02', 'CNPM02', 'ducle133@yahoo.com', '2343435435', 'Quận 1, Tp.HCM', 'Quận 1, Tp.HCM', 'Đang học', '2', '2007-9-6', 'Nam', '1232441', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Văn Lộc', '07520210', '1988-05-04', 'CNPM02', 'loc@uit.edu.vn', '089893429', 'Hồ Chí Minh', 'Ninh Bình', 'Đang học', '2', '2007-9-6', 'Nam', '34325345', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Hữu Hải', '07520222', '1989-09-08', 'CNPM02', 'hainh@gmail.com', '1683508402', 'TP. Hồ Chí Minh', 'TP. Ninh Bình', 'Đang học', '2', '2007-09-05', 'Nam', '123456789', 'Chính Qui', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Chu Hoàng Nhật', '07520234', '1989-06-12', 'CNPM02', 'nhatcn@gmail.com', '12423523532', 'Quận 9', 'Tây Ninh', 'Đang học', '2', '2007-09-19', 'Nam', '3534534534', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyên Văn Nam', '07520235', '1989-09-08', 'CNPM02', 'namnv@gmail.com', '28582572357', 'Quận Bình Thạnh', 'Nghệ An', 'Đang học', '2', '2007-09-23', 'Nam', '223523523', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Trung Thành', '07520319', '1988-08-02', 'CNPM02', 'thanhnt28@gmail.com', '0989432371', '9/32 khu phố 6, P.Linh Trung, Q.Thủ Đức, Tp.HCm', 'Xuân Liên-Nghi Xuân-Hà Tĩnh', 'Đang học', '2', '2007-9-9', 'Nam', '12345678', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Võ Như Thông', '07520356', '1989-06-09', 'CNPM02', 'thongvn@gmail.com', '2423235255', 'Quận 1, Tp. Hồ Chí Minh', 'Quận 1, Tp.HCM', 'Đang học', '2', '2007-09-08', 'Nam', '2434233444', 'Chính quy', 'Đại học', 'Null');
INSERT INTO `student` VALUES ('Nguyễn Đức Hạnh', '07520444', '1989-09-10', 'CNPM02', 'locnv.uit@gmail.com', '1683508402', 'TP. Hồ Chí Minh', 'TP. Ninh Bình', 'Đang học', '2', '2007-09-07', 'Nam', '123456789', 'Chính Qui', 'Đại học', 'Null');
INSERT INTO `studyresult` VALUES ('07520087', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520098', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520106', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520111', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520112', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520190', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520210', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520210', 'SE209', '8', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520222', 'CNET1', '4.5', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'CARC1 ', '8.5', '2008-2009', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'CNET1', '10', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'CSC21', '8.5', '2008-2009', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'DBSS1', '8.5', '2008-2009', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'DSAL1', '7', '2008-2009', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'HCMT1', '8', '2010-2011', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'ITEM1', '5.5', '2008-2009', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'ITEW1', '10', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'LIA01', '6.5', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT04', '7.5', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT21', '5', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT22', '8.5', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'OOPT1', '9', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'OSYS1', '8.5', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'PHIL2', '5', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'PHY01', '8', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'PHY02', '8', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE101', '9', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE102', '5', '2009-2010', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE103', '7', '2009-2010', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE104', '7.5', '2009-2010', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE105', '7.5', '2009-2010', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE106', '7', '2009-2010', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE207', '6', '2009-2010', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE208', '6.5', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE209', '6.5', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE210', '4.5', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE212', '10', '2007-2008', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'SE31*', '8', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'SE32*', '10', '2010-2011', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'STA01', '8.5', '2010-2011', '1');
INSERT INTO `studyresult` VALUES ('07520319', 'VCPL1', '6.5', '2008-2009', '2');
INSERT INTO `studyresult` VALUES ('07520319', 'WINP1', '7.5', '2010-2011', '1');
INSERT INTO `subject` VALUES ('Kiến trúc máy tính', 'CARC1', '3', '3', '0');
INSERT INTO `subject` VALUES ('Mạng máy tính', 'CNET1', '4', '3', '1');
INSERT INTO `subject` VALUES ('Tin học đại cương', 'CSC21', '4', '3', '1');
INSERT INTO `subject` VALUES ('Cơ sử dữ liệu', 'DBSS1', '4', '3', '1');
INSERT INTO `subject` VALUES ('Cấu trúc dữ liệu và giải thuật', 'DSAL1', '4', '3', '1');
INSERT INTO `subject` VALUES ('Tư tưởng Hồ Chí Minh', 'HCMT1', '2', '2', '0');
INSERT INTO `subject` VALUES ('Nhập môn quản trị doanh nghiệp', 'ITEM1', '2', '2', '0');
INSERT INTO `subject` VALUES ('Nhập môn công tác kỹ sư', 'ITEW1', '2', '2', '0');
INSERT INTO `subject` VALUES ('Đại số tuyến tính', 'LIA01', '3', '3', '0');
INSERT INTO `subject` VALUES ('Cấu trúc rời rạc', 'MAT04', '4', '4', '0');
INSERT INTO `subject` VALUES ('Toán cao cấp A1', 'MAT21', '3', '3', '0');
INSERT INTO `subject` VALUES ('Toán cao cấp A2', 'MAT22', '3', '3', '0');
INSERT INTO `subject` VALUES ('Kinh tế chính trị Mac-Lênin', 'MLPE1', '4', '4', '0');
INSERT INTO `subject` VALUES ('Lập trình hướng đối tượng', 'OOPT1', '4', '3', '1');
INSERT INTO `subject` VALUES ('Hệ điều hành', 'OSYS1', '4', '3', '1');
INSERT INTO `subject` VALUES ('Những NLCB chủ nghĩa Mác-Lênin', 'PHIL2', '5', '5', '0');
INSERT INTO `subject` VALUES ('Vật lý đại cương A1', 'PHY01', '3', '3', '0');
INSERT INTO `subject` VALUES ('Vật lý đại cương A2', 'PHY02', '3', '3', '0');
INSERT INTO `subject` VALUES ('Triêt học Mac-Lênin', 'PHYl2', '5', '5', '0');
INSERT INTO `subject` VALUES ('Phương pháp mô hình hóa', 'SE101', '3', '3', '0');
INSERT INTO `subject` VALUES ('Nhập môn phát triển game', 'SE102', '3', '2', '1');
INSERT INTO `subject` VALUES ('Các phương pháp lập trình', 'SE103', '3', '2', '1');
INSERT INTO `subject` VALUES ('Nhập môn công nghệ phần mềm', 'SE104', '4', '3', '1');
INSERT INTO `subject` VALUES ('Lập trình nhúng căn bản', 'SE105', '3', '2', '1');
INSERT INTO `subject` VALUES ('Đặc tả hình thức', 'SE106', '4', '4', '0');
INSERT INTO `subject` VALUES ('Phân tích thiết kế hệ thống', 'SE207', '4', '3', '1');
INSERT INTO `subject` VALUES ('Kiếm chứng phần mềm', 'SE208', '3', '2', '1');
INSERT INTO `subject` VALUES ('Phát triển, vận hành, bảo trì phần mềm', 'SE209', '3', '3', '0');
INSERT INTO `subject` VALUES ('Quản lý dự án công nghệ thông tin', 'SE210', '4', '3', '1');
INSERT INTO `subject` VALUES ('Phát triển phần mềm hướng đối tượng', 'SE211', '4', '3', '1');
INSERT INTO `subject` VALUES ('Phát triển phần mềm mã nguỗn mở', 'SE212', '3', '2', '1');
INSERT INTO `subject` VALUES ('Xử lý phân bố', 'SE213', '3', '2', '1');
INSERT INTO `subject` VALUES ('Các học phần tự chọn 1', 'SE31*', '4', '3', '1');
INSERT INTO `subject` VALUES ('Ngôn ngữ lập trình java', 'SE311', '4', '3', '1');
INSERT INTO `subject` VALUES ('Công Nghệ .Net', 'SE312', '4', '3', '1');
INSERT INTO `subject` VALUES ('Các học phần tự chọn 2', 'SE32*', '4', '3', '1');
INSERT INTO `subject` VALUES ('Chuyên đề J2EE', 'SE325', '4', '3', '1');
INSERT INTO `subject` VALUES ('Các học phần tự chọn 3', 'SE33*', '4', '3', '1');
INSERT INTO `subject` VALUES ('Chuyên đề E-commerce', 'SE331', '2', '2', '0');
INSERT INTO `subject` VALUES ('Một số thuật toán thông minh', 'SE337', '2', '2', '0');
INSERT INTO `subject` VALUES ('Các học phần tự chọn 4', 'SE34*', '4', '3', '1');
INSERT INTO `subject` VALUES ('Đồ án môn học mã nguồn mở', 'SE417', '2', '2', '0');
INSERT INTO `subject` VALUES ('Đồ án môn học chuyên nghành', 'SE418', '3', '3', '0');
INSERT INTO `subject` VALUES ('Thực tập cuối khóa', 'SE501', '3', '0', '3');
INSERT INTO `subject` VALUES ('Môn tốt nghiệp 1', 'SE502', '3', '0', '3');
INSERT INTO `subject` VALUES ('Môn tốt nghiệp 2', 'SE503', '3', '0', '3');
INSERT INTO `subject` VALUES ('Đồ án tốt nghiệp', 'SE504', '4', '0', '4');
INSERT INTO `subject` VALUES ('Khóa luận tốt nghiệp', 'SE505', '10', '0', '10');
INSERT INTO `subject` VALUES ('Phương pháp luận sáng tạo KH-CN', 'SMET2', '2', '2', '0');
INSERT INTO `subject` VALUES ('Xác xuất thống kê', 'STA01', '3', '3', '0');
INSERT INTO `subject` VALUES ('Đường Lối cách mạng đảng', 'VCPL1', '3', '3', '0');
INSERT INTO `subject` VALUES ('Lập trình trên Windows', 'WINP1', '4', '3', '1');
INSERT INTO `subjectdetail` VALUES ('DSAL1', 'CSC21');
INSERT INTO `subjectdetail` VALUES ('OOPT1', 'CSC21');
INSERT INTO `subjectdetail` VALUES ('SE104', 'DBSS1');
INSERT INTO `subjectdetail` VALUES ('SE102', 'OOPT1');
INSERT INTO `subjectdetail` VALUES ('SE103', 'OOPT1');
INSERT INTO `subjectdetail` VALUES ('SE105', 'OOPT1');
INSERT INTO `subjectdetail` VALUES ('SE211', 'OOPT1');
INSERT INTO `subjectdetail` VALUES ('WINP1', 'OOPT1');
INSERT INTO `subjectdetail` VALUES ('SE418', 'SE102');
INSERT INTO `subjectdetail` VALUES ('SE501', 'SE102');
INSERT INTO `subjectdetail` VALUES ('SE207', 'SE104');
INSERT INTO `subjectdetail` VALUES ('SE208', 'SE207');
INSERT INTO `subjectdetail` VALUES ('SE209', 'SE208');
INSERT INTO `subjectdetail` VALUES ('SE418', 'SE209');
INSERT INTO `subjectdetail` VALUES ('SE501', 'SE209');
INSERT INTO `subjectdetail` VALUES ('SE418', 'SE211');
INSERT INTO `subjectdetail` VALUES ('SE501', 'SE211');
INSERT INTO `subjectdetail` VALUES ('SE417', 'SE212');
INSERT INTO `subjectdetail` VALUES ('SE418', 'SE417');
INSERT INTO `subjectdetail` VALUES ('SE501', 'SE417');
INSERT INTO `subjectdetail` VALUES ('SE504', 'SE501');
INSERT INTO `subjectdetail` VALUES ('SE505', 'SE501');
INSERT INTO `subjectdetail` VALUES ('SE104', 'WINP1');

-- ----------------------------
-- Trigger structure for updateNumStudent
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `updateNumStudent` AFTER INSERT ON `registry` FOR EACH ROW BEGIN
       UPDATE dangkyhocphan.class set dangkyhocphan.class.NumOfStudent=dangkyhocphan.class.NumOfStudent+1 where dangkyhocphan.class. ClassName=NEW.ClassName;
  END;;
DELIMITER ;

-- ----------------------------
-- Trigger structure for updateNumStudent1
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `updateNumStudent1` BEFORE DELETE ON `registry` FOR EACH ROW BEGIN
       UPDATE dangkyhocphan.class set dangkyhocphan.class.NumOfStudent=dangkyhocphan.class.NumOfStudent-1 where dangkyhocphan.class. ClassName=OLD.ClassName;
  END;;
DELIMITER ;

-- ----------------------------
-- Trigger structure for studentacc
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `studentacc` BEFORE INSERT ON `student` FOR EACH ROW BEGIN
     INSERT into dangkyhocphan.accounts values(New.MSSV,New.MSSV,New.FullName ,0,0,0 );
  END;;
DELIMITER ;

-- ----------------------------
-- Trigger structure for InsertStudent
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `InsertStudent` AFTER INSERT ON `student` FOR EACH ROW BEGIN
       UPDATE dangkyhocphan.course set dangkyhocphan.course.NumOfStudent=dangkyhocphan.course.NumOfStudent+1 where dangkyhocphan.course.CourseCode=NEW.CourseCode;
  END;;
DELIMITER ;

-- ----------------------------
-- Trigger structure for DeleteStudent
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `DeleteStudent` BEFORE DELETE ON `student` FOR EACH ROW BEGIN
       UPDATE dangkyhocphan.course set dangkyhocphan.course.NumOfStudent=dangkyhocphan.course.NumOfStudent-1 where dangkyhocphan.course.CourseCode=OLD.CourseCode;
  END;;
DELIMITER ;

-- ----------------------------
-- Trigger structure for studentacc1
-- ----------------------------
DELIMITER ;;
CREATE TRIGGER `studentacc1` AFTER DELETE ON `student` FOR EACH ROW BEGIN
     delete from dangkyhocphan.accounts where UserName=Old.MSSV;
END;;
DELIMITER ;
