import java.util.Scanner;

/**
 * FEATURES & ASSUMPTIONS
 * 1. Multi floor Parking Lot. Each floor has an entry point.
 * 2. Park, Unpark a vehicle
 * 3. 3 types of Vehicle: Car, Bus, Bike
 * 4. Car takes 2 parking spots, bus takes 4, bike takes 1
 * 5. Printing the Parking Lot status at any moment in time
 * 6. Gets vehicle numbers of all vehicles of a particular color
 * 7. Gets parking spot numbers having cars of a particular color
 * 8. Gets ParkingSpot number vehicle is parked in when given vehicle number as input
 */

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter number of parking slots: ");
        Scanner scan = new Scanner(System.in);
        //int n = 30;
        int n = scan.nextInt();

        System.out.print("Enter number of entry points: ");
        //int k = 3;
        int k = scan.nextInt();

        ParkingLot parkingLot = new ParkingLot(n, k);

        Car car1 = new Car("KA-01-HH-1234", "White");
        parkingLot.park(car1, 0);

        Car car2 = new Car("KA-01-HH-9999", "White");
        parkingLot.park(car2, 1);

        Bus car3 = new Bus("KA-01-BB-0001", "Black");
        parkingLot.park(car3, 2);

        Car car4 = new Car("KA-01-HH-7777", "Red");
        parkingLot.park(car4, 0);

        Car car5 = new Car("KA-01-HH-2701", "Blue");
        parkingLot.park(car5, 0);

        Bike car6 = new Bike("KA-01-HH-3141", "Black");
        parkingLot.park(car6, 1);

        parkingLot.clearSpot(4);

        parkingLot.printLotStatus();

        Bus car7 = new Bus("KA-01-P-333", "White");
        parkingLot.park(car7, 1);

        Car car8 = new Car("DL-12-AA-9999", "White");
        parkingLot.park(car8, 2);

        parkingLot.getVehicleNumberWithColor("White");

        parkingLot.getSpotNumberWithColor("White");

        parkingLot.getSpotForVehicleNumber("KA-01-HH-3141");

        parkingLot.getSpotForVehicleNumber("MH-04-AY-1111");
    }
}
