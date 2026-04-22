package Service;

import Entity.AutoPayment;
import Entity.Invoice;
import Entity.Payment;
import Repository.AutoPaymentRepository;
import Repository.InvoiceRepository;
import Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoPaymentService  {
    @Autowired
    private InvoiceRepository invoiceRepo;
    @Autowired private PaymentRepository paymentRepo;
    @Autowired private AutoPaymentRepository autoRepo;


    public Payment processAutoPay(Long invoiceId, long timeGap, String customerId) {

        Invoice invoice = invoiceRepo.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));


        double ratePerType = 0;
        if (invoice.getVehicleType() == 'C') {
            ratePerType = 20.0;
        } else if (invoice.getVehicleType() == 'B') {
            ratePerType = 10.0;
        }


        double baseAmount = timeGap * ratePerType;


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


