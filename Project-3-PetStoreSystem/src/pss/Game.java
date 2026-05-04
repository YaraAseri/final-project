package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Game extends Accessory {

    private boolean safe;

    public Game() {
        this(0, "", 0.0, "", false);
    }

    public Game(int ID, String description, double price, String brand, boolean safe) {
        super(ID, description, price, brand);
        setSafe(safe);
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        if (isSafe()) {
            price += 50;
        }

        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\nSafe: %s", super.toString(), isSafe());
    }
}
