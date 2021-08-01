"use strict";
exports.__esModule = true;
var Employees_1 = require("./Employees");
var Engineers_1 = require("./Engineers");
var Workers_1 = require("./Workers");
var worker1 = new Workers_1.Worker("Worker1", 20, "Male", "HN", 4);
var worker2 = new Workers_1.Worker("Worker2", 22, "FeMale", "TN", 2);
var worker3 = new Workers_1.Worker("Worker3", 24, "Male", "HN", 3);
worker1.printInfoWorker();
console.log("------------------Demo Array Worker ------------------");
var workerArray;
workerArray = [worker1, worker2, worker3];
workerArray.forEach(function (element) {
    element.printInfoWorker;
});
console.log("----- Kết thúc lệnh foreach cho Worker:");
console.log("------------------Finish Demo Array ------------------");
var Engineer1 = new Engineers_1.Engineer("Engineer1", 20, "Male", "HN", "DEV"); // Tạo mới 1 đối tượng Worker.
var Engineer2 = new Engineers_1.Engineer("Engineer2", 22, "FeMale", "NĐ", "TEST");
var Engineer3 = new Engineers_1.Engineer("Engineer3", 24, "Male", "HN", "DEV");
Engineer1.printInfoEngineer();
console.log("------------------Demo Set Engineer ------------------");
var engineerSet = new Set(); // Khai báo 1 set
engineerSet.add(Engineer1); // Add các phần tử vào trong set
engineerSet.add(Engineer2);
engineerSet.add(Engineer3);
// Lấy ra tổng số phần tử trong Set
console.log("Tổng số phần tử trong Set: " + engineerSet.size);
console.log("Xóa 1 phần tử trong Set: " + engineerSet["delete"](Engineer1));
// In thông tin các phần tử trong set
engineerSet.forEach(function (element) {
    console.log(element);
});
console.log("------------------Finish Demo Set ------------------");
// Khai báo các Employee trên hệ thống
var Employee1 = new Employees_1.Employee("Employee1", 20, "Male", "HN", "Task1"); // Tạo mới 1 đối tượng Worker
var Employee2 = new Employees_1.Employee("Employee2", 22, "FeMale", "NĐ", "Task2");
var Employee3 = new Employees_1.Employee("Employee3", 24, "Male", "HN", "Task3");
// In thông tin của Employee:
Employee1.printInfoEmployee();
console.log("----------------- Demo For Of qua Array ------------------");
