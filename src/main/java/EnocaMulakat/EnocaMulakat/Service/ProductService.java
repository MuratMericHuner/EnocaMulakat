package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getProducts();

    Product getproduct(Long id);
    Product updateProduct(Long id, Product product);
    boolean deleteProduct(Long id);
}
