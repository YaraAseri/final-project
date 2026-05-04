package pss;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public abstract class Pet extends Item {

    private final char gender;
    private String furColor;
    private int age;
    private boolean vaccinated;
    private static int count;

    public Pet() {
        this(0, "", 0.0, ' ', "", 0, false);
    }

    public Pet(int ID, String description, double price, char gender, String furColor, int age, boolean vaccinated) {
        super(ID, description, price);
        this.gender = gender;
        this.furColor = furColor;
        this.age = age;
        this.vaccinated = vaccinated;
        count++;
    }

    public char getGender() {
        return gender;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Pet.count = count;
    }

    @Override
    public double calcPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s\nGender: %s\nFur Color: %s\nAge: %d\nVaccinated: %s", super.toString(), getGender(), getFurColor(), getAge(), isVaccinated());
    }
}
