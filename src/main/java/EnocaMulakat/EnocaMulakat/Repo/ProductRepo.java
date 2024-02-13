package EnocaMulakat.EnocaMulakat.Repo;

import EnocaMulakat.EnocaMulakat.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
