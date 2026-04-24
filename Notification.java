public class Notification {

    public void sendEntryMessage(RegisteredCustomer customer, String time) {
        String contactInfo = customer.getContactInfo();
        sendEmail(contactInfo, "Entry recorded at " + time);
    }

    public void sendExitMessage(RegisteredCustomer customer, String time) {
        String contactInfo = customer.getContactInfo();
        sendEmail(contactInfo, "Exit recorded at " + time);
    }

    public void sendAutoDeductionAlert(RegisteredCustomer customer, double amount) {
        String contactInfo = customer.getContactInfo();
        sendSMS(contactInfo, "Auto-deduction of $" + amount + " successful.");
    }

    public void sendRenewalAlert(RegisteredCustomer customer) {
        String contactInfo = customer.getContactInfo();
        sendEmail(contactInfo, "Your subscription has been renewed.");
    }

    public void sendExpiryAlert(RegisteredCustomer customer) {
        String contactInfo = customer.getContactInfo();
        sendSMS(contactInfo, "Warning: Your subscription is nearing expiry.");
    }

    public void sendOverstayAlert(User user) {
        String contactInfo = user.getContactInfo();
        sendSMS(contactInfo, "Alert: You have exceeded your parking duration limit.");
    }

    private void sendSMS(String phoneNumber, String message) {
    }

    private void sendEmail(String emailAddress, String message) {
    }
}