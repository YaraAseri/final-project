package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public final class RegularSpot extends ParkingSpot {

    private int distance; //distance in meters from nearest entrance

    //constructors
    public RegularSpot(String SPOT_ID, int floorNum, String section, Vehicle[] vehicleRecord, int distance) {
        super(SPOT_ID, floorNum, section, vehicleRecord);
        setDistance(distance);
    }

    public RegularSpot() {
        this("", 0, "", null, 0);
    }

    //methods
    @Override
    public int parkingSpace() {
        return 6;
    }

    @Override
    public double calcCost() {
        // Regular spots might cost less the farther they are from the entrance
        double cost = 20.00; // Base cost for regular parking per day
        if (distance < 50) {//50 meters
            cost += 5;
        }
        return cost;
    }

    //setters & getters
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("%s\nDistance From Entrance: %d meters", super.toString(), getDistance());
    }
}
