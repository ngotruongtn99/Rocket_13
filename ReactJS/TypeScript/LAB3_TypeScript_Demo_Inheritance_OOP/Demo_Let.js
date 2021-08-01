"use strict";
exports.__esModule = true;
var Workers_1 = require("./Workers");
var name = "Worker1";
var age = 18;
var gender = "Male";
var address;
address = "HN";
var rank = 7;
var worker1 = new Workers_1.Worker(name, age, gender, address, rank);
console.log("Thông tin worker1");
worker1.printInfoWorker();
// Sau khi in thông tin xong thực hiện khai báo lại biến worker1, dùng var nên không báo lỗi, khó quản lý cấu trúc chương trình.
console.log("Thông tin worker1_ Sau khi khai báo biến var lại 1 lần nữa");
// let worker1 = new Worker("Worker1_Name1", 20, "FeMale", "HN", 10); // sẽ không khai báo lại được như này nữa, báo lỗi
worker1.printInfoWorker();
worker1 = new Workers_1.Worker("Trường", 19, "Male", "TN", 9);
worker1.printInfoWorker();
