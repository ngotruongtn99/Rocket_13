import { Employee } from "./Employees";
import { Engineer } from "./Engineers";
import { Worker } from "./Workers";

let worker1 = new Worker("Worker1", 20, "Male", "HN", 4);
let worker2 = new Worker("Worker2", 22, "FeMale", "TN", 2);
let worker3 = new Worker("Worker3", 24, "Male", "HN", 3);

worker1.printInfoWorker();

console.log("------------------Demo Array Worker ------------------");
let workerArray: Worker[];
workerArray = [worker1, worker2, worker3];
workerArray.forEach((element) => {
  element.printInfoWorker;
});

console.log("----- Kết thúc lệnh foreach cho Worker:");
console.log("------------------Finish Demo Array ------------------");
let Engineer1 = new Engineer("Engineer1", 20, "Male", "HN", "DEV"); // Tạo mới 1 đối tượng Worker.
let Engineer2 = new Engineer("Engineer2", 22, "FeMale", "NĐ", "TEST");
let Engineer3 = new Engineer("Engineer3", 24, "Male", "HN", "DEV");

Engineer1.printInfoEngineer();

console.log("------------------Demo Set Engineer ------------------");
let engineerSet = new Set(); // Khai báo 1 set
engineerSet.add(Engineer1); // Add các phần tử vào trong set
engineerSet.add(Engineer2);
engineerSet.add(Engineer3);

// Lấy ra tổng số phần tử trong Set
console.log("Tổng số phần tử trong Set: " + engineerSet.size);
console.log("Xóa 1 phần tử trong Set: " + engineerSet.delete(Engineer1));
// In thông tin các phần tử trong set
engineerSet.forEach((element) => {
  console.log(element);
});
console.log("------------------Finish Demo Set ------------------");

// Khai báo các Employee trên hệ thống
let Employee1 = new Employee("Employee1", 20, "Male", "HN", "Task1"); // Tạo mới 1 đối tượng Worker
let Employee2 = new Employee("Employee2", 22, "FeMale", "NĐ", "Task2");
let Employee3 = new Employee("Employee3", 24, "Male", "HN", "Task3");

// In thông tin của Employee:
Employee1.printInfoEmployee();
console.log("----------------- Demo For Of qua Array ------------------");
