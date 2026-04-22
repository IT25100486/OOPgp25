package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  double hours;
    private  double rate;

    @OneToMany(mappedBy = "invoice" , cascade = CascadeType.ALL)
    private List<Payment> payments;

}
