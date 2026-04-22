package Repository;

import Entity.RateChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RateChartRepository extends JpaRepository<RateChart, Long> {
    Optional<RateChart> findBySlotType(String slotType);
}
