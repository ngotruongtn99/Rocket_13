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
		(N'Gi??m ?????c'	),
        (N'Ph?? gi??m ?????c'),
        (N'Th?? k??'		),
        (N'Sale'		),
        (N'Marketing'	),
        (N'IT'			),
        (N'K?? thu???t'	),
        (N'Nh??n s???'		),
        (N'K??? to??n'		),
        (N'B???o v???'		),
        (N'Ph??ng ch???'	);

INSERT INTO `Position`(PositionName)
VALUES 
		('Dev'			),
        ('Test'			),
        ('Scrum Master'	),
        ('PM'			);
        
INSERT INTO `Account`(Email, UserName, FullName,Gender, DepartmentID, PositionID, CreateDate )
VALUES
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguy???n V??n A1','M', 1, 4, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguy???n V??n A2','M', 1, 3, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguy???n V??n A3','F', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguy???n V??n A4','M', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguy???n V??n A5','F', 5, 2, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguy???n V??n A6','F', 6, 1, '2020-04-05'),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguy???n V??n A7','M', 7, 1, NULL		),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguy???n V??n A8','U', 8, 1, '2020-04-07'),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguy???n V??n A9','F', 9, 2, '2020-04-07'),
        ('admin@gmail.com', 'abcxyz10', 'Nguy???n V??n A10','M', 10, 2, '2020-04-07');
        
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
		('Java l?? g??', 1, 1, 1, '2020-02-13'),
        ('Java s??? d???ng ng??n ng??? g??', 1, 1, 1, '2020-02-15'),
        ('Java l?? g??', 1, 2, 2, '2020-02-28'),
        ('.NET l?? g??', 2, 1, 1, '2020-02-20'),
        ('.NET l?? g??', 2, 2, 3, '2020-07-13'),
		('SQL l?? g??', 3, 1, 3, NULL),
        ('SQL l?? g??', 3, 2, 5, '2020-05-13'),
        ('Postman l?? g??', 4, 1, 5, '2020-06-13'),
        ('Postman l?? g??', 4, 2, 6, '2020-02-17'),
        ('Ruby l?? g??', 5, 1, 7, '2021-05-01'),
        ('Ruby l?? g??', 5, 2, 8, '2021-05-02');

INSERT INTO Answer(Content, QuestionID, isCorrect)
VALUES
        ('Java l?? g??', 1, 1),
        ('Java s??? d???ng ng??n ng??? g??', 2, 1),
        ('Java l?? g??', 3, 0),
        ('.NET l?? g??', 4, 1),
        ('.NET l?? g??', 5, 0),
		('SQL l?? g??', 6, 1),
        ('SQL l?? g??', 7, 0),
        ('Postman l?? g??', 8, 1),
        ('Postman l?? g??', 9, 0),
        ('Ruby l?? g??', 10, 1),
        ('Ruby l?? g??', 11, 0);
        
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


-- Question 1: T???o trigger kh??ng cho ph??p ng?????i d??ng nh???p v??o Group c?? ng??y t???o 
--  tr?????c 1 n??m tr?????c

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

-- Question 2: T???o trigger Kh??ng cho ph??p ng?????i d??ng th??m b???t k??? user n??o v??o 
--  department "Sale" n???a, khi th??m th?? hi???n ra th??ng b??o "Department
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

-- Question 3: C???u h??nh 1 group c?? nhi???u nh???t l?? 5 user

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

-- Question 4: C???u h??nh 1 b??i thi c?? nhi???u nh???t l?? 10 Question

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

-- Question 5: T???o trigger kh??ng cho ph??p ng?????i d??ng x??a t??i kho???n c?? email l?? 
--  admin@gmail.com (????y l?? t??i kho???n admin, kh??ng cho ph??p user x??a), 
--  c??n l???i c??c t??i kho???n kh??c th?? s??? cho ph??p x??a v?? s??? x??a t???t c??? c??c th??ng 
--  tin li??n quan t???i user ????
        
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

-- Question 6: Kh??ng s??? d???ng c???u h??nh default cho field DepartmentID c???a table 
--  Account, h??y t???o trigger cho ph??p ng?????i d??ng khi t???o account kh??ng ??i???n 
--  v??o departmentID th?? s??? ???????c ph??n v??o ph??ng ban "waiting Department"

DROP TRIGGER IF EXISTS Trg_InsertAccToWaitDept;
DELIMITER $$
CREATE TRIGGER Trg_InsertAccToWaitDept
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
DECLARE Department TINYINT UNSIGNED;
SELECT d.DepartmentID INTO Department 
FROM Department d 
WHERE  DepartmentName = 'Ph??ng ch???';
IF NEW.DepartmentID IS NULL 
THEN SET NEW.DepartmentID = Department;
END IF;
END$$
 DELIMITER ;

INSERT INTO `Account`	(Email, UserName, FullName, PositionID, CreateDate)
VALUES 						('Email3@gamil.com', 'UserName3','FullName23', 1, DEFAULT);

-- Question 7: C???u h??nh 1 b??i thi ch??? cho ph??p user t???o t???i ??a 4 answers cho m???i 
--  question, trong ???? c?? t???i ??a 2 ????p ??n ????ng.

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

-- Question 8: Vi???t trigger s???a l???i d??? li???u cho ????ng: 
--  N???u ng?????i d??ng nh???p v??o gender c???a account l?? nam, n???, ch??a x??c ?????nh 
--  Th?? s??? ?????i l???i th??nh M, F, U cho gi???ng v???i c???u h??nh ??? database

DROP TRIGGER IF EXISTS Trg_Set_Gender;
DELIMITER $$
CREATE TRIGGER Trg_Set_Gender
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
		IF NEW.Gender = 'Nam' THEN
			SET NEW.Gender = 'M' ;
		ELSEIF NEW.Gender = 'N???' THEN
			SET NEW.Gender = 'F';
		ELSEIF NEW.Gender = 'Ch??a x??c ?????nh' THEN
			SET NEW.Gender = 'U';
END IF;
END$$
DELIMITER ;
 
INSERT INTO `Account`	(Email, UserName, FullName, Gender, DepartmentID, PositionID)
VALUES 					('Email2@gmail.com','UserName2','FullName1', 'N???', 1, 1);

-- Question 9: Vi???t trigger kh??ng cho ph??p ng?????i d??ng x??a b??i thi m???i t???o ???????c 2 ng??y

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

-- Question 10: Vi???t trigger ch??? cho ph??p ng?????i d??ng ch??? ???????c update, delete c??c 
--  question khi question ???? ch??a n???m trong exam n??o

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
-- Question 12: L???y ra th??ng tin exam trong ????:
-- Duration <= 30 th?? s??? ?????i th??nh gi?? tr??? "Short time"
-- 30 < Duration <= 60 th?? s??? ?????i th??nh gi?? tr??? "Medium time"
-- Duration > 60 th?? s??? ?????i th??nh gi?? tr??? "Long time"

SELECT ExamID,
		CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;

-- Question 13: Th???ng k?? s??? account trong m???i group v?? in ra th??m 1 column n???a c?? t??n 
--  l?? the_number_user_amount v?? mang gi?? tr??? ???????c quy ?????nh nh?? sau:2
-- N???u s??? l?????ng user trong group =< 5 th?? s??? c?? gi?? tr??? l?? few
-- N???u s??? l?????ng user trong group <= 20 v?? > 5 th?? s??? c?? gi?? tr??? l?? normal
-- N???u s??? l?????ng user trong group > 20 th?? s??? c?? gi?? tr??? l?? higher

SELECT GroupID,
		CASE 
			WHEN COUNT(AccountID) <= 5 THEN 'few'
            
            WHEN COUNT(AccountID) <= 20 THEN 'normal'
            ELSE 'higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;

-- Question 14: Th???ng k?? s??? m???i ph??ng ban c?? bao nhi??u user, n???u ph??ng ban n??o 
--  kh??ng c?? user th?? s??? thay ?????i gi?? tr??? 0 th??nh "Kh??ng c?? User"

SELECT d.DepartmentID,d.DepartmentName,
		CASE 
			WHEN COUNT(AccountID) = 0 THEN 'Kh??ng c?? User'
            ELSE COUNT(AccountID)
		END AS SL
FROM `Account` a
RIGHT JOIN Department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentID;






