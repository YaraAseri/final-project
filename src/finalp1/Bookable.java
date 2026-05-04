package finalp1;

// Contract for any bookable parking spot or booking.
public interface Bookable {

    public static final int MAX_BOOKING_HOURS = 12;
    public static final int MIN_BOOKING_HOURS = 1;

    public abstract void book();
    public abstract void cancel();
    public abstract double calcCost();
}
