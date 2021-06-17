DROP DATABASE IF EXISTS Testing_Exam;
CREATE DATABASE Testing_Exam;
USE Testing_Exam;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Fullname 		NVARCHAR(50) NOT NULL,
    Email			VARCHAR(40) NOT NULL UNIQUE KEY CHECK (LENGTH(Email)>=6 AND LENGTH(Email) <= 40),
    `password` 		VARCHAR(800) NOT NULL,
    `Role`			ENUM ('ADMIN', 'EMPLOYEE'),
    ExpInYear 		TINYINT UNSIGNED ,
	proSkill 		ENUM('DEV', 'TEST', 'JAVA', 'SQL') 
);


-- 1. Khởi tạo thông tin của các User ở database.
INSERT INTO `User` 	(`email`,						`password`,		`fullName` , 	`Role`, 		ExpInYear, 			proSkill)
VALUES				('Email1@gmail.com',			'123456A',		'Fullname1',	'ADMIN',		8, 					NULL), 
					('Email2@gmail.com',			'123456A',		'Fullname2',	'ADMIN',		8, 					NULL), 
					('Email3@gmail.com',			'123456A',		'Fullname3',	'Employee',		NULL, 				'DEV'), 
					('Email4@gmail.com',			'123456A',		'Fullname4',	'ADMIN',		8, 					NULL), 
					('Email5@gmail.com',			'123456A',		'Fullname5',	'ADMIN',		8, 					NULL), 
					('Email6@gmail.com',			'123456A',		'Fullname6',	'Employee',		NULL, 				'DEV'),
					('Email7@gmail.com', 			'123456A',		'Fullname7',	'Employee',		NULL, 				'TEST'),
					('Email8@gmail.com', 			'123456A',		'Fullname8',	'Employee',		NULL, 				'SQL'),
					('Email9@gmail.com', 			'123456A',		'Fullname9',	'Employee',		NULL, 				'TEST'),
					('Email10@gmail.com', 			'123456A',		'Fullname10',	'Employee',		NULL, 				'DEV'),
					('Email11@gmail.com', 			'123456A',  	'Fullname11',	'Employee',		NULL, 				'JAVA'),
					('Email12@gmail.com', 			'123456A',		'Fullname12',	'Employee',		NULL, 				'DEV'),
					('Email13@gmail.com', 			'123456A',		'Fullname13',	'ADMIN',		8, 					NULL),
					('Email14@gmail.com', 			'123456A',		'Fullname14',	'Employee',		NULL, 				'SQL'),
					('Email150@gmail.com', 			'123456A',		'Fullname15',	'Employee',		NULL, 				'TEST'),
					('Email16@gmail.com', 			'123456A',		'Fullname16',	'ADMIN',		8, 					NULL),
					('Email17@gmail.com', 			'123456A',		'Fullname17',	'Employee',		NULL, 				'JAVA');
                    
-- Viết function để in ra thông tin id và fullName, Email của tất cả User (in ra dạng table)

SELECT 
    id, `email`, `fullName`
FROM
    `User`;

-- 3. Viết function có đầu vào là id của User, sau đó in ra thông tin của User đó
SET @UserID = 1;
SELECT id, `email`, `fullName` FROM `User` WHERE ID = @UserID;

-- 4. Viết function có đầu vào là id của User, sau đó sẽ xóa toàn bộ thông tin của 
-- User đó

DELETE FROM `User` WHERE ID = @UserID;
   
-- 5. Viết chức năng login, User sẽ nhập Email và Password trên giao diện login
-- Chương trình phải kiểm tra được các hợp lệ của các thuộc tính
SET @Email = 'Email14@gmail.com';
SET @UserPassword = '123456A';
SELECT * FROM `User` WHERE email = @Email AND `password` = @UserPassword;

-- 6. Viết chức năng tạo thêm User dành cho Admin theo hướng dẫn sau:
-- Sau khi login xong, Admin nhập FullName, Email của Employee, sau đó hệ 
-- thống sẽ tự động tạo tài khoản cho employee đó với password là 123456
-- Chương trình phải kiểm tra được các hợp lệ của các thuộc tính

-- Đăng nhập dành cho ADMIN
SELECT * FROM `User` WHERE email = @Email AND `password` = @UserPassword AND `role` = 'ADMIN';

-- Admin nhập FullName, Email của Employee
SET @NewEmail = 'newEmail@gmail.com';
SET @NewFullname = 'newFullname';
INSERT INTO `User` (`email`,	`password`,		`fullName` , 	`Role`)
VALUE				(@NewEmail, '123456', 		@NewFullname, 'EMPLOYEE');

SELECT * FROM `User` WHERE email = 'Email10@gmail.com';



