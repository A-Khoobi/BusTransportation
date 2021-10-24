package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByUserName(String userName);
}
