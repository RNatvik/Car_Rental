package data;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * The CarReservation class represents a single reservation of a car to be
 * rented by a customer.
 *
 * @author arne
 * @version 0.1
 */
public class CarReservation {

    private RentalCar car;
    private String customer;
    private LocalDateTime reservedFrom;
    private LocalDateTime reservedTo;
    private int hourlyCost;


    /**
     * Creates an instance of the CarReservation class.
     *
     * @param fromDateAndTime the date and time when the reservation starts
     * @param toDateAndTime   the date and time of the end of the reservation
     */
    public CarReservation(RentalCar car, String customerName, LocalDateTime fromDateAndTime,
                          LocalDateTime toDateAndTime, int hourlyCost) {
        this.car = car;
        this.customer = customerName;
        this.reservedFrom = fromDateAndTime;
        this.reservedTo = toDateAndTime;
        this.hourlyCost = hourlyCost;
    }

    public RentalCar getCar() {
        return car;
    }

    public String getCustomer() {
        return customer;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public LocalDateTime getReservedFrom() {
        return reservedFrom;
    }

    public LocalDateTime getReservedTo() {
        return reservedTo;
    }

    /**
     * Returns the number of days between the start of the rental
     * period to the end of the rental period.
     * The number of days are returned as an integer
     * (whole days, not as decimal).
     *
     * @return the number of days between the start of the rental
     * period to the end of the rental period.
     */
    public long getNumberOfRentalDays() {
        return this.getRentalDuration().toDays();
    }

    /**
     * Returns the total number of hours from the date and time the rental
     * periods start, till it ends.
     *
     * @return the total number of hours from the date and time the rental
     * periods start, till it ends.
     */
    public long getNumberOfRentalHours() {
        return this.getRentalDuration().toHours();
    }

    /**
     * Returns the duration of the rental period as an
     * object of <code>Duration</code>.
     *
     * @return the duration of the rental period
     */
    private Duration getRentalDuration() {
        return Duration.between(this.reservedFrom, this.reservedTo);
    }

    /**
     * Returns a String holding the details of the rental period. The string
     * holds information about the date and time of the start and the end
     * of the rental period, and how many days or hours in total.
     *
     * @return the details of the rental period as a String.
     */
    public String getRentalPeriodDetailsAsString() {
        String detailsString = "Rental start from "
                + this.reservedFrom.toString()
                + " to " + this.reservedTo.toString()
                + ", a total of " + this.getNumberOfRentalDays() + " days "
                + "or " + this.getNumberOfRentalHours() + " hours.";
        return detailsString;
    }

    /**
     * This static class function shows how the class CarReservation
     * might be used in an application. Use the code here as an example,
     * but do not use this method from your own code in your final solution.
     */
    /*public static void exampleOfUse() {
        // To create a date-and-time object, use the "of()"-method of the
        // LocalDateTime-class.
        // The "of()" method takes the following parameters:
        //  day (1-31)
        //  month (1-12)
        //  year (like 2017 for example)
        //  hours (0-23)
        //  minutes (0-59)
        // Create a startrental from 10th May 2017 at 13:42
        LocalDateTime startRentalDateTime = LocalDateTime.of(10, 5, 2017, 13, 42);
        // To 12th May at 13:15
        LocalDateTime endRentalDateTime = LocalDateTime.of(12, 5, 2017, 13, 15);

        //Create a Car Reservation, with hourly cost of 120
        CarReservation carRes = new CarReservation(startRentalDateTime, endRentalDateTime, 120);

        //Get the number of days the car has been rented for
        System.out.println("Number of rental days: " + carRes.getNumberOfRentalDays());

        // Get the number of hours the rental car 

        System.out.println("Number of rental hours in total: " + carRes.getNumberOfRentalHours());

    }*/
}
