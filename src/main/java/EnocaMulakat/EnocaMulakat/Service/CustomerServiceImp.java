package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Cart;
import EnocaMulakat.EnocaMulakat.Entities.Customer;
import EnocaMulakat.EnocaMulakat.Entities.Order;
import EnocaMulakat.EnocaMulakat.Entities.Product;
import EnocaMulakat.EnocaMulakat.Repo.CartRepo;
import EnocaMulakat.EnocaMulakat.Repo.CustomerRepo;
import EnocaMulakat.EnocaMulakat.Repo.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepo customerRepo;
    private final CartRepo cartRepo;
    private final OrderRepo orderRepo;

    @Override
    @Transactional
    public Customer addCustomer(String name) {
        Cart cart = new Cart();
        List<Order> orders = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setName(name);
        customer1.setCart(cart);
        customer1.setOrders(orders);
        cartRepo.save(cart);
        return customerRepo.save(customer1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional
    public Order placeOrder(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow();
        Cart cart = customer.getCart();
        int totalQuantity = customer.getCart().getProducts().values().stream().reduce(0,Integer::sum);
        int totalPrice = customer.getCart().getProducts().entrySet().stream().mapToInt(product -> product.getKey().getPrice()*product.getValue()).sum();
        Map<String,Integer> orderProduct = new HashMap<>();
        for(Map.Entry<Product,Integer> entry: cart.getProducts().entrySet()){
            orderProduct.put(entry.getKey().getName(),entry.getValue());
        }
        Order order = new Order(orderProduct,totalPrice,totalQuantity);
        orderRepo.save(order);
        customer.getOrders().add(order);
        customer.getCart().getProducts().clear();
        return order;
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long id) {
        return customerRepo.findById(id).orElseThrow().getOrders();
    }

    @Override
    public Order getOrderForCode(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }
}
