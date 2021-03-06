DROP DATABASE IF EXISTS Testing_System_Assignment_5;
CREATE DATABASE Testing_System_Assignment_5;
USE Testing_System_Assignment_5;

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
        (N'B???o v???'		);

INSERT INTO `Position`(PositionName)
VALUES 
		('Dev'			),
        ('Test'			),
        ('Scrum Master'	),
        ('PM'			);
        
INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate )
VALUES
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguy???n V??n A1', 1, 4, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguy???n V??n A2', 1, 3, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguy???n V??n A3', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguy???n V??n A4', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguy???n V??n A5', 5, 2, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguy???n V??n A6', 6, 1, '2020-04-05'),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguy???n V??n A7', 7, 1, NULL		),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguy???n V??n A8', 8, 1, '2020-04-07'),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguy???n V??n A9', 9, 2, '2020-04-07'),
        ('abcxyz10@gmail.com', 'abcxyz10', 'Nguy???n V??n A10', 10, 2, '2020-04-07');
        
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
        ('Ruby l?? g??', 5, 1, 7, '2020-01-20'),
        ('Ruby l?? g??', 5, 2, 8, '2020-12-13');

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
        
-- Question 1: T???o view c?? ch???a danh s??ch nh??n vi??n thu???c ph??ng ban sale        

CREATE OR REPLACE VIEW vw_AccSale AS
SELECT A.*, D.DepartmentName FROM `account` A
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID
WHERE DepartmentName = 'Sale';
SELECT * FROM vw_AccSale;

-- Question 2: T???o view c?? ch???a th??ng tin c??c account tham gia v??o nhi???u group nh???t
CREATE OR REPLACE VIEW vw_Acc_In_Group_Max AS
WITH CTE_Acc_In_Group_Max AS (
	SELECT COUNT(GA.AccountID) AS SL FROM groupaccount GA
	GROUP BY GA.AccountID
)
SELECT a.AccountID, a.FullName, GA.GroupID, COUNT(GA.AccountID) AS 'SL'  FROM groupaccount GA
INNER JOIN `account` a ON GA.AccountID = a.AccountID
GROUP BY GA.AccountID
HAVING COUNT(GA.AccountID) = (SELECT MAX(SL) FROM CTE_Acc_In_Group_Max);
SELECT * FROM vw_Acc_In_Group_Max;

-- Question 3: T???o view c?? ch???a c??u h???i c?? nh???ng content qu?? d??i (content qu?? 300 t??? 
--  ???????c coi l?? qu?? d??i) v?? x??a n?? ??i
CREATE OR REPLACE VIEW vw_ContentTooLong AS
SELECT * FROM Question
WHERE length(Content) > 30;

DELETE FROM vw_ContentTooLong;

-- Question 4: T???o view c?? ch???a danh s??ch c??c ph??ng ban c?? nhi???u nh??n vi??n nh???t
CREATE OR REPLACE VIEW vw_DEPT_ACC_MAX AS
WITH CTE_DEPT_ACC_MAX AS (
	SELECT COUNT(A.DepartmentID) AS SL FROM `Account` A
	GROUP BY A.DepartmentID 
)
SELECT D.DepartmentName, COUNT(A.DepartmentID) AS 'SL'  FROM `Account` A
INNER JOIN   Department D ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
HAVING COUNT(D.DepartmentID) = (SELECT MAX(SL) FROM CTE_DEPT_ACC_MAX );
SELECT * FROM vw_DEPT_ACC_MAX;

 
-- Question 5: T???o view c?? ch???a t???t c??c c??c c??u h???i do user h??? Nguy???n t???o 

CREATE OR REPLACE VIEW vw_Que5
AS
SELECT Q.CategoryID, Q.Content, A.FullName AS Creator FROM question Q
INNER JOIN account A ON A.AccountID = Q.CreatorID 
WHERE SUBSTRING_INDEX( A.FullName, ' ', 1 ) = 'Nguy???n';

SELECT * FROM vw_Que5;

