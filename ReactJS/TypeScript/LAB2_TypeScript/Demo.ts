import { Account, printInfoAccount } from "./Account";
import { Department, printDepartment } from "./Department";
import { Position, printInfoPosition } from "./Position";

let dep1 = new Department(1, "Sale");
let dep2 = new Department(2, "Kỹ thuật");
let dep3 = new Department(3, "Phó giám đốc");
let dep4 = new Department(4, "Tài chính");
let dep5 = new Department(5, "Bảo vệ");
console.log("Thông tin phòng ban trên hệ thống ");
printDepartment(dep1);
printDepartment(dep2);
printDepartment(dep3);
printDepartment(dep4);
printDepartment(dep5);

let pos1 = new Position(1, "Dev"); // Tạo mới 1 đối tượng Department.
let pos2 = new Position(2, "Test");
let pos3 = new Position(3, "Scrum_Master");
let pos4 = new Position(4, "PM");
console.log("--- Thông tin Position trên hệ thống: ---");
printInfoPosition(pos1); // Thực hiện in thông tin của đối tượng vừa tạo.
printInfoPosition(pos2);
printInfoPosition(pos3);
printInfoPosition(pos4);

// Khai báo các Account trên hệ thống
let date: Date = new Date("2020-07-20"); // khai báo đổi tượng kiểu date để sử dụng
let acc1 = new Account(
  1,
  "ngotruongtn991@gmail.com",
  "ngotruongtn991",
  "ngotruongtn991",
  dep1,
  pos1,
  date
);
let acc2 = new Account(
  1,
  "ngotruongtn992@gmail.com",
  "ngotruongtn992",
  "ngotruongtn992",
  dep1,
  pos3,
  date
);
let acc3 = new Account(
  1,
  "ngotruongtn993@gmail.com",
  "ngotruongtn993",
  "ngotruongtn993",
  dep2,
  pos2,
  date
);
let acc4 = new Account(
  1,
  "ngotruongtn99@gmai.com",
  "ngotruongtn994",
  "ngotruongtn994",
  dep4,
  pos4,
  date
);
// Gọi hàm in thông tin Account để sử dụng.
printInfoAccount(acc1);
printInfoAccount(acc2);
printInfoAccount(acc3);
printInfoAccount(acc4);
