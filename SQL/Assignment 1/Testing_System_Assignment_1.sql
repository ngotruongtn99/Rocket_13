DROP DATABASE IF EXISTS Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assignment_1;
USE Testing_System_Assignment_1;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	DepartmentID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    DepartmentName		NVARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PositionName		ENUM ('Dev', 'Test', 'Scrum Master', 'PM')
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Email				VARCHAR(20) NOT NULL UNIQUE KEY,
    UserName			VARCHAR(20) NOT NULL UNIQUE KEY,
    FullName			NVARCHAR(30) NOT NULL,
    DepartmentID		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    GroupName			VARCHAR(20) NOT NULL UNIQUE KEY,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID				TINYINT UNSIGNED NOT NULL,
    AccountID			TINYINT UNSIGNED NOT NULL,
    JoinDate			DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    TypeName			ENUM ('Essay', 'Multiple-Choice')
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    CategoryName		ENUM ('Java', '.NET', 'SQL', 'Postman', 'Ruby')
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
    PRIMARY KEY (ExamID, QuestionID)
);

INSERT INTO Department(DepartmentName)
VALUES 
		(N'Giám đốc'	),
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
        
INSERT INTO `Account`(Email, UserName, FullName, DepartmentID, PositionID )
VALUES
		('abcxyz1@gmail.com', 'abcxyz1', 'Nguyễn Văn A1', 1, 4),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguyễn Văn A2', 2, 2),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguyễn Văn A3', 3, 3),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguyễn Văn A4', 4, 4),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguyễn Văn A5', 5, 2),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguyễn Văn A6', 6, 3),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguyễn Văn A7', 7, 4),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguyễn Văn A8', 8, 1),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguyễn Văn A9', 9, 2);
        
INSERT INTO `Group`(GroupName, CreatorID)
VALUES
		('abcxy1', 1),
        ('abcxy2', 2),
        ('abcxy3', 3),
        ('abcxy4', 4),
        ('abcxy5', 5),
        ('abcxy6', 6),
        ('abcxy7', 7),
        ('abcxy8', 8),
        ('abcxy9', 9);
        
INSERT INTO GroupAccount(GroupID, AccountID)
VALUES
		(1,1),
		(2,2),
        (3,3),
        (4,4),
        (4,5),
        (5,6),
        (7,8);
        
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

INSERT INTO Question(Content, CategoryID, TypeID, CreatorID)
VALUES 
		('Java là gì', 1, 1, 1),
        ('Java là gì', 1, 2, 2),
        ('.NET là gì', 2, 1, 1),
        ('.NET là gì', 2, 2, 3),
		('SQL là gì', 3, 1, 3),
        ('SQL là gì', 3, 2, 5),
        ('Postman là gì', 4, 1, 5),
        ('Postman là gì', 4, 2, 6),
        ('Ruby là gì', 5, 1, 7),
        ('Ruby là gì', 5, 2, 8);

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
        
INSERT INTO Exam(`Code`, Title, CategoryID, Duration, CreatorID)
VALUES
		('JV1', 'Java', 1, 90, 1),
        ('.NET1', '.NET', 2, 90, 2),
        ('SQL1', 'SQL', 3, 90, 3),
        ('Postman1', 'Postman', 4, 90, 1),
        ('Ruby1', 'Ruby', 5, 90, 2);
        
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
	



        

        
        
