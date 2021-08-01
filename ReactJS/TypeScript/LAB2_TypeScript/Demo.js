"use strict";
exports.__esModule = true;
var Account_1 = require("./Account");
var Department_1 = require("./Department");
var Position_1 = require("./Position");
var dep1 = new Department_1.Department(1, "Sale");
var dep2 = new Department_1.Department(2, "Kỹ thuật");
var dep3 = new Department_1.Department(3, "Phó giám đốc");
var dep4 = new Department_1.Department(4, "Tài chính");
var dep5 = new Department_1.Department(5, "Bảo vệ");
console.log("Thông tin phòng ban trên hệ thống ");
Department_1.printDepartment(dep1);
Department_1.printDepartment(dep2);
Department_1.printDepartment(dep3);
Department_1.printDepartment(dep4);
Department_1.printDepartment(dep5);
var pos1 = new Position_1.Position(1, "Dev"); // Tạo mới 1 đối tượng Department.
var pos2 = new Position_1.Position(2, "Test");
var pos3 = new Position_1.Position(3, "Scrum_Master");
var pos4 = new Position_1.Position(4, "PM");
console.log("--- Thông tin Position trên hệ thống: ---");
Position_1.printInfoPosition(pos1); // Thực hiện in thông tin của đối tượng vừa tạo.
Position_1.printInfoPosition(pos2);
Position_1.printInfoPosition(pos3);
Position_1.printInfoPosition(pos4);
// Khai báo các Account trên hệ thống
var date = new Date("2020-07-20"); // khai báo đổi tượng kiểu date để sử dụng
var acc1 = new Account_1.Account(1, "ngotruongtn991@gmail.com", "ngotruongtn991", "ngotruongtn991", dep1, pos1, date);
var acc2 = new Account_1.Account(1, "ngotruongtn992@gmail.com", "ngotruongtn992", "ngotruongtn992", dep1, pos3, date);
var acc3 = new Account_1.Account(1, "ngotruongtn993@gmail.com", "ngotruongtn993", "ngotruongtn993", dep2, pos2, date);
var acc4 = new Account_1.Account(1, "ngotruongtn99@gmai.com", "ngotruongtn994", "ngotruongtn994", dep4, pos4, date);
// Gọi hàm in thông tin Account để sử dụng.
Account_1.printInfoAccount(acc1);
Account_1.printInfoAccount(acc2);
Account_1.printInfoAccount(acc3);
Account_1.printInfoAccount(acc4);
