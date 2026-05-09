public class DisplayBoard {

    private int totalStandardSlots;
    private int availableStandardSlots;
    private int availablePrioritySlots;

    public void updateSlotCounts(ParkingLot parkingLot) {
        this.totalStandardSlots = parkingLot.getTotalSlots();
        this.availableStandardSlots = parkingLot.getAvailableStandardSlots();
        this.availablePrioritySlots = parkingLot.getAvailablePrioritySlots();
        refreshBoard();
    }

    public void updateFloorAvailability(ParkingFloor floor) {
        int floorAvailable = floor.getAvailableSlotsCount();
        displayMessage("Floor " + floor.getFloorNumber() + " Availability: " + floorAvailable);
    }

    public void refreshBoard() {
        if (availableStandardSlots == 0 && availablePrioritySlots == 0) {
            displayMessage("FULL");
        } else {
            displayMessage("AVAILABLE");
            displayMessage("Standard Slots: " + availableStandardSlots);
            highlightPriorityZone();
        }
    }

    private void highlightPriorityZone() {
        displayMessage("Priority Member Slots Available: " + availablePrioritySlots);
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}