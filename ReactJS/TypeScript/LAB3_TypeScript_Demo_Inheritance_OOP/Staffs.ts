class Staff {
  private name: string;
  private age: number;
  private gender: string;
  private address: string;

  /**
   * Getter name
   * @return {string}
   */
  public getName(): string {
    return this.name;
  }

  /**
   * Getter age
   * @return {number}
   */
  public getAge(): number {
    return this.age;
  }

  /**
   * Getter gender
   * @return {string}
   */
  public getGender(): string {
    return this.gender;
  }

  /**
   * Getter address
   * @return {string}
   */
  public getAddress(): string {
    return this.address;
  }

  /**
   * Setter name
   * @param {string} value
   */
  public setName(value: string) {
    this.name = value;
  }

  /**
   * Setter age
   * @param {number} value
   */
  public setAge(value: number) {
    this.age = value;
  }

  /**
   * Setter gender
   * @param {string} value
   */
  public setGender(value: string) {
    this.gender = value;
  }

  /**
   * Setter address
   * @param {string} value
   */
  public setAddress(value: string) {
    this.address = value;
  }

  constructor(name: string, age: number, gender: string, address: string) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }

  public printInfoStaff() {
    console.log(
      "Name: ",
      this.name,
      " Age: ",
      this.age,
      " Gender: ",
      this.gender,
      " Address: ",
      this.address
    );
  }
}
export { Staff };
