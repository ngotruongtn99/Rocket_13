DROP DATABASE IF EXISTS QL_DoAn;
CREATE DATABASE QL_DoAn;
USE QL_DoAn;
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien (
	Id_GV 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ten_GV			VARCHAR(40) NOT NULL, 
    Tuoi			TINYINT UNSIGNED NOT NULL,
    HocVi			CHAR(5) NOT NULL
);

DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien (
	Id_SV 			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ten_SV			VARCHAR(40) NOT NULL, 
    NamSinh			YEAR NOT NULL,
    QueQuan			VARCHAR(20) NOT NULL
    
);

DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai (
	Id_DeTai 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ten_DeTai			VARCHAR(100) NOT NULL
	
);

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan (
	Id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Id_SV			SMALLINT UNSIGNED NOT NULL,
    Id_DeTai		SMALLINT UNSIGNED NOT NULL,
    Id_GV			TINYINT UNSIGNED NOT NULL,
	Diem			TINYINT UNSIGNED NOT NULL,
    CONSTRAINT FK_Huongdan_SinhVien FOREIGN KEY (Id_SV) REFERENCES SinhVien(Id_SV),
    CONSTRAINT FK_Huongdan_DeTai FOREIGN KEY (Id_DeTai) REFERENCES DeTai(Id_DeTai),
    CONSTRAINT FK_Huongdan_GiangVien FOREIGN KEY (Id_GV) REFERENCES GiangVien(Id_GV)
);
-- 1. Tạo table với các ràng buộc và kiểu dữ liệu

INSERT INTO GiangVien 	(Ten_GV, Tuoi, HocVi)
VALUES 					('Giang Vien 1',41, 'Ths'),
						('Giang Vien 2',42, 'Ths'),
                        ('Giang Vien 3',45, 'Ths'),
                        ('Giang Vien 4',52, 'Ts'),
                        ('Giang Vien 5',51, 'PSG'),
                        ('Giang Vien 6',61, 'GS'),
                        ('Giang Vien 7',58, 'GS'),
                        ('Giang Vien 8',42, 'TS'),
                        ('Giang Vien 9',54, 'TS'),
                        ('Giang Vien 10',55, 'Ths');
                        
INSERT INTO SinhVien	(Ten_SV, NamSinh, QueQuan)
VALUES 					('Sinh Vien 1',1999, 'Que Quan 1'),
						('Sinh Vien 2',1998, 'Que Quan 2'),
						('Sinh Vien 3',2000, 'Que Quan 3'),
                        ('Sinh Vien 4',1997, 'Que Quan 4'),
                        ('Sinh Vien 5',1999, 'Que Quan 5'),
                        ('Sinh Vien 6',1998, 'Que Quan 6'),
                        ('Sinh Vien 7',1999, 'Que Quan 7'),
                        ('Sinh Vien 8',1995, 'Que Quan 8'),
                        ('Sinh Vien 9',1998, 'Que Quan 9'),
                        ('Sinh Vien 10',2001, 'Que Quan 10');  

INSERT INTO DeTai		(Ten_DeTai)
VALUES 					('De Tai 1'),
						('De Tai 2'),
						('De Tai 3'),
                        ('De Tai 4'),
						('De Tai 5'),
                        ('De Tai 6'),
                        ('De Tai 7'),
                        ('De Tai 8'),
                        ('De Tai 9'),
						('De Tai 10'); 
                        
INSERT INTO HuongDan	(Id_SV, Id_DeTai, Id_GV, Diem)
VALUES 					( 1,1, 1, 10),
						( 1,2, 3, 9),
						( 3,3, 4, 5),
						( 4,6, 3, 4),
                        ( 5,5, 2, 8),
						( 6,7, 5, 7),
						( 7,8, 6, 10),
						( 8,4, 4, 8),
                        ( 9,10, 9, 6),
						( 10,3, 8, 3);                        
                        
-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn   

SELECT sv.Id_SV, sv.Ten_SV, sv.NamSinh FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.Id_SV = hd.Id_SV
WHERE hd.Id_DeTai IS NULL;

-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’

SELECT sv.Id_SV, sv.Ten_SV, sv.NamSinh FROM HuongDan hd
INNER JOIN SinhVien sv	ON sv.Id_SV = hd.Id_SV
INNER JOIN DeTai dt 	ON dt.Id_DeTai = hd.Id_DeTai
WHERE dt.Ten_DeTai = 'De Tai 6';

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

CREATE OR REPLACE VIEW vw_SinhVienInfo AS 

SELECT sv.Id_SV, sv.Ten_SV, hd.Id_DeTai,
CASE 
	WHEN dt.Id_DeTai IS NULL THEN 'Chưa có'
    ELSE dt.Ten_DeTai
    END AS Ten_De_Tai
FROM HuongDan hd
LEFT JOIN DeTai dt 	ON dt.Id_DeTai = hd.Id_DeTai
RIGHT JOIN SinhVien sv	ON sv.Id_SV = hd.Id_SV;

SELECT * FROM vw_SinhVienInfo;

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
-- thì hiện ra thông báo "Moi ban kiem tra lai nam sinh"

DROP TRIGGER IF EXISTS Trg_Insert_Year;
DELIMITER $$
CREATE TRIGGER Trg_Insert_Year
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN
		IF (NEW.NamSinh <= 1950) THEN
        SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Moi ban kiem tra lai nam sinh';
END IF;
END$$
DELIMITER ;
 
INSERT INTO SinhVien	(Ten_SV,NamSinh,QueQuan)
VALUES 					('SinhVien11',1949,'Thai Nguyen');

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi

ALTER TABLE HuongDan DROP FOREIGN KEY FK_Huongdan_SinhVien;
ALTER TABLE HuongDan ADD CONSTRAINT FK_Huongdan_SinhVien FOREIGN KEY (Id_SV) REFERENCES SinhVien(Id_SV) ON DELETE CASCADE;



-- 6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin 
-- liên quan của sinh viên trên hệ thống


DROP PROCEDURE IF EXISTS sp_DelSvByName;
DELIMITER $$
CREATE PROCEDURE sp_DelSvByName(IN in_SvName VARCHAR(40))
BEGIN		
		DECLARE IdSv SMALLINT UNSIGNED;
		SELECT Id_SV INTO  IdSv FROM SinhVien WHERE Ten_SV = in_SvName;
		DELETE FROM HuongDan WHERE  Id_SV = IdSv;
		DELETE FROM SinhVien WHERE  Ten_SV = in_SvName;
END$$
DELIMITER ;

CALL sp_DelSvByName('Sinh Vien 3');

                     