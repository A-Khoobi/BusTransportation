package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
