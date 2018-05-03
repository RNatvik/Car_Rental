package logic;

import data.CarReservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationRegistry {

    ArrayList<CarReservation> reservations;

    public ReservationRegistry() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(CarReservation reservation) {
        if (!this.reservations.contains(reservation)) {
            this.reservations.add(reservation);
        }
    }

    public void removeReservation(CarReservation reservation) {
        if (this.reservations.contains(reservation)) {
            this.reservations.remove(reservation);
        }
    }

    public List<CarReservation> getReservations() {
        return reservations;
    }
}
