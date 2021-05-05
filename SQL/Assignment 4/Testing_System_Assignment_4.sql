DROP DATABASE IF EXISTS Testing_System_Assignment_4;
CREATE DATABASE Testing_System_Assignment_4;
USE Testing_System_Assignment_4;

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
        ('abcxyz2@gmail.com', 'abcxyz2', 'Nguyễn Văn A2', 1, 3, '2020-03-05'),
        ('abcxyz3@gmail.com', 'abcxyz3', 'Nguyễn Văn A3', 3, 3, '2020-03-07'),
        ('abcxyz4@gmail.com', 'abcxyz4', 'Nguyễn Văn A4', 4, 4, '2020-03-08'),
        ('abcxyz5@gmail.com', 'abcxyz5', 'Nguyễn Văn A5', 5, 2, '2020-03-10'),
        ('abcxyz6@gmail.com', 'abcxyz6', 'Nguyễn Văn A6', 6, 1, '2020-04-05'),
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
        ('Java sử dụng ngôn ngữ gì', 1, 1, 1, '2020-02-15'),
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
        
-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ

SELECT A.AccountID, A.UserName, A.FullName, A.Email, D.DepartmentName FROM `account` A
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010

SELECT * FROM `account` A
WHERE CreateDate > '2010-12-20 00:00:00 ';

-- Question 3: Viết lệnh để lấy ra tất cả các developer 

SELECT A.AccountID, A.UserName, A.FullName, A.Email 
FROM `account` A
INNER JOIN `position` P ON A.PositionID = P.PositionID 
WHERE P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT D.DepartmentName, COUNT(A.DepartmentID) AS Soluong 
FROM `account` A
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID
GROUP BY D.DepartmentID 
HAVING Soluong > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT 		Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM		Question Q 
INNER JOIN 	ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(Q.Content) = (SELECT	MAX(CountQ)
								FROM		
										(SELECT 		Q.Content,COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ 
										INNER JOIN 		Question Q ON EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.Content) AS MaxContent);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

SELECT CQ.CategoryID, COUNT(Q.QuestionID) AS SoLuong FROM CategoryQuestion CQ
INNER JOIN Question Q ON CQ.CategoryID = Q.CategoryID
GROUP BY CQ.CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT q.QuestionID, COUNT(eq.QuestionID) AS SoLuong 
FROM Question q
INNER JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
GROUP BY eq.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất

SELECT QuestionID, COUNT(AnswerID) FROM Answer
GROUP BY QuestionID;

-- Question 9: Thống kê số lượng account trong mỗi group

SELECT GroupID, COUNT(AccountID) AS AccInGr FROM GroupAccount
GROUP BY GroupID;

-- Question 10: Tìm chức vụ có ít người nhất

SELECT P.PositionName, COUNT(p.PositionID) FROM `Account` A
INNER JOIN `Position` P ON A.PositionID = P.PositionID
GROUP BY P.PositionID;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT  A.DepartmentID, D.DepartmentName, P.PositionName, COUNT(P.PositionID) AS SL FROM `Account` A
INNER JOIN `Position` P ON A.PositionID = P.PositionID
INNER JOIN Department D ON A.DepartmentID = D.DepartmentID
GROUP BY   A.DepartmentID, P.PositionName;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của 
--  question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …

SELECT Q.CreatorID AS 'Người tạo' ,T.TypeName AS 'Loại câu hỏi', Q.Content AS 'Câu hỏi', AN.Content AS 'Câu trả lời'   FROM Question Q
INNER JOIN `account` A ON A.AccountID = Q.CreatorID
INNER JOIN	TypeQuestion T ON q.TypeID = T.TypeID
INNER JOIN Answer AN ON AN.QuestionID = Q.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm

SELECT TQ.TypeName, COUNT(QuestionID) AS SoLuong FROM Question Q
INNER JOIN TypeQuestion TQ on TQ.TypeID = Q.TypeID
GROUP BY TQ.TypeID;

-- Question 14:Lấy ra group không có account nào

SELECT * FROM `Group` G
LEFT JOIN GroupAccount GA ON G.GroupID = GA.GroupID
WHERE GA.AccountID IS NULL;

-- Question 16: Lấy ra question không có answer nào

SELECT * FROM Question Q
LEFT JOIN Answer A ON Q.QuestionID = A.QuestionID
WHERE A.QuestionID IS NULL;

-- Question 17: 
-- a) Lấy các account thuộc nhóm thứ 1

SELECT * FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GroupID = 1;

-- b) Lấy các account thuộc nhóm thứ 2

SELECT * FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GroupID = 2;

-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT * FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GroupID = 1
UNION
SELECT * FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
WHERE GroupID = 2;

-- Question 18: 
-- a) Lấy các group có lớn hơn 5 thành viên

SELECT GA.GroupID, COUNT(A.AccountID) AS SL FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GroupID
HAVING SL > 5;

-- b) Lấy các group có nhỏ hơn 7 thành viên

SELECT GA.GroupID, COUNT(A.AccountID) AS SL FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GroupID
HAVING SL < 7;

-- c) Ghép 2 kết quả từ câu a) và câu b)

SELECT GA.GroupID, COUNT(A.AccountID) AS SL FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GA.GroupID
HAVING SL > 5
UNION
SELECT GA.GroupID, COUNT(A.AccountID) AS SL FROM `Account` A
INNER JOIN GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GA.GroupID
HAVING SL < 7;


