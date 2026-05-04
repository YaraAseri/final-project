package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Food extends Accessory {

    private double size; //size in grams

    public Food() {
        this(0, "", 0.0, "", 0.0);
    }

    public Food(int ID, String description, double price, String brand, double size) {
        super(ID, description, price, brand);
        setSize(size);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        if (size > 0) {
            this.size = size;
        } else {
            System.out.println("Invalid Size!");
            this.size = 0;
        }
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        if (getSize() > 2000) {//2KG
            price += 5;
        }

        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\nSize(g): %s", super.toString(), getSize());
    }
}
