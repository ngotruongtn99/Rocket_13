"use strict";
exports.__esModule = true;
exports.printInfoAccount = exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account(id, email, username, fullName, department, position, createDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }
    Account.prototype.getId = function () {
        return this.id;
    };
    Account.prototype.getEmail = function () {
        return this.email;
    };
    Account.prototype.getUsername = function () {
        return this.username;
    };
    Account.prototype.getFullName = function () {
        return this.fullName;
    };
    Account.prototype.getDepartment = function () {
        return this.department;
    };
    Account.prototype.getPosition = function () {
        return this.position;
    };
    Account.prototype.getCreateDate = function () {
        return this.createDate;
    };
    Account.prototype.setId = function (value) {
        this.id = value;
    };
    Account.prototype.setEmail = function (value) {
        this.email = value;
    };
    Account.prototype.setUsername = function (value) {
        this.username = value;
    };
    Account.prototype.setFullName = function (value) {
        this.fullName = value;
    };
    Account.prototype.setDepartment = function (value) {
        this.department = value;
    };
    Account.prototype.setPosition = function (value) {
        this.position = value;
    };
    Account.prototype.setCreateDate = function (value) {
        this.createDate = value;
    };
    return Account;
}());
exports.Account = Account;
function printInfoAccount(account) {
    console.log("ID: " +
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
        account.getCreateDate());
}
exports.printInfoAccount = printInfoAccount;
