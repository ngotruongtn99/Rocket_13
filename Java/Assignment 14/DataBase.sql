-- create database
DROP DATABASE IF EXISTS TestingSystem_EX3;
CREATE DATABASE TestingSystem_EX3;
USE TestingSystem_EX3;

-- create table: Account
DROP TABLE IF EXISTS 	`Account`;
CREATE TABLE IF NOT EXISTS `Account` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullName` 		NVARCHAR(50) NOT NULL,
     `Role`			ENUM('USER', 'ADMIN')
);

-- create table: Manager
DROP TABLE IF EXISTS 	`Manager`;
CREATE TABLE IF NOT EXISTS `Manager` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
	`expInYear` 	SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (id) REFERENCES `Account`(id)
);

-- create table: Employee
DROP TABLE IF EXISTS 	`Employee`;
CREATE TABLE IF NOT EXISTS `Employee` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
    proSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL') NOT NULL,
    FOREIGN KEY (id) REFERENCES `Account`(id)
);

-- create table: Project
DROP TABLE IF EXISTS 	`Project`;
CREATE TABLE IF NOT EXISTS `Project` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Project_Name 	VARCHAR(50) NOT NULL,
	`teamSize`	 	SMALLINT UNSIGNED # Trigger TODO...
);

-- create table: Project & Account
DROP TABLE IF EXISTS 	`ProjectAndAccount`;
CREATE TABLE IF NOT EXISTS `ProjectAndAccount` ( 	
	projectId 		SMALLINT UNSIGNED NOT NULL,
	accountId	 		SMALLINT UNSIGNED NOT NULL,
    `Role`			ENUM ('MANAGER', 'EMPLOYEE'),
    FOREIGN KEY (projectId) REFERENCES `Project`(id),
    FOREIGN KEY (accountId) REFERENCES `Account`(id),
    PRIMARY KEY (projectId, accountId)
);

-- Add data Account
INSERT INTO `Account` 	(`email`,						`password`,		`fullName`, 	`Role` )
VALUE				('Email1@gmail.com',			'123456A',		'Fullname1', 		'USER'), 
					('Email2@gmail.com',			'123456A',		'Fullname2', 		'USER'), 
					('Email3@gmail.com',			'123456A',		'Fullname3', 		'USER'), 
					('Email4@gmail.com',			'123456A',		'Fullname4', 		'USER'), 
					('Email5@gmail.com',			'123456A',		'Fullname5', 		'USER'), 
					('Email6@gmail.com',			'123456A',		'Fullname6', 		'USER'),
					('Email7@gmail.com', 			'123456A',		'Fullname7', 		'USER'),
					('Email8@gmail.com', 			'123456A',		'Fullname8', 		'USER'),
					('Email9@gmail.com', 			'123456A',		'Fullname9', 		'USER'),
					('Email10@gmail.com', 			'123456A',		'Fullname10', 		'USER'),
					('Email11@gmail.com', 			'123456A',  	'Fullname11', 		'USER'),
					('Email12@gmail.com', 			'123456A',		'Fullname12', 		'USER'),
					('Email13@gmail.com', 			'123456A',		'Fullname13', 		'USER'),
					('Email14@gmail.com', 			'123456A',		'Fullname14', 		'USER'),
					('Email150@gmail.com', 			'123456A',		'Fullname15', 		'USER'),
					('Email16@gmail.com', 			'123456A',		'Fullname16', 		'USER'),
					('Email17@gmail.com', 			'123456A',		'Fullname17', 		'USER'),
                    ('admin1@gmail.com', 			'Admin1',		'Admin1'	, 		'ADMIN'),
                    ('admin2@gmail.com', 			'Admin2',		'Admin2'	, 		'ADMIN');
 
               
-- Add data Manager
INSERT INTO Manager (id,	`expInYear`	)
VALUE				(1,			5		), 
					(3,			1		), 
					(5,			2		), 
					(7,			3		), 
					(9,			5		), 
					(11,		7		), 
					(13,		8		), 
					(15,		9		), 
					(17,		10		);

-- Add data Employee
INSERT INTO Employee 	(id,	`proSkill`	)
VALUE					(2,			'DEV'	), 
						(4,			'DEV'	), 
						(6,			'TEST'	), 
						(8,			'TEST'	), 
						(10,		'JAVA'	), 
						(12,		'DEV'	), 
						(14,		'JAVA'	), 
						(16,		'SQL'	);
                        
-- Add data Project
INSERT INTO Project 	(`Project_Name`,	 `teamSize`	)
VALUE					('Project_Name_1',			3		), 
						('Project_Name_2',			3		), 
                        ('Project_Name_3',			2		), 
                        ('Project_Name_4',			4		), 
                        ('Project_Name_5',			8		);
                        
-- Add data `ProjectAndAccount`
INSERT INTO `ProjectAndAccount` 	(projectId	,	`accountId`,	`Role`		)
VALUE							(1			,		1	,	'MANAGER'	), 
								(1			,		2	,	'EMPLOYEE'	), 
								(1			,		3	,	'EMPLOYEE'	), 
								(2			,		4	,	'EMPLOYEE'	), 
								(2			,		5	,	'MANAGER'	), 
								(2			,		6	,	'EMPLOYEE'	), 
								(3			,		7	,	'EMPLOYEE'	), 
								(3			,		8	,	'MANAGER'	);
         
-- a.	Tạo thêm User dành cho Admin theo hướng dẫn sau: Sau khi login xong, Admin nhập FullName, Email của Account, sau đó 
-- hệ thống sẽ tự động tạo tài khoản cho Account đó với password là 123456, yêu cầu validate ở các thuộc tính.
SET @newEmail = '';
SET @newFullName = '';
INSERT INTO `Account` 	(email, fullName, `password`)
VALUES					(@newEmail, @newFullName, '123456');

-- b.	Login: Lấy dữ liệu từ DB để login hệ thống(qua Email và Password), yêu cầu validate các thuộc tính Email và Password.

SELECT * FROM `Account` WHERE email = ? AND `password` = ?;

-- c.	Tìm thành viên của Project theo tên Project.

SELECT paa.projectId, paa.accountId, a.fullName, a.email, paa.`Role` FROM `Account` a
INNER JOIN ProjectAndAccount paa ON a.id = paa.accountId
INNER JOIN Project p ON p.id = paa.projectId
WHERE Project_Name = 'Project_Name_1';

INSERT INTO `Account` 	(email, `fullName`, 	`Role`)
VALUES					(?, 	?, 			'USER');
SELECT * FROM `Account` WHERE email = ? AND `password` = ? AND `Role` = 'ADMIN';