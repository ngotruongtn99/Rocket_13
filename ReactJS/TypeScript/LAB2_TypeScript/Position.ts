class Position {
  private id: number;
  private name: string;

  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }

  public getId(): number {
    return this.id;
  }

  public getName(): string {
    return this.name;
  }

  public setId(value: number) {
    this.id = value;
  }

  public setName(value: string) {
    this.name = value;
  }
}
function printInfoPosition(position: Position): void {
  console.log(
    "ID: " + position.getId() + " Position Name: " + position.getName()
  );
}

export { Position, printInfoPosition };
