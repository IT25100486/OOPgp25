package PaymentAndBill;
import java.time.LocalTime;

public class mainC {
    static void main() {
        invoice i = new invoice();
        i.setCustomerId("2345"); // Link to M1
        i.setTicketId(101);       // Link to M3
        i.setVehicleType('A');
        i.setVehicleNumber("WP-1234");
        i.setStartTime(LocalTime.of(13, 0));
        i.setEndTime(LocalTime.of(15, 0));
        i.setCustomerType('w');
        i.makePayment();
        i.printInvoiceDetails();
    }
}
