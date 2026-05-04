package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Owner {

    private final int ID;
    private String name;
    private String phone;

    public Owner() {
        this(0, "", "");
    }

    public Owner(int ID, String name, String phone) {
        this.ID = ID;
        setName(name);
        setPhone(phone);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nPhone: %s", getID(), getName(), getPhone());
    }

}
