let el1 = document.getElementById("content");
let el2 = document.getElementById("content2");
class User {
    constructor(_name, _age) {
        this.name = _name;
        this.age = _age;
    }
}
class Employee {
    constructor(_name, _age, _status) {
        this._name = _name;
        this._age = _age;
        this._status = _status;
    }
    getInfo() {
        return `Имя: ${this._name} возраст: ${this._age} статус: ${this._status}`;
    }
}
let tom = new User("Влад", 29);
let mary = new Employee("Mary", 24, "married");
el1.innerHTML = `Имя: ${tom.name} возраст: ${tom.age}`;
el2.innerHTML = mary.getInfo();
//# sourceMappingURL=main.js.map