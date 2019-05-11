public class ParkingSpot {
    private int spotNumber;
    private int spotLevel;
    private Vehicle parkedVehicle;

    ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.parkedVehicle = null;
    }

    int getSpotNumber() {
        return spotNumber;
    }

    Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    void setParkedVehicle(Vehicle vehicle) {
        parkedVehicle = vehicle;
    }

    int getSpotLevel() {
        return spotLevel;
    }

}
