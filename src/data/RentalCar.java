package data;

/**
 * Stores relevant information about a rental car
 */
public class RentalCar {

    private final String manufacturer;
    private final String model;
    private final int productionYear;
    private int mileage;
    private final String licencePlate;
    private boolean available;

    /**
     * Constructor
     * @param manufacturer the car's manufacturer, e.g Audi, BMW, Peugeot
     * @param model the car's model.
     * @param productionYear the car's production year
     * @param mileage the car's current mileage
     * @param licencePlate the car's licence plate
     */
    public RentalCar(String manufacturer, String model, int productionYear, int mileage, String licencePlate) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.licencePlate = licencePlate;
        this.available = true;
    }

    /**
     * Gets the car's manufacturer
     * @return the car's manufacturer
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Gets the car's model
     * @return the car's model
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Gets the car's production year
     * @return the car's production year
     */
    public int getProductionYear() {
        return this.productionYear;
    }

    /**
     * Gets the car's mileage
     * @return the car's mileage
     */
    public int getMileage() {
        return this.mileage;
    }

    /**
     * Gets the car's licence plate
     * @return the car's licence plate
     */
    public String getLicencePlate() {
        return this.licencePlate;
    }

    /**
     * Gets the car's availability
     * @return the car's availability, true if car is available for rent, false if not
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the car's mileage
     * @param mileage the new mileage
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Sets the cars availability
     * @param available, true if car is available for rent, false if not
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
