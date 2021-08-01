import { Staff } from "./Staffs";
class Worker extends Staff {
  private rank: number;
  constructor(
    name: string,
    age: number,
    gender: string,
    address,
    rank: number
  ) {
    super(name, age, gender, address);
    this.rank = rank;
  }
  public printInfoWorker() {
    console.log("Thông tin Worker");
    super.printInfoStaff();
    console.log(" Rank: " + this.rank);
  }
}
export { Worker };
