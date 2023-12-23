package CarRental;

/**
 * TruckVehicle: interface with 3 features
 * settings()
 * set/getCargoCapacity(): the most weight of object in tons it can carry
 * set/getTransmissionType(): manual or automatic
 */
public interface TruckVehicle extends Vehicle{
    int getCargoCapacity();
    String getTransmissionType();
    void setCargoCapacity(int capacity);
    void setTransmissionType(String type);
}
