package EnocaMulakat.EnocaMulakat.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    @ElementCollection
    private Map<Product,Integer> products;

}
