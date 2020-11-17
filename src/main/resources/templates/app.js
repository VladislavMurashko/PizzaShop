var el = document.getElementById("content");
var User = /** @class */ (function () {
    function User(_name, _age) {
        this.name = _name;
        this.age = _age;
    }
    return User;
}());
var tom = new User("Vladislav", 29);
el.innerHTML = "Имя: " + tom.name + " возраст: " + tom.age;
