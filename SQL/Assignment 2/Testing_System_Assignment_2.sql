DROP DATABASE IF EXISTS Testing_System_Assignment_2;
CREATE DATABASE Testing_System_Assignment_2;
USE Testing_System_Assignment_2;

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
	FOREIGN KEY (ExamID) 		REFERENCES Exam(ExamID),
	FOREIGN KEY (QuestionID) 	REFERENCES Question(QuestionID)
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
        (N'Bảo vệ'		);

INSERT INTO `Position`(PositionName)
VALUES 
		('Dev'			),
        ('Test'			),
        ('Scrum Master'	),
        ('PM'			);
        
INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID, CreateDate )
VALUES
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguyễn Văn A1', 1, 4, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguyễn Văn A2', 1, 4, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguyễn Văn A3', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguyễn Văn A4', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguyễn Văn A5', 5, 1, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguyễn Văn A6', 6, 3, '2020-04-05'),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguyễn Văn A7', 7, 1, NULL		),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguyễn Văn A8', 8, 1, '2020-04-07'),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguyễn Văn A9', 9, 2, '2020-04-07'),
        ('abcxyz10@gmail.com', 'abcxyz10', 'Nguyễn Văn A10', 10, 2, '2020-04-07');
        
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
        ('Java là gì', 1, 2, 2, '2020-02-28'),
        ('.NET là gì', 2, 1, 1, '2020-02-20'),
        ('.NET là gì', 2, 2, 3, '2020-07-13'),
		('SQL là gì', 3, 1, 3, NULL),
        ('SQL là gì', 3, 2, 5, '2020-05-13'),
        ('Postman là gì', 4, 1, 5, '2020-06-13'),
        ('Postman là gì', 4, 2, 6, '2020-02-17'),
        ('Ruby là gì', 5, 1, 7, '2020-01-20'),
        ('Ruby là gì', 5, 2, 8, '2020-12-13');

INSERT INTO Answer(Content, QuestionID, isCorrect)
VALUES
        ('Java là gì', 1, 1),
        ('Java là gì', 1, 0),
        ('.NET là gì', 2, 1),
        ('.NET là gì', 2, 0),
		('SQL là gì', 3, 1),
        ('SQL là gì', 3, 0),
        ('Postman là gì', 4, 1),
        ('Postman là gì', 4, 0),
        ('Ruby là gì', 5, 1),
        ('Ruby là gì', 5, 0);
        
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
        (2,3),
        (2,4),
        (3,5),
        (3,6),
        (4,7),
        (4,8),
        (5,9),
        (5,10);