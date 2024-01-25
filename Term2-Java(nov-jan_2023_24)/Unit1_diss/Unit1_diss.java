package Unit1_diss;

public class Unit1_diss {
	public static void main(String[] args) {
		// primitive types
		double cost = 4.27;
		int math = 5 + 3 * 2;
		
        // reference types
        int[] numbers = {1, 2, 3, 4, 5};
        String hello = "Hello, Java!";
        String[] fruit = {"apple", "banana", "orange"};
        
        System.out.println(cost);
        System.out.println("Number array " + java.util.Arrays.toString(numbers));
        System.out.println(hello);
		System.out.println("fruits array " + java.util.Arrays.toString(fruit));
		System.out.println();
		System.out.println("5 + 3 * 2 = " + math);
    }
}
