import { Staff } from "./Staffs";
class Employee extends Staff {
  private task: string;
  constructor(
    name: string,
    age: number,
    gender: string,
    address,
    task: string
  ) {
    super(name, age, gender, address);
    this.task = task;
  }
  public printInfoEmployee() {
    console.log("Thông tin Engineer");
    super.printInfoStaff();
    console.log("task: " + this.task);
  }
}
export { Employee };
