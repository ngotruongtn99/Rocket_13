DROP DATABASE IF EXISTS Testing_System_Assignment_3;
CREATE DATABASE Testing_System_Assignment_3;
USE Testing_System_Assignment_3;

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
    Email				VARCHAR(30) NOT NULL UNIQUE KEY,
    UserName			VARCHAR(20) NOT NULL UNIQUE KEY CHECK (LENGTH(UserName) >=6),
    FullName			NVARCHAR(30) NOT NULL,
    DepartmentID		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) 	REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) 	REFERENCES `Position`(PositionID)
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    GroupName			VARCHAR(20) NOT NULL UNIQUE KEY CHECK (LENGTH(GroupName) >=8),
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID				TINYINT UNSIGNED NOT NULL,
    AccountID			TINYINT UNSIGNED NOT NULL,
    JoinDate			DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
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
    FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (TypeID) 		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) 	REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
	Content				VARCHAR (100) NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BIT DEFAULT 1,
    FOREIGN KEY (QuestionID) 	REFERENCES Question(QuestionID)
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
	FOREIGN KEY (CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY (CreatorID) 	REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID			TINYINT UNSIGNED NOT NULL,	
    QuestionID		TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (ExamID, QuestionID),
	FOREIGN KEY (ExamID) 		REFERENCES Exam(ExamID) ON DELETE CASCADE,
	FOREIGN KEY (QuestionID) 	REFERENCES Question(QuestionID)ON DELETE CASCADE
);

-- Question 1: Th??m ??t nh???t 10 record v??o m???i table

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
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguy???n V??n Nam', 1, 4, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguy???n V??n A2', 2, 4, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguy???n V??n Nh???t', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguy???n V??n T??', 3, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguy???n V??n Tr?????ng', 3, 1, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'D????ng V??n ?????o', 2, 3, '2020-04-05'),
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
        ('Java l?? g??', 1, 0),
        ('.NET l?? g??', 2, 1),
        ('.NET l?? g??', 2, 0),
		('SQL l?? g??', 3, 1),
        ('SQL l?? g??', 3, 0),
        ('Postman l?? g??', 4, 1),
        ('Postman l?? g??', 4, 0),
        ('Ruby l?? g??', 5, 1),
        ('Ruby l?? g??', 5, 0);
        
INSERT INTO Exam(`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
		('JV1', 'Java', 1, 90, 1, '2020-12-30'),
        ('.NET1', '.NET', 2, 90, 2, '2020-03-12'),
        ('SQL1', 'SQL', 3, 90, 3, '2020-09-21'),
        ('Postman1', 'Postman', 4, 90, 1, '2020-10-23'),
        ('Ruby1', 'Ruby', 5, 90, 2, '2019-11-09');
        
INSERT INTO ExamQuestion(ExamID, QuestionID)
VALUES
        (1,1),
        (1,2),
        (2,3),
        (2,4),
        (3,5),
        (3,6),
        (4,7),
        (4,8),
        (5,9),
        (5,10);
        

 
-- Question 2: l???y ra t???t c??? c??c ph??ng ban

SELECT * FROM Department;

-- Question 3: l???y ra id c???a ph??ng ban "Sale"

SELECT DepartmentID FROM Department WHERE DepartmentName = 'Sale';

-- Question 4: l???y ra th??ng tin account c?? full name d??i nh???t

SELECT  * FROM `Account`
WHERE LENGTH(FullName) = (SELECT MAX(length(FullName)) FROM `Account`);

-- Question 5: L???y ra th??ng tin account c?? full name d??i nh???t v?? thu???c ph??ng ban c?? id = 3
-- C??ch 1
SELECT  * FROM `Account`
WHERE DepartmentID = 3 
AND LENGTH(FullName) = (SELECT MAX(length(FullName)) 
                        FROM `Account` 
                        WHERE DepartmentID = 3 );

-- C??ch 2
WITH CTE_GetFullNameMax AS (
	SELECT MAX(length(FullName)) 
                        FROM `Account` 
                        WHERE DepartmentID = 3 
)
SELECT  * FROM `Account`
WHERE DepartmentID = 3 
AND LENGTH(FullName) = (SELECT * FROM CTE_GetFullNameMax);



-- Question 6: L???y ra t??n group ???? tham gia tr?????c ng??y 20/12/2019

SELECT GroupName FROM `group`
WHERE CreateDate < '2019-12-20 00:00:00';

-- Question 7: L???y ra ID c???a question c?? >= 4 c??u tr??? l???i

SELECT QuestionID, COUNT(AnswerID) FROM Answer
GROUP BY QuestionID
HAVING COUNT(AnswerID) >= 4;

-- Question 8: L???y ra c??c m?? ????? thi c?? th???i gian thi >= 60 ph??t v?? ???????c t???o tr?????c ng??y 20/12/2019

SELECT `Code` FROM Exam
WHERE Duration >= 60 AND CreateDate < '2019-12-20';

-- Question 9: L???y ra 5 group ???????c t???o g???n ????y nh???t

SELECT * FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: ?????m s??? nh??n vi??n thu???c department c?? id = 2

SELECT DepartmentID, COUNT(DepartmentID) AS SoLuong FROM `Account`
GROUP BY DepartmentID
HAVING DepartmentID = 2;

-- Question 11: L???y ra nh??n vi??n c?? t??n b???t ?????u b???ng ch??? "D" v?? k???t th??c b???ng ch??? "o"

SELECT * FROM `Account`
WHERE FullName LIKE 'D%o';

-- Question 12: X??a t???t c??? c??c exam ???????c t???o tr?????c ng??y 20/12/2019

DELETE FROM Exam WHERE CreateDate < '2019-12-20';

-- Question 13: X??a t???t c??? c??c question c?? n???i dung b???t ?????u b???ng t??? "c??u h???i"

DELETE FROM Question WHERE SUBSTRING_INDEX(Content, ' ', 2) = 'c??u h???i';

-- Question 14: Update th??ng tin c???a account c?? id = 5 th??nh t??n "Nguy???n B?? L???c" v?? 
--  email th??nh loc.nguyenba@vti.com.vn

UPDATE 	`account`
SET 			FullName = 'Nguy???n B?? L???c',
				Email = 'loc.nguyenba@vti.com.vn'
WHERE 	AccountID = 5;

-- Question 15: update account c?? id = 5 s??? thu???c group c?? id = 4

UPDATE 	GroupAccount
SET 			GroupID = 4
WHERE 	AccountID = 5;

