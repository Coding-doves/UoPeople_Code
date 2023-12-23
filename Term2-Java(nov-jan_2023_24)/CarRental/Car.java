package CarRental;

/**
 * Car: implement Vehicle and CarVehicle interface
 */
public class Car implements CarVehicle{
    String make;
    String model;
    String fuelType;
    int year;
    int numberOfDoors;

    //constructor, initializing variables
    public Car(String _make, String _model, int _year){
        this.make = _make;
        this.model = _model;
        this.year = _year;
    }

    // setter
    //implementing model for Vehicle interface
    
    public void setDoors(int doors){
        this.numberOfDoors = doors;
    };
    public void setFuelType(String type){
        this.fuelType = type;
    };
 
    // getters
    //retriving model for Vehicle interface
    public String getVehicleMake(){
        return this.make;
    };
    
    public String getVehicleModel(){
        return this.model;
    };
    
    public int getManufacturedYear(){
        return this.year;
    };

    public int getDoors(){
        return this.numberOfDoors;
    };

    public String getFuelType(){
            return this.fuelType;
    };
}
