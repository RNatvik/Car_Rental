package view;

import data.CarReservation;
import data.RentalCar;


public class ViewFactory {

    public ViewFactory() {
    }

    public View getReservaionView(CarReservation reservation) {
        View view = new CarReservationView(reservation);
        return view;
    }

    public View getVehicleView(RentalCar car) {
        View view = new RentalCarView(car);
        return view;
    }
}
