package pms;

/**
 *
 * @author ENG.NAIF ALSHEHRI
 * @see https://VisionAcademy.online
 * @version 0.01 - Beta
 */
public interface Bookable {

    public static final int MAX_BOOKING_DURATION = 24;//hours

    public static final int MIN_BOOKING_DURATION = 1;//hours

    public abstract void book();

    public abstract void cancel();

    public abstract double calcCost();
}
