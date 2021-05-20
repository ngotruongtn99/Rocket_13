DROP DATABASE IF EXISTS Facebook_DB;
CREATE DATABASE Facebook_DB;
USE Facebook_DB;

DROP TABLE IF EXISTS `National`;
CREATE TABLE `National` (
	National_id			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    National_Name		VARCHAR(30) UNIQUE KEY NOT NULL,
    Language_Main		VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS Office;
CREATE TABLE Office (
	Office_id			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Street_Address		VARCHAR(50) NOT NULL,
    National_id			TINYINT UNSIGNED NOT NULL,
    CONSTRAINT FK_Office_National FOREIGN KEY (National_id) REFERENCES  `National`(National_id)
);

DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff (
	Staff_id			MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    First_Name			VARCHAR(20) NOT NULL,
    Last_Name			VARCHAR(20) NOT NULL,
    Email				VARCHAR(30) UNIQUE KEY NOT NULL,
    Office_id			SMALLINT UNSIGNED NOT NULL,
    CONSTRAINT FK_Staff_Office FOREIGN KEY (Office_id) 	REFERENCES  Office(Office_id) 
 
);

-- Ques1: Tạo table với các ràng buộc và kiểu dữ liệu.
-- Ques2: Thêm 10 bản ghi vào các table

INSERT INTO `National` 	(National_Name, Language_Main)
VALUES 					('Vietnam', 'Vietnamese'),
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
WHERE n.National_Name = 'Vietnam';

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

SELECT  n.National_id, n.National_Name, s.Staff_id FROM Staff s
INNER JOIN office o ON s.Office_id = o.Office_id
RIGHT JOIN `National` n ON o.National_id = n.National_id
WHERE o.National_id IS NULL;

WITH cte_tpm_tb_officeID AS (
SELECT DISTINCT o.National_id FROM office o
INNER JOIN (SELECT DISTINCT s.Office_id FROM staff s) t ON o.Office_id = t.Office_id
)

SELECT * FROM cte_tpm_tb_officeID c
RIGHT JOIN `national` n ON c.National_id = n.National_id
WHERE c.National_id IS NULL ;

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
	 DECLARE nation_id TINYINT;
	 SELECT n.National_id INTO nation_id FROM `national` n WHERE n.National_Name = natonal_name;
	 DELETE FROM staff s WHERE s.Office_id IN (SELECT o.Office_id FROM office o WHERE o.National_id = nation_id);
	 DELETE FROM office o WHERE o.National_id = nation_id;
	 DELETE FROM `national` n WHERE n.National_id = nation_id;
END$$
DELIMITER ;

CALL sp_DelNational('Australia');


-- Ques12: Mark muốn biết xem hiện tại đang có bao nhiêu nhân viên trên toàn thế giới đang
-- làm việc cho anh ấy, hãy viết cho anh ấy 1 Function để a ấy có thể lấy dữ liệu này 1 cách 
-- nhanh chóng.

SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS fc_NumberOfStaff;
DELIMITER $$ 
CREATE FUNCTION fc_NumberOfStaff () RETURNS INT
BEGIN
DECLARE sum MEDIUMINT; 
 SELECT COUNT(1) INTO sum FROM staff;
RETURN sum;
END$$
DELIMITER ;
SELECT FC_NUMBEROFSTAFF() AS SUM;

-- Ques13: Để thuận tiện cho việc quản trị Mark muốn số lượng nhân viên tại mỗi quốc gia chỉ
-- tối đa 10.000 người. Bạn hãy tạo trigger cho table Staff chỉ cho phép insert mỗi quốc gia có 
-- tối đa 10.000 nhân viên giúp anh ấy (có thể cấu hình số lượng nhân viên nhỏ hơn vd 11 nhân
-- viên để Test).

DROP TRIGGER IF EXISTS trg_limitStaff;
DELIMITER $$ 
CREATE TRIGGER trg_limitStaff
BEFORE INSERT ON Staff
FOR EACH ROW
BEGIN
	DECLARE NationalId TINYINT;
    DEClARE count_staff SMALLINT;
    SELECT o.National_id INTO NationalId FROM office o WHERE o.Office_id = NEW.Office_id;
	SELECT COUNT(1) INTO count_staff FROM Office o
    INNER JOIN `National` n ON o.National_id = n.National_id
    INNER JOIN Staff s 		ON o.Office_id = s.Office_id
    WHERE n.National_id = NationalId;
 
    IF (count_Staff >10000) THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Cant add more Staff to this Country';
    END IF; 
END$$
DELIMITER ;
INSERT INTO `staff` (`First_Name`, `Last_Name`, `Email`, `Office_id`) 
VALUES 				('First_Name20', 'Last_Name20', 'Email20@gmail.com', 1);

-- Ques14: Bạn hãy viết 1 Procedure để lấy ra tên trụ sở mà có số lượng nhân viên đang làm
-- việc nhiều nhất

DROP PROCEDURE IF EXISTS sp_getMaxStaffInOffice;
DELIMITER $$
CREATE PROCEDURE sp_getMaxStaffInOffice()
BEGIN
WITH CTE_getMaxStaffInOffice AS (
	SELECT COUNT(1) AS SL FROM staff s 
     INNER JOIN office o ON s.Office_id = o.Office_id
     GROUP BY s.Office_id
) 
	 SELECT o.Office_id, o.Street_Address, o.National_id, COUNT(s.Staff_id) FROM staff s 
     INNER JOIN office o ON s.Office_id = o.Office_id
     GROUP BY s.Office_id
     HAVING COUNT(s.Staff_id) = (SELECT MAX(SL) FROM CTE_getMaxStaffInOffice );
END$$
DELIMITER ;

CALL sp_getMaxStaffInOffice();

-- Ques15: Bạn hãy viết 1 Function để khi nhập vào thông tin Email của nhân viên thì sẽ trả ra
-- thông tin đầy đủ của nhân viên đó.(Trả về tên đầy đủ của nhân viên)

SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS fc_getInforStaffByEmail;
DELIMITER $$
CREATE FUNCTION fc_getInforStaffByEmail(email VARCHAR(50)) RETURNS VARCHAR(100)

BEGIN
	DECLARE fullname VARCHAR(40);
    SELECT CONCAT(First_Name, ' ' , Last_Name) INTO fullname FROM  staff s WHERE s.Email = email;
    RETURN fullname;
END$$
DELIMITER ;

SELECT fc_getInforStaffByEmail('email1@gamil.com') AS FullName;

-- Ques16: Bạn hãy viết 1 Trigger để khi thực hiện cập nhật thông tin về trụ sở làm việc của
-- nhân viên đó thì hệ thống sẽ tự động lưu lại trụ sở cũ của nhân viên vào 1 bảng khác có tên
-- Log_Office để Mark có thể xem lại khi cần thiết.

DROP TABLE IF EXISTS Log_Office;
CREATE TABLE Log_Office(
	Id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 			VARCHAR(20) NOT NULL,
    Office_id_Old 	SMALLINT UNSIGNED NOT NULL,
    ChangeDate		DATETIME
);

DROP TRIGGER IF EXISTS trg_getOldOfficeId;
DELIMITER $$
CREATE TRIGGER trg_getOldOfficeId
AFTER UPDATE ON staff
FOR EACH ROW
BEGIN
	INSERT INTO `log_office` (`Email`, `Office_id_Old`, `ChangeDate`) 
	VALUES ( OLD.Email, OLD.Office_id, now());
    
END$$
DELIMITER ;

UPDATE staff SET Office_id = 2 WHERE Staff_id = 1;

-- Ques17: FB đang vướng vào 1 đạo luật hạn chế hoạt động, FB chỉ có thể hoạt động tối đa
-- trên 100 quốc gia trên thế giới, hãy tạo Trigger để ngăn người nhập liệu nhập vào quốc gia
-- thứ 101 (bạn có thể sử dụng số nước nhỏ hơn để Test VD 11 nước).

DROP TRIGGER IF EXISTS trg_limitNational;
DELIMITER $$
CREATE TRIGGER trg_limitNational
BEFORE INSERT ON `national` 
FOR EACH ROW
BEGIN 
	DECLARE Count_National TINYINT;
	SELECT COUNT(1) INTO Count_National FROM `national`;
    
    IF(Count_National >= 100) THEN 
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = "Can not add more National to this Table";
    END IF;
    
END $$

DELIMITER ;
INSERT INTO `national` (National_Name, Language_Main)
VALUES 					('National_Name 13', 'Language_Main 24'	);

-- Ques18: Thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân viên đang làm việc.

SELECT n.National_id, n.National_Name, COUNT(s.Staff_id) AS SL FROM staff s 
INNER JOIN office o ON o.Office_id = s.Office_id
INNER JOIN `national` n ON o.National_id = n.National_id
GROUP BY n.National_id;

-- Ques19: Viết Procedure để thống kê mỗi xem mỗi nước(National) đang có bao nhiêu nhân
-- viên đang làm việc, với đầu vào là tên nước.

DROP PROCEDURE IF EXISTS sp_getStaffByNationalName;
DELIMITER $$
CREATE PROCEDURE sp_getStaffByNationalName (IN In_NationName VARCHAR(30))
BEGIN 
	SELECT n.National_Id, COUNT(s.Staff_id) AS SL FROM staff s 
    INNER JOIN office o ON s.Office_id = o.Office_id
    INNER JOIN `national` n ON n.National_id = o.National_id
    WHERE n.National_Name = In_NationName;

END $$
DELIMITER ;

CALL sp_getStaffByNationalName('Vietnam');

-- Ques20: Thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu employee đang
-- làm việc.

SELECT o.Street_Address, n.National_Name, count(1) AS SL FROM `Staff` s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY o.Office_id;

-- Ques21: Viết Procedure để thống kê mỗi xem trong cùng 1 trụ sở (Office) đang có bao nhiêu
-- employee đang làm việc đầu vào là ID của trụ sở.

DROP PROCEDURE IF EXISTS sp_getStaffByOfficeId;
DELIMITER $$
CREATE PROCEDURE sp_getStaffByOfficeId (IN in_OfficeID TINYINT)
BEGIN 
SELECT o.Street_Address, n.National_Name, count(1) AS SL FROM `Staff` s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY o.Office_id
HAVING o.Office_id = in_OfficeID;
END $$
DELIMITER ; 

CALL sp_getStaffByOfficeId(1);

-- Ques22: Viết Procedure để lấy ra tên quốc gia đang có nhiều nhân viên nhất.

DROP PROCEDURE IF EXISTS sp_getNationalMaxStaff;
DELIMITER $$
CREATE PROCEDURE sp_getNationalMaxStaff()
BEGIN 
WITH CTE_GetNationalMaxStaff AS (
	SELECT  count(1) AS SL FROM `Staff` s
	INNER JOIN `office` o ON s.Office_id = o.Office_id
	INNER JOIN `national` n ON n.National_id = o.National_id
    GROUP BY o.National_id
)
SELECT n.National_id, n.National_Name,  COUNT(1) AS SL FROM Staff s
INNER JOIN `office` o ON s.Office_id = o.Office_id
INNER JOIN `national` n ON n.National_id = o.National_id
GROUP BY o.National_id
HAVING COUNT(s.Staff_id) = (SELECT MAX(SL) FROM CTE_GetNationalMaxStaff);
END $$

DELIMITER ;

CALL sp_getNationalMaxStaff();

-- Ques23: (Trùng Ques18) Thống kê mỗi country có bao nhiêu employee đang làm việc

-- Ques24: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
-- việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ chuyển về Null

ALTER TABLE Staff DROP FOREIGN KEY FK_Staff_Office;
ALTER TABLE Staff ADD CONSTRAINT FK_Staff_Office FOREIGN KEY (Office_id) REFERENCES  Office (Office_id);

-- Ques25: Bạn hãy cấu hình lại các bảng và ràng buộc giữ liệu sao cho khi xóa 1 trụ sở làm
-- việc (Office) thì tất cả dữ liệu liên quan đến trụ sở này sẽ bị xóa hết.


ALTER TABLE Staff DROP FOREIGN KEY FK_Staff_Office;
ALTER TABLE Staff ADD CONSTRAINT FK_Staff_Office FOREIGN KEY (Office_id) REFERENCES Office(Office_id) ON DELETE CASCADE;
