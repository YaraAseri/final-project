package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public final class Cat extends Pet {

    public Cat() {
        this(0, "", 0.0, ' ', "", 0, false);
    }

    public Cat(int ID, String description, double price, char gender, String furColor, int age, boolean vaccinated) {
        super(ID, description, price, gender, furColor, age, vaccinated);
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }

}
