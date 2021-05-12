DROP DATABASE IF EXISTS Testing_System_Assignment_7;
CREATE DATABASE Testing_System_Assignment_7;
USE Testing_System_Assignment_7;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	DepartmentID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    DepartmentName		NVARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PositionName		ENUM ('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Email				VARCHAR(20) NOT NULL UNIQUE KEY,
    UserName			VARCHAR(20) NOT NULL UNIQUE KEY CHECK (LENGTH(UserName) >=6),
    FullName			NVARCHAR(30) NOT NULL,
    Gender				VARCHAR(20) NOT NULL,
    DepartmentID		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) 	REFERENCES Department(DepartmentID) ON DELETE CASCADE ,
    FOREIGN KEY (PositionID) 	REFERENCES `Position`(PositionID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    GroupName			VARCHAR(20) NOT NULL UNIQUE KEY CHECK (LENGTH(GroupName) >=8),
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID				TINYINT UNSIGNED NOT NULL,
    AccountID			TINYINT UNSIGNED NOT NULL,
    JoinDate			DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE ,
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    TypeName			ENUM ('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    CategoryName		ENUM ('Java', '.NET', 'SQL', 'Postman', 'Ruby') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Content				VARCHAR (100) NOT NULL,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    TypeID				TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE ,
    FOREIGN KEY (TypeID) 		REFERENCES TypeQuestion(TypeID) ON DELETE CASCADE ,
    FOREIGN KEY (CreatorID) 	REFERENCES `Account`(AccountID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content				VARCHAR (100) NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BIT DEFAULT 1,
    FOREIGN KEY (QuestionID) 	REFERENCES Question(QuestionID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
	`Code`				CHAR (10) NOT NULL,
	Title				VARCHAR(20) NOT NULL,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    Duration			TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
	FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID) ON DELETE CASCADE ,
    FOREIGN KEY (CreatorID) 	REFERENCES `Account`(AccountID) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID			TINYINT UNSIGNED NOT NULL,	
    QuestionID		TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (ExamID, QuestionID),
	FOREIGN KEY (ExamID) 		REFERENCES Exam(ExamID) ON DELETE CASCADE ,
	FOREIGN KEY (QuestionID) 	REFERENCES Question(QuestionID) ON DELETE CASCADE 
);

INSERT INTO Department(DepartmentName)
VALUES 
		(N'Giám đốc'	),
        (N'Phó giám đốc'),
        (N'Thư kí'		),
        (N'Sale'		),
        (N'Marketing'	),
        (N'IT'			),
        (N'Kĩ thuật'	),
        (N'Nhân sự'		),
        (N'Kế toán'		),
        (N'Bảo vệ'		),
        (N'Phòng chờ'	);

INSERT INTO `Position`(PositionName)
VALUES 
		('Dev'			),
        ('Test'			),
        ('Scrum Master'	),
        ('PM'			);
        
INSERT INTO `Account`(Email, UserName, FullName,Gender, DepartmentID, PositionID, CreateDate )
VALUES
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguyễn Văn A1','M', 1, 4, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguyễn Văn A2','M', 1, 3, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguyễn Văn A3','F', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguyễn Văn A4','M', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguyễn Văn A5','F', 5, 2, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguyễn Văn A6','F', 6, 1, '2020-04-05'),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguyễn Văn A7','M', 7, 1, NULL		),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguyễn Văn A8','U', 8, 1, '2020-04-07'),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguyễn Văn A9','F', 9, 2, '2020-04-07'),
        ('admin@gmail.com', 'abcxyz10', 'Nguyễn Văn A10','M', 10, 2, '2020-04-07');
        
INSERT INTO `Group`(GroupName, CreatorID, CreateDate)
VALUES
		('abcxy123', 1, '2020-12-20'),
        ('abcxy223', 2, '2018-03-20'),
        ('abcxy323', 3, '2017-02-20'),
        ('abcxy423', 4, '2020-04-20'),
        ('abcxy523', 5, '2020-05-20'),
        ('abcxy623', 6, '2020-12-20'),
        ('abcxy723', 7, '2019-12-20'),
        ('abcxy823', 8, '2020-12-21'),
        ('abcxy923', 9, '2019-10-20');
        
INSERT INTO GroupAccount(GroupID, AccountID, JoinDate)
VALUES
		(1,1, '2020-05-20'),
		(2,2, DEFAULT),
        (3,3, '2018-03-20'),
        (4,4, '2020-04-20'),
        (4,5, '2020-05-20'),
        (5,6, '2020-12-20'),
        (7,8, '2020-12-21');
        
INSERT INTO TypeQuestion(TypeName)
VALUES 
		('Essay'),
        ('Multiple-Choice');
        
INSERT INTO CategoryQuestion(CategoryName)
VALUES 
		('Java'),
        ('.NET'),
        ('SQL'),
        ('Postman'),
        ('Ruby');

INSERT INTO Question(Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES 
		('Java là gì', 1, 1, 1, '2020-02-13'),
        ('Java sử dụng ngôn ngữ gì', 1, 1, 1, '2020-02-15'),
        ('Java là gì', 1, 2, 2, '2020-02-28'),
        ('.NET là gì', 2, 1, 1, '2020-02-20'),
        ('.NET là gì', 2, 2, 3, '2020-07-13'),
		('SQL là gì', 3, 1, 3, NULL),
        ('SQL là gì', 3, 2, 5, '2020-05-13'),
        ('Postman là gì', 4, 1, 5, '2020-06-13'),
        ('Postman là gì', 4, 2, 6, '2020-02-17'),
        ('Ruby là gì', 5, 1, 7, '2021-05-01'),
        ('Ruby là gì', 5, 2, 8, '2021-05-02');

INSERT INTO Answer(Content, QuestionID, isCorrect)
VALUES
        ('Java là gì', 1, 1),
        ('Java sử dụng ngôn ngữ gì', 2, 1),
        ('Java là gì', 3, 0),
        ('.NET là gì', 4, 1),
        ('.NET là gì', 5, 0),
		('SQL là gì', 6, 1),
        ('SQL là gì', 7, 0),
        ('Postman là gì', 8, 1),
        ('Postman là gì', 9, 0),
        ('Ruby là gì', 10, 1),
        ('Ruby là gì', 11, 0);
        
INSERT INTO Exam(`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
		('JV1', 'Java', 1, 90, 1, '2020-12-30'),
        ('.NET1', '.NET', 2, 90, 2, '2020-03-12'),
        ('SQL1', 'SQL', 3, 90, 3, '2020-09-21'),
        ('Postman1', 'Postman', 4, 90, 1, '2020-10-23'),
        ('Ruby1', 'Ruby', 5, 90, 2, '2020-11-09');
        
INSERT INTO ExamQuestion(ExamID, QuestionID)
VALUES
        (1,1),
        (1,2),
        (1,3),
        (2,4),
        (2,5),
        (3,6),
        (3,7),
        (4,8),
        (4,9),
        (5,10),
        (5,11);


CREATE TABLE log_dep_name_acc (
	Id TINYINT AUTO_INCREMENT,
    UserName VARCHAR(20) NOT NULL,
    OldNameDep VARCHAR(30) NOT NULL,
    ChangeDate DATETIME NOT NULL,
    PRIMARY KEY (Id)
);
 

DROP TRIGGER IF EXISTS Trg_LogDepNameAcc;
DELIMITER $$
CREATE TRIGGER Trg_LogDepNameAcc
 AFTER UPDATE ON `account`
 FOR EACH ROW
 BEGIN
DECLARE DepName VARCHAR(20);
SELECT d.DepartmentName INTO DepName FROM `department` d WHERE  d.DepartmentID = OLD.DepartmentID;
INSERT INTO log_dep_name_acc (UserName, OldNameDep, ChangeDate) VALUES (OLD.UserName, DepName, now());
 END$$
 DELIMITER ;

UPDATE account SET DepartmentID = '5' WHERE (AccountID = '1');


-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo 
--  trước 1 năm trước

DROP TRIGGER IF EXISTS Trg_InsertGr;
DELIMITER $$
CREATE TRIGGER Trg_InsertGr
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN

IF (NEW.CreateDate <= DATE_SUB(CURRENT_DATE, INTERVAL 1 YEAR ) ) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Update This Group';
 END IF;
 END$$
 DELIMITER ;

INSERT INTO `group`	(GroupName, CreatorID, CreateDate)
VALUES 				('Group12346', 1, '2018-02-01');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào 
--  department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
--  "Sale" cannot add more user"

DROP TRIGGER IF EXISTS Trg_InsertUserToSale;
DELIMITER $$
CREATE TRIGGER Trg_InsertUserToSale
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
DECLARE DeptID TINYINT;
SELECT DepartmentID INTO DeptID
FROM Department
WHERE DepartmentName = 'Sale';
IF ( NEW.DepartmentID = DeptID) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
 END IF;
 END$$
 DELIMITER ;

INSERT INTO `Account`	(Email, UserName, FullName, DepartmentID, PositionID, CreateDate)
VALUES 				('Email@gmail.com','UserName1', 'FullName1', 4, 1, DEFAULT);

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user

DROP TRIGGER IF EXISTS Trg_LimitGr;
DELIMITER $$
CREATE TRIGGER Trg_LimitGr
BEFORE INSERT ON `GroupAccount`
FOR EACH ROW
BEGIN
IF ( SELECT COUNT(AccountID) 
FROM `GroupAccount` 
GROUP BY GroupID 
HAVING COUNT(AccountID) >= 5) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'This Group cannot add more user';
 END IF;
 END$$
 DELIMITER ;
 
INSERT INTO `GroupAccount`	(GroupID, AccountID, JoinDate)
VALUES 						(4, 1, DEFAULT);

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question

DROP TRIGGER IF EXISTS Trg_LimitEx;
DELIMITER $$
CREATE TRIGGER Trg_LimitEx
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN
IF ( SELECT COUNT(AccountID) 
FROM `ExamQuestion` 
GROUP BY ExamID 
HAVING COUNT(QuestionID) >= 10) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'This Exam cannot add more Questions';
 END IF;
 END$$
 DELIMITER ;

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là 
--  admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), 
--  còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông 
--  tin liên quan tới user đó
        
DROP TRIGGER IF EXISTS Trg_DelAccAdmin;
DELIMITER $$
CREATE TRIGGER Trg_DelAccAdmin
 BEFORE DELETE ON `account`
 FOR EACH ROW
 BEGIN
DECLARE Email VARCHAR(20);
 SELECT a.Email INTO Email 
 FROM `account` a 
 WHERE  a.AccountID = OLD.AccountID;
 IF Email = 'admin@gmail.com' THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Del This Account';
 END IF;
 END$$
 DELIMITER ;
 
DELETE FROM `account` a WHERE a.AccountID = 10;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table 
--  Account, hãy tạo trigger cho phép người dùng khi tạo account không điền 
--  vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_InsertAccToWaitDept;
DELIMITER $$
CREATE TRIGGER Trg_InsertAccToWaitDept
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
DECLARE Department TINYINT UNSIGNED;
SELECT d.DepartmentID INTO Department 
FROM Department d 
WHERE  DepartmentName = 'Phòng chờ';
IF NEW.DepartmentID IS NULL 
THEN SET NEW.DepartmentID = Department;
END IF;
END$$
 DELIMITER ;

INSERT INTO `Account`	(Email, UserName, FullName, PositionID, CreateDate)
VALUES 						('Email3@gamil.com', 'UserName3','FullName23', 1, DEFAULT);

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi 
--  question, trong đó có tối đa 2 đáp án đúng.

DROP TRIGGER IF EXISTS Trg_InsertAnsert;
DELIMITER $$
CREATE TRIGGER Trg_InsertAnsert
BEFORE INSERT ON Answer
FOR EACH ROW
BEGIN
DECLARE CountAnswer TINYINT UNSIGNED;
DECLARE CountCorrectAnswer TINYINT UNSIGNED;
SELECT COUNT(AnswerID) INTO CountAnswer 
FROM Answer
WHERE  QuestionID = NEW.QuestionID;

SELECT COUNT(AnswerID) INTO CountCorrectAnswer 
FROM Answer
WHERE  QuestionID = NEW.QuestionID AND isCorrect = 1;

IF CountAnswer >= 4 OR CountCorrectAnswer >= 2 IS NULL THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Add This Answer To Question';
END IF;
END$$
 DELIMITER ;

INSERT INTO Answer	(Content,QuestionID,isCorrect)
VALUES 						('Content Question', 1, 1);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: 
--  Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
--  Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP TRIGGER IF EXISTS Trg_Set_Gender;
DELIMITER $$
CREATE TRIGGER Trg_Set_Gender
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
		IF NEW.Gender = 'Nam' THEN
			SET NEW.Gender = 'M' ;
		ELSEIF NEW.Gender = 'Nữ' THEN
			SET NEW.Gender = 'F';
		ELSEIF NEW.Gender = 'Chưa xác định' THEN
			SET NEW.Gender = 'U';
END IF;
END$$
DELIMITER ;
 
INSERT INTO `Account`	(Email, UserName, FullName, Gender, DepartmentID, PositionID)
VALUES 					('Email2@gmail.com','UserName2','FullName1', 'Nữ', 1, 1);

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DROP TRIGGER IF EXISTS Trg_DelExam;
DELIMITER $$
CREATE TRIGGER Trg_DelExam
BEFORE DELETE ON Exam 
FOR EACH ROW
BEGIN
IF (OLD.CreateDate > DATE_SUB(NOW(), INTERVAL 2 DAY)) THEN

SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Delete This Exam';
END IF;
END$$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các 
--  question khi question đó chưa nằm trong exam nào

DROP TRIGGER IF EXISTS Trg_UpdateQuestion;
DELIMITER $$
CREATE TRIGGER Trg_UpdateQuestion
BEFORE UPDATE ON Question 
FOR EACH ROW
BEGIN
DECLARE Qs_Not_In_Exam TINYINT;
SET Qs_Not_In_Exam = -1;
SELECT COUNT(1) INTO Qs_Not_In_Exam
FROM ExamQuestion eq 
WHERE eq.QuestionID = NEW.QuestionID;

IF ( NEW.QuestionID != Qs_Not_In_Exam) THEN

SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Update This Exam';
END IF;
END$$
DELIMITER ;

UPDATE Question SET CreatorID = 2 WHERE QuestionID = 1;

DROP TRIGGER IF EXISTS Trg_DelQuestion;
DELIMITER $$
CREATE TRIGGER Trg_DelQuestion
BEFORE DELETE ON Question 
FOR EACH ROW
BEGIN
DECLARE Qs_Not_In_Exam TINYINT;
SET Qs_Not_In_Exam = -1;
SELECT COUNT(1) INTO Qs_Not_In_Exam
FROM ExamQuestion eq 
WHERE eq.QuestionID = OLD.QuestionID;

IF ( OLD.QuestionID != Qs_Not_In_Exam) THEN

SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Cant Delete This Exam';
END IF;
END$$
DELIMITER ;

DELETE FROM Question WHERE  QuestionID = 5;
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT ExamID,
		CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên 
--  là the_number_user_amount và mang giá trị được quy định như sau:2
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT GroupID,
		CASE 
			WHEN COUNT(AccountID) <= 5 THEN 'few'
            
            WHEN COUNT(AccountID) <= 20 THEN 'normal'
            ELSE 'higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào 
--  không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT d.DepartmentID,d.DepartmentName,
		CASE 
			WHEN COUNT(AccountID) = 0 THEN 'Không có User'
            ELSE COUNT(AccountID)
		END AS SL
FROM `Account` a
RIGHT JOIN Department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentID;






