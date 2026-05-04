package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public final class VIPSpot extends ParkingSpot {

    private boolean serviceIncluded;

    //constructors
    public VIPSpot(String SPOT_ID, int floorNum, String section, Vehicle[] vehicleRecord, boolean serviceIncluded) {
        super(SPOT_ID, floorNum, section, vehicleRecord);
        setServiceIncluded(serviceIncluded);
    }

    public VIPSpot() {
        this("", 0, "", null, false);
    }

    //methods
    @Override
    public int parkingSpace() {
        return 20;
    }

    @Override
    public double calcCost() {
        double cost = 50.00;
        if (isServiceIncluded()) {
            cost += 15;
        }
        return cost;
    }

    // Method to print VIP spot features
    public void vipFeatures() {
        System.out.println("Features of the VIP Parking Spot:");
        System.out.println("- Prime Location: Closest to the entrance/exit.");
        System.out.println("- Increased Security: Enhanced surveillance and security patrols.");
        System.out.println("- Larger Space: Extra space for larger vehicles or to prevent door dings.");
    }

    public final void upgradeToFullService() {
        if (!serviceIncluded) {
            serviceIncluded = true;
            System.out.println("VIP spot has been upgraded to full service.");
        } else {
            System.out.println("This VIP spot already includes full services.");
        }
    }

    //setters & getters
    public boolean isServiceIncluded() {
        return serviceIncluded;
    }

    public void setServiceIncluded(boolean serviceIncluded) {
        this.serviceIncluded = serviceIncluded;
    }

    @Override
    public String toString() {
        return String.format("%s\nService Included: %s", super.toString(), isServiceIncluded());
    }

}
