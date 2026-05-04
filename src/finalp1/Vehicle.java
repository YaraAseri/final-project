package finalp1;

// A vehicle registered in the parking system.
public class Vehicle {

    private String plate;
    private String model;
    private String company;
    private final String vehicleRef;

    // empty constructor
    public Vehicle() {
        this("", "", "");
    }

    /**
     * Full constructor.
     * @param plate the vehicle plate number
     * @param model the vehicle model name
     * @param company the vehicle manufacturer
     */
    public Vehicle(String plate, String model, String company) {
        setPlate(plate);
        setModel(model);
        setCompany(company);
        this.vehicleRef = generateVehicleRef();
    }

    public String getPlate()           { return plate; }
    public void setPlate(String plate) { this.plate = plate.trim().toUpperCase(); }

    public String getModel()           { return model; }
    public void setModel(String model) { this.model = model.trim(); }

    public String getCompany()             { return company; }
    public void setCompany(String company) { this.company = company.trim(); }

    public String getVehicleRef() { return vehicleRef; }

    /**
     * @return Lab 1.2 derived ref: first 2 chars of model + last 2 chars of plate, uppercase
     */
    private String generateVehicleRef() {
        String modelPart = "";
        if (model != null && model.length() >= 2) {
            modelPart = model.substring(0, 2);
        }
        String platePart = "";
        if (plate != null && plate.length() >= 2) {
            platePart = plate.substring(plate.length() - 2);
        }
        return (modelPart + platePart).toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("Plate: %s\nVehicle Ref: %s\nModel: %s\nCompany: %s",
            getPlate(), getVehicleRef(), getModel(), getCompany());
    }
}
