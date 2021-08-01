"use strict";
exports.__esModule = true;
exports.printInfoPosition = exports.Position = void 0;
var Position = /** @class */ (function () {
    function Position(id, name) {
        this.id = id;
        this.name = name;
    }
    Position.prototype.getName = function () {
        return this.name;
    };
    Position.prototype.setName = function (v) {
        this.name = v;
    };
    Position.prototype.getId = function () {
        return this.id;
    };
    Position.prototype.setId = function (v) {
        this.id = v;
    };
    return Position;
}());
exports.Position = Position;
function printInfoPosition(position) {
    console.log("ID: " + position.getId() + " Position Name: " + position.getName());
}
exports.printInfoPosition = printInfoPosition;
