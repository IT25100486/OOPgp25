package Service;

import Entity.Invoice;
import Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepo;

@Autowired
    public InvoiceService(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }


}
