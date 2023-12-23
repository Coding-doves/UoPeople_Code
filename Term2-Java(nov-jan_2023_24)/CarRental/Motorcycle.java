package CarRental;

/**
 * Motorcycle: implements Vehicle and MotorVehicle interface
 */
public class Motorcycle implements MotorVehicle {
    String make;
    String model;
    String type;
    int year;
    int numbersOfWheels;

    //constructor, initializing variables
    public Motorcycle(String _make, String _model, int _year){
        this.make = _make;
        this.model = _model;
        this.year = _year;
    }

    // setter
    //implementing model for Vehicle interface
    public void setNumbersOfWheels(int wheels){
        this.numbersOfWheels = wheels;
    };
    public void setMotorcycleType(String type){
        this.type = type;
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

    public int getNumbersOfWheels(){
        return this.numbersOfWheels;
    };

    public String getMotorcycleType(){
            return this.type;
    };
}
