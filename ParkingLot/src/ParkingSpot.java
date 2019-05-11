public class ParkingSpot {
    private int spotNumber;
    private int spotLevel;
    private Car parkedCar;

    ParkingSpot(int spotNumber, int numberOfSpotsOnFloor) {
        this.spotNumber = spotNumber;
        this.spotLevel = spotNumber/numberOfSpotsOnFloor;
        this.parkedCar = null;
    }

    int getSpotNumber() {
        return spotNumber;
    }

    Car getParkedCar() {
        return parkedCar;
    }

    void setParkedCar(Car car) {
        parkedCar = car;
    }

    int getSpotLevel() {
        return spotLevel;
    }

}
