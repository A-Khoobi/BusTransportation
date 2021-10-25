package ir.maktab.bustransportation.repository;

import ir.maktab.bustransportation.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
