public class ParkingSpot {

    private int spotNumber;
    private int spotType;
    private boolean status;
    private Vehicle parkedVehicle;

    ParkingSpot(int spotNumber, int spotType) {
        status = true;
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        parkedVehicle = null;
    }

    int getSpotNumber() {
        return spotNumber;
    }

    int getSpotType() {
        return spotType;
    }

    boolean isAvailable() {
        return status;
    }

    void park(Vehicle vehicle) {

        if (vehicle.getVehicleType() != spotType) {
            System.out.println("Cannot Park Vehicle: " + vehicle.getVehicleNumber() + " in Spot: " + getSpotNumber());
            return;
        }
        parkedVehicle = vehicle;
        status = false;
    }

    void remove() {
        parkedVehicle = null;
        status = true;
    }

    private int getParkedVehicleNumber() {
        return parkedVehicle.getVehicleNumber();
    }

    String getSpotStatus() {
        if (isAvailable())
            return "Empty";
        return ("Parked Vehicle Number: " + getParkedVehicleNumber());
    }

}
