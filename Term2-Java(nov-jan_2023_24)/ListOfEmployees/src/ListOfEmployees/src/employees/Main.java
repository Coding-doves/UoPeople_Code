package ListOfEmployees.src.employees;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	// Read data-set and store it in a collection-> List
	public static void main(String[] args) {
		List<Employees> employeeData = Arrays.asList(
			new Employees("Ada", 32, "Software-Developer(intern)", 50_000.0),
			new Employees("Nuux", 30, "Senior Software-Developer", 55_000.0),
			new Employees("Elis", 30, "Video Editor", 67_000.0),
			new Employees("Nwa", 25, "IT", 45_000.0)
		);
		
		System.out.println("Employee's List");
		employeeData.forEach(employee -> System.out.println(employee.name + " - " + employee.age + " - " + employee.department + " - " + employee.salary));

		// Function interface: returns the employee's name and department as a concatenated string.
		Function<Employees, String> employeeAsString = employee -> employee.getName() + " -> " + employee.getDepartment();
		
		//Using streams to apply the function and collect the result
		List<String> output = employeeData.stream().map(employeeAsString).collect(Collectors.toList());
		
		System.out.println("\nEmployee's Name and Department Only");
		output.forEach(System.out::println);
		
		// find the average salary of all employees using the stream's built-in functions.
		double averageSalary = employeeData.stream().mapToDouble(Employees::getSalary).average().orElse(0.0);
		
		System.out.println("\nAverage Salary of All Employee Calculated");
		System.out.println("Average salary of all employee is " + averageSalary);
		
		//filter function that only includes employees whose age is above a certain threshold 
		int threshold = 29;
		
		List<Employees> employeeThreshold = employeeData.stream().filter(emp -> emp.getAge() > threshold).collect(Collectors.toList());
		
		System.out.println("\nThreshold: Employee Above 29 Years of Age");
		employeeThreshold.forEach(employee -> System.out.println(employee.name + " - " + employee.age + " - " + employee.department + " - " + employee.salary));

	}

}
