package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public abstract class Accessory extends Item {

    private String brand;

    public Accessory() {
        this(0, "", 0.0, "");
    }

    public Accessory(int ID, String description, double price, String brand) {
        super(ID, description, price);
        setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public double calcPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s\nBrand: %s", super.toString(), getBrand());
    }

}
