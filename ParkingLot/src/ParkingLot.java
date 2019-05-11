import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {

    private static int numberOfSpots;
    private static int numberOfFloors;

    // Map for SpotNumber to ParkingSpot
    private static HashMap<Integer, ParkingSpot> spotMap = new HashMap<Integer, ParkingSpot>();
    // Map for CarNumber to ParkingSpot
    private static HashMap<String, ArrayList<ParkingSpot> > vehicleToSpotMap = new HashMap<String, ArrayList<ParkingSpot> >();
    // Map for Color to ParkingSpots
    private static HashMap<String, ArrayList<ParkingSpot> > colorToSpotMap = new HashMap<String, ArrayList<ParkingSpot> >();

    ParkingLot(){

    }

    ParkingLot(int numberOfSpots, int numberOfFloors) {

        this.numberOfSpots = numberOfSpots;
        this.numberOfFloors = numberOfFloors;

        System.out.println("\nCreated Parking Lot with " + numberOfSpots + " total slots and " + numberOfFloors + " floors!");
    }

    // is there space in the parking lot?
    private boolean isSpotAvailable() {
        return (spotMap.size() < numberOfSpots);
    }

    private void fillMaps(Vehicle vehicle, ParkingSpot spot) {

        spot.setParkedVehicle(vehicle);
        int spotId = spot.getSpotNumber();
        spotMap.put(spotId, spot);

        ArrayList<ParkingSpot> spotList = new ArrayList<>();
        if (vehicleToSpotMap.containsKey(vehicle.getNumber())) {
            spotList = vehicleToSpotMap.get(vehicle.getNumber());
        }
        spotList.add(spot);
        vehicleToSpotMap.put(vehicle.getNumber(), spotList);

        ArrayList<ParkingSpot> colorList = new ArrayList<>();
        if(colorToSpotMap.containsKey(vehicle.getColor())) {
            colorList = colorToSpotMap.get(vehicle.getColor());
        }
        colorList.add(spot);
        colorToSpotMap.put(vehicle.getColor(), colorList);
    }

    public void park(Vehicle vehicle, int entryFloor) {
        System.out.println("\nParking Vehicle Number: " + vehicle.getNumber() + " Vehicle Color: " + vehicle.getColor());

        if (entryFloor >= numberOfFloors) {
            System.out.println("Invalid Entry Floor!");
            return;
        }

        if(!isSpotAvailable()) {
            System.out.println("Sorry! Parking Lot is Full!");
            return;
        }

        ArrayList<Integer> spotList = new ArrayList<>();
        synchronized (this) {
            spotList = vehicle.findNearestSpot(entryFloor);
        }

        System.out.print("Allocated Slot Number: ");
        for(int spotId : spotList) {
            ParkingSpot spot = new ParkingSpot(spotId);
            fillMaps(vehicle, spot);
            System.out.print(spotId + ", ");
        }
        System.out.println();
    }

    public void clearSpot(int spotId) {
        System.out.println("\nClearing SpotId : " + spotId);

        if (!spotMap.containsKey(spotId)) {
            System.out.println("Spot already empty!");
            return;
        }

        Vehicle vehicle = spotMap.get(spotId).getParkedVehicle();
        ArrayList<ParkingSpot> spotList = vehicleToSpotMap.get(vehicle.getNumber());

        vehicleToSpotMap.remove(vehicle.getNumber());

        ArrayList<ParkingSpot> colorList= colorToSpotMap.get(vehicle.getColor());
        for(ParkingSpot spot : spotList) {
            for (ParkingSpot colorSpot : colorList) {
                if (colorSpot.getSpotNumber() == spot.getSpotNumber()) {
                    colorList.remove(colorSpot);
                    break;
                }
            }
        }
        colorToSpotMap.put(vehicle.getColor(), colorList);

        System.out.print("Spot Numbers: ");
        for(ParkingSpot spot : spotList) {
            spot.setParkedVehicle(null);
            spotMap.remove(spot.getSpotNumber());
            System.out.print(spot.getSpotNumber() + " ,");
        }

        System.out.println(" are free!");
    }

    // Gets vehicle numbers of all vehicles of a particular color
    public void getVehicleNumberWithColor(String color) {
        System.out.println("\nPrinting Vehicle Numbers for Color: " + color);

        ArrayList<ParkingSpot> spotList = colorToSpotMap.get(color);
        System.out.print("Vehicles with Color " + color + ": ");
        Vehicle lastVehicle = null;
        for(ParkingSpot spot : spotList) {
            if (spot.getParkedVehicle() != lastVehicle) {
                lastVehicle = spot.getParkedVehicle();
                System.out.print(spot.getParkedVehicle().getNumber() + ", ");
            }
        }
        System.out.println();
    }

    // Gets parking spot numbers having cars of a particular color
    public void getSpotNumberWithColor(String color) {
        System.out.println("\nPrinting SpotIds for Color: " + color);

        ArrayList<ParkingSpot> spotList = colorToSpotMap.get(color);
        System.out.print("Spots with Color " + color + ": ");
        for(ParkingSpot spot : spotList) {
            System.out.print(spot.getSpotNumber() + ", ");
        }
        System.out.println();
    }

    // Gets ParkingSpot number vehicle is parked in when given vehicle number as input
    public void getSpotForVehicleNumber(String vehicleNumber) {
        System.out.println("\nPrinting SpotIds for Vehicle Number: " + vehicleNumber);

        if (!vehicleToSpotMap.containsKey(vehicleNumber)) {
            System.out.println("Not found!");
            return;
        }
        ArrayList<ParkingSpot> spotList = vehicleToSpotMap.get(vehicleNumber);
        for(ParkingSpot spot : spotList) {
            System.out.print(spot.getSpotNumber() + ", ");
        }
        System.out.println();
    }

    // Printing the Parking Lot status at any moment in time
    public void printLotStatus() {
        System.out.println("\nPrinting Lot Status: ");

        for (int spotId : spotMap.keySet()) {
            Vehicle vehicle = spotMap.get(spotId).getParkedVehicle();
            System.out.println("SpotID: " + spotId + " Vehicle Number: " + vehicle.getNumber() + " Vehicle Type: " + vehicle.getVehicleType() + " Vehicle Color: " + vehicle.getColor());
        }
    }

    public HashMap<Integer, ParkingSpot> getSpotMap() {
        return spotMap;
    }

    public int getNumberOfSpots() {
        return numberOfSpots;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

}
