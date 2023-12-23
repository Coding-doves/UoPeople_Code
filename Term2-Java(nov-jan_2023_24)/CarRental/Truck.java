package CarRental;

/**
 * Truck: implements Vehicle and TruckVehicle interface
 */
public class Truck implements TruckVehicle{
    String make;
    String model;
    String transmissonType;
    int year;
    int capacityInTons;

    //constructor, initializing variables
    public Truck(String _make, String _model, int _year){
        this.make = _make;
        this.model = _model;
        this.year = _year;
    }

    // setters
    //implementing model for TruckVehicle interface
    public void setCargoCapacity(int tons){
        this.capacityInTons = tons;
    };

    public void setTransmissionType(String type){
        this.transmissonType = type;
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

    //implementing model for TruckVehicle interface
    public String getTransmissionType(){
        return this.transmissonType;
    };
    public int getCargoCapacity(){
        return this.capacityInTons;
    };
}
