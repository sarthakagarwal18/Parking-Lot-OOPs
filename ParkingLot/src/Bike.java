import java.util.ArrayList;
import java.util.HashMap;

public class Bike extends Vehicle{

    Bike(String bikeNumber, String bikeColor) {
        super(bikeNumber, bikeColor);
        setSpotsNeeded(1);
        setVehicleType("Bike");
    }


    // Assumption: Vehicle will get a place on the floor it enters.
    // The logic for finding nearest spot can easily be modified in case the above assumption is not taken to be true
    public ArrayList<Integer> findNearestSpot(int entryFloor) {
        ParkingLot parkingLot = new ParkingLot();
        HashMap<Integer, ParkingSpot> spotMap = parkingLot.getSpotMap();
        int numberoOfSpots = parkingLot.getNumberOfSpots();
        int numberOfFloors = parkingLot.getNumberOfFloors();
        int spotsOnFloor = (numberoOfSpots)/(numberOfFloors);

        for (int spotId = spotsOnFloor*entryFloor + 1; spotId <= spotsOnFloor*(entryFloor+1); spotId++) {
            if (!spotMap.containsKey(spotId)) {
                ArrayList<Integer> spotList = new ArrayList<>();
                spotList.add(spotId);
                return spotList;
            }
        }
        return null;
    }

}
