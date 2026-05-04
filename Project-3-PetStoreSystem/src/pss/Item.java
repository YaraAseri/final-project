package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public abstract class Item {

    private final int ID;
    private String description;
    private double price;

    private static int count;

    public Item() {
        this(0, "", 0.0);
    }

    public Item(int ID, String description, double price) {
        this.ID = ID;
        setDescription(description);
        setPrice(price);
        count++;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Item.count = count;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return String.format("id: %d\nDescription:%s\nPrice:%.2f SAR", getID(), getDescription(), getPrice());
    }
}
