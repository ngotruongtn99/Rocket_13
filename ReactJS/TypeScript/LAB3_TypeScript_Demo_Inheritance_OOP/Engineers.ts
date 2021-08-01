import { Staff } from "./Staffs";
class Engineer extends Staff {
  private specialized: string;
  constructor(
    name: string,
    age: number,
    gender: string,
    address: string,
    specialized: string
  ) {
    super(name, age, gender, address);
    this.specialized = specialized;
  }
  public printInfoEngineer() {
    console.log("Thông tin Engineer");
    super.printInfoStaff();
    console.log("Sspecialized: " + this.specialized);
  }
}
export { Engineer };
