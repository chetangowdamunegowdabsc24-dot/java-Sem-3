class Book {
    String title;
    String author;
    double price;

    // Constructor using 'this' keyword
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display details
    void display() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("-----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating book objects
        Book b1 = new Book("Java Programming", "Herbert Schildt", 550.75);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 699.00);

        // Display details
        b1.display();
        b2.display();
    }
}
