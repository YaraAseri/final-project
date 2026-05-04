package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static ArrayList<ParkingSpot> list = new ArrayList<ParkingSpot>();
    static ArrayList<Booking> bookingList = new ArrayList<Booking>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        fillList(list);
        System.out.println("*** WELCOME TO PARKING MANAGEMENT SYSTEM ***");
        do {
            try {
                menu();
                choice = input.nextInt();
                switch (choice) {

                    case 1://Display Parking Spots.
                        for (ParkingSpot ele : list) {
                            if (ele instanceof ParkingSpot) {
                                // Polymorphic methods(Polymorphism)
                                System.out.println(ele.getClass().getSimpleName());
                                System.out.println(ele);
                                System.out.printf("Price Per One Hour: %.2f SAR.\n", ele.calcCost());
                                System.out.println("Space Area: " + ele.parkingSpace());
                                //downcasting to call specific methods of a sub class.
                                if (ele instanceof HandicappedSpot) {
                                    ((HandicappedSpot) ele).checkAccessibilityFeatures();
                                } else if (ele instanceof VIPSpot) {
                                    ((VIPSpot) ele).vipFeatures();
                                }
                                System.out.println("--------------------------------------------------------");
                            }
                        }
                        System.out.println("Total Parking Spots is: " + ParkingSpot.getTotalParkingSpot());
                        break;

                    case 2://Display Spot Vehicle Record.
                        System.out.print("Enter spot id: ");
                        String spotId = input.next();
                        boolean found = false;
                        for (ParkingSpot ele : list) {
                            //show only if ele is of type ParkingSpot

                            if (ele.getSPOT_ID().equals(spotId)) {
                                ele.displayPreviousVehicles();
                                found = true;
                                break;

                            }
                        }
                        if (!found) {
                            System.out.println("Spot with id " + spotId + " is not found.");
                        }
                        break;

                    case 3://Book Parking Spot.
                        System.out.print("Enter parking spot id: ");
                        spotId = input.next();
                        ParkingSpot spot = null;
                        for (ParkingSpot ele : list) {

                            if (ele.getSPOT_ID().equals(spotId)) {
                                spot = (ParkingSpot) ele;
                                break;
                            }

                        }//end loop
                        if (spot == null) {
                            System.out.println("Parking Spot with id " + spotId + " is not found.");
                            continue;
                        }

                        if (!spot.isAvailable()) {
                            System.out.println("Sorry this spot with id " + spotId + " is not available.");
                            continue;
                        }

                        //read owner info
                        System.out.print("Enter your id: ");
                        int ownertId = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter your name: ");
                        String ownerName = input.nextLine();
                        System.out.print("Enter your phone Number: ");
                        String ownerPhoneNo = input.nextLine();

                        //create owner object
                        Owner owner = new Owner(ownertId, ownerName, ownerPhoneNo);

                        //read vehicle info
                        System.out.print("Enter vehcile plate number: ");
                        String vehiclePlateNo = input.nextLine();
                        System.out.print("Enter vehicle model: ");
                        String vehicleModel = input.nextLine();

                        //create vehicle object                        
                        Vehicle vehicle = new Vehicle(vehiclePlateNo, vehicleModel, owner);

                        System.out.print("Enter booking duration in hours: ");
                        int hours = input.nextInt();

                        //validate min/max hours
                        if (hours < Bookable.MIN_BOOKING_DURATION || hours > Bookable.MAX_BOOKING_DURATION) {
                            System.out.println("Invalid hours");
                            hours = 1;
                        }

                        //Charger booking 
                        ElectricCharger bookingCharger;
                        //Available chargers
                        ElectricCharger ch1 = new ElectricCharger("ST101", 400);
                        ElectricCharger.supportedCars();
                        System.out.print("Would you like to book an electric charger? (Y/N): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            bookingCharger = ch1;
                            System.out.println("Car Electric charger is booked for you at the parking spot.");
                        } else {
                            bookingCharger = null;
                            System.out.println("No electric charger is booked.");
                        }

                        Booking booking = new Booking(spot, vehicle, bookingCharger, hours);

                        //confirm
                        System.out.print("Confirm parking spot booking? (Y/N): ");
                        answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            booking.confirm();
                            System.out.println(booking);
                            bookingList.add(booking);
                        } else {
                            System.out.println("Your booking has been cancelled!");
                        }
                        break;

                    case 4://Display Booking
                        System.out.print("Enter booking id: ");
                        int bookingId = input.nextInt();
                        found = false;
                        for (Booking b : bookingList) {
                            if (b.getID() == bookingId) {
                                System.out.println(b);
                                found = true;
                            }
                        }//end loop
                        if (found == false) {
                            System.out.println("Booking with id " + bookingId + " is not found.");
                        }
                        break;

                    case 5://Cancel Booking
                        System.out.print("Enter booking id: ");
                        bookingId = input.nextInt();
                        found = false;
                        for (Booking b : bookingList) {
                            if (b.getID() == bookingId) {
                                b.cancel();
                                System.out.println(b);
                                found = true;
                            }
                        }//end loop
                        if (found == false) {
                            System.out.println("Booking with id " + bookingId + " is not found.");
                        }
                        break;

                    case 6://GUI
                        //GUI.main(null); //calling static method
                        break;

                    case 7://Read from text file
                        ReadText rt = new ReadText();
                        rt.openTextFile("bookings.txt");
                        rt.readFromFile();
                        rt.closeFile();
                        break;

                    case 8://Save/Write to text file
                        WriteText wf = new WriteText();
                        wf.openTextFile("bookings.txt");
                        if (bookingList.isEmpty()) {
                            System.out.println("No bookings yet.");
                        } else {
                            for (Booking ele : bookingList) {
                                wf.writeToFile(ele);
                            }
                        }
                        wf.closeFile();
                        System.out.println("All bookings saved to the text file bookings.txt");
                        break;

                    case 9://Exit
                        System.out.println("Thank you for using our system.\nHave a nice day.");
                        break;
                    default:
                        System.out.println("Invalid Choice!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                input.nextLine();
            } catch (NullPointerException ex) {
                System.err.println(ex);
            } catch (ClassCastException ex) {
                System.err.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.err.println(ex);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } while (choice != 9);

    }

    public static void menu() {

        //TODO: 'Add Parking' to the menu and read from Scanner
        System.out.print("\n1. Display Parking Spots.\n"
                + "2. Display Spot Vehicle Record.\n"
                + "3. Book Parking Spot.\n"
                + "4. Display Booking.\n"
                + "5. Cancel Booking.\n"
                + "6. GUI\n"
                + "7. Read From File.\n"
                + "8. Save/Write Bookings.\n"
                + "9. Exit\n"
                + ">> ");
    }

    public static void fillList(ArrayList<ParkingSpot> list) {

        ParkingSpot s1 = new HandicappedSpot("A101", 1, "A", new Vehicle[]{}, true);
        ParkingSpot s2 = new VIPSpot("B201", 2, "B", new Vehicle[]{}, true);
        ParkingSpot s3 = new RegularSpot("C301", 2, "C", new Vehicle[]{}, 10);
        ParkingSpot s4 = new RegularSpot("C302", 3, "C", new Vehicle[]{}, 120);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

    }

}
