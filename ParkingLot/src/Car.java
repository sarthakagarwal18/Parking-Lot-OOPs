import java.util.ArrayList;
import java.util.HashMap;

public class Car extends Vehicle{

    Car(String carNumber, String carColor) {
        super(carNumber, carColor);
        setSpotsNeeded(2);
        setVehicleType("Car");
    }

    // Assumption: Vehicle will get a place on the floor it enters.
    // The logic for finding nearest spot can easily be modified in case the above assumption is not taken to be true
    public ArrayList<Integer> findNearestSpot(int entryFloor) {
        ParkingLot parkingLot = new ParkingLot();
        HashMap<Integer, ParkingSpot> spotMap = parkingLot.getSpotMap();
        int numberoOfSpots = parkingLot.getNumberOfSpots();
        int numberOfFloors = parkingLot.getNumberOfFloors();
        int spotsOnFloor = (numberoOfSpots)/(numberOfFloors);

        for (int spotId = spotsOnFloor*entryFloor + 1; spotId <= spotsOnFloor*(entryFloor+1)-1; spotId++) {
            if (!spotMap.containsKey(spotId) && !spotMap.containsKey(spotId+1)) {
                ArrayList<Integer> spotList = new ArrayList<>();
                spotList.add(spotId);
                spotList.add(spotId+1);
                return spotList;
            }
        }

        return null;
    }

}
