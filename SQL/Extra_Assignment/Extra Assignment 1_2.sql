-- Exercise 1:Design a table --

DROP DATABASE IF EXISTS Fresher_Training_Management;
CREATE DATABASE Fresher_Training_Management;
USE Fresher_Training_Management;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Full_Name			NVARCHAR(30) NOT NULL UNIQUE KEY,
    Birth_Date			DATE NOT NULL,
    Gender				ENUM ('male','female','unknown') NOT NULL,
    ET_IQ				TINYINT(20)  UNSIGNED NOT NULL,
    ET_Gmath			TINYINT(20)  UNSIGNED NOT NULL,
    ET_English			TINYINT(50)  UNSIGNED NOT NULL,
    Training_Class		CHAR(10) NOT NULL,
    Evaluation_Notes	VARCHAR(100)
);

ALTER TABLE Trainee ADD VTI_Account VARCHAR(20) NOT NULL;

-- Exercise 2: Data Types --

DROP TABLE IF EXISTS Data_types_1;
CREATE TABLE Data_types_1(
	ID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `Name`				VARCHAR(20) UNIQUE KEY NOT NULL,
    `Code`				CHAR(5) NOT NULL,
    ModifiedDate		DATETIME DEFAULT NOW()
);

-- Exercise 3: Data Types 2 --

DROP TABLE IF EXISTS Data_types_2;
CREATE TABLE Data_types_2(
	ID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `Name`				VARCHAR(20) UNIQUE KEY NOT NULL,
    BirthDate			DATE NOT NULL,
    Gender				ENUM ('0', '1', 'NULL') NOT NULL,
    IsDeletedFlag		BIT DEFAULT 1
);


