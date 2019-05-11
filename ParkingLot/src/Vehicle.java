public class Vehicle {

    private String vehicleNumber;
    private String vehicleColor;
    protected int spotsNeeded;

    Vehicle(String carNumber, String carColor) {
        this.vehicleNumber = carNumber;
        this.vehicleColor = carColor;
    }

    String getNumber() {
        return vehicleNumber;
    }

    String getColor() {
        return vehicleColor;
    }

    int getSpotsNeeded() {
        return spotsNeeded;
    }

}
