package by.bsuir.murashko.pizzashop.controller;

import by.bsuir.murashko.pizzashop.model.Pizza;
import by.bsuir.murashko.pizzashop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        return "about";
    }

    @GetMapping(value = "/")
    public String getAllPizza(Model model) {
        Iterable<Pizza> pizza = pizzaRepository.findAll();
        model.addAttribute("pizza", pizza);
        return "home";
    }

    @GetMapping(value = "/pizza/{id}/edit")
    public String editPizzaInfo(@PathVariable int id, Model model) {
        if (!pizzaRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Pizza> pizza = pizzaRepository.findById(id);
        List<Pizza> pizzaList = new ArrayList<>();
        pizza.ifPresent(pizzaList::add);
        model.addAttribute("pizza", pizzaList);

        return "pizza-edit";
    }

    @PostMapping(value = "/pizza/{id}/edit")
    public String updatePizzaInfo(@PathVariable int id, @RequestParam String name, @RequestParam String description, @RequestParam double price, Model model) {
        try {
            Pizza pizza = pizzaRepository.findById(id).orElseThrow();
            pizza.setName(name);
            pizza.setDescription(description);
            pizza.setPrice(price);
            pizzaRepository.save(pizza);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/";
    }

    @PostMapping(value = "/pizza/{id}/delete")
    public String deletePizza(@PathVariable int id, Model model) {
        try {
            Pizza pizza = pizzaRepository.findById(id).orElseThrow();
            pizzaRepository.delete(pizza);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/";
    }
}
