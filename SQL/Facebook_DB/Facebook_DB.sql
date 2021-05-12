DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

DROP TABLE IF EXISTS `National`;
CREATE TABLE `National` (
	National_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    National_Name		VARCHAR(30) UNIQUE NOT NULL,
    Language_Main		VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS Office;
CREATE TABLE Office (
	Office_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Street_Address		VARCHAR(50) NOT NULL,
    National_id			TINYINT UNSIGNED NOT NULL,
    CONSTRAINT FK_Office_National FOREIGN KEY (National_id) REFERENCES  `National`(National_id) ON DELETE CASCADE 
);

DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff (
	Staff_id			MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    First_Name			VARCHAR(20) NOT NULL,
    Last_Name			VARCHAR(20) NOT NULL,
    Email				VARCHAR(30) UNIQUE NOT NULL,
    Office_id			TINYINT UNSIGNED NOT NULL,
    CONSTRAINT FK_Staff_Office FOREIGN KEY (Office_id) 	REFERENCES  Office(Office_id) ON DELETE CASCADE 
);

-- Ques1: Tạo table với các ràng buộc và kiểu dữ liệu.
-- Ques2: Thêm 10 bản ghi vào các table

INSERT INTO `National` 	(National_Name, Language_Main)
VALUES 					('Viet Nam', 'Vietnamese'),
						('National_Name 2', 'Language_Main 2'),
                        ('National_Name 3', 'Language_Main 3'),
                        ('National_Name 4', 'Language_Main 1'),
                        ('National_Name 5', 'Language_Main 4'),
                        ('National_Name 6', 'Language_Main 2'),
                        ('National_Name 7', 'Language_Main 3'),
                        ('National_Name 8', 'Language_Main 6'),
                        ('National_Name 9', 'Language_Main 5'),
                        ('National_Name 10', 'Language_Main 1');
                        
INSERT INTO Office 		(Street_Address, National_id)
VALUES 	         		('Street_Address 1', 1),
						('Street_Address 2', 2),
                        ('Street_Address 3', 3),
                        ('Street_Address 4', 1),
                        ('Street_Address 5', 5),
                        ('Street_Address 6', 4),
                        ('Street_Address 7', 6),
                        ('Street_Address 8', 2),
                        ('Street_Address 9', 5),
                        ('Street_Address 10', 3);
                        
INSERT INTO Staff 		(First_Name, Last_Name, Email, Office_id)
VALUES 	 				
						('First_Name1', 'Last_Name1', 'Email1@gamil.com', 1),
                        ('First_Name2', 'Last_Name2', 'Email2@gamil.com', 2),
                        ('First_Name3', 'Last_Name3', 'Email3@gamil.com', 3),
                        ('First_Name4', 'Last_Name4', 'Email4@gamil.com', 1),
                        ('First_Name5', 'Last_Name5', 'Email5@gamil.com', 5),
                        ('First_Name6', 'Last_Name6', 'Email6@gamil.com', 6),
                        ('First_Name7', 'Last_Name7', 'Email7@gamil.com', 4),
                        ('First_Name8', 'Last_Name8', 'Email8@gamil.com', 5),
                        ('First_Name9', 'Last_Name9', 'Email9@gamil.com', 7),
                        ('First_Name10', 'Last_Name10', 'Email10@gamil.com', 2);
               
-- Ques3: Bạn hãy lấy dữ liệu của tất cả nhân viên đang làm việc tại Vietnam.                        

SELECT s.Staff_id, s.First_Name, s.Last_Name, s.Email, o.Office_id FROM Office o
INNER JOIN Staff s 		ON o.Office_id = s.Office_id
INNER JOIN `National` n ON o.National_id = n.National_id
WHERE n.National_id = 1;

-- Ques4: Lấy ra ID, FullName, Email, National của mỗi nhân viên.

SELECT s.Staff_id, s.Email, o.National_id,CONCAT(s.First_Name, ' ',s.Last_Name) AS FullName FROM Office o
INNER JOIN Staff s 		ON o.Office_id = s.Office_id
INNER JOIN `National` n ON o.National_id = n.National_id;

-- Ques5: Lấy ra tên nước mà nhân viên có Email: "daonq@viettel.com.vn" đang làm việc.

SELECT s.Staff_id, s.Email, o.National_id, n.National_Name FROM Office o
INNER JOIN Staff s 		ON o.Office_id = s.Office_id
INNER JOIN `National` n ON o.National_id = n.National_id
WHERE s.Email = 'daonq@viettel.com.vn';

-- Ques6: Bạn hãy tìm xem trên hệ thống có quốc gia nào có thông tin trên hệ thống nhưng 
-- không có nhân viên nào đang làm việc.

SELECT  n.National_id, n.National_Name FROM Office o
RIGHT JOIN `National` n ON o.National_id = n.National_id
WHERE o.National_id IS NULL;

-- Ques7: Thống kê xem trên thế giới có bao nhiêu quốc gia mà FB đang hoạt động sử dụng 
-- tiếng Anh làm ngôn ngữ chính.

SELECT  Language_Main, COUNT(Language_Main) AS SL FROM `National`
GROUP BY Language_Main
HAVING Language_Main = 'English';

-- Ques8: Viết lệnh để lấy ra thông tin nhân viên có tên (First_Name) 
-- có 10 ký tự, bắt đầu bằng 
-- chữ N và kết thúc bằng chữ C.

SELECT * FROM staff
WHERE LENGTH(First_Name) = 10 AND First_Name LIKE 'N%C';

-- Ques9: Bạn hãy tìm trên hệ thống xem có nhân viên nào đang làm việc nhưng do nhập khi 
-- nhập liệu bị lỗi mà nhân viên đó vẫn chưa cho thông tin về trụ sở làm việc(Office).

SELECT s.Staff_id, CONCAT(s.First_Name, ' ',s.Last_Name) AS FullName, s.Email  FROM Staff s
LEFT JOIN Office o ON s.Office_id = o.Office_id
WHERE s.Office_id IS NULL;

-- Ques10: Nhân viên có mã ID =9 hiện tại đã nghỉ việc, bạn hãy xóa thông tin của nhân viên 
-- này trên hệ thống.

DELETE FROM Staff WHERE Staff_id = 9;

-- Ques11: FB vì 1 lý do nào đó không còn muốn hoạt động tại Australia nữa, và Mark 
-- Zuckerberg muốn bạn xóa tất cả các thông tin trên hệ thống 
-- liên quan đến quốc gia này. Hãy 
-- tạo 1 Procedure có đầu vào là tên quốc gia cần xóa thông tin để 
-- làm việc này và gửi lại cho anh ấy.

DROP PROCEDURE IF EXISTS sp_DelNational;
DELIMITER $$
CREATE PROCEDURE sp_DelNational(IN var_NationaltName VARCHAR(30))
BEGIN
	DECLARE var_NationaltID TINYINT UNSIGNED;
    DECLARE var_OfficeID TINYINT UNSIGNED;
    DECLARE var_StaffID TINYINT UNSIGNED;
    
    SELECT National_id INTO var_NationaltID FROM `National` WHERE National_Name = var_NationaltName;
    SELECT Office_id INTO var_OfficeID FROM Office GROUP BY National_id HAVING National_id = var_NationaltID;
    SELECT Staff_id INTO var_StaffID FROM Staff GROUP BY Office_id HAVING Office_id = var_OfficeID;
    
    DELETE FROM Staff WHERE Staff_id = var_StaffID;
    DELETE FROM Office WHERE Office_id = var_OfficeID;
	DELETE FROM `National` WHERE National_id = var_NationaltID;
END$$
DELIMITER ;

CALL sp_DelNational('Australia');










