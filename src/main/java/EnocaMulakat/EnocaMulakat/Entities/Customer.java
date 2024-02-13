package EnocaMulakat.EnocaMulakat.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    private String name;
    @OneToOne
    private Cart cart;
    @OneToMany
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
    }
}
