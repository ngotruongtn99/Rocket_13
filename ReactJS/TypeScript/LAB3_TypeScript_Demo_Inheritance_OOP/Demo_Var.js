"use strict";
exports.__esModule = true;
var Workers_1 = require("./Workers");
var fullName = "Ngô Xuân Trường";
var age = 22;
var gender = "Male";
var address;
address = "HN";
var rank = 7;
var worker1 = new Workers_1.Worker(fullName, age, gender, address, rank);
console.log("Thông tin worker1");
worker1.printInfoWorker();
console.log("Thông tin worker1_ Sau khi khai báo biến var lại 1 lần nữa");
var worker1 = new Workers_1.Worker("Worker1_Name1", 20, "FeMale", "HN", 10);
worker1.printInfoWorker();
// Khai báo Worker2
var worker2 = new Workers_1.Worker("Worker2_Name2", 22, "Male", "HN", 9);
// Viết hàm để in thông tin các biến.
console.log("In thông tin thông qua khai báo thêm 1 hàm: ");
function printWorker_array() {
    var workerArray; // Khai báo 1 mảng
    workerArray = [worker1, worker2]; // Do worker1, worker2 khai báo var nên có phạm vi toàn cục, có thể gọi trong hàm được luôn
    workerArray.forEach(function (element) {
        // Sử dụng Foreach để in thông tin worker trong mảng
        console.log(element);
    });
    worker2 = new Workers_1.Worker("Worker2_Name2_Change", 22, "Male_Change", "HN_Change", 9); // khai báo lạiworker2 trong hàm này. thay đổi giá trị
    var worker4 = new Workers_1.Worker("Worker3", 22, "Male", "HN", 9); // Worker4 khai báo bên trong hàm, nênchỉ có phạm vi bên trong hàm này. ra ngoài sẽ không gọi được, giống khi báo với let
}
// Gọi hàm vừa khai báo bên trên để sử dụng
printWorker_array(); // ở đây vẫn lấy ra được các giá trị worker1 và worker đã khai báo bên ngoài
// In lại thông tin worker để kiểm tra sau khi thay đổi trong hàm printWorker_array();
console.log("Thông tin Worker sau khi thay đổi trong hàm printWorker_array");
console.log(worker2);
// console.log(worker4); Không gọi worker4 để dụng được
