import { Department } from "./Department";
import { Position } from "./Position";

class Account {
  private id: number;
  private email: string;
  private username: string;
  private fullName: string;
  private department: Department;
  private position: Position;
  private createDate: Date;

  constructor(
    id: number,
    email: string,
    username: string,
    fullName: string,
    department: Department,
    position: Position,
    createDate: Date
  ) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.fullName = fullName;
    this.department = department;
    this.position = position;
    this.createDate = createDate;
  }

  public getId(): number {
    return this.id;
  }

  public getEmail(): string {
    return this.email;
  }

  public getUsername(): string {
    return this.username;
  }

  public getFullName(): string {
    return this.fullName;
  }

  public getDepartment(): Department {
    return this.department;
  }

  public getPosition(): Position {
    return this.position;
  }

  public getCreateDate(): Date {
    return this.createDate;
  }

  public setId(value: number) {
    this.id = value;
  }

  public setEmail(value: string) {
    this.email = value;
  }

  public setUsername(value: string) {
    this.username = value;
  }

  public setFullName(value: string) {
    this.fullName = value;
  }

  public setDepartment(value: Department) {
    this.department = value;
  }

  public setPosition(value: Position) {
    this.position = value;
  }

  public setCreateDate(value: Date) {
    this.createDate = value;
  }
}
function printInfoAccount(account: Account) {
  console.log(
    "ID: " +
      account.getId() +
      " Email: " +
      account.getEmail() +
      " Username: " +
      account.getUsername() +
      " FullName: " +
      account.getFullName() +
      " Department: " +
      account.getDepartment().getName() +
      " Position: " +
      account.getPosition().getName() +
      " Create Date: " +
      account.getCreateDate()
  );
}
// Export Account và hàm printInfoAccount sang class khác để sử dụng.
export { Account, printInfoAccount };
