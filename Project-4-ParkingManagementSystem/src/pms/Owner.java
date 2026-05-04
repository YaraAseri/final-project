package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Owner {

    private final int ID;
    private String name;
    private String phoneNo;

    //constructors
    public Owner(int ID, String name, String phoneNo) {
        this.ID = ID;
        setName(name);
        setPhoneNo(phoneNo);
    }

    public Owner() {
        this(0, "", "");
    }

    //setters & getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return String.format("Owner Id: %d\nOwner Name: %s\nOwner Phone: %s", getID(), getName(), getPhoneNo());
    }

}
