DROP DATABASE IF EXISTS Testing_System_Assignment_6;
CREATE DATABASE Testing_System_Assignment_6;
USE Testing_System_Assignment_6;

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
        
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các 
--  account thuộc phòng ban đó

SELECT * FROM  `Account` a
INNER JOIN Department d ON d.DepartmentID = a.DepartmentID
WHERE  DepartmentName = 'Sale'

DROP PROCEDURE IF EXISTS sp_getAccFromDeptName
DELIMITER $$ 	
CREATE PROCEDURE sp_getAccFromDeptName (IN in_deptName VARCHAR(50))
			BEGIN
				SELECT * FROM  `Account` a
				INNER JOIN Department d ON d.DepartmentID = a.DepartmentID
				WHERE  DepartmentName = in_deptName;
			END$$
DELIMITER ;

CALL sp_getAccFromDeptName('Giám đốc');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_getCountAccFromGroupName
DELIMITER $$ 	
CREATE PROCEDURE sp_getCountAccFromGroupName (IN in_GroupName VARCHAR(50))
			BEGIN
				SELECT g.GroupName, Count(1) FROM groupaccount  ga
				INNER JOIN `Group` g ON g.GroupID = ga.GroupID
				WHERE GroupName = in_GroupName;
			END$$
DELIMITER ;

CALL sp_getCountAccFromGroupName('abcxy323');

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo 
--  trong tháng hiện tại

DROP PROCEDURE IF EXISTS sp_getCountQuesFromTypeQ
DELIMITER $$ 	
CREATE PROCEDURE sp_getCountQuesFromTypeQ ()
			BEGIN
				SELECT tq.TypeName, Count(q.TypeID) FROM Question  q
				INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
				WHERE month(q.CreateDate) = month(now()) AND year(q.CreateDate) = year(now())
                GROUP BY q.TypeID;
			END$$
DELIMITER ;

CALL sp_getCountQuesFromTypeQ();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS sp_getIdFromTypeQuesMax;
DELIMITER $$ 	
CREATE PROCEDURE sp_getIdFromTypeQuesMax (OUT out_TypeID TINYINT)
			BEGIN
				WITH CTE_MaxTypeQ AS (
				SELECT COUNT(q.TypeID) AS SL FROM Question q
				GROUP BY q.TypeID)
				SELECT q.TypeID INTO out_TypeID FROM Question q
				INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
				GROUP BY q.TypeID
				HAVING COUNT(q.TypeID) = (SELECT MAX(SL) FROM CTE_MaxTypeQ);
			END$$
DELIMITER ;
SET @ID = 0;
CALL sp_getIdFromTypeQuesMax(@ID);
SELECT @ID;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS sp_getTypeNameFromTypeQuesMax;
DELIMITER $$ 	
CREATE PROCEDURE sp_getTypeNameFromTypeQuesMax (OUT out_TypeName ENUM('Essay','Multiple-Choice'))
			BEGIN
				WITH CTE_MaxTypeQ AS (
				SELECT COUNT(q.TypeID) AS SL FROM Question q
				GROUP BY q.TypeID)
				SELECT tq.TypeName INTO out_TypeName FROM Question q
				INNER JOIN TypeQuestion tq ON q.TypeID = tq.TypeID
				GROUP BY q.TypeID
				HAVING COUNT(q.TypeID) = (SELECT MAX(SL) FROM CTE_MaxTypeQ);
			END$$
DELIMITER ;

SET @Type_Name = '';
CALL sp_getTypeNameFromTypeQuesMax(@Type_Name);
SELECT @Type_Name;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
--  chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
--  chuỗi của người dùng nhập vào

-- Cách 1
DROP PROCEDURE IF EXISTS sp_GetGr_GetUser;
DELIMITER $$ 	
CREATE PROCEDURE sp_GetGr_GetUser (in in_StringInput VARCHAR(20), IN in_select TINYINT)
			BEGIN
				IF in_select = 1 THEN 
                SELECT * FROM  `Group`
				WHERE GroupName LIKE CONCAT("%", in_StringInput, "%") ;
                ELSE
                SELECT * FROM `account`
				WHERE UserName LIKE CONCAT("%", in_StringInput, "%");
                END IF;
			END$$
DELIMITER ;

CALL sp_GetGr_GetUser('abc',1);


-- Cách 2
DROP PROCEDURE IF EXISTS GetGroupOrUserName;
DELIMITER $$
CREATE PROCEDURE GetGroupOrUserName(IN var_String VARCHAR(50))
BEGIN
		SELECT g.GroupName FROM  `Group` g
		WHERE g.GroupName LIKE CONCAT("%", var_String, "%") 
		UNION 
		SELECT a.UserName FROM `account` a
		WHERE a.UserName LIKE CONCAT("%", var_String, "%");
END$$
DELIMITER ;
Call GetGroupOrUserName('123');
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và 
--  trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
--  Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_InsertAccByEmFulN;
DELIMITER $$
CREATE PROCEDURE sp_InsertAccByEmFulN(IN var_Email VARCHAR(20), IN var_FullName VARCHAR(30) ) 
BEGIN
	DECLARE v_UserName VARCHAR(20) DEFAULT SUBSTRING_INDEX(var_Email, '@', 1);
	DECLARE v_DepartmentID TINYINT UNSIGNED DEFAULT 11;
	DECLARE v_PositionID TINYINT UNSIGNED DEFAULT 1;
	INSERT INTO `Account` 	(FullName, UserName, Email, DepartmentID, PositionID)
	VALUES 
							(var_FullName, v_UserName, var_Email, v_DepartmentID, v_PositionID);
END$$
DELIMITER ;
Call sp_InsertAccByEmFulN('ngotruong@gmail.com', 'Ngo Truong');


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
--  để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS sp_QsContenMax_Type;
DELIMITER $$
CREATE PROCEDURE sp_QsContenMax_Type(IN in_TypeName VARCHAR(15))
BEGIN
	IF (in_TypeName = 'Essay') THEN
		SELECT	Content, MAX(LENGTH(Content)) AS 'Độ dài'
		FROM	Question
		WHERE	TypeID = 1 AND length(Content) = (SELECT  Max(length(Content)) FROM Question GROUP BY TypeID HAVING TypeID = 1);
	ELSEIF (in_TypeName = 'Multiple-Choice') THEN
		SELECT	Content, MAX(LENGTH(Content)) AS 'Độ dài'
		FROM	Question
		WHERE	TypeID = 2 AND length(Content) = (SELECT  Max(length(Content)) FROM Question GROUP BY TypeID HAVING TypeID = 2);
	END IF;
END$$
DELIMITER ;
CALL sp_QsContenMax_Type('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

DROP PROCEDURE IF EXISTS sp_DelExFromId;
DELIMITER $$
CREATE PROCEDURE sp_DelExFromId(IN in_ExamID TINYINT)
BEGIN
	DELETE FROM Exam WHERE ExamID = in_ExamID;
END$$
DELIMITER ;

CALL sp_DelExFromId(1);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử 
--  dụng store ở câu 9 để xóa)
--  Sau đó in số lượng record đã remove từ các table liên quan trong khi 
--  removing

--  Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng 
--  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được 
--  chuyển về phòng ban default là phòng ban chờ việc

DROP PROCEDURE IF EXISTS sp_DelDeptSetWait;
DELIMITER $$
CREATE PROCEDURE sp_DelDeptSetWait(IN var_DepartmentName VARCHAR(30))
BEGIN
	DECLARE v_DepartmentID TINYINT UNSIGNED;
    SELECT d.DepartmentID INTO v_DepartmentID  FROM Department d WHERE d.DepartmentName = var_DepartmentName;
	UPDATE `account` a SET a.DepartmentID = '11' WHERE a.DepartmentID = v_DepartmentID;
	DELETE FROM Department WHERE DepartmentName = var_DepartmentName;
END$$
DELIMITER ;

CALL sp_DelDeptSetWait('Thư kí');

