package Repository;

import Entity.AutoPayment;
import Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoPaymentRepository extends JpaRepository<AutoPayment, Long> {

    Optional<AutoPayment> findByCustomerId(String customerId);



}
