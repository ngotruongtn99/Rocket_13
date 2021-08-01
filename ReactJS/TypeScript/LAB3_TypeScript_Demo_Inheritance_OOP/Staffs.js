"use strict";
exports.__esModule = true;
exports.Staff = void 0;
var Staff = /** @class */ (function () {
    function Staff(name, age, gender, address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    /**
     * Getter name
     * @return {string}
     */
    Staff.prototype.getName = function () {
        return this.name;
    };
    /**
     * Getter age
     * @return {number}
     */
    Staff.prototype.getAge = function () {
        return this.age;
    };
    /**
     * Getter gender
     * @return {string}
     */
    Staff.prototype.getGender = function () {
        return this.gender;
    };
    /**
     * Getter address
     * @return {string}
     */
    Staff.prototype.getAddress = function () {
        return this.address;
    };
    /**
     * Setter name
     * @param {string} value
     */
    Staff.prototype.setName = function (value) {
        this.name = value;
    };
    /**
     * Setter age
     * @param {number} value
     */
    Staff.prototype.setAge = function (value) {
        this.age = value;
    };
    /**
     * Setter gender
     * @param {string} value
     */
    Staff.prototype.setGender = function (value) {
        this.gender = value;
    };
    /**
     * Setter address
     * @param {string} value
     */
    Staff.prototype.setAddress = function (value) {
        this.address = value;
    };
    Staff.prototype.printInfoStaff = function () {
        console.log("Name: ", this.name, " Age: ", this.age, " Gender: ", this.gender, " Address: ", this.address);
    };
    return Staff;
}());
exports.Staff = Staff;
