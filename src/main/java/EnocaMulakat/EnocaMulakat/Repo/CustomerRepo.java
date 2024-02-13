package EnocaMulakat.EnocaMulakat.Repo;

import EnocaMulakat.EnocaMulakat.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
