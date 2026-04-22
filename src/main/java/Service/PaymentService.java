package Service;

import Entity.Invoice;
import Entity.Payment;
import Repository.InvoiceRepository;
import Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentRepository paymentRepo;
    private InvoiceRepository invoiceRepo;

    public PaymentService(InvoiceRepository invoiceRepo, PaymentRepository paymentRepo) {
        this.invoiceRepo = invoiceRepo;
        this.paymentRepo = paymentRepo;
    }

    public Payment makePayment(Long invoiceId, double amount, long timeGap) {
        Invoice invoice = invoiceRepo.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));


        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setTimeGap(timeGap);
        payment.setInvoice(invoice);
        return paymentRepo.save(payment);


    }

}
