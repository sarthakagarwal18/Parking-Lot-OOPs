public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(6);
        parkingLot.printLotStatus();

        Car car1 = new Car(1);
        parkingLot.park(car1);
        parkingLot.printLotStatus();

        Car car2 = new Car(2);
        parkingLot.park(car2);
        parkingLot.printLotStatus();

        Car car3 = new Car(3);
        parkingLot.park(car3);
        parkingLot.printLotStatus();

        parkingLot.removeVehicle(car2);
        parkingLot.printLotStatus();

        Bike bike1 = new Bike(4);
        parkingLot.park(bike1);
        parkingLot.printLotStatus();

        Car car5 = new Car(5);
        parkingLot.park(car5);
        parkingLot.printLotStatus();

    }
}
