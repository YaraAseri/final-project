package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public final class HandicappedSpot extends ParkingSpot {

    private boolean chairIncluded;

    //constructors
    public HandicappedSpot(String SPOT_ID, int floorNum, String section, Vehicle[] vehicleRecord, boolean chairIncluded) {
        super(SPOT_ID, floorNum, section, vehicleRecord);
        setChairIncluded(chairIncluded);
    }

    public HandicappedSpot() {
        this("", 0, "", null, false);
    }

    //methods
    @Override
    public int parkingSpace() {
        if (chairIncluded) {
            return 20;
        } else {
            return 16;
        }
    }

    @Override
    public double calcCost() {
        return 0.00; // Assuming handicapped spots are free
    }

    public void checkAccessibilityFeatures() {
        if (chairIncluded) {
            System.out.println("This handicapped spot includes accessibility features.");
        } else {
            System.out.println("No additional accessibility features are included with this handicapped spot.");
        }
    }

    //setters & getters
    public boolean isChairIncluded() {
        return chairIncluded;
    }

    public void setChairIncluded(boolean chairIncluded) {
        this.chairIncluded = chairIncluded;
    }

    @Override
    public String toString() {
        return String.format("%s\nChair Included: %s", super.toString(), isChairIncluded());
    }

}
