package Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class RateChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotType;
    private double hourlyRate;
    private double dailyRate;
    private String updatedBy;
    private LocalDateTime validFrom;
}