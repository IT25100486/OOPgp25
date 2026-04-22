package Service;

import Entity.*;
import Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoPaymentService {
    @Autowired private InvoiceRepository invoiceRepo;
    @Autowired private PaymentRepository paymentRepo;
    @Autowired private AutoPaymentRepository autoRepo;
    @Autowired private RateChartRepository rateRepo;

    public Payment processAutoPay(Long invoiceId, long timeGap, String customerId) {
        Invoice invoice = invoiceRepo.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        RateChart rate = rateRepo.findBySlotType(String.valueOf(invoice.getVehicleType()))
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        double baseAmount = timeGap * rate.getHourlyRate();

        double finalAmount = autoRepo.findByCustomerId(customerId)
                .map(customer -> baseAmount * (1 - customer.getDiscountRate()))
                .orElse(baseAmount);

        Payment payment = new Payment();
        payment.setAmount(finalAmount);
        payment.setTimeGap(timeGap);
        payment.setInvoice(invoice);

        return paymentRepo.save(payment);
    }
}