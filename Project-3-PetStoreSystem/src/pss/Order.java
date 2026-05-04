package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Order implements Printable {

    private final int ID;
    private String status;
    private Owner owner;
    private Item[] items;
    private static int count;

    public Order(Owner owner, Item[] items) {
        this.ID = ++count;
        this.status = "new";
        this.owner = owner;
        this.items = items;
    }

    public int getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    @Override
    public double calcTotal() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                total += items[i].calcPrice();
            }
        }
        total += total * Printable.VAT;
        return total;
    }

    @Override
    public void print() {
        System.out.println("*** Order Info ***");
        System.out.println("ID: " + getID());
        System.out.println("Status: " + getStatus());
        System.out.println("Owner: " + getOwner());
        System.out.println("-- Items ---");
        for (Item item : items) {
            System.out.println(item);
            System.out.println("----------------------");
        }
        System.out.printf("Total Price is: %.2f SAR\n", calcTotal());
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nStatus: %s\nOwner: %s", getID(), getStatus(), getOwner());
    }

}
