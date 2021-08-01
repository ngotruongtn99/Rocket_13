class Department {
  private id: number;

  private name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }

  public getName(): string {
    return this.name;
  }

  public setName(v: string): void {
    this.name = v;
  }

  public getId(): number {
    return this.id;
  }

  public setId(v: number): void {
    this.id = v;
  }
}

function printDepartment(department: Department): void {
  console.log("ID: ", department.getId(), "Name: ", department.getName());
}

export { Department, printDepartment };
