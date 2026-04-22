package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  double hours;
    private  double rate;
    private  char vehicleType;


    @OneToMany(mappedBy = "invoice" , cascade = CascadeType.ALL)
    private List<Payment> payments;

}
