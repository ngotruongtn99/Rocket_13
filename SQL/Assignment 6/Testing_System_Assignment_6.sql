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
        
-- Question 1: T???o store ????? ng?????i d??ng nh???p v??o t??n ph??ng ban v?? in ra t???t c??? c??c 
--  account thu???c ph??ng ban ????

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

CALL sp_getAccFromDeptName('Gi??m ?????c');

-- Question 2: T???o store ????? in ra s??? l?????ng account trong m???i group
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

-- Question 3: T???o store ????? th???ng k?? m???i type question c?? bao nhi??u question ???????c t???o 
--  trong th??ng hi???n t???i

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

-- Question 4: T???o store ????? tr??? ra id c???a type question c?? nhi???u c??u h???i nh???t

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

-- Question 5: S??? d???ng store ??? question 4 ????? t??m ra t??n c???a type question

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

-- Question 6: Vi???t 1 store cho ph??p ng?????i d??ng nh???p v??o 1 chu???i v?? tr??? v??? group c?? t??n 
--  ch???a chu???i c???a ng?????i d??ng nh???p v??o ho???c tr??? v??? user c?? username ch???a 
--  chu???i c???a ng?????i d??ng nh???p v??o

-- C??ch 1
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


-- C??ch 2
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
-- Question 7: Vi???t 1 store cho ph??p ng?????i d??ng nh???p v??o th??ng tin fullName, email v?? 
--  trong store s??? t??? ?????ng g??n:
-- username s??? gi???ng email nh??ng b??? ph???n @..mail ??i
-- positionID: s??? c?? default l?? developer
-- departmentID: s??? ???????c cho v??o 1 ph??ng ch???
--  Sau ???? in ra k???t qu??? t???o th??nh c??ng
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


-- Question 8: Vi???t 1 store cho ph??p ng?????i d??ng nh???p v??o Essay ho???c Multiple-Choice
--  ????? th???ng k?? c??u h???i essay ho???c multiple-choice n??o c?? content d??i nh???t

DROP PROCEDURE IF EXISTS sp_QsContenMax_Type;
DELIMITER $$
CREATE PROCEDURE sp_QsContenMax_Type(IN in_TypeName VARCHAR(15))
BEGIN
	IF (in_TypeName = 'Essay') THEN
		SELECT	Content, MAX(LENGTH(Content)) AS '????? d??i'
		FROM	Question
		WHERE	TypeID = 1 AND length(Content) = (SELECT  Max(length(Content)) FROM Question GROUP BY TypeID HAVING TypeID = 1);
	ELSEIF (in_TypeName = 'Multiple-Choice') THEN
		SELECT	Content, MAX(LENGTH(Content)) AS '????? d??i'
		FROM	Question
		WHERE	TypeID = 2 AND length(Content) = (SELECT  Max(length(Content)) FROM Question GROUP BY TypeID HAVING TypeID = 2);
	END IF;
END$$
DELIMITER ;
CALL sp_QsContenMax_Type('Multiple-Choice');

-- Question 9: Vi???t 1 store cho ph??p ng?????i d??ng x??a exam d???a v??o ID

DROP PROCEDURE IF EXISTS sp_DelExFromId;
DELIMITER $$
CREATE PROCEDURE sp_DelExFromId(IN in_ExamID TINYINT UNSIGNED)
BEGIN
	DELETE FROM ExamQuestion WHERE ExamID = in_ExamID;
	DELETE FROM Exam WHERE ExamID = in_ExamID;
END$$
DELIMITER ;

CALL sp_DelExFromId(1);

-- Question 10: T??m ra c??c exam ???????c t???o t??? 3 n??m tr?????c v?? x??a c??c exam ???? ??i (s??? 
--  d???ng store ??? c??u 9 ????? x??a)
--  Sau ???? in s??? l?????ng record ???? remove t??? c??c table li??n quan trong khi 
--  removing

DROP PROCEDURE IF EXISTS SP_DeleteExamBefore3Year;
DELIMITER $$
CREATE PROCEDURE SP_DeleteExamBefore3Year()
BEGIN
-- Khai b??o bi???n s??? d???ng trong ch????ng tr??nh
DECLARE v_ExamID TINYINT UNSIGNED;
DECLARE v_CountExam TINYINT UNSIGNED DEFAULT 0;
DECLARE v_CountExamquestion TINYINT UNSIGNED DEFAULT 0;
 DECLARE i TINYINT UNSIGNED DEFAULT 1;
 DECLARE v_print_Del_info_Exam VARCHAR(50) ;
-- T???o b???ng t???m
 DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
CREATE TABLE ExamIDBefore3Year_Temp(
ID INT PRIMARY KEY AUTO_INCREMENT,
ExamID INT);
-- Insert d??? li???u b???ng t???m
 INSERT INTO ExamIDBefore3Year_Temp(ExamID)
SELECT e.ExamID FROM exam e WHERE (year(now()) - year(e.CreateDate)) >2;
-- L???y s??? l?????ng s??? Exam v?? ExamQuestion c???n x??a.
 SELECT count(1) INTO v_CountExam FROM ExamIDBefore3Year_Temp;
 SELECT count(1) INTO v_CountExamquestion FROM examquestion ex
 INNER JOIN ExamIDBefore3Year_Temp et ON ex.ExamID = et.ExamID;

-- Th???c hi???n x??a tr??n b???ng Exam v?? ExamQuestion s??? d???ng Procedure ???? t???o ??? Question9 b??n tr??n
 WHILE (i <= v_CountExam) DO
SELECT ExamID INTO v_ExamID FROM ExamIDBefore3Year_Temp WHERE ID=i;
CALL sp_DelExFromId(v_ExamID);
 SET i = i +1;
 END WHILE;
-- In c??u th??ng b??o
 SELECT CONCAT("DELETE ",v_CountExam," IN Exam AND ", v_CountExamquestion ," IN
ExamQuestion") INTO v_print_Del_info_Exam;
SIGNAL SQLSTATE '45000'
 SET MESSAGE_TEXT = v_print_Del_info_Exam ;
-- X??a b???ng t???m sau khi ho??n th??nh
DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
END$$
DELIMITER ;
-- Run Procedure
Call SP_DeleteExamBefore3Year();

--  Question 11: Vi???t store cho ph??p ng?????i d??ng x??a ph??ng ban b???ng c??ch ng?????i d??ng 
--  nh???p v??o t??n ph??ng ban v?? c??c account thu???c ph??ng ban ???? s??? ???????c 
--  chuy???n v??? ph??ng ban default l?? ph??ng ban ch??? vi???c

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

CALL sp_DelDeptSetWait('Th?? k??');

-- Question 12: Vi???t store ????? in ra m???i th??ng c?? bao nhi??u c??u h???i ???????c t???o trong n??m 
--  nay
	
DROP PROCEDURE IF EXISTS sp_CountQuesInMonth;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesInMonth()
BEGIN
	WITH CTE_12Months AS (
	         SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
)	
SELECT M.MONTH, count(month(Q.CreateDate)) AS SL  FROM CTE_12Months M
LEFT JOIN (SELECT * FROM question Q1 WHERE year(Q1.CreateDate) = year(now()) )  Q ON M.MONTH = month(Q.CreateDate) 
GROUP BY M.MONTH;
END$$
DELIMITER ;

Call sp_CountQuesInMonth();      
  
-- Question 13: Vi???t store ????? in ra m???i th??ng c?? bao nhi??u c??u h???i ???????c t???o trong 6 th??ng g???n ????y nh???t
--  (N???u th??ng n??o kh??ng c?? th?? s??? in ra l?? "kh??ng c?? c??u h???i n??o trong th??ng")

DROP PROCEDURE IF EXISTS sp_CountQuesBefore6Month;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesBefore6Month()
BEGIN
WITH CTE_Talbe_6MonthBefore AS (
SELECT MONTH(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
UNION
SELECT MONTH(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
UNION
SELECT MONTH(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
UNION
SELECT MONTH(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`
UNION
SELECT MONTH(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH, YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
UNION
SELECT MONTH(NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`
)
SELECT M.MONTH,M.YEAR, CASE
WHEN COUNT(QuestionID) = 0 THEN 'kh??ng c?? c??u h???i n??o trong
th??ng'
 ELSE COUNT(QuestionID)
END AS SL
FROM CTE_Talbe_6MonthBefore M
LEFT JOIN (SELECT * FROM question where CreateDate >= DATE_SUB(NOW(), INTERVAL 6 MONTH) AND CreateDate <= now()) AS Sub_Question ON M.MONTH = MONTH(CreateDate)
GROUP BY M.MONTH
ORDER BY M.MONTH ASC;
END$$
DELIMITER ;
-- Run:
CALL sp_CountQuesBefore6Month;


