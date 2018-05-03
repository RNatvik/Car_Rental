package logic;

import data.RentalCar;

import java.util.ArrayList;
import java.util.List;

public class CarRegistry {

    private ArrayList<RentalCar> cars;

    public CarRegistry() {
        this.cars = new ArrayList<>();
    }

    public void addCar(RentalCar car) {
        if (!this.cars.contains(car)) {
            this.cars.add(car);
        }
    }

    public void removeCar(RentalCar car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
        }
    }

    public List<RentalCar> getCars() {
        return cars;
    }
}
