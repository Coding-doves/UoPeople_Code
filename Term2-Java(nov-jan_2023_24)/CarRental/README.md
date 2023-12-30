# CarRental Application

`Main Class`:
The Main class serves as the entry point for the CarRental application. It provides a text-based user interface for ordering vehicles (Cars, Motorcycles, and Trucks). The class contains methods to handle the main menu options, including ordering, viewing, and updating vehicle orders.

	Attributes:
o	scan: A static instance of the `Scanner` class to handle user input.
o	make: A static string variable to store the make of a vehicle.
o	model: A static string variable to store the model of a vehicle.
o	year: A static integer variable to store the year of manufacture of a vehicle.

	Methods:
o	main(String[] args): The main method where the execution of the program starts. It displays the main menu and handles user input for ordering different types of vehicles.
o	car(): Method to implement the car order menu. It provides options for placing, viewing, and updating car orders.
o	motorcycle(): Method to implement the motorcycle order menu. It provides options for placing, viewing, and updating motorcycle orders.
o	truck(): Method to implement the truck order menu. It provides options for placing, viewing, and updating truck orders.
o	getStringInput(String prompt, Scanner scan): Method to handle exceptions and retrieve a string input from the user.
o	getIntInput(String prompt, Scanner scan): Method to handle exceptions and retrieve an integer input from the user.
o	ifEmpty(String value): Loops until a non-empty value is provided for string input.

Interface
Vehicle Interface
The Vehicle interface defines a blueprint for objects representing vehicles in a car rental system. It includes three methods that must be implemented by any class that implements this interface. The methods provide information about the make, model, and manufacturing year of a vehicle.
•	Methods:
•	getVehicleMake(): This method returns a string representing the make of the vehicle. The "make" typically refers to the brand or manufacturer of the vehicle.
•	getVehicleModel(): This method returns a string representing the model of the vehicle. The "model" refers to the specific version or design of the vehicle.
•	getManufacturedYear(): This method returns an integer representing the year the vehicle was manufactured. It provides information about the production year of the vehicle.
Usage:
The Vehicle interface can be implemented by different classes representing specific types of vehicles, such as cars, motorcycles, or trucks. By implementing this interface, a class is obligated to provide concrete implementations for the methods defined in the interface.

`TruckVehicle Interface`
The `TruckVehicle` interface defines a contract for objects that represent trucks within the CarRental application. It extends the `Vehicle` interface, inheriting its features and adding specific functionality related to trucks.

•	Methods:

•	getCargoCapacity():This method returns an int. It retrieves the maximum weight capacity of the truck in tons that it can carry.
•	getTransmissionType():This method returns a String, it retrieves the transmission type of the truck (manual or automatic).
•	setCargoCapacity(int capacity): Update or initialize the cargo capacity of a truck.

•	setTransmissionType(String type): The transmission type of the truck (manual or automatic). Used to update or initialize the transmission type of a truck.

•	Inherited Methods: Inherited from the Vehicle interface, these methods retrieve the make, model, and year of manufacture of the vehicle, respectively.
Usage:
The `TruckVehicle` interface serves as a blueprint for implementing classes that represent trucks in the CarRental application. Any class that implements this interface is expected to provide concrete implementations for the defined methods. These methods facilitate the retrieval and modification of specific attributes related to trucks, enhancing the flexibility and consistency of truck-related functionalities within the application.

CarVehicle Interface
The CarVehicle interface defines a contract for objects representing vehicles in a car rental system. It extends the Vehicle interface, indicating that any class implementing CarVehicle must also implement the methods declared in the Vehicle interface.
•	Methods:
•	setDoors(int doors): A method to set the number of doors for a car model. It takes an integer parameter representing the number of doors and does not return any value.
•	setFuelType(String type): A method to set the fuel type for a car model. It takes a string parameter representing the fuel type (petrol, diesel, or electric) and does not return any value.
•	getFuelType(): A method to retrieve the fuel type of a car model. It returns a string representing the fuel type.
•	getDoors(): A method to retrieve the number of doors for a car model. It returns an integer representing the number of doors.
•	Inherited Methods: Inherited from the Vehicle interface, these methods retrieve the make, model, and year of manufacture of the vehicle, respectively.
Usage:
Any class that implements the CarVehicle interface is required to provide concrete implementations for the methods declared in the interface.

MotorVehicle Interface
The `MotorVehicle` interface defines a set of methods related to motor vehicles, specifically motorcycles. It extends the `Vehicle` interface, inheriting its features. This interface is designed to capture common behaviors and properties of motor vehicles and provides methods to retrieve and set information such as the number of wheels and the type of motorcycle.

•	Methods:

•	setNumbersOfWheels(int wheels): Abstract method to set the number of wheels for a motor vehicle. Implementing classes must define the logic for setting the number of wheels.
•	setMotorcycleType(String type): Abstract method to set the type of motorcycle (e.g., sport, cruiser, or off-road). Implementing classes must define the logic for setting the motorcycle type.
•	getNumbersOfWheels(): Abstract method to retrieve the number of wheels for a motor vehicle. Implementing classes must provide the actual implementation for retrieving the number of wheels.

•	getMotorcycleType(): Abstract method to retrieve the type of motorcycle. Implementing classes must provide the actual implementation for retrieving the motorcycle type.

•	Inheritance: The `MotorVehicle` interface extends the `Vehicle` interface, inheriting its methods. This implies that any class implementing the `MotorVehicle` interface must also provide concrete implementations for the methods declared in the `Vehicle` interface.

Class
Car Class
The Car class is part of the CarRental application and implements the Vehicle and CarVehicle interfaces. It represents a basic blueprint for creating car objects with specific attributes and methods. The class includes a constructor for initializing car details and getter and setter methods to access and modify the car's properties.
•	Attributes:
•	make: A string variable representing the make of the car.
•	model: A string variable representing the model of the car.
•	fuelType: A string variable representing the fuel type of the car (petrol, diesel, or electric).
•	year: An integer variable representing the year of manufacture of the car.
•	numberOfDoors: An integer variable representing the number of doors on the car.
•	Constructor:
•	Car(String _make, String _model, int _year): A constructor that initializes the make, model, and year attributes when creating a new Car object.
•	Methods:
•	Setters (Mutator Methods):
•	setDoors(int doors): A method to set the number of doors for the car.
•	setFuelType(String type): A method to set the fuel type for the car.
•	Getters (Accessor Methods):
•	getVehicleMake(): A method to retrieve the make of the car.
•	getVehicleModel(): A method to retrieve the model of the car.
•	getManufacturedYear(): A method to retrieve the year of manufacture of the car.
•	getDoors(): A method to retrieve the number of doors on the car.
•	getFuelType(): A method to retrieve the fuel type of the car.
Interface Implementation:
•	Vehicle Interface:
•	The Car class implements the Vehicle interface, providing implementations for the getVehicleMake(), getVehicleModel(), and getManufacturedYear() methods.
•	CarVehicle Interface:
•	The Car class implements the CarVehicle interface, providing implementations for the setDoors(int doors) and setFuelType(String type) methods.
Usage
The Car class provides a structured way to represent and manipulate car data within the CarRental application, adhering to the Vehicle and CarVehicle interfaces.

Motorcycle Class
The Motorcycle class is part of the CarRental application and implements the Vehicle and MotorVehicle interfaces. It represents a basic blueprint for creating motorcycle objects with specific attributes and methods. The class includes a constructor for initializing motorcycle details and getter and setter methods to access and modify the motorcycle's properties.
•	Attributes:
•	make: A string variable representing the make of the motorcycle.
•	model: A string variable representing the model of the motorcycle.
•	type: A string variable representing the type of the motorcycle (sport, cruiser, or off-road).
•	year: An integer variable representing the year of manufacture of the motorcycle.
•	numbersOfWheels: An integer variable representing the number of wheels on the motorcycle.
•	Constructor:
•	Motorcycle(String _make, String _model, int _year): A constructor that initializes the make, model, and year attributes when creating a new Motorcycle object.
•	Methods:
•	Setters (Mutator Methods):
•	setNumbersOfWheels(int wheels): A method to set the number of wheels for the motorcycle.
•	setMotorcycleType(String type): A method to set the type of the motorcycle.
•	Getters (Accessor Methods):
•	getVehicleMake(): A method to retrieve the make of the motorcycle.
•	getVehicleModel(): A method to retrieve the model of the motorcycle.
•	getManufacturedYear(): A method to retrieve the year of manufacture of the motorcycle.
•	getNumbersOfWheels(): A method to retrieve the number of wheels on the motorcycle.
•	getMotorcycleType(): A method to retrieve the type of the motorcycle.
Usage:
The Motorcycle class provides a structured way to represent and manipulate motorcycle data within the CarRental application, adhering to the Vehicle and MotorVehicle interfaces.

Truck Class
The Truck class is a part of the CarRental application and implements the Vehicle and TruckVehicle interfaces. This class serves as a blueprint for creating truck objects with specific attributes and methods. It includes a constructor for initializing truck details and getter and setter methods to access and modify the truck's properties.
•	Attributes:
•	make: A string variable representing the make of the truck.
•	model: A string variable representing the model of the truck.
•	transmissionType: A string variable representing the transmission type of the truck (e.g., automatic, manual).
•	year: An integer variable representing the year of manufacture of the truck.
•	capacityInTons: An integer variable representing the cargo capacity of the truck in tons.
•	Constructor:
•	Truck(String _make, String _model, int _year): A constructor that initializes the make, model, and year attributes when creating a new Truck object.
•	Methods:
•	Setters (Mutator Methods):
•	setCargoCapacity(int tons): A method to set the cargo capacity of the truck in tons.
•	setTransmissionType(String type): A method to set the transmission type of the truck.
•	Getters (Accessor Methods):
•	getVehicleMake(): A method to retrieve the make of the truck.
•	getVehicleModel(): A method to retrieve the model of the truck.
•	getManufacturedYear(): A method to retrieve the year of manufacture of the truck.
•	getTransmissionType(): A method to retrieve the transmission type of the truck.
•	getCargoCapacity(): A method to retrieve the cargo capacity of the truck in tons.
Usage:
The Truck class provides a structured way to represent and manipulate truck data within the CarRental application, adhering to the Vehicle and TruckVehicle interfaces.

truckClass Class
The truckClass class is part of the CarRental application and is responsible for managing truck-related functionalities. It includes methods for placing truck orders, viewing the list of trucks, and updating truck details. The class utilizes the Truck class to create and manipulate truck objects.
•	Attributes:
•	make: A string variable representing the make of the truck.
•	model: A string variable representing the model of the truck.
•	year: An integer variable representing the year of manufacture of the truck.
•	capacity: An integer variable representing the cargo capacity of the truck in tons.
•	type: A string variable representing the transmission type of the truck (e.g., MANUAL or AUTOMATIC).
•	Methods:
•	placeOrder() Method: This method allows users to place an order for a truck. It prompts the user for information such as make, model, type, year, and capacity. The entered details are used to create a new Truck object, which is added to the listOfTrucks.
•	view() Method: This method displays the list of trucks. It checks if the list is empty and prints the details of each truck if available. The method then returns to the main truck menu.
•	update() Method: This method allows users to update the details of a specific truck. Users are prompted to enter the model of the truck they want to update. The method searches for the truck in the listOfTrucks based on the model. If found, it prompts the user to update the cargo capacity and transmission type. The updated truck object is then added to the list, replacing the existing truck.If the truck is not found, a message is displayed.
Usage:
The truckClass class provides a structured way to manage and interact with truck-related functionalities within the CarRental application. It works in conjunction with the Truck class to handle truck orders, view truck details, and update truck information.


motorcycleClass Class
The motorcycleClass class is part of the CarRental application and is responsible for managing motorcycle-related functionalities. It includes methods for placing motorcycle orders, viewing the list of motorcycles, and updating motorcycle details. The class utilizes the Motorcycle class to create and manipulate motorcycle objects.
•	Attributes:
•	make: A string variable representing the make of the motorcycle.
•	model: A string variable representing the model of the motorcycle.
•	type: A string variable representing the type of the motorcycle (e.g., sport, cruiser, or off-road).
•	year: An integer variable representing the year of manufacture of the motorcycle.
•	numbersOfWheels: An integer variable representing the number of wheels on the motorcycle.
•	Methods:
•	placeOrder() Method:
•	This method allows users to place an order for a motorcycle.
•	It prompts the user for information such as make, model, type, year, and the number of wheels.
•	The entered details are used to create a new Motorcycle object, which is added to the listOfBikes.
•	view() Method:
•	This method displays the list of motorcycles.
•	It checks if the list is empty and prints the details of each motorcycle if available.
•	The method then returns to the main motorcycle menu.
•	update() Method:
•	This method allows users to update the details of a specific motorcycle.
•	Users are prompted to enter the model of the motorcycle they want to update.
•	The method searches for the motorcycle in the listOfBikes based on the model.
•	If found, it prompts the user to update the number of wheels and motorcycle type.
•	The updated motorcycle object is then added to the list, replacing the existing motorcycle.
•	If the motorcycle is not found, a message is displayed.
Usage:
The motorcycleClass class provides a structured way to manage and interact with motorcycle-related functionalities within the CarRental application. It works in conjunction with the Motorcycle class to handle motorcycle orders, view motorcycle details, and update motorcycle information.

CarClass Class
The CarClass class is a component of the CarRental application, responsible for managing car-related functionalities. It contains methods for placing car orders, viewing the list of cars, and updating car details. The class uses the Car class to create and manipulate car objects.
•	Attributes:
•	make: A string variable representing the make of the car.
•	model: A string variable representing the model of the car.
•	fuel: A string variable representing the fuel type of the car.
•	year: An integer variable representing the year of manufacture of the car.
•	doors: An integer variable representing the number of doors on the car.
•	Methods:
•	placeOrder() Method:
•	This method allows users to place an order for a car.
•	It prompts the user for information such as make, model, fuel type, year, and the number of doors.
•	The entered details are used to create a new Car object, which is added to the listOfVehicles.
•	view() Method:
•	This method displays the list of cars.
•	It checks if the list is empty and prints the details of each car if available.
•	The method then returns to the main car menu.
•	update() Method:
•	This method allows users to update the details of a specific car.
•	Users are prompted to enter the model of the car they want to update.
•	The method searches for the car in the listOfVehicles based on the model.
•	If found, it prompts the user to update the number of doors and fuel type.
•	The updated car object is then added to the list, replacing the existing car.
•	If the car is not found, a message is displayed.
Usage:
The CarClass class provides a structured way to manage and interact with car-related functionalities within the CarRental application. It works in conjunction with the Car class to handle car orders, view car details, and update car information.

