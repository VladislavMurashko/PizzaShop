package by.bsuir.murashko.pizzashop.controller;

import by.bsuir.murashko.pizzashop.model.Pizza;
import by.bsuir.murashko.pizzashop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping(value = "/")
    public String getAllPizza(Model model) {
        Iterable<Pizza> pizza = pizzaRepository.findAll();
        model.addAttribute("pizza", pizza);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }
}
