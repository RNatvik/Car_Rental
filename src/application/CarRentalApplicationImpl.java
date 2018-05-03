package application;

import data.CarReservation;
import data.RentalCar;
import logic.CarRegistry;
import logic.ReservationRegistry;
import view.View;
import view.ViewFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the CarRentalApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * CarRentalApplication interface).
 *
 * @author asty
 * @version 0.1
 */
public class CarRentalApplicationImpl implements CarRentalApplication {

    private CarRegistry carRegistry;
    private ReservationRegistry reservationRegistry;
    private UserInput userInput;
    private ViewFactory viewFactory;

    public CarRentalApplicationImpl() {
        this.carRegistry = new CarRegistry();
        this.reservationRegistry = new ReservationRegistry();
        this.userInput = new UserInput("/cancel");
        this.viewFactory = new ViewFactory();
    }

    @Override
    public void init() {
        this.fillRegistersWithDataForTesting();
    }

    @Override
    public void addCarToCarRegister() {
        System.out.println("addCarToCarRegister() was called..");

        String manufacturer = this.userInput.getInputString("Manufacturer:");
        String model = this.userInput.getInputString("Model:");
        int productionYear = this.userInput.getInputInteger("Production year:");
        int mileage = this.userInput.getInputInteger("Mileage:");
        String licencePlate = this.userInput.getInputString("Licence Plate:");

        RentalCar car = new RentalCar(manufacturer, model, productionYear, mileage, licencePlate);

        View view = this.viewFactory.getVehicleView(car);
        view.show();

        boolean confirmation = this.userInput.getUserConfirmation("Please make sure all information is correct");

        if (confirmation) {
            this.carRegistry.addCar(car);
            System.out.println("Added car to registry");
        } else {
            System.out.println("Car was not added to registry");
        }
    }

    @Override
    public void makeReservation() {
        System.out.println("makeReservation() was called..");
        List<RentalCar> availableCars = this.getAvailableCars();
        if (availableCars.size() > 0) {
            String customerName = this.userInput.getInputString("Please enter your name: (Last name, first name)");
            RentalCar chosenCar = null;
            int index = 0;
            for (RentalCar car : availableCars) {
                View view = this.viewFactory.getVehicleView(car);
                System.out.println("Reference Index: " + index);
                view.show();
                index++;
            }

            boolean validChoice = false;
            while (!validChoice) {
                int choice = this.userInput.getInputInteger(
                        "Please use \"Reference Index\" to select the car to reserve."
                );
                if (choice < availableCars.size() && choice >= 0) {
                    validChoice = true;
                    chosenCar = availableCars.get(choice);
                    System.out.println("Your chosen car:");
                    this.viewFactory.getVehicleView(chosenCar).showShort();
                } else {
                    System.out.println("Index out of bounds");
                }
            }

            int startYear = this.userInput.getInputInteger("Please enter start year:");
            int startMonth = this.userInput.getInputInteger("Please enter start month (1-12):");
            int startDay = this.userInput.getInputInteger("Please enter start day of month:");
            int startHour = this.userInput.getInputInteger("Please enter start hour (0-23):");
            int startMinute = this.userInput.getInputInteger("Please enter start minutes (0-59):");

            int endYear = this.userInput.getInputInteger("Please enter end year:");
            int endMonth = this.userInput.getInputInteger("Please enter end month (1-12):");
            int endDay = this.userInput.getInputInteger("Please enter end day of month:");
            int endHour = this.userInput.getInputInteger("Please enter end hour (0-23):");
            int endMinute = this.userInput.getInputInteger("Please enter end minutes (0-59):");

            int hourlyCost = this.userInput.getInputInteger("Please enter hourly cost for rent:");

            LocalDateTime startTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, startMinute);
            LocalDateTime endTime = LocalDateTime.of(endYear, endMonth, endDay, endHour, endMinute);

            CarReservation reservation = new CarReservation(chosenCar, customerName, startTime, endTime, hourlyCost);
            this.finalizeReservation(reservation);
        } else {
            System.out.printf("No available cars to rent at this time, please check back again later");
        }
    }

    private void finalizeReservation(CarReservation reservation) {
        this.reservationRegistry.addReservation(reservation);
        reservation.getCar().setAvailable(false);
    }

    @Override
    public void listRentalsByCar() {
        System.out.println("listRentalsByCar() was called..");
    }

    @Override
    public void listAllCars() {
        System.out.println("listAllCars() was called..");

        int index = 0;
        for (RentalCar car : this.carRegistry.getCars()) {
            View view = this.viewFactory.getVehicleView(car);
            System.out.println("Reference Index: " + index);
            view.show();
            index++;
        }
    }

    @Override
    public void listAllRentals() {
        int index = 0;
        for (CarReservation reservation : this.reservationRegistry.getReservations()) {
            View view = this.viewFactory.getReservaionView(reservation);
            System.out.println("Reference Index: " + index);
            view.show();
            index++;
        }
    }

    private List<RentalCar> getAvailableCars() {
        ArrayList<RentalCar> availableCars = new ArrayList<>();
        for (RentalCar car : this.carRegistry.getCars()) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting() {
        RentalCar car1 = new RentalCar(
                "Audi", "A4", 2010, 25000, "AB12345"
        );
        RentalCar car2 = new RentalCar(
                "Peugeot", "406", 2001, 255000, "CE99867"
        );
        RentalCar car3 = new RentalCar(
                "Volvo", "V70", 2010, 45021, "BE48573"
        );
        RentalCar car4 = new RentalCar(
                "Fiat", "Punto", 2011, 23000, "GH20585"
        );

        this.carRegistry.addCar(car1);
        this.carRegistry.addCar(car2);
        this.carRegistry.addCar(car3);
        this.carRegistry.addCar(car4);

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime res1Time = LocalDateTime.of(2018, 8, 7, 14, 0);
        LocalDateTime res2Time = LocalDateTime.of(2018, 6, 24, 21, 13);
        LocalDateTime res3Time = LocalDateTime.of(2018, 7, 4, 12, 54);
        LocalDateTime res4Time = LocalDateTime.of(2018, 11, 11, 16, 13);


        CarReservation res1 = new CarReservation(car1, "Grindvik, Marcus", now, res1Time, 150);
        CarReservation res2 = new CarReservation(car2, "Natvik, Ruben", now, res2Time, 150);
        CarReservation res3 = new CarReservation(car3, "Waldum, Håkon", now, res3Time, 150);
        CarReservation res4 = new CarReservation(car4, "Wille, Vebjørn", now, res4Time, 150);

        this.finalizeReservation(res1);
        this.finalizeReservation(res2);
        this.finalizeReservation(res3);
    }

    private void updateAvailableCars() {

    }
}
