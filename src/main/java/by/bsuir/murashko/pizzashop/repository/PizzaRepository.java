package by.bsuir.murashko.pizzashop.repository;

import by.bsuir.murashko.pizzashop.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {
}
