"use strict";
exports.__esModule = true;
exports.printDepartment = exports.Department = void 0;
var Department = /** @class */ (function () {
    function Department(id, name) {
        this.id = id;
        this.name = name;
    }
    Department.prototype.getName = function () {
        return this.name;
    };
    Department.prototype.setName = function (v) {
        this.name = v;
    };
    Department.prototype.getId = function () {
        return this.id;
    };
    Department.prototype.setId = function (v) {
        this.id = v;
    };
    return Department;
}());
exports.Department = Department;
function printDepartment(department) {
    console.log("ID: ", department.getId(), "Name: ", department.getName());
}
exports.printDepartment = printDepartment;
