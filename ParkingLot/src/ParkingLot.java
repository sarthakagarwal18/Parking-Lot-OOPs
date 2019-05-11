import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO
 * 1. Multiple entry points for each floor
 * 2. Multiple spots for car, bus
 * 3. Finding spot interface implementation
 */

public class ParkingLot {

    private int numberOfSpots;
    private int numberOfEntryPoints;
    private int numberOfSpotsOnFloor;

    // Map for SpotID to ParkingSpot
    private HashMap<Integer, ParkingSpot> spotMap = new HashMap<Integer, ParkingSpot>();
    // Map for CarNumber to ParkingSpot
    private HashMap<String, ParkingSpot > carToSpotMap = new HashMap<String, ParkingSpot>();
    // Map for Color to ParkingSpots
    private HashMap<String, ArrayList<ParkingSpot> > colorToSpotMap = new HashMap<String, ArrayList<ParkingSpot> >();

    ParkingLot(int numberOfSpots, int numberOfEntryPoints) {

        this.numberOfSpots = numberOfSpots;
        this.numberOfEntryPoints = numberOfEntryPoints;
        this.numberOfSpotsOnFloor = 4;

        System.out.println("\nCreated Parking Lot with " + numberOfSpots + " slots and " + numberOfEntryPoints + " entry points!");
    }

    private boolean isSpotAvailable() {
        return (spotMap.size() < numberOfSpots);
    }

    private synchronized int findNearestSpot() {
        for (int spotId = 1; spotId <= numberOfSpots; spotId++) {
            if (!spotMap.containsKey(spotId))
                return spotId;
        }
        return -1;
    }

    private void fillMaps(Car car, ParkingSpot spot) {

        // mark spot as occupied
        spot.setParkedCar(car);
        int spotId = spot.getSpotNumber();
        spotMap.put(spotId, spot);

        // populate car to spot map
        carToSpotMap.put(car.getNumber(), spot);

        // populate color to spot map
        ArrayList<ParkingSpot> colorList = new ArrayList<>();
        if(colorToSpotMap.containsKey(car.getColor())) {
            colorList = colorToSpotMap.get(car.getColor());
        }
        colorList.add(spot);
        colorToSpotMap.put(car.getColor(), colorList);
    }

    private void removeFromMaps(Car car, ParkingSpot spot) {

        spot.setParkedCar(null);
        int spotId = spot.getSpotNumber();
        spotMap.remove(spotId);

        carToSpotMap.remove(car.getNumber());

        ArrayList<ParkingSpot> colorList= colorToSpotMap.get(car.getColor());
        for(int i = 0;i < colorList.size(); i++) {
            if(colorList.get(i).getSpotNumber() == spotId) {
                colorList.remove(i);
                break;
            }
        }
        colorToSpotMap.put(car.getColor(), colorList);
    }

    public void park(Car car, int entryPointId) {
        System.out.println("\nParking CarNumber: " + car.getNumber() + " CarColor: " + car.getColor());

        if(!isSpotAvailable()) {
            System.out.println("Sorry! Parking Lot is Full!");
            return;
        }

        int spotId = findNearestSpot();

        ParkingSpot spot = new ParkingSpot(spotId, numberOfSpotsOnFloor);
        fillMaps(car, spot);

        System.out.println("Allocated Slot Number: " + spotId);

    }

    public void clearSpot(int spotId) {
        System.out.println("\nClearing SpotId : " + spotId);

        if (!spotMap.containsKey(spotId)) {
            System.out.println("Spot already empty!");
            return;
        }

        Car car = spotMap.get(spotId).getParkedCar();

        ParkingSpot spot = spotMap.get(spotId);
        removeFromMaps(car, spot);

        System.out.println("Spot Number: " + spotId + " is free!");
    }

    public void getCarNumberWithColor(String color) {
        System.out.println("\nPrinting CarNumbers for Color: " + color);

        ArrayList<ParkingSpot> spotList = colorToSpotMap.get(color);
        System.out.print("Cars with Color " + color + ": ");
        for(int i = 0; i<spotList.size();i++) {
            System.out.print(spotList.get(i).getParkedCar().getNumber() + ", ");
        }
        System.out.println();
    }

    public void getSpotNumberWithColor(String color) {
        System.out.println("\nPrinting SpotIds for Color: " + color);

        ArrayList<ParkingSpot> spotList = colorToSpotMap.get(color);
        System.out.print("Spots with Color " + color + ": ");
        for(int i = 0; i<spotList.size();i++) {
            System.out.print(spotList.get(i).getSpotNumber() + ", ");
        }
        System.out.println();
    }

    public void getSpotForCarNumber(String carNumber) {
        System.out.println("\nPrinting SpotId for CarNumber: " + carNumber);

        if (!carToSpotMap.containsKey(carNumber)) {
            System.out.println("Not found!");
            return;
        }
        System.out.println(carToSpotMap.get(carNumber).getSpotNumber());
    }

    public void printLotStatus() {
        System.out.println("\nPrinting Lot Status: ");

        for (int spotId : spotMap.keySet()) {
            Car car = spotMap.get(spotId).getParkedCar();
            System.out.println("SpotID: " + spotId + " Car Number: " + car.getNumber() + " Car Color: " + car.getColor());
        }
    }

}
