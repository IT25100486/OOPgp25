package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private long timeGap;
    private LocalTime entryTime;
    private LocalTime leavingTime;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;
}
