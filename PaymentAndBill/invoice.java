package PaymentAndBill;

import java.time.LocalTime;
import java.time.Duration;

 public class invoice {

    protected String vehicleNumber;
    protected char vehicleType;
    protected char customerType;
     protected double discount;

    protected String customerId;
    protected int ticketId;

    protected LocalTime startTime;
    protected LocalTime endTime;


    protected double amount;

     public invoice() {
     }



     public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public char getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(char vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }



     public char getCustomerType() {
         return customerType;
     }

     public void setCustomerType(char customerType) {
         this.customerType = customerType;
     }

     public double makePayment() {
         Duration timeGap = Duration.between(getStartTime(), getEndTime());
         double hours = timeGap.toHours();

         if (vehicleType == 'A') {
             return hours*100;
         }
         else if (vehicleType == 'B') {
             return hours*200;
         }
         else if (vehicleType == 'C') {
             return hours*300;
         }
         else{
             return 0.00;
         }

     }


     public void printInvoiceDetails() {
         System.out.println("--- INVOICE DETAILS ---");
         System.out.println("Ticket ID: " + this.ticketId);
         System.out.println("Customer ID: " + this.customerId);
         System.out.println("Vehicle Number: " + this.vehicleNumber);
         System.out.println("Vehicle Type: " + this.vehicleType);
         System.out.println("Start Time: " + this.startTime);
         System.out.println("End Time: " + this.endTime);
         System.out.println("Payment is:"+makePayment());

     }

 }
