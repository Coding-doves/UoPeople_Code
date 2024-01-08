# Function interface
This is a Java application showcasing the Function interface within an employee roster. Below are its main features:

### Program objective:

The process involves the accecptance of an employee dataset, which is then stored as a collection(List). The program utilizes Java streams to execute different tasks. It highlights how the Function interface can be used to change and obtain certain details from each employee item. Moreover, it computes the mean pay for all staff members while also screening employees based on a stipulated age limit.

### Program's Features:

The program creates a class called `Employees` that represents employees as individual objects with characteristics including their name, age, department and salary.

Data Initialization involves the creation of an initial list containing employee data through utilization of the `Arrays.asList` method.

The usage of the Function Interface involves defining a function called `employeeAsString`, which takes an employee object and combines their name and department into a single string. This function is subsequently utilized on the list of employees through Java streams.

- Operations on Streams:

Efficient processing and manipulation of employee data is achieved through utilization of stream operations such as `map`, `collect`, `filter` and `forEach`.

The average salary of all employees is computed by the program utilizing Java streams' `mapToDouble` and `average` functions.

The Java streams exhibit great flexibility in data processing as illustrated by the filtering of employees who are above a particular age threshold (29, precisely) utilizing the `filter` function.

- Java Function Interface:

Part of the java.util.function package, the Function interface in Java represents a function that produces a result based on one argument. This program utilizes the Function interface to encapsulate logic for creating an employee's name and department as string representation. Through implementation with lambda expressions, concise transformation logic definition is enabled via application of the `apply` method from this interface.

The Function interface boosts code legibility and management by enclosing conversion logic, thus allowing it to be readily employed with Java streams. It presents a practical abstraction that streamlines the incorporation of functions as fundamental components in Java coding.
