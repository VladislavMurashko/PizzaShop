package by.bsuir.murashko.pizzashop.controller;

import by.bsuir.murashko.pizzashop.model.Pizza;
import by.bsuir.murashko.pizzashop.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {
    @Autowired
    PizzaService pizzaService;

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }

    @GetMapping(value = "/")
    public Iterable<Pizza> getAllPizza() {
        return pizzaService.getAllPizza();
    }


    @PutMapping(value = "/pizza/{id}/edit")
    public Pizza updatePizzaInfo(@PathVariable int id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizzaInfo(id, pizza);
    }

    @DeleteMapping(value = "/pizza/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }

    @PostMapping(value = "/pizza/add")
    public void addPizza(@RequestBody Pizza pizza) {
        pizzaService.addPizza(pizza);
    }
}
