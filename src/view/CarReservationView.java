package view;

import data.CarReservation;

public class CarReservationView implements View {

    private CarReservation reservation;

    public CarReservationView(CarReservation reservation) {
        this.reservation = reservation;
    }


    @Override
    public void show() {
        String details = "";
        details += "Reserved by: " + reservation.getCustomer() + "\n";
        details += "Car: " + reservation.getCar().getManufacturer() + " " + reservation.getCar().getModel()
                + " (" + reservation.getCar().getProductionYear() + ")\n";
        details += "Licence plate: " + reservation.getCar().getLicencePlate() + "\n";
        details += "Mileage on reservation: " + reservation.getCar().getMileage() + " km\n";
        details += "Start Date: " +
                reservation.getReservedFrom().getDayOfMonth() + "." +
                reservation.getReservedFrom().getMonthValue() + "." +
                reservation.getReservedFrom().getYear() + ", " +
                reservation.getReservedFrom().getHour() + ":" +
                reservation.getReservedFrom().getMinute() + "\n";
        details += "End Date: " +
                reservation.getReservedTo().getDayOfMonth() + "." +
                reservation.getReservedTo().getMonthValue() + "." +
                reservation.getReservedTo().getYear() + ", " +
                reservation.getReservedTo().getHour() + ":" +
                reservation.getReservedTo().getMinute() + "\n";
        details +=  reservation.getRentalPeriodDetailsAsString() +
                " at " + reservation.getHourlyCost() + " pr hour" + "\n";
        System.out.println(details);
    }

    @Override
    public void showShort() {
        String details = "";
        details += "Reserved by: " + reservation.getCustomer() + "\n";
        details += "Car: " + reservation.getCar().getManufacturer() + " " + reservation.getCar().getModel()
                + " (" + reservation.getCar().getProductionYear() + ")\n";
        details += "Licence plate: " + reservation.getCar().getLicencePlate() + "\n";
        details += "Start Date: " +
                reservation.getReservedFrom().getDayOfMonth() + "." +
                reservation.getReservedFrom().getMonthValue() + "." +
                reservation.getReservedFrom().getYear() + ", " +
                reservation.getReservedFrom().getHour() + ":" +
                reservation.getReservedFrom().getMinute() + "\n";
        details += "End Date: " +
                reservation.getReservedTo().getDayOfMonth() + "." +
                reservation.getReservedTo().getMonthValue() + "." +
                reservation.getReservedTo().getYear() + ", " +
                reservation.getReservedTo().getHour() + ":" +
                reservation.getReservedTo().getMinute() + "\n";
        System.out.println(details);
    }
}
