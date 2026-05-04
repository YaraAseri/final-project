package finalp1;

// A standard covered or uncovered parking spot.
public class RegularSpot extends ParkingSpot {

    private boolean covered;

    // empty constructor
    public RegularSpot() {
        this(0, 0, "", false, false);
    }

    /**
     * Full constructor.
     * @param spotNum the spot number
     * @param floorNum the floor number
     * @param section the section label
     * @param isAvailable whether the spot is free
     * @param covered whether the spot has a roof
     */
    public RegularSpot(int spotNum, int floorNum, String section, boolean isAvailable, boolean covered) {
        super(spotNum, floorNum, section, isAvailable);
        setCovered(covered);
    }

    public boolean getCovered()             { return covered; }
    public void setCovered(boolean covered) { this.covered = covered; }

    /**
     * @return hourly rate for this regular spot
     */
    public double calcPrise() {
        return covered ? 7.0 : 5.0;
    }

    @Override
    public double calcCost() {
        return calcPrise();
    }

    /**
     * @return total parking spots in the system
     */
    public int parkingSpace() {
        return getTotalparking();
    }

    // Prints an upgrade offer to VIP for this spot.
    public void upgradeToVip() {
        System.out.println("Spot " + getSpotNum() + " can be upgraded to VIP. Contact the front desk.");
    }

    @Override
    public void book() {
        setIsAvailable(false);
        System.out.println("Regular spot " + getSpotNum() + " booked.");
    }

    @Override
    public void cancel() {
        setIsAvailable(true);
        System.out.println("Regular spot " + getSpotNum() + " booking cancelled.");
    }

    @Override
    public String toString() {
        return String.format("%s\nCovered: %b", super.toString(), getCovered());
    }
}
