package CarRental;
/**
 * CarRental:Entry point
 */
public class CarRental {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2022);
        Motorcycle motorcycle = new Motorcycle("Harley", "Davidson", 2021);
        Truck truck = new Truck("Ford", "F-150", 2023);

        car.numberOfDoors = 4;
        car.fuelType = "petrol";

        motorcycle.numbersOfWheels = 2;
        motorcycle.type = "sport";

        truck.capacityInTons = 1200;
        truck.transmissonType = "automatic";

        System.out.println(car.fuelType);
        System.out.println(motorcycle.make);
        System.out.println(truck.capacityInTons);
    }
}
