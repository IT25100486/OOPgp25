package PaymentAndBill;


import java.time.Duration;
import java.time.LocalTime;

class AutoPayment extends invoice {

    private double discount;





    public void calculateDiscount() {
        if (customerType == 'd') {
            discount = 0.05;
        }
        else if (customerType == 'w') {
            discount = 0.1;
        } else if (customerType=='m') {
            discount = 0.2;

        } else if (customerType=='y') {
            discount = 0.3;

        }

    }
@Override
    public double makePayment() {
        Duration timeGap = Duration.between(getStartTime(), getEndTime());
        double hours = timeGap.toHours();
        return makePayment()-makePayment()*discount;
    }



}
