package CarRental;

/**
 * MotorVehicle: interface with 3 features
 * settings():
 * numbersOfWheels():  retrieving the number of wheels
 * motorcycleType(): sport, cruiser, or off-road
 */
public interface MotorVehicle extends Vehicle{
    void setNumbersOfWheels(int wheels);
    void setMotorcycleType(String type);
    int getNumbersOfWheels();
    String getMotorcycleType();
}
