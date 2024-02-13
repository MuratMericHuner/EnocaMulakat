package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Cart;
import EnocaMulakat.EnocaMulakat.Entities.Customer;
import EnocaMulakat.EnocaMulakat.Entities.Product;
import EnocaMulakat.EnocaMulakat.Repo.CartRepo;
import EnocaMulakat.EnocaMulakat.Repo.CustomerRepo;
import EnocaMulakat.EnocaMulakat.Repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CartServiceImp implements CartService{

    private final ProductRepo productRepo;
    private final CustomerRepo customerRepo;
    private final CartRepo cartRepo;

    @Override
    public Cart getCart(Long id) {
        return customerRepo.findById(id).orElseThrow().getCart();
    }

    @Override
    @Transactional
    public void emptyCart(Long id) {
        Cart cart =customerRepo.findById(id).orElseThrow().getCart();
        if(cart.getProducts()!= null){
            for(Map.Entry<Product,Integer> entry: cart.getProducts().entrySet()){
                Product product = productRepo.findById(entry.getKey().getProductId()).orElseThrow();
                int quantity = entry.getValue();
                product.setQuantity(product.getQuantity()+quantity);
            }
            cart.getProducts().clear();
        }
    }

    @Override
    @Transactional
    public Cart addproductToCart(Long id,Long productId) {
        Cart cart = customerRepo.findById(id).orElseThrow().getCart();
        Product product = productRepo.findById(productId).orElseThrow(()-> new IllegalStateException("There is  no such product"));
        if(product.getQuantity()>0) {
            int productQuantity = cart.getProducts().getOrDefault(product,0);
            cart.getProducts().put(product, productQuantity+1);
            product.setQuantity(product.getQuantity()-1);
        }
        return cart;
    }

    @Override
    @Transactional
    public Cart deleteProductFromCart(Long id,Long productId) {
        Cart cart = customerRepo.findById(id).orElseThrow().getCart();
        Product product = productRepo.findById(productId).orElseThrow(()-> new IllegalStateException("There is  no such product"));
        if(cart.getProducts().get(product)-1 == 0) {
            cart.getProducts().remove(product);
        }else{
            if(cart.getProducts().get(product)!=null){
                int productQuantity = cart.getProducts().get(product);
                cart.getProducts().put(product, productQuantity-1);
                product.setQuantity(product.getQuantity()+1);
            }
        }
        return cart;
    }
}
