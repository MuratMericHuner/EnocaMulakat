package EnocaMulakat.EnocaMulakat.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@Table(name = "customerorders")
@Getter
@Setter
@NoArgsConstructor
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @ElementCollection
    private Map<String,Integer> products;
    private int totalPrice;
    private int totalQuantity;

    public Order(Map<String, Integer> products, int totalPrice, int totalQuantity) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }
}
