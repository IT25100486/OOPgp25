public class EntrancePanel {

    private ParkingSlot assignedSlot;

    public void scanMembershipCard(MembershipCard card, ParkingLot lot, Attendant attendant) {
        if (card.isActive()) {
            greetMember(card.getCustomerName());
            this.assignedSlot = lot.findNearestPrioritySlot();
            openBarrier();
        } else {
            notifyAttendant(attendant, "Invalid Membership Card");
        }
    }

    public void scanLicensePlate(String licensePlate, ParkingLot lot) {
        this.assignedSlot = lot.findNearestStandardSlot();
        issueStandardTicket(licensePlate, this.assignedSlot);
        openBarrier();
    }

    public void checkReservation(Reservation reservation, ParkingLot lot) {
        if (reservation.isValid()) {
            this.assignedSlot = reservation.getAssignedSlot();
            openBarrier();
        }
    }

    private void greetMember(String name) {
        System.out.println("Welcome back, " + name);
    }

    private Ticket issueStandardTicket(String licensePlate, ParkingSlot slot) {
        return new Ticket(licensePlate, slot, false);
    }

    private void openBarrier() {
    }

    private void notifyAttendant(Attendant attendant, String message) {
    }
}