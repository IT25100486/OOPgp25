package Controller;

import Entity.Payment;
import Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/payment")
public class PaymentController {
    private  PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping ("/pay")
    public Payment pay(@RequestParam Long invoiceId,
                       @RequestParam double amount,
                       @RequestParam long timeGap)
    {
        return paymentService.makePayment(invoiceId, amount, timeGap);
    }


}
