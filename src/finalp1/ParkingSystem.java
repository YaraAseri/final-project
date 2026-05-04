package finalp1;

import java.util.ArrayList;

// Manages all parking spots and bookings in the system.
public class ParkingSystem {

    private ArrayList<ParkingSpot> spots;
    private ArrayList<Booking> bookings;

    public ParkingSystem() {
        spots    = new ArrayList<ParkingSpot>();
        bookings = new ArrayList<Booking>();
    }

    public void addSpot(ParkingSpot spot)       { spots.add(spot); }
    public boolean removeSpot(ParkingSpot spot) { return spots.remove(spot); }

    public void addBooking(Booking booking)       { bookings.add(booking); }
    public boolean removeBooking(Booking booking) { return bookings.remove(booking); }

    public ArrayList<ParkingSpot> getSpots()    { return spots; }
    public ArrayList<Booking>     getBookings() { return bookings; }

    public ParkingSpot findSpotByNum(int spotNum) {
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getSpotNum() == spotNum)
                return spots.get(i);
        }
        return null;
    }

    public Booking findBookingById(int bookingId) {
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingId() == bookingId)
                return bookings.get(i);
        }
        return null;
    }

    public void displayAllSpots() {
        if (spots.size() == 0) { System.out.println("No spots registered."); return; }
        for (int i = 0; i < spots.size(); i++) {
            System.out.println(spots.get(i));
            System.out.println("------------------------------------------");
        }
    }

    public void displayRegularSpots() {
        boolean found = false;
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) instanceof RegularSpot) {
                System.out.println(spots.get(i));
                System.out.println("------------------------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No regular spots found.");
    }

    public void displayVIPSpots() {
        boolean found = false;
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) instanceof VIPSpot) {
                System.out.println(spots.get(i));
                System.out.println("------------------------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No VIP spots found.");
    }

    public void displayDisabilitySpots() {
        boolean found = false;
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i) instanceof DisabilitySpot) {
                System.out.println(spots.get(i));
                System.out.println("------------------------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No disability spots found.");
    }

    public void displayAllBookings() {
        if (bookings.size() == 0) { System.out.println("No bookings found."); return; }
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println(bookings.get(i));
            System.out.println("==========================================");
        }
    }

    public void searchBySection(String keyword) {
        boolean found = false;
        for (int i = 0; i < spots.size(); i++) {
            if (spots.get(i).getSection().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(spots.get(i));
                System.out.println("------------------------------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No spots found in section: " + keyword);
    }

    /**
     * @return total revenue from all CONFIRMED bookings
     */
    public double calculateTotalRevenue() {
        double total = 0.0;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getStatus().equalsIgnoreCase("CONFIRMED"))
                total += bookings.get(i).calcCost();
        }
        return total;
    }
}
