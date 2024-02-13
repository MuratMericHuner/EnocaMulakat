package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Cart;
import EnocaMulakat.EnocaMulakat.Entities.Product;

public interface CartService {

    Cart getCart(Long id);
    void emptyCart(Long id);
    Cart addproductToCart(Long id,Long productId);
    Cart deleteProductFromCart(Long id,Long productId);
}
