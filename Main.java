package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try {
            File file = new File("vehicles.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String type = input.next();
                String brand = input.next();
                String model = input.next();
                double price = input.nextDouble();

                if (type.equals("C")) {
                    int numOfDoors = input.nextInt();
                    vehicles.add(new Car(brand, model, price, numOfDoors));
                } else if (type.equals("M")) {
                    int engineCapacity = input.nextInt();
                    vehicles.add(new Motorcycle(brand, model, price, engineCapacity));
                } else {
                    throw new IllegalArgumentException("Invalid vehicle type: " + type);
                }
            }
            input.close();

            Formatter output = new Formatter("output.txt");
            for (int i = vehicles.size() - 1; i >= 0; i--) {
                output.format("%s%n", vehicles.get(i));
            }
            output.close();

            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            System.err.println("Error: File does not exist or cannot be opened.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Incorrect data type in the file.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid value - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: I/O error during file operations - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: Unexpected error - " + e.getMessage());
        }
    }
}
