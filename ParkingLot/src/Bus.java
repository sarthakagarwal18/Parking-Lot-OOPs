import java.util.ArrayList;
import java.util.HashMap;

public class Bus extends Vehicle{

    Bus(String busNumber, String busColor) {
        super(busNumber, busColor);
        setSpotsNeeded(4);
        setVehicleType("Bus");
    }

    // Assumption: Vehicle will get a place on the floor it enters.
    // The logic for finding nearest spot can easily be modified in case the above assumption is not taken to be true
    public ArrayList<Integer> findNearestSpot(int entryFloor) {
        ParkingLot parkingLot = new ParkingLot();
        HashMap<Integer, ParkingSpot> spotMap = parkingLot.getSpotMap();
        int numberoOfSpots = parkingLot.getNumberOfSpots();
        int numberOfFloors = parkingLot.getNumberOfFloors();
        int spotsOnFloor = (numberoOfSpots)/(numberOfFloors);

        for (int spotId = spotsOnFloor*entryFloor + 1; spotId <= spotsOnFloor*(entryFloor+1)-3; spotId++) {
            if (!spotMap.containsKey(spotId) && !spotMap.containsKey(spotId+1)
                    && !spotMap.containsKey(spotId+2) && !spotMap.containsKey(spotId+3)) {
                ArrayList<Integer> spotList = new ArrayList<>();
                spotList.add(spotId);
                spotList.add(spotId+1);
                spotList.add(spotId+2);
                spotList.add(spotId+3);
                return spotList;
            }
        }
        return null;
    }

}
