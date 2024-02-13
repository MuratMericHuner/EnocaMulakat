package EnocaMulakat.EnocaMulakat.Service;

import EnocaMulakat.EnocaMulakat.Entities.Customer;
import EnocaMulakat.EnocaMulakat.Entities.Order;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(String name);

    List<Customer> getAllCustomers();

    Order placeOrder(Long id);
    List<Order> getAllOrdersForCustomer(Long id);

    Order getOrderForCode(Long id);
}
