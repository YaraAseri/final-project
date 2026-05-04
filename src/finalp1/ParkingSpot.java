package finalp1;

// Abstract parking spot — base for Regular, VIP, and Disability spots.
public abstract class ParkingSpot implements Bookable {

    private int spotNum;
    private int floorNum;
    private String section;
    private boolean isAvailable;
    private static int totalparking;
    private Vehicle[] vehicleNumber;

    // empty constructor
    public ParkingSpot() {
        this(0, 0, "", false);
    }

    /**
     * Full constructor.
     * @param spotNum the spot number
     * @param floorNum the floor number
     * @param section the section label
     * @param isAvailable whether the spot is currently free
     */
    public ParkingSpot(int spotNum, int floorNum, String section, boolean isAvailable) {
        setSpotNum(spotNum);
        setFloorNum(floorNum);
        setSection(section);
        setIsAvailable(isAvailable);
        this.vehicleNumber = new Vehicle[0];
        totalparking++;
    }

    public int getSpotNum()    { return spotNum; }
    public void setSpotNum(int spotNum) {
        if (spotNum < 0) throw new IllegalArgumentException("Spot number cannot be negative");
        this.spotNum = spotNum;
    }

    public int getFloorNum()   { return floorNum; }
    public void setFloorNum(int floorNum) {
        if (floorNum < 0) throw new IllegalArgumentException("Floor number cannot be negative");
        this.floorNum = floorNum;
    }

    public String getSection()  { return section; }
    public void setSection(String section) { this.section = section.trim(); }

    public boolean getIsAvailable()                     { return isAvailable; }
    public void setIsAvailable(boolean isAvailable)     { this.isAvailable = isAvailable; }

    public static int getTotalparking()           { return totalparking; }
    public static void setTotalparking(int count) { ParkingSpot.totalparking = count; }

    public Vehicle[] getVehicleNumber()                        { return vehicleNumber; }
    public void setVehicleNumber(Vehicle[] vehicleNumber)      { this.vehicleNumber = vehicleNumber; }

    // Returns total number of ParkingSpot instances created.
    public int EmptyParking() {
        return totalparking;
    }

    public abstract void book();
    public abstract void cancel();
    public abstract double calcCost();

    @Override
    public String toString() {
        return String.format("Spot Number: %d\nFloor: %d\nSection: %s\nAvailable: %b",
            getSpotNum(), getFloorNum(), getSection(), getIsAvailable());
    }
}
