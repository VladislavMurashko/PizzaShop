let el1 = document.getElementById("content");
let el2 = document.getElementById("content2");

class User {
    name: string;
    age: number;

    constructor(_name: string, _age: number) {
        this.name = _name;
        this.age = _age;
    }
}
class Employee {
    constructor(private _name: string, private _age: number, private _status: string) {
    }

    public getInfo(): string {
        return `Имя: ${this._name} возраст: ${this._age} статус: ${this._status}`;
    }
}

let tom: User = new User("Влад", 29);
let mary: Employee = new Employee("Mary", 24, "married");

el1.innerHTML = `Имя: ${tom.name} возраст: ${tom.age}`;
el2.innerHTML = mary.getInfo();
