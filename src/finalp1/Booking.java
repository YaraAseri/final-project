package finalp1;

// A booking that links a vehicle to a parking spot.
public class Booking implements Bookable {

    private final int BOOKING_ID;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private String chargerType;
    private String model;
    private String status;
    private int hours;
    private static int count;

    // empty constructor
    public Booking() {
        this(null, null, "", "", "PENDING", MIN_BOOKING_HOURS);
    }

    /**
     * Full constructor.
     * @param parkingSpot the booked parking spot
     * @param vehicle the vehicle being parked
     * @param chargerType the charger type (blank if none)
     * @param model the booking package description
     * @param status the booking status
     * @param hours the number of hours booked
     */
    public Booking(ParkingSpot parkingSpot, Vehicle vehicle, String chargerType,
                   String model, String status, int hours) {
        this.BOOKING_ID = generateId();
        setParkingSpot(parkingSpot);
        setVehicle(vehicle);
        setChargerType(chargerType);
        setModel(model);
        setStatus(status);
        setHours(hours);
        count++;
    }

    private int generateId() {
        int min = 1000;
        int max = 9999;
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public int getBookingId() { return BOOKING_ID; }

    public ParkingSpot getParkingSpot()                 { return parkingSpot; }
    public void setParkingSpot(ParkingSpot parkingSpot) { this.parkingSpot = parkingSpot; }

    public Vehicle getVehicle()             { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public String getChargerType()                 { return chargerType; }
    public void setChargerType(String chargerType) { this.chargerType = chargerType.trim(); }

    public String getModel()           { return model; }
    public void setModel(String model) { this.model = model.trim(); }

    public String getStatus()            { return status; }
    public void setStatus(String status) { this.status = status.trim(); }

    public int getHours() { return hours; }
    public void setHours(int hours) {
        if (hours < MIN_BOOKING_HOURS || hours > MAX_BOOKING_HOURS)
            throw new IllegalArgumentException(
                "Hours must be between " + MIN_BOOKING_HOURS + " and " + MAX_BOOKING_HOURS);
        this.hours = hours;
    }

    public static int getCount()           { return count; }
    public static void setCount(int count) { Booking.count = count; }

    /**
     * @return base cost: spot hourly rate multiplied by hours
     */
    public double calcPrise() {
        if (parkingSpot == null) return 0.0;
        return parkingSpot.calcCost() * hours;
    }

    // Marks this booking as CONFIRMED and prints a summary.
    public void confirm() {
        setStatus("CONFIRMED");
        System.out.println("Booking " + BOOKING_ID + " confirmed for " + hours + " hour(s).");
    }

    @Override
    public void book() {
        if (parkingSpot != null) parkingSpot.book();
        confirm();
    }

    @Override
    public void cancel() {
        setStatus("CANCELLED");
        if (parkingSpot != null) parkingSpot.cancel();
        System.out.println("Booking " + BOOKING_ID + " cancelled.");
    }

    /**
     * @return total cost including 10 SAR charger surcharge if chargerType is set
     */
    @Override
    public double calcCost() {
        double total = calcPrise();
        if (chargerType != null && chargerType.length() > 0) {
            total += 10.0;
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format(
            "Booking ID: %d\nSpot Number: %d\nVehicle Plate: %s\nCharger Type: %s\n" +
            "Model: %s\nStatus: %s\nHours: %d\nTotal Cost: %.2f SAR",
            BOOKING_ID,
            parkingSpot != null ? parkingSpot.getSpotNum() : 0,
            vehicle     != null ? vehicle.getPlate()      : "N/A",
            getChargerType(), getModel(), getStatus(), getHours(), calcCost());
    }
}
