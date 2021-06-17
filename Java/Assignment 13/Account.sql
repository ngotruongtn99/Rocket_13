-- create database
DROP DATABASE IF EXISTS TestingSystem_EX;
CREATE DATABASE TestingSystem_EX;
USE TestingSystem_EX;

-- create table: User
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE IF NOT EXISTS `User` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`email` 		CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
	`fullName` 		NVARCHAR(50) NOT NULL
);

-- create table: Manager
DROP TABLE IF EXISTS 	`Manager`;
CREATE TABLE IF NOT EXISTS `Manager` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
	`expInYear` 	SMALLINT UNSIGNED NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id)
);

-- create table: Employee
DROP TABLE IF EXISTS 	`Employee`;
CREATE TABLE IF NOT EXISTS `Employee` ( 	
	id 				SMALLINT UNSIGNED NOT NULL,
    proSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL') NOT NULL,
    FOREIGN KEY (id) REFERENCES `User`(id)
);

-- create table: Project
DROP TABLE IF EXISTS 	`Project`;
CREATE TABLE IF NOT EXISTS `Project` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Project_Name 	VARCHAR(50) NOT NULL,
	`teamSize`	 	SMALLINT UNSIGNED # Trigger TODO...
);

-- create table: Project & User
DROP TABLE IF EXISTS 	`ProjectAndUser`;
CREATE TABLE IF NOT EXISTS `ProjectAndUser` ( 	
	projectId 		SMALLINT UNSIGNED NOT NULL,
	userId	 		SMALLINT UNSIGNED NOT NULL,
    `Role`			ENUM ('MANAGER', 'EMPLOYEE'),
    FOREIGN KEY (projectId) REFERENCES `Project`(id),
    FOREIGN KEY (userId) REFERENCES `User`(id),
    PRIMARY KEY (projectId, userId)
);

-- Note: Manager của Project không liên quan gì tới Project Manager

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
-- Add data User
INSERT INTO `User` 	(`email`,						`password`,		`fullName` )
VALUE				('Email1@gmail.com',			'123456A',		'Fullname1'), 
					('Email2@gmail.com',			'123456A',		'Fullname2'), 
					('Email3@gmail.com',			'123456A',		'Fullname3'), 
					('Email4@gmail.com',			'123456A',		'Fullname4'), 
					('Email5@gmail.com',			'123456A',		'Fullname5'), 
					('Email6@gmail.com',			'123456A',		'Fullname6'),
					('Email7@gmail.com', 			'123456A',		'Fullname7'),
					('Email8@gmail.com', 			'123456A',		'Fullname8'),
					('Email9@gmail.com', 			'123456A',		'Fullname9'),
					('Email10@gmail.com', 			'123456A',		'Fullname10'),
					('Email11@gmail.com', 			'123456A',  	'Fullname11'),
					('Email12@gmail.com', 			'123456A',		'Fullname12'),
					('Email13@gmail.com', 			'123456A',		'Fullname13'),
					('Email14@gmail.com', 			'123456A',		'Fullname14'),
					('Email150@gmail.com', 			'123456A',		'Fullname15'),
					('Email16@gmail.com', 			'123456A',		'Fullname16'),
					('Email17@gmail.com', 			'123456A',		'Fullname17');
                                                                
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
                        
-- Add data `ProjectAndUser`
INSERT INTO `ProjectAndUser` 	(projectId	,	`userId`,	`Role`		)
VALUE							(1			,		1	,	'MANAGER'	), 
								(1			,		2	,	'EMPLOYEE'	), 
								(1			,		3	,	'EMPLOYEE'	), 
								(2			,		4	,	'EMPLOYEE'	), 
								(2			,		5	,	'MANAGER'	), 
								(2			,		6	,	'EMPLOYEE'	), 
								(3			,		7	,	'EMPLOYEE'	), 
								(3			,		8	,	'MANAGER'	);
                                
-- Question 2: Viết function để user nhập vào id project, sau đó in ra tất cả các employee &
-- Manager trong project đó (in ra dạng table)
SET @project_id = 1;

SELECT 	pau.projectId, u.`fullName`, pau.`Role`	
FROM	`ProjectAndUser` pau
JOIN	`User` u	ON u.id = pau.userId
WHERE	pau.projectId = @project_id;

-- Question 3: Viết function để user có thể lấy ra tất cả Manager của các project (in ra dạng table)
SELECT 	pau.projectId, u.`fullName`, pau.`Role`	
FROM	`ProjectAndUser` pau
JOIN	`User` u	ON u.id = pau.userId
WHERE	`Role` = 'MANAGER';

-- Question 4: Viết chức năng login, User sẽ nhập Email và Password trên giao diện login
SET @email = 'hanhhanoi1999@gmail.com';
SET @password = '123456A';

SELECT 	u.`fullName`	
FROM	`User` u
WHERE	u.`email` = @email AND `password` = @password;

-- DAONQ
SELECT 	u.id, u.email, u.`fullName`
FROM	`ProjectAndUser` pau
INNER JOIN	`User` u	ON u.id = pau.userId
WHERE	pau.projectId = @project_id;
-- ===========
SELECT 	u.id, u.email, u.`fullName`
FROM	`ProjectAndUser` pau
JOIN	`User` u	ON u.id = pau.userId
WHERE	`Role` = 'MANAGER';