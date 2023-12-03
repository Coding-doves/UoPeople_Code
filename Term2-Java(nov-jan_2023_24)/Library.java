
/* developig a mini library */

import java.util.Scanner;
import java.util.ArrayList;

public class Library
{
	private static Scanner scan = new Scanner(System.in);// to get users input
    // store book and its details in an array
    private static ArrayList<Book> library = new ArrayList<>();
    public static void main(String[] args){
        boolean exit = false;
        //creating an infinte loop
        try {
            while (!exit) {
                System.out.println("\nChoose from the Menu: 1, 2, 3 or exit:");
                System.out.println("1 - To add book.");
                System.out.println("2 - To borrow book.");
                System.out.println("3 - To return book.");
                System.out.println("exit - To exit.");

                String option = scan.nextLine();
                switch (option) {
                    case "1":
                        addBook();
                        break;
                    case "2":
                        borrowBook();
                        break;
                    case "3":
                        returnBook();
                        break;
                    case "exit":
                        exit = true;
                        scan.close();
                        System.out.println("\nExiting...");
                        break;
                    default:
                        System.out.println("\nEnter a valid option");
                        break;
                }
            } 
        } catch (Exception e) {
            System.out.println(e);            
        }           
    }

    // Adding book get users input and save in the library
    private static void addBook(){
        System.out.println("\nADD BOOK details");
        
        //enter title of book
        System.out.println("Book title: ");
        String title = scan.nextLine();
        
        //check if book already exist
        Book exist = checkTitle(title);

        try {
            if (exist != null){
                //if book exist add to qty
                System.out.println("Book quantity: ");
                int qty = scan.nextInt();
                scan.nextLine();

                exist.addQuantity(qty);
                System.out.println("Quantity of the book '" + title + "' has been updated");
            } else {
                // if book doesn't exist add book
                System.out.println("Book author: ");
                String author = scan.nextLine();
                
                System.out.println("Book quantity: ");
                int qty = scan.nextInt();
                scan.nextLine();

                //save book detail in an array
                Book newBook = new Book(title, author, qty);

                //saving the book in the library
                library.add(newBook);
                System.out.println(qty + " pieces of '" + title + "' has been added.");
            }
        } catch (Exception e) {
            System.out.println("An error occured: " + e);
        }
    
    }

    // Borrow book from the library
    private static void borrowBook(){
        System.out.println("\nBORROWED BOOK details");
        
        try {
            //enter title of book
            System.out.println("Book title: ");
            String title = scan.nextLine();

            // check if book exist and get the qty
            Book tit = checkTitle(title);
            if (tit != null){
                //enter number of book
                System.out.println("How many: ");
                int num = scan.nextInt();
                scan.nextLine();

                int qty = tit.returnQty();
                if (qty < 1){
                    System.out.println("quantity should be greater than 0");
                }else if (qty < num){
                    System.out.println("Not enough in the library. Only " + qty + " left.");
                }else{
                    tit.subQuantity(qty);
                    System.out.println("Here is " + num + " '" + title + "'. Enjoy your read and have a nice day.");
                }
            }else{
            System.out.println(title + " Not in the library of books.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Return book to the library
    private static void returnBook(){
        System.out.println("\nRETURNED BOOK details");
        
        try {
            //enter title of book
            System.out.println("Book title: ");
            String title = scan.nextLine();

            // check if book title exist in the library
            // if not then it is not a property of the library
            Book tit = checkTitle(title);
            if (tit != null){
                //enter number of book
                System.out.println("How many: ");
                int num = scan.nextInt();
                scan.nextLine();

                tit.addQuantity(num);
                System.out.println(title + " has been successful updated");
            }else{
                System.out.println(title + " is not a property of the library");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //check if book exist
    private static Book checkTitle(String bTitle){
        for (Book tit : library) {
            if (tit.returnTitle().equalsIgnoreCase(bTitle)){
                return tit;   
            }
        }
        return null;
    }
}


// book section class
class Book
{
    String title;
    String author;
    int qty;

    //initializing
    public Book(String title, String author, int qty)
    {
        this.title = title;
        this.author = author;
        this.qty = qty;
    }

    //update book quantity
    public void addQuantity(int quantity){
        this.qty += quantity;
    }
    //reduce quantity
    public void subQuantity(int quantity){
        this.qty -= quantity;
    }
    //return book title
    public String returnTitle() {
        return this.title;
    }
    //return quantity of a book 
    public int returnQty() {
        return this.qty;
    }
}
