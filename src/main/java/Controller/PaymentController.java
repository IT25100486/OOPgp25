package Controller;

import Entity.Payment;
import Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping ("/payment")
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public Payment pay(@RequestParam Long invoiceId,
                       @RequestParam String entry,
                       @RequestParam String leaving)
    {

        LocalTime entryTime = LocalTime.parse(entry);
        LocalTime leavingTime = LocalTime.parse(leaving);


        return paymentService.makePayment(invoiceId, entryTime, leavingTime);
    }
}