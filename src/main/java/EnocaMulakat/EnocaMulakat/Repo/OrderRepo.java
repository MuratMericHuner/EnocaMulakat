package EnocaMulakat.EnocaMulakat.Repo;

import EnocaMulakat.EnocaMulakat.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

}
