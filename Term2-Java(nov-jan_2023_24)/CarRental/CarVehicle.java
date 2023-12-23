package CarRental;

/**
 * CarVehicle: interface with 2 features
 * doors(): the numbeer of doors car model can have
 * fuelType(): either petrol, diesel, or electric
 */
public interface CarVehicle extends Vehicle {
    void setDoors(int doors);
    void setFuelType(String type);
    String getFuelType();
    int getDoors();
    
}
