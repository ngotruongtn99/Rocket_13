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
    PositionName		ENUM ('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE KEY
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
    FOREIGN KEY (DepartmentID) 	REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) 	REFERENCES `Position`(PositionID)
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
		('abcxyz1@gmail.com', 'abcxyz1', 'Ban', 1, 2, '2020-03-05'),
        ('abcxyz2@gmail.com', 'abcxyz2', 'Bna', 1, 2, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguy???n V??n A3', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguy???n V??n A4', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguy???n V??n A5', 5, 2, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguy???n V??n A6', 6, 3, '2020-04-05'),
        ('abcxyz7@gmail.com', 'abcxyz7', 'Nguy???n V??n A7', 7, 4, NULL		),
        ('abcxyz8@gmail.com', 'abcxyz8', 'Nguy???n V??n A8', 8, 1, '2020-04-07'),
        ('abcxyz9@gmail.com', 'abcxyz9', 'Nguy???n V??n A9', 9, 2, '2020-04-07'),
        ('abcxyz10@gmail.com', 'abcxyz10', 'Nguy???n V??n A10', 10, 2, '2020-04-07');
        
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
		('Java l?? g??', 1, 1, 1),
        ('Java l?? g??', 1, 2, 2),
        ('.NET l?? g??', 2, 1, 1),
        ('.NET l?? g??', 2, 2, 3),
		('SQL l?? g??', 3, 1, 3),
        ('SQL l?? g??', 3, 2, 5),
        ('Postman l?? g??', 4, 1, 5),
        ('Postman l?? g??', 4, 2, 6),
        ('Ruby l?? g??', 5, 1, 7),
        ('Ruby l?? g??', 5, 2, 8);

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