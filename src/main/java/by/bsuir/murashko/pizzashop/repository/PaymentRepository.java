package by.bsuir.murashko.pizzashop.repository;

import by.bsuir.murashko.pizzashop.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
