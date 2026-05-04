package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class ElectricCharger implements Bookable {

    private final String STATION_ID;
    private boolean available;
    private int chargingPower; // ee.g. 300 kW
    private static int totalChargers;

    //constructors
    public ElectricCharger(String STATION_ID, int chargingPower) {
        this.STATION_ID = STATION_ID;
        setAvailable(true);// By default, the station is available.
        setChargingPower(chargingPower);
        totalChargers++;
    }

    public ElectricCharger() {
        this("", 0);
    }

    //methods
    public static void supportedCars() {
        System.out.println("The Electric Chargers support the following cars:");
        System.out.println("Tesla Model S, 3, X, Y");
        System.out.println("Hyundai Kona Electric and Ioniq Electric");
        System.out.println("Nissan Leaf");
        System.out.println("BMW i3 and iX3");
    }

    @Override
    public void book() {
        if (available) {
            available = false;
            System.out.println("Charging station " + STATION_ID + " has been booked.");
        } else {
            System.out.println("Charging station " + STATION_ID + " is currently unavailable.");
        }
    }

    @Override
    public void cancel() {
        if (!available) {
            available = true;
            System.out.println("Booking for charging station " + STATION_ID + " has been cancelled.");
        }
    }

    @Override
    public double calcCost() {

        double pricePerHours;
        if (chargingPower > 300) {
            pricePerHours = 20;
        } else {
            pricePerHours = 10;
        }
        return pricePerHours;
    }

    //setters & getters
    public String getStation_ID() {
        return STATION_ID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getChargingPower() {
        return chargingPower;
    }

    public void setChargingPower(int chargingPower) {
        this.chargingPower = chargingPower;
    }

    public static int getTotalChargers() {
        return totalChargers;
    }

    public static void setTotalChargers(int totalChargers) {
        ElectricCharger.totalChargers = totalChargers;
    }

    @Override
    public String toString() {
        return String.format("Station Id: %s\nCharging Power: %d KW\nAvailble: %s\nPrice/Hour: %.2f SAR.", getStation_ID(), getChargingPower(), isAvailable(), calcCost());
    }
}
