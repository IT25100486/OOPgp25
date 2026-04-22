package Controller;

import Entity.Payment;
import Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping ("/payment")
public class PaymentController {
    private  PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pay")
    public Payment pay(@RequestParam Long invoiceId,
                       @RequestParam double amount,
                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime entryTime,
                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime leavingTime)
    {
        return paymentService.makePayment(invoiceId, amount, entryTime, leavingTime);
    }

}
