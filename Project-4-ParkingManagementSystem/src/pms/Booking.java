package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Booking {

    private final int ID;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private ElectricCharger charger;
    private String status;
    private int hours;

    //constructors
    public Booking(ParkingSpot parkingSpot, Vehicle vehicle, ElectricCharger charger, int hours) {
        this.ID = generateId();
        setParkingSpot(parkingSpot);
        setVehicle(vehicle);
        setStatus("New");
        setCharger(charger);
        setHours(hours);

    }

    public Booking() {
        this(null, null, null, 0);
    }

    //methods
    private final int generateId() {
        int min = 1;
        int max = 1000;
        int id = (int) (Math.random() * ((max - min) + 1)) + min;
        return id;
    }

    public double calcPayment() {
        double price = getParkingSpot().calcCost();
        double total = getHours() * price;
        if (charger != null) {
            total += (charger.calcCost() * getHours());
        }
        //15% VAT
        total += (total * 0.15);
        return total;
    }

    public final void confirm() {
        setStatus("Confirmed");
        parkingSpot.book();
        parkingSpot.registerVehicle(vehicle);
        if (charger != null) {
            charger.book();
        }
        System.out.println("Your booking has been confirmed.\nDrive safe. Thank you!");
    }

    public final void cancel() {
        setStatus("Cancelled");
        parkingSpot.cancel();
        if (charger != null) {
            charger.cancel();
        }
        System.out.println("Your booking has been cancelled. Thank you!");
    }

    //setters & getters
    public int getID() {
        return ID;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHours() {
        return hours;
    }

    public ElectricCharger getCharger() {
        return charger;
    }

    public void setCharger(ElectricCharger charger) {
        this.charger = charger;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format("Booking id:%d\nBooked Parking Spot:\n%s\nVehicle:\n%s\nChrager:\n%s\nHours: %d\nBooking Status: %s\nTotal Payment: %.2f SAR.", getID(), getParkingSpot(), getVehicle(), getCharger(), getHours(), getStatus(), calcPayment());
    }
}
