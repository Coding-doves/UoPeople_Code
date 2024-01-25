package Library;

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
