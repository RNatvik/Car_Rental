package application;

/**
 * A Lottery system. This interface defines the functionality required
 * from the car rental system. It is expected that a class implementing
 * this interface, implements all the methods defined in this interface.
 * 
 * <p>This interface and the class that implements it, it to be considered as
 * part of the <b>user interface</b>. Hence it is natural and accepted to have 
 * code that interacts with the user in the class implementing this interface.
 *
 * @author asty
 * @version 1.0
 */
public interface CarRentalApplication
{

    /**
     * Initialize the CarRental-application.
     */
    void init();
 
    /**
     * Register a new car to the car pool, making it available for renting.
     */
    void addCarToCarRegister();

    /**
     * Make a reservation for a car (ie rent a car).
     */
    void makeReservation();

    /**
     * List all rentals done of one spesific car.
     */
    void listRentalsByCar();

    /**
     * List all cars in the car register.
     */
    void listAllCars();

    /**
     * List all rentals registered, and provide a total sum of the cost/
     * income from all the rentals.
     */
    void listAllRentals();

}
