package by.bsuir.murashko.pizzashop.controller;

import by.bsuir.murashko.pizzashop.model.Customer;
import by.bsuir.murashko.pizzashop.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id);
    }
}
