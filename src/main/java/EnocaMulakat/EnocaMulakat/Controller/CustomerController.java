package EnocaMulakat.EnocaMulakat.Controller;

import EnocaMulakat.EnocaMulakat.Entities.Cart;
import EnocaMulakat.EnocaMulakat.Entities.Customer;
import EnocaMulakat.EnocaMulakat.Entities.Order;
import EnocaMulakat.EnocaMulakat.Service.CartService;
import EnocaMulakat.EnocaMulakat.Service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CartService cartService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody String name){
        return customerService.addCustomer(name);
    }
    @GetMapping("/all")
    public List<Customer> allCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}/cart")
    public Cart getCustomersCart(@PathVariable("id") Long customerId){
        return cartService.getCart(customerId);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getCustomersOrders(@PathVariable("id") Long customerId){
        return customerService.getAllOrdersForCustomer(customerId);
    }
    @PostMapping("/{id}/placeorder")
    public Order placeCustomerOrder(@PathVariable("id")Long id){
        return customerService.placeOrder(id);
    }
    @GetMapping("/orders/{id}")
    public Order getOrdersByCode(@PathVariable("id") Long id){
        return customerService.getOrderForCode(id);
    }
    @DeleteMapping("/cart/{id}")
    public void emptyCart(@PathVariable("id") Long customerId){
        cartService.emptyCart(customerId);
    }

    @PutMapping("/addtocart/{customerId}/{productId}")
    public Cart addProductToCart(@PathVariable("customerId") Long customerId,@PathVariable("productId") Long productId){
        return cartService.addproductToCart(customerId,productId);
    }
    @PutMapping("/deletefromcart/{customerId}/{productId}")
    public Cart deleteProductFromCart(@PathVariable("customerId") Long customerId,@PathVariable("productId") Long productId){
        return cartService.deleteProductFromCart(customerId,productId);
    }
}
