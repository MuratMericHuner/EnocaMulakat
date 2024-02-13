package EnocaMulakat.EnocaMulakat.Controller;

import EnocaMulakat.EnocaMulakat.Entities.Product;
import EnocaMulakat.EnocaMulakat.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
            return productService.saveProduct(product);
    }
    @GetMapping("/all")
    public List<Product> saveProduct(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getproduct(id);
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }
}
