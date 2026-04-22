package Controller;

import Entity.Payment;
import Service.AutoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/autopay")
public class AutoPaymentController {

    @Autowired
    private AutoPaymentService autoService;

    @PostMapping("/process")
    public Payment process(@RequestParam Long invoiceId,
                           @RequestParam long timeGap,
                           @RequestParam String customerId) {

        return autoService.processAutoPay(invoiceId, timeGap, customerId);
    }
}
