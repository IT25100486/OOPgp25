package Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private long timeGap;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;
}
