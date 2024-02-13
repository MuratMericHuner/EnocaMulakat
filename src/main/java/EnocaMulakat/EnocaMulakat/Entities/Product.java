package EnocaMulakat.EnocaMulakat.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    private String name;
    private int price;
    private int quantity;
    private int originalQuantity;

    public Product(String name, int price, int quantity, int originalQuantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.originalQuantity = originalQuantity;
    }
}
