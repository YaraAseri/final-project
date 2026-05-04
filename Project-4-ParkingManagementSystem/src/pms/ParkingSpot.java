package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public abstract class ParkingSpot implements Bookable {

    private final String SPOT_ID;
    private int floorNum;
    private String section;//A,B,C
    private boolean available;
    private Vehicle[] vehicleRecord;//previous vehicles parked in the spot
    private static int totalParkingSpot;

    //constructors
    public ParkingSpot(String SPOT_ID, int floorNum, String section, Vehicle[] vehicleRecord) {
        this.SPOT_ID = SPOT_ID;
        setFloorNum(floorNum);
        setAvailable(true);
        setSection(section);
        setVehicleRecord(vehicleRecord);
        totalParkingSpot++;
    }

    public ParkingSpot() {
        this(" ", 0, " ", null);
    }

    //methods
    public abstract int parkingSpace();//parking space area

    @Override
    public void book() {
        if (available == false) {
            System.out.println("Sorry, this spot is unavailable!");
        } else {
            this.available = false;
            System.out.println("The spot has been reserved");
        }
    }

    @Override
    public void cancel() {
        setAvailable(true);
        System.out.println("The spot is available now.");
    }

    public final void registerVehicle(Vehicle v) {

        Vehicle[] arr = new Vehicle[vehicleRecord.length + 1];
        //copy vehicleRecord array into arr
        int i;
        for (i = 0; i < vehicleRecord.length; i++) {
            arr[i] = vehicleRecord[i];
        }

        //add the new vehicle
        arr[i] = v;

        //re-assign the new record arr
        vehicleRecord = arr;
        System.out.println("Car has been registered successfully to the spot.");
    }

    public final void displayPreviousVehicles() {
        if (vehicleRecord.length == 0) {
            System.out.println("No previous vehicles are parked in this spot.");
        } else {
            System.out.println("Previous Vehicles Parked in this Spot: ");
            for (Vehicle v : vehicleRecord) {
                System.out.println(v);
                System.out.println("------------------------------");

            }
        }
    }

    //setter & getters
    public String getSPOT_ID() {
        return SPOT_ID;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Vehicle[] getVehicleRecord() {
        return vehicleRecord;
    }

    public void setVehicleRecord(Vehicle[] vehicleRecord) {
        this.vehicleRecord = vehicleRecord;
    }

    public static int getTotalParkingSpot() {
        return totalParkingSpot;
    }

    public static void setTotalParkingSpot(int totalParkingSpot) {
        ParkingSpot.totalParkingSpot = totalParkingSpot;
    }

    @Override
    public String toString() {
        return String.format("Spot Id: %s\nLevel: %d\nSection: %s\nAvailable: %s", getSPOT_ID(), getFloorNum(), getSection(), isAvailable());
    }

}
