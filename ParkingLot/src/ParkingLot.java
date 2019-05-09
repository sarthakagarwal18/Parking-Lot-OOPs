import java.util.HashMap;

public class ParkingLot {

    private boolean parkingLotStatus;
    private int numberOfSpots;
    private HashMap<Integer, ParkingSpot> spotMap = new HashMap<Integer, ParkingSpot>();
    private HashMap<Vehicle, ParkingSpot> vehicleMap = new HashMap<Vehicle, ParkingSpot>();

    ParkingLot(int numberOfSpots) {
        parkingLotStatus = true;
        this.numberOfSpots = numberOfSpots;

        for (int spotId = 1; spotId <= numberOfSpots; spotId++) {
            int spotType = 1;
            if (spotId % 3 == 0) {
                spotType = 2;
            }
            ParkingSpot spot = new ParkingSpot(spotId, spotType);
            spotMap.put(spotId, spot);
        }
    }

    private boolean isSpotAvailable() {
        return parkingLotStatus;
    }

    private ParkingSpot findNearestSpot(Vehicle vehicle) {

        for (int spotId = 1; spotId <= numberOfSpots; spotId++) {
            ParkingSpot spot = spotMap.get(spotId);
            if (spot.isAvailable() && spot.getSpotType() == vehicle.getVehicleType())
                return spot;
        }
        return null;
    }

    public void park(Vehicle vehicle) {

        if(!isSpotAvailable()) {
            System.out.println("Parking Lot Full!");
            return;
        }

        ParkingSpot spot = findNearestSpot(vehicle);
        spot.park(vehicle);

        vehicleMap.put(vehicle, spot);

    }

    public void removeVehicle(Vehicle vehicle) {

        if (vehicleMap.containsKey(vehicle)) {
            ParkingSpot spot = vehicleMap.get(vehicle);
            spot.remove();

            vehicleMap.remove(vehicle);
        } else {
            System.out.println("Vehicle not in Parking Lot!");
        }
    }

    public void printLotStatus() {

        for (int spotId = 1; spotId <= numberOfSpots; spotId++) {
            ParkingSpot spot = spotMap.get(spotId);
            System.out.println("SpotID: " + spot.getSpotNumber() + " SpotType: " + spot.getSpotType() + " --> " + spot.getSpotStatus());
        }
        System.out.println();
    }

}
