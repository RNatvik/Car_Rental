package view;

import data.RentalCar;

public class RentalCarView implements View {

    private RentalCar car;

    public RentalCarView(RentalCar car) {
        this.car = car;
    }

    @Override
    public void show() {
        String details = "";
        details += this.car.getManufacturer() + " " + this.car.getModel()
                + " (" + this.car.getProductionYear() + ")\n";
        details += "Licence plate: " + this.car.getLicencePlate() + "\n";
        details += "Mileage: " + this.car.getMileage() + " km\n";
        details += "Available for rent: " + car.isAvailable() + "\n";
        System.out.println(details);
    }

    @Override
    public void showShort() {
        String details = "";
        details += this.car.getManufacturer() + " " + this.car.getModel()
                + " (" + this.car.getProductionYear() + ")\n";
        System.out.println(details);
    }
}
