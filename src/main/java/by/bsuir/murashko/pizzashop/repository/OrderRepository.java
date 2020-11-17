package by.bsuir.murashko.pizzashop.repository;

import by.bsuir.murashko.pizzashop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
