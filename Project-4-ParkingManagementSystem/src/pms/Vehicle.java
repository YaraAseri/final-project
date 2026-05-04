package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public class Vehicle {

    private String plate;
    private String model;
    private Owner owner;

    //constructors
    public Vehicle(String plate, String model, Owner owner) {
        setPlate(plate);
        setModel(model);
        setOwner(owner);
    }

    public Vehicle() {
        this("", "", null);
    }

    //setters & getters
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("Plate: %s\nModel: %s\nOwner: \n%s", getPlate(), getModel(), getOwner());
    }

}
