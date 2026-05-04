package finalp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static ParkingSystem system = new ParkingSystem();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        fillList();
        System.out.println("**** Welcome To Parking Spot Booking System ****");
        int choice = 0;
        do {
            try {
                menu();
                choice = Integer.parseInt(input.nextLine().trim());
                switch (choice) {
                    case 1:  addSpot();                    break;
                    case 2:  system.displayAllSpots();     break;
                    case 3:  displayByType();              break;
                    case 4:  searchBySection();            break;
                    case 5:  createBooking();              break;
                    case 6:  cancelBooking();              break;
                    case 7:  system.displayAllBookings();  break;
                    case 8:  showRevenue();                break;
                    case 9:  spotFeature();                break;
                    case 10: showVehicleHistory();         break;
                    case 11: searchVehicleHistory();       break;
                    case 12: removeVehicleFromHistory();   break;
                    case 13: writeText();                  break;
                    case 14: readText();                   break;
                    case 15: openGUI();                    break;
                    case 16: System.out.println("Thank you!"); break;
                    default: System.out.println("Invalid option!");
                }
            } catch (InputMismatchException ex) { System.err.println("Invalid input"); input.nextLine(); }
            catch (NullPointerException ex)     { System.err.println(ex); }
            catch (ClassCastException ex)       { System.err.println(ex); }
            catch (ArrayIndexOutOfBoundsException ex) { System.err.println(ex); }
            catch (Exception ex)                { System.err.println(ex); }
        } while (choice != 16);
    }

    // Prints the menu.
    public static void menu() {
        System.out.print(
            "\n1.  Add Parking Spot.\n"
          + "2.  Display All Spots.\n"
          + "3.  Display Spots by Type.\n"
          + "4.  Search Spot by Section.\n"
          + "5.  Create Booking.\n"
          + "6.  Cancel Booking.\n"
          + "7.  Display All Bookings.\n"
          + "8.  Show Total Revenue.\n"
          + "9.  Show Spot Special Feature.\n"
          + "10. Display Vehicle History.\n"
          + "11. Search Vehicle in History.\n"
          + "12. Remove Vehicle from History.\n"
          + "13. Save Bookings to File.\n"
          + "14. Read Bookings from File.\n"
          + "15. Open GUI.\n"
          + "16. Exit.\n"
          + ">> ");
    }

    // Fills the system with sample data.
    public static void fillList() {
        RegularSpot    r1 = new RegularSpot(1, 1, "A", true,  true);
        RegularSpot    r2 = new RegularSpot(2, 1, "A", true,  false);
        VIPSpot        v1 = new VIPSpot(3, 2, "B",     true,  true);
        VIPSpot        v2 = new VIPSpot(4, 2, "B",     true,  false);
        DisabilitySpot d1 = new DisabilitySpot(5, 1, "C", true,  true,  1001, "Ahmed Ali");
        DisabilitySpot d2 = new DisabilitySpot(6, 1, "C", false, false, 1002, "Sara Mohamed");

        system.addSpot(r1); system.addSpot(r2);
        system.addSpot(v1); system.addSpot(v2);
        system.addSpot(d1); system.addSpot(d2);

        Vehicle veh1 = new Vehicle("ABC123", "Toyota", "Toyota Group");
        Vehicle veh2 = new Vehicle("XYZ789", "Honda",  "Honda Group");
        Vehicle veh3 = new Vehicle("LMN456", "BMW",    "BMW Group");

        Booking b1 = new Booking(r1, veh1, "",             "Standard", "CONFIRMED", 3);
        Booking b2 = new Booking(v1, veh2, "Fast Charger", "Premium",  "CONFIRMED", 2);
        system.addBooking(b1);
        system.addBooking(b2);

        appendVehicle(r1, veh1);
        appendVehicle(r1, veh2);
        appendVehicle(v1, veh3);
    }

    // ── SPOT MANAGEMENT ──────────────────────────────────────────────────────

    private static void addSpot() {
        System.out.println("Spot type: 1=Regular  2=VIP  3=Disability");
        int type       = Integer.parseInt(input.nextLine().trim());
        int spotNum    = readPositiveInt("Spot number: ");
        int floorNum   = readPositiveInt("Floor number: ");
        String section = readModel("Section (e.g. A1): ");
        boolean avail  = readBoolean("Available (true/false): ");

        if (type == 1) {
            boolean covered = readBoolean("Covered (true/false): ");
            system.addSpot(new RegularSpot(spotNum, floorNum, section, avail, covered));
            System.out.println("Regular spot added.");
        } else if (type == 2) {
            boolean valet = readBoolean("Valet driver (true/false): ");
            system.addSpot(new VIPSpot(spotNum, floorNum, section, avail, valet));
            System.out.println("VIP spot added.");
        } else if (type == 3) {
            boolean chair     = readBoolean("Chair included (true/false): ");
            int permitId      = readPositiveInt("Disability permit ID: ");
            String holderName = readName("Permit holder name: ");
            system.addSpot(new DisabilitySpot(spotNum, floorNum, section,
                avail, chair, permitId, holderName));
            System.out.println("Disability spot added.");
        } else {
            System.out.println("Invalid spot type.");
        }
    }

    private static void displayByType() {
        System.out.println("Type: 1=Regular  2=VIP  3=Disability");
        int type = Integer.parseInt(input.nextLine().trim());
        if      (type == 1) system.displayRegularSpots();
        else if (type == 2) system.displayVIPSpots();
        else if (type == 3) system.displayDisabilitySpots();
        else System.out.println("Invalid type.");
    }

    private static void searchBySection() {
        String keyword = readModel("Section keyword: ");
        system.searchBySection(keyword);
    }

    // ── BOOKING MANAGEMENT ───────────────────────────────────────────────────

    private static void createBooking() {
        int spotNum = readPositiveInt("Spot number to book: ");
        ParkingSpot spot = system.findSpotByNum(spotNum);
        if (spot == null)           { System.out.println("Spot not found.");        return; }
        if (!spot.getIsAvailable()) { System.out.println("Spot is not available."); return; }

        String plate   = readPlate("Vehicle plate: ");
        String vModel  = readModel("Vehicle model: ");
        String company = readModel("Vehicle company: ");
        Vehicle vehicle = new Vehicle(plate, vModel, company);

        System.out.print("Charger type (leave blank for none): ");
        String chargerType = input.nextLine().trim();
        String bookModel   = readModel("Booking package: ");
        int hours = readIntInRange(
            "Hours (" + Bookable.MIN_BOOKING_HOURS + "-" + Bookable.MAX_BOOKING_HOURS + "): ",
            Bookable.MIN_BOOKING_HOURS, Bookable.MAX_BOOKING_HOURS);

        Booking booking = new Booking(spot, vehicle, chargerType, bookModel, "PENDING", hours);
        booking.book();
        system.addBooking(booking);
        appendVehicle(spot, vehicle);
        System.out.printf("Booking created. Total cost: %.2f SAR%n", booking.calcCost());
    }

    private static void cancelBooking() {
        int id = readPositiveInt("Booking ID to cancel: ");
        Booking booking = system.findBookingById(id);
        if (booking == null) { System.out.println("Booking not found."); return; }
        booking.cancel();
    }

    private static void showRevenue() {
        System.out.printf("Total confirmed revenue: %.2f SAR%n", system.calculateTotalRevenue());
    }

    // ── INSTANCEOF + DOWNCAST ────────────────────────────────────────────────

    private static void spotFeature() {
        int spotNum = readPositiveInt("Spot number: ");
        ParkingSpot spot = system.findSpotByNum(spotNum);
        if (spot == null) { System.out.println("Spot not found."); return; }

        if (spot instanceof RegularSpot) {
            RegularSpot r = (RegularSpot) spot;
            r.upgradeToVip();
        } else if (spot instanceof VIPSpot) {
            VIPSpot v = (VIPSpot) spot;
            v.vipFeatures();
        } else if (spot instanceof DisabilitySpot) {
            DisabilitySpot d = (DisabilitySpot) spot;
            d.checkAccessibilityFeature();
        }
    }

    // ── ARRAY CRUD (ParkingSpot.vehicleNumber[]) ─────────────────────────────

    // Grows vehicleNumber[] by one — called automatically inside createBooking().
    private static void appendVehicle(ParkingSpot spot, Vehicle v) {
        Vehicle[] old     = spot.getVehicleNumber();
        Vehicle[] updated = new Vehicle[old.length + 1];
        for (int i = 0; i < old.length; i++) {
            updated[i] = old[i];
        }
        updated[old.length] = v;
        spot.setVehicleNumber(updated);
    }

    // Iterates vehicleNumber[].
    private static void showVehicleHistory() {
        int spotNum = readPositiveInt("Spot number: ");
        ParkingSpot spot = system.findSpotByNum(spotNum);
        if (spot == null) { System.out.println("Spot not found."); return; }

        Vehicle[] history = spot.getVehicleNumber();
        if (history.length == 0) { System.out.println("No vehicle history for this spot."); return; }

        System.out.println("Vehicle history for spot " + spotNum + ":");
        for (int i = 0; i < history.length; i++) {
            System.out.println(history[i]);
            System.out.println("------------------------------------------");
        }
    }

    // Searches vehicleNumber[] by plate.
    private static void searchVehicleHistory() {
        int spotNum = readPositiveInt("Spot number: ");
        ParkingSpot spot = system.findSpotByNum(spotNum);
        if (spot == null) { System.out.println("Spot not found."); return; }

        String plate      = readPlate("Plate to search: ");
        Vehicle[] history = spot.getVehicleNumber();
        boolean found     = false;
        for (int i = 0; i < history.length; i++) {
            if (history[i].getPlate().equalsIgnoreCase(plate)) {
                System.out.println(history[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Vehicle not found in history.");
    }

    // Shrinks vehicleNumber[] by removing the first vehicle matching the given plate.
    private static void removeVehicleFromHistory() {
        int spotNum = readPositiveInt("Spot number: ");
        ParkingSpot spot = system.findSpotByNum(spotNum);
        if (spot == null) { System.out.println("Spot not found."); return; }

        String plate      = readPlate("Plate to remove: ");
        Vehicle[] history = spot.getVehicleNumber();

        int index = -1;
        for (int i = 0; i < history.length; i++) {
            if (history[i].getPlate().equalsIgnoreCase(plate)) { index = i; break; }
        }
        if (index == -1) { System.out.println("Vehicle not found in history."); return; }

        Vehicle[] updated = new Vehicle[history.length - 1];
        for (int i = 0, j = 0; i < history.length; i++) {
            if (i != index) { updated[j] = history[i]; j++; }
        }
        spot.setVehicleNumber(updated);
        System.out.println("Vehicle " + plate + " removed from history.");
    }

    // ── FILE I/O ─────────────────────────────────────────────────────────────

    /** Saves all bookings to the text file. */
    public static void writeText() {
        try {
            Formatter output = new Formatter("bookings.txt");
            if (system.getBookings().isEmpty()) {
                System.out.println("No bookings yet.");
            } else {
                for (Booking ele : system.getBookings()) {
                    output.format(ele.toString() + "\n");
                    output.format("\n---------------------------------------------\n");
                }
                System.out.println("All bookings saved to the text file bookings.txt");
            }
            output.close();
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            System.err.println(ex);
        }
    }

    /** Reads the text file line by line and prints each line. */
    public static void readText() {
        try {
            Scanner fileIn = new Scanner(new File("bookings.txt"));
            while (fileIn.hasNextLine()) {
                System.out.println(fileIn.nextLine());
            }
            fileIn.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
            System.err.println(ex);
        } catch (NoSuchElementException ex) {
            System.err.println("File improperly formed.");
            System.err.println(ex);
        } catch (IllegalStateException ex) {
            System.err.println("Error reading from file.");
            System.err.println(ex);
        }
    }

    // ── GUI ──────────────────────────────────────────────────────────────────

    private static void openGUI() {
        try {
            GUI.main(null);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    // ── VALIDATION HELPERS ───────────────────────────────────────────────────

    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            boolean valid = line.length() > 0;
            for (int i = 0; i < line.length() && valid; i++) {
                if (!Character.isDigit(line.charAt(i))) valid = false;
            }
            if (valid) {
                int val = Integer.parseInt(line);
                if (val > 0) return val;
            }
            System.out.println("Invalid input. Enter a positive whole number.");
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            boolean valid = line.length() > 0;
            for (int i = 0; i < line.length() && valid; i++) {
                if (!Character.isDigit(line.charAt(i))) valid = false;
            }
            if (valid) {
                int val = Integer.parseInt(line);
                if (val >= min && val <= max) return val;
            }
            System.out.println("Invalid input. Enter a number between " + min + " and " + max + ".");
        }
    }

    private static boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            if (line.equalsIgnoreCase("true"))  return true;
            if (line.equalsIgnoreCase("false")) return false;
            System.out.println("Invalid input. Enter true or false.");
        }
    }

    private static String readName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            if (line.length() >= 2 && line.length() <= 50) {
                boolean valid = true;
                for (int i = 0; i < line.length() && valid; i++) {
                    char c = line.charAt(i);
                    if (!Character.isLetter(c) && c != ' ') valid = false;
                }
                if (valid) return line;
            }
            System.out.println("Invalid input. Letters and spaces only, length 2-50.");
        }
    }

    private static String readPlate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim().toUpperCase();
            if (line.length() >= 6 && line.length() <= 8) {
                boolean valid = true;
                for (int i = 0; i < line.length() && valid; i++) {
                    if (!Character.isLetterOrDigit(line.charAt(i))) valid = false;
                }
                if (valid) return line;
            }
            System.out.println("Invalid plate. Uppercase letters and digits only, length 6-8.");
        }
    }

    private static String readModel(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            if (line.length() >= 2 && line.length() <= 50) {
                boolean valid = true;
                for (int i = 0; i < line.length() && valid; i++) {
                    char c = line.charAt(i);
                    if (!Character.isLetterOrDigit(c) && c != ' ') valid = false;
                }
                if (valid) return line;
            }
            System.out.println("Invalid input. Letters, digits, and spaces only, length 2-50.");
        }
    }
}
