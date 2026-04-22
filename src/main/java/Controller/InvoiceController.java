package Controller;

import Entity.Invoice;
import Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private  final InvoiceService service;

@Autowired
    public InvoiceController(InvoiceService service){
        this.service = service;
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return service.saveInvoice(invoice);
    }



}
