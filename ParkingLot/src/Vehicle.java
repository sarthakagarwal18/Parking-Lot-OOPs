public abstract class Vehicle {

    protected int vehicleNumber;
    protected int vehicleType;

    Vehicle(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    int getVehicleNumber() {
        return vehicleNumber;
    }

    int getVehicleType() {
        return vehicleType;
    }

}
