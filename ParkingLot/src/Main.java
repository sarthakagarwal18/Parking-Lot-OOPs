import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Enter number of parking slots: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.print("Enter number of entry points: ");
        int k = scan.nextInt();

        ParkingLot parkingLot = new ParkingLot(n, k);

        Car car1 = new Car("KA-01-HH-1234", "White");
        parkingLot.park(car1, 1);

        Car car2 = new Car("KA-01-HH-9999", "White");
        parkingLot.park(car2, 2);

        Car car3 = new Car("KA-01-BB-0001", "Black");
        parkingLot.park(car3, 3);

        Car car4 = new Car("KA-01-HH-7777", "Red");
        parkingLot.park(car4, 1);

        Car car5 = new Car("KA-01-HH-2701", "Blue");
        parkingLot.park(car5, 1);

        Car car6 = new Car("KA-01-HH-3141", "Black");
        parkingLot.park(car6, 2);

        parkingLot.clearSpot(4);

        parkingLot.printLotStatus();

        Car car7 = new Car("KA-01-P-333", "White");
        parkingLot.park(car7, 2);

        Car car8 = new Car("DL-12-AA-9999", "White");
        parkingLot.park(car8, 3);

        parkingLot.getCarNumberWithColor("White");

        parkingLot.getSpotNumberWithColor("White");

        parkingLot.getSpotForCarNumber("KA-01-HH-3141");

        parkingLot.getSpotForCarNumber("MH-04-AY-1111");
    }
}
