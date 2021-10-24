package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   Customer findByUserName(String userName);
}
