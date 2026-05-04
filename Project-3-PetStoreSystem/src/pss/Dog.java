package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public final class Dog extends Pet {

    private String sensitivityLevel;
    private boolean dogFriendly;

    public Dog() {
        this(0, "", 0.0, ' ', "", 0, false, "", false);
    }

    public Dog(int ID, String description, double price, char gender, String furColor, int age, boolean vaccinated, String sensitivityLevel, boolean dogFriendly) {
        super(ID, description, price, gender, furColor, age, vaccinated);
        setSensitivityLevel(sensitivityLevel);
        setDogFriendly(dogFriendly);
    }

    public String getSensitivityLevel() {
        return sensitivityLevel;
    }

    public void setSensitivityLevel(String sensitivityLevel) {
        this.sensitivityLevel = sensitivityLevel;
    }

    public boolean isDogFriendly() {
        return dogFriendly;
    }

    public void setDogFriendly(boolean dogFriendly) {
        this.dogFriendly = dogFriendly;
    }

    @Override
    public double calcPrice() {
        double price = super.calcPrice();
        if (isDogFriendly()) {
            price += 100;
        }
        if (getSensitivityLevel() == "Low") {
            price += 50;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\nSensitivity Level: %s\ndogFriendly: %s", super.toString(), getSensitivityLevel(), isDogFriendly());
    }

}
