package by.bsuir.murashko.pizzashop.service;

import by.bsuir.murashko.pizzashop.model.Pizza;
import by.bsuir.murashko.pizzashop.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Iterable<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    public Pizza updatePizzaInfo(int id, Pizza pizza) {
        Pizza updatedPizza = null;
        try {
            pizzaRepository.findById(id).orElseThrow();
            updatedPizza = pizzaRepository.save(pizza);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }

        return updatedPizza;
    }

    public void addPizza(Pizza pizza) {
        try {
            pizzaRepository.save(pizza);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deletePizza(int id) {
        try {
            pizzaRepository.deleteById(id);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
