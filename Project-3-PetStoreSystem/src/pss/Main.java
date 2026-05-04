package pss;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<Item>();
        fillList(items);

        System.out.println("**** Welcome To Pet Zone Store ****");
        System.out.println("What would you like to do?");

        int choice;
        Order order = null; //current order
        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1://Show Pets
                    System.out.println("***** Pet List ****");
                    for (Item e : items) {
                        if (e instanceof Pet) {
                            System.out.println(e);
                            System.out.println("------------------------------------------");
                        }
                    }
                    break;

                case 2://Show Accessories
                    System.out.println("***** Accessory List ****");
                    for (Item e : items) {
                        if (e instanceof Accessory) {
                            System.out.println(e);
                            System.out.println("------------------------------------------");
                        }
                    }
                    break;

                case 3://Make Order
                    System.out.print("How many items you want to purchase? ");
                    int size = input.nextInt();

                    if (size <= 0) {
                        System.out.println("Invalid number!");
                        break;//stop
                    }

                    Item[] orderItems = new Item[size];
                    System.out.println("Enter " + size + " item ids:");
                    int count = 0;
                    while (count < size) {
                        System.out.printf("Enter item %d id: ", (count + 1));
                        int id = input.nextInt();
                        //search for product
                        boolean isFound = false;
                        for (Item e : items) {
                            if (e.getID() == id) {
                                orderItems[count] = e;
                                isFound = true;
                                break;
                            }
                        }//end
                        if (!isFound) {
                            System.out.println("Invalid item id");
                        } else {
                            count++;
                        }
                    }//end loop
                    System.out.println("*** Owner Info ***");
                    System.out.print("Enter your id: ");
                    int id = input.nextInt();
                    System.out.print("Enter your first name: ");
                    String name = input.next();
                    System.out.print("Phone number: ");
                    String phone = input.next();

                    Owner owner = new Owner(id, name, phone);
                    order = new Order(owner, orderItems);

                    System.out.print("Confirm order? (Y/N): ");
                    char answer = input.next().charAt(0);
                    if (answer == 'y' || answer == 'Y') {
                        order.setStatus("Confirmed");
                        order.print();
                        System.out.println("*** Your order has been confirmed! ***");
                    } else {
                        order = null;
                        System.out.println("Your order has been cancelled!");
                    }
                    break;

                case 4://Show Order
                    if (order != null) {
                        order.print();
                    } else {
                        System.out.println("No current order yet!");
                    }
                    break;

                case 5://Cancel Order
                    if (order != null) {
                        System.out.print("Are you sure you want to cancel your order? (Y/N): ");
                        answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            order.setStatus("Cancelled");
                            order.print();
                            System.out.println("Your order has been cancelled!");
                        } else {
                            System.out.println("Your order is in progress!");
                        }
                    } else {
                        System.out.println("No current order yet!");
                    }
                    break;

                case 6://Exit
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid option!");

            }
        } while (choice != 6);

    }

    public static void menu() {
        System.out.print("\n1. Show Pets\n"
                + "2. Show Accessories\n"
                + "3. Purchase\n"
                + "4. Show Order\n"
                + "5. Cancel Order\n"
                + "6. Exit\n"
                + ">> ");
    }

    public static void fillList(ArrayList<Item> list) {
        list.add(new Cat(101, "Cute male cat", 2000, 'M', "Gray", 3, false));
        list.add(new Cat(102, "Cute female cat", 1000, 'F', "White", 24, true));
        list.add(new Dog(103, "Friendly dog", 5000, 'M', "White", 14, true, "Low", true));

        list.add(new Food(104, "Cat dry food", 100, "Taste Of The Wild", 1200));
        list.add(new Game(105, "Fish game for cats", 20, "Kitty", true));
    }
}
