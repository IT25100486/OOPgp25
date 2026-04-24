public class ExitPanel {

    public void processExit(Ticket ticket, ParkingSlot slot, Attendant attendant) {
        scanTicket(ticket);
        
        if (ticket.isRegistered()) {
            triggerAutoPayment(ticket);
        } else {
            processManualPayment(ticket, attendant);
        }
        
        signalSlotFree(slot);
        openBarrier();
    }

    private void scanTicket(Ticket ticket) {
        ticket.computeDuration();
    }

    private void triggerAutoPayment(Ticket ticket) {
        AutoPayment autoPayment = new AutoPayment();
        autoPayment.deductFee(ticket);
    }

    private void processManualPayment(Ticket ticket, Attendant attendant) {
        Invoice invoice = new Invoice(ticket);
        showInvoice(invoice.getTotalAmount());
        
        Payment payment = new Payment();
        boolean success = payment.collectManualPayment(invoice.getTotalAmount());
        
        if (!success) {
            notifyAttendant(attendant, "Payment Failed");
        }
    }

    private void showInvoice(double amount) {
        System.out.println("Total Amount Due: $" + amount);
    }

    private void signalSlotFree(ParkingSlot slot) {
        slot.markAsFree();
    }

    private void openBarrier() {
    }

    private void notifyAttendant(Attendant attendant, String message) {
    }
}