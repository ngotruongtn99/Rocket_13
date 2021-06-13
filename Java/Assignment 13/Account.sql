DROP DATABASE IF EXISTS testing_system_Ex2;
CREATE DATABASE testing_system_Ex2;
USE testing_system_Ex2;

DROP TABLE IF EXISTS `Project`;
CREATE TABLE IF NOT EXISTS `Project` ( 	
	ProjectID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectName		VARCHAR(30)	NOT NULL,
    Teamsize		SMALLINT NOT NULL
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`FullName` 		NVARCHAR(60) NOT NULL,
     `Email` 		CHAR(50) NOT NULL,
	`password` 		VARCHAR(100) NOT NULL,	
    expInYear 		SMALLINT UNSIGNED,
	ProSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL'),
	Category		ENUM('Manager', 'Employee') NOT NULL,
    ProjectID		SMALLINT UNSIGNED NOT NULL,
	FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID)
);

INSERT INTO `Project`   (ProjectName,		Teamsize) 
VALUES 					('ProjectName 1', 	10	),
						('ProjectName 2', 	10	),
                        ('ProjectName 3', 	10	);

INSERT INTO `Account`   (`FullName`,		`Email`, 					`password`,	 `expInYear`, 	`ProSkill`, 		`Category`, ProjectID	) 
VALUES 					('FullName1', 		'email1@viettel.com.vn',	 '123456aA',	 '1', 			Null, 			'Manager',  	'1'	),
						('FullName2', 		'email2@viettel.com.vn',	 '123456aA',	 '4', 			Null, 			'Manager',  	'2'	),
						('FullName3', 		'email3@viettel.com.vn',	 '123456aA',	 '8', 			Null, 			'Manager',  	'3'	),
						('FullName4',	 	'email4@viettel.com.vn',	 '123456aA',	Null, 			'DEV', 			'Employee', 	'1'	),
						('FullName5', 		'email5@viettel.com.vn',	 '123456aA',	 Null, 			'JAVA', 		'Employee', 	'2'	),
						('FullName6', 		'email6@viettel.com.vn',	 '123456aA',	Null, 			'SQL', 			'Employee', 	'3'	),
                        ('FullName7', 		'email7@viettel.com.vn',	 '123456aA',	 Null, 			'TEST', 		'Employee', 	'1'	),
						('FullName8',	 	'email8@viettel.com.vn',	 '123456aA',	Null, 			'DEV', 			'Employee', 	'2'	),
                        ('FullName9', 		'email9@viettel.com.vn',	 '123456aA',	 NULL, 			'TEST', 		'Employee', 	'3'	),
						('FullName10',	 	'email10@viettel.com.vn',	 '123456aA',	Null, 			'DEV', 			'Employee', 	'1'	),
                        ('FullName11', 		'email11@viettel.com.vn',	 '123456aA',	 '1', 			Null, 			'Manager',  	'1'	),
						('FullName12', 		'email12@viettel.com.vn',	 '123456aA',	 '4', 			Null, 			'Manager',  	'2'	),
						('FullName13', 		'email13@viettel.com.vn',	 '123456aA',	 '8', 			Null, 			'Manager',  	'3'	);
	

                        
CREATE OR REPLACE VIEW vw_AccInProject
AS SELECT id, FullName, Email ,`password`, Category, ProjectID
FROM `Account`;


SELECT a.id, a.FullName, a.Email, a.`password`, a.expInYear, a.ProjectID FROM `Account` a 
INNER JOIN Project p ON a.ProjectID = p.ProjectID
WHERE Category = 'Manager';

SELECT * FROM vw_AccInProject;