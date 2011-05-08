/*
MySQL Data Transfer
Source Host: localhost
Source Database: dangkyhocphan
Target Host: localhost
Target Database: dangkyhocphan
Date: 5/9/2011 12:37:45 AM
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
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `LectuerCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DateOfWeek` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Room` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `NumOfStudent` int(11) NOT NULL,
  `Time` tinyint(4) NOT NULL,
  PRIMARY KEY (`ClassName`),
  KEY `foreign_class_lec` (`LectuerCode`),
  KEY `foreign_class_sub` (`SubCode`),
  CONSTRAINT `foreign_class_lec` FOREIGN KEY (`LectuerCode`) REFERENCES `lecturer` (`LectuterCode`),
  CONSTRAINT `foreign_class_sub` FOREIGN KEY (`SubCode`) REFERENCES `subject` (`SubCode`)
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  KEY `foreign_course_pro` (`ProCode`),
  CONSTRAINT `foreign_course_pro` FOREIGN KEY (`ProCode`) REFERENCES `program` (`ProCode`)
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
-- Table structure for program
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `ProCode` int(11) NOT NULL,
  `SubCode` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ProCode`,`SubCode`),
  KEY `foreign_pro_sub` (`SubCode`),
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
  `Gender` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `CMND` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `BacHoc` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
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
INSERT INTO `accounts` VALUES ('07520210', '07520210', 'Nguyễn Văn Lộc', '0', '0', '0');
INSERT INTO `accounts` VALUES ('07520319', '07520319', 'Nguyễn Trung Thành', '0', '0', '0');
INSERT INTO `accounts` VALUES ('admin', 'admin', 'admin', '0', '0', '1');
INSERT INTO `class` VALUES ('SE101.B11', 'SE101', 'GV01', '2', '106', '0', '1');
INSERT INTO `class` VALUES ('SE104.B13', 'SE104', 'GV02', '3', '201', '0', '1');
INSERT INTO `class` VALUES ('SE417.B12', 'SE417', 'GV01', '5', '108', '0', '1');
INSERT INTO `comment` VALUES ('1', '########', 'Nguyen Thanh', 'thanhnt28@gmail.com', 'Comment 1', '2011-05-07');
INSERT INTO `comment` VALUES ('2', '########', 'Nguyen Thanh', 'thanhtrung.xl@gmail.com', 'Comment 2', '2011-05-07');
INSERT INTO `comment` VALUES ('3', '########', 'Nguyen Thanh', 'thanhtrung.xl@gmail.com', 'Comment 3', '2011-05-07');
INSERT INTO `comment` VALUES ('4', '########', 'Nguyen Thanh', 'thanhtrung.xl@gmail.com', 'Comment 4', '2011-05-07');
INSERT INTO `comment` VALUES ('5', '########', 'commnet mới', 'Nguyễn Thành', 'thanhtrung.xl@gmail.com', '2011-05-08');
INSERT INTO `comment` VALUES ('6', '07520319', 'Comment mới của ta', 'Nguyễn Trung Thành', 'thanhtrung.xl@gmail.com', '2011-05-08');
INSERT INTO `course` VALUES ('1', '2006', '2011', '100', '2');
INSERT INTO `course` VALUES ('2', '2007', '2012', '120', '2');
INSERT INTO `course` VALUES ('3', '2008', '2013', '110', '2');
INSERT INTO `course` VALUES ('4', '2009', '2014', '135', '2');
INSERT INTO `course` VALUES ('5', '2010', '2015', '111', '2');
INSERT INTO `lecturer` VALUES ('GV01', 'Vũ Thanh Nguyên', '1956-12-13', 'nguyenvt@yut.edu.vn', '0989567432', 'Tp.HCM', 'null', 'Tiến Sĩ', '', '');
INSERT INTO `lecturer` VALUES ('GV02', 'Trần Anh Dũng', '1976-02-03', 'dungta@uit.edu.vn', '0977346123', 'Tp.HCm', 'null', 'Cao Học', '', '');
INSERT INTO `lecturer` VALUES ('GV03', 'Nguyen Trung Thanh', '1987-08-02', 'thanhnt28@gmail.com', '0989432371', 'Hà Tĩnh', 'null', 'null', '', '');
INSERT INTO `program` VALUES ('2', 'CARC1');
INSERT INTO `program` VALUES ('2', 'CNET1');
INSERT INTO `program` VALUES ('2', 'CSC21');
INSERT INTO `program` VALUES ('2', 'DBSS1');
INSERT INTO `program` VALUES ('2', 'DSAL1');
INSERT INTO `program` VALUES ('2', 'HCMT1');
INSERT INTO `program` VALUES ('2', 'ITEM1');
INSERT INTO `program` VALUES ('2', 'ITEW1');
INSERT INTO `program` VALUES ('2', 'LIA01');
INSERT INTO `program` VALUES ('2', 'MAT04');
INSERT INTO `program` VALUES ('2', 'MAT21');
INSERT INTO `program` VALUES ('2', 'MAT22');
INSERT INTO `program` VALUES ('2', 'OOPT1');
INSERT INTO `program` VALUES ('2', 'OSYS1');
INSERT INTO `program` VALUES ('2', 'PHIL2');
INSERT INTO `program` VALUES ('2', 'PHY01');
INSERT INTO `program` VALUES ('2', 'PHY02');
INSERT INTO `program` VALUES ('2', 'SE101');
INSERT INTO `program` VALUES ('2', 'SE102');
INSERT INTO `program` VALUES ('2', 'SE103');
INSERT INTO `program` VALUES ('2', 'SE104');
INSERT INTO `program` VALUES ('2', 'SE105');
INSERT INTO `program` VALUES ('2', 'SE106');
INSERT INTO `program` VALUES ('2', 'SE207');
INSERT INTO `program` VALUES ('2', 'SE208');
INSERT INTO `program` VALUES ('2', 'SE209');
INSERT INTO `program` VALUES ('2', 'SE210');
INSERT INTO `program` VALUES ('2', 'SE211');
INSERT INTO `program` VALUES ('2', 'SE212');
INSERT INTO `program` VALUES ('2', 'SE213');
INSERT INTO `program` VALUES ('2', 'SE31*');
INSERT INTO `program` VALUES ('2', 'SE32*');
INSERT INTO `program` VALUES ('2', 'SE33*');
INSERT INTO `program` VALUES ('2', 'SE34*');
INSERT INTO `program` VALUES ('2', 'SE417');
INSERT INTO `program` VALUES ('2', 'SE418');
INSERT INTO `program` VALUES ('2', 'SE501');
INSERT INTO `program` VALUES ('2', 'SE502');
INSERT INTO `program` VALUES ('2', 'SE503');
INSERT INTO `program` VALUES ('2', 'SE504');
INSERT INTO `program` VALUES ('2', 'SE505');
INSERT INTO `program` VALUES ('2', 'SMET2');
INSERT INTO `program` VALUES ('2', 'STA01');
INSERT INTO `program` VALUES ('2', 'VCPL1');
INSERT INTO `program` VALUES ('2', 'WINP1');
INSERT INTO `registry` VALUES ('07520106', 'SE101.B11', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520106', 'SE104.B13', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520106', 'SE417.B12', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520210', 'SE101.B11', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520210', 'SE104.B13', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520210', 'SE417.B12', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE101.B11', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE104.B13', '1', '2010-2011', null);
INSERT INTO `registry` VALUES ('07520319', 'SE417.B12', '1', '2010-2011', null);
INSERT INTO `rule` VALUES ('1', '24', '14', '30', '15', '100', '30', '4.5', '60', '26');
INSERT INTO `student` VALUES ('Nguyễn Đức Lê', '07252190', '1989-10-23', 'CNPM02', 'ducle133@yahoo.com', '01211213478', 'Quận 1, Tp.HCm', 'Tp.HCm', 'Đang học', '2', 'Nam', '12345678', 'Chính quy', 'Đại học');
INSERT INTO `student` VALUES ('Hoàng Nam Hải', '07520106', '1989-01-01', 'CNPM02', 'namhai@gmail.com', '0978345095', 'Quận 12, Tp.HCM', 'Tỉnh Lâm Đồng', 'Đang học', '2', 'Nam', '12345678', 'Chính quy', 'Đại học');
INSERT INTO `student` VALUES ('Nguyễn Văn Lộc', '07520210', '1989-12-12', 'CNPM02', 'nguyenloc.uit@gmail.com', '01683452346', 'Tân Bình, Tp.HCM', 'Tỉnh Ninh Bình', 'Đang học', '2', 'Nam', '12345678', 'Chính quy', 'Đại học');
INSERT INTO `student` VALUES ('Nguyễn Trung Thành', '07520319', '1987-08-02', 'CNPM02', 'thanhnt28@gmail.com', '0989432371', '9/32 khu phố 6, P.Linh Trung, Q.Thủ Đức, Tp.HCm', 'Xuân Liên-Nghi Xuân-Hà Tĩnh', 'Đang học', '2', 'Nam', '12345678', 'Chính quy', 'Đại học');
INSERT INTO `studyresult` VALUES ('07520319', 'CARC1 ', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'CNET1', '8');
INSERT INTO `studyresult` VALUES ('07520319', 'CSC21', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'DBSS1', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'DSAL1', '7');
INSERT INTO `studyresult` VALUES ('07520319', 'ITEM1', '5.5');
INSERT INTO `studyresult` VALUES ('07520319', 'ITEW1', '10');
INSERT INTO `studyresult` VALUES ('07520319', 'LIA01', '6.5');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT04', '7.5');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT21', '5');
INSERT INTO `studyresult` VALUES ('07520319', 'MAT22', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'OOPT1', '9');
INSERT INTO `studyresult` VALUES ('07520319', 'OSYS1', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'PHIL2', '5');
INSERT INTO `studyresult` VALUES ('07520319', 'PHY01', '8');
INSERT INTO `studyresult` VALUES ('07520319', 'PHY02', '8');
INSERT INTO `studyresult` VALUES ('07520319', 'SE101', '9');
INSERT INTO `studyresult` VALUES ('07520319', 'SE102', '5');
INSERT INTO `studyresult` VALUES ('07520319', 'SE103', '7');
INSERT INTO `studyresult` VALUES ('07520319', 'SE104', '7.5');
INSERT INTO `studyresult` VALUES ('07520319', 'SE105', '7.5');
INSERT INTO `studyresult` VALUES ('07520319', 'SE106', '7');
INSERT INTO `studyresult` VALUES ('07520319', 'SE207', '6');
INSERT INTO `studyresult` VALUES ('07520319', 'SE208', '6.5');
INSERT INTO `studyresult` VALUES ('07520319', 'SE209', '6.5');
INSERT INTO `studyresult` VALUES ('07520319', 'STA01', '8.5');
INSERT INTO `studyresult` VALUES ('07520319', 'WINP1', '7.5');
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
INSERT INTO `subject` VALUES ('Các học phần tự chọn 2', 'SE32*', '4', '3', '1');
INSERT INTO `subject` VALUES ('Các học phần tự chọn 3', 'SE33*', '4', '3', '1');
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
