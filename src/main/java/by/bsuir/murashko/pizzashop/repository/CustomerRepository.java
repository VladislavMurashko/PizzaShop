package by.bsuir.murashko.pizzashop.repository;

import by.bsuir.murashko.pizzashop.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
