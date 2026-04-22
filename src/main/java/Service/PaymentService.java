package Service;

import Entity.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.Duration;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepo;
    private final InvoiceRepository invoiceRepo;
    private final RateChartRepository rateRepo;

    @Autowired
    public PaymentService(InvoiceRepository invoiceRepo, PaymentRepository paymentRepo, RateChartRepository rateRepo) {
        this.invoiceRepo = invoiceRepo;
        this.paymentRepo = paymentRepo;
        this.rateRepo = rateRepo;
    }

    public Payment makePayment(Long invoiceId, LocalTime entryTime, LocalTime leavingTime) {
        Invoice invoice = invoiceRepo.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));


        String type = String.valueOf(invoice.getVehicleType());
        RateChart rate = rateRepo.findBySlotType(type)
                .orElseThrow(() -> new RuntimeException("Rate not defined for: " + type));

        long hours = Duration.between(entryTime, leavingTime).toHours();


        double calculatedAmount = (hours >= 24) ? (hours / 24.0) * rate.getDailyRate() : hours * rate.getHourlyRate();

        Payment payment = new Payment();
        payment.setAmount(calculatedAmount);
        payment.setTimeGap(hours);
        payment.setInvoice(invoice);

        return paymentRepo.save(payment);
    }
}