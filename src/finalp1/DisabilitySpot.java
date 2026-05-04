package finalp1;

// A disability-accessible parking spot.
public class DisabilitySpot extends ParkingSpot {

    private boolean chairIncluded;
    private int disabilityPermitId;
    private String permitHolderName;

    // empty constructor
    public DisabilitySpot() {
        this(0, 0, "", false, false, 0, "");
    }

    /**
     * Full constructor.
     * @param spotNum the spot number
     * @param floorNum the floor number
     * @param section the section label
     * @param isAvailable whether the spot is free
     * @param chairIncluded whether a wheelchair is provided
     * @param disabilityPermitId the disability permit ID
     * @param permitHolderName the permit holder's full name
     */
    public DisabilitySpot(int spotNum, int floorNum, String section, boolean isAvailable,
                          boolean chairIncluded, int disabilityPermitId, String permitHolderName) {
        super(spotNum, floorNum, section, isAvailable);
        setChairIncluded(chairIncluded);
        setDisabilityPermitId(disabilityPermitId);
        setPermitHolderName(permitHolderName);
    }

    public boolean getChairIncluded()                   { return chairIncluded; }
    public void setChairIncluded(boolean chairIncluded) { this.chairIncluded = chairIncluded; }

    public int getDisabilityPermitId() { return disabilityPermitId; }
    public void setDisabilityPermitId(int disabilityPermitId) {
        if (disabilityPermitId < 0) throw new IllegalArgumentException("Permit ID cannot be negative");
        this.disabilityPermitId = disabilityPermitId;
    }

    public String getPermitHolderName() { return permitHolderName; }
    public void setPermitHolderName(String permitHolderName) {
        this.permitHolderName = permitHolderName.trim();
    }

    /**
     * @return hourly rate for this disability spot
     */
    public double calcPrise() {
        return chairIncluded ? 4.0 : 3.0;
    }

    @Override
    public double calcCost() {
        return calcPrise();
    }

    @Override
    public int EmptyParking() {
        return getTotalparking();
    }

    // Displays accessibility features for this spot.
    public void checkAccessibilityFeature() {
        System.out.println("Disability Spot " + getSpotNum() + " — Permit holder: " + permitHolderName
            + (chairIncluded ? " | Wheelchair included." : " | No wheelchair."));
    }

    @Override
    public void book() {
        setIsAvailable(false);
        System.out.println("Disability spot " + getSpotNum() + " booked.");
    }

    @Override
    public void cancel() {
        setIsAvailable(true);
        System.out.println("Disability spot " + getSpotNum() + " booking cancelled.");
    }

    @Override
    public String toString() {
        return String.format("%s\nChair Included: %b\nPermit ID: %d\nPermit Holder: %s",
            super.toString(), getChairIncluded(), getDisabilityPermitId(), getPermitHolderName());
    }
}
