package finalp1;

// A premium VIP parking spot with optional valet service.
public class VIPSpot extends ParkingSpot {

    private boolean valetDriver;

    // empty constructor
    public VIPSpot() {
        this(0, 0, "", false, false);
    }

    /**
     * Full constructor.
     * @param spotNum the spot number
     * @param floorNum the floor number
     * @param section the section label
     * @param isAvailable whether the spot is free
     * @param valetDriver whether valet service is included
     */
    public VIPSpot(int spotNum, int floorNum, String section, boolean isAvailable, boolean valetDriver) {
        super(spotNum, floorNum, section, isAvailable);
        setValetDriver(valetDriver);
    }

    public boolean getValetDriver()                 { return valetDriver; }
    public void setValetDriver(boolean valetDriver) { this.valetDriver = valetDriver; }

    /**
     * @return hourly rate for this VIP spot
     */
    public double calcPrise() {
        return valetDriver ? 20.0 : 15.0;
    }

    @Override
    public double calcCost() {
        return calcPrise();
    }

    @Override
    public int EmptyParking() {
        return getTotalparking();
    }

    // Displays VIP-exclusive features for this spot.
    public void vipFeatures() {
        System.out.println("VIP Spot " + getSpotNum() + " — Reserved area, 24/7 security"
            + (valetDriver ? ", Valet included." : "."));
    }

    @Override
    public void book() {
        setIsAvailable(false);
        System.out.println("VIP spot " + getSpotNum() + " booked.");
    }

    @Override
    public void cancel() {
        setIsAvailable(true);
        System.out.println("VIP spot " + getSpotNum() + " booking cancelled.");
    }

    @Override
    public String toString() {
        return String.format("%s\nValet Driver: %b", super.toString(), getValetDriver());
    }
}
