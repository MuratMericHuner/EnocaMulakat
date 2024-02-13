package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Product;
import EnocaMulakat.EnocaMulakat.Repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService{
    private final ProductRepo productRepo;
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getproduct(Long id) {
        return productRepo.findById(id).orElseThrow(()-> new IllegalStateException("There is  no such product"));
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product product) {
        Product product1 = productRepo.findById(id).orElseThrow(()-> new IllegalStateException("There is  no such product"));
        product1.setQuantity(product.getQuantity());
        product1.setName(product.getName());
        product1.setOriginalQuantity(product.getOriginalQuantity());
        product1.setPrice(product.getPrice());
        return product1;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new IllegalStateException("There is  no such product"));
        productRepo.delete(product);
        return true;
    }
}
