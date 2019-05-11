import java.util.ArrayList;

public abstract class Vehicle implements Parkable{

    private String vehicleNumber;
    private String vehicleColor;
    private String vehicleType;
    private int spotsNeeded;

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

    void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    String getVehicleType() {
        return vehicleType;
    }

    void setVehicleType(String type) {
        vehicleType = type;
    }

}
