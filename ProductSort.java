import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}

public class ProductSort {
    public static void main(String[] args) {

        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 65000));
        products.add(new Product("Phone", 35000));
        products.add(new Product("Tablet", 25000));
        products.add(new Product("Headphones", 3000));
        products.add(new Product("Smartwatch", 12000));

        System.out.println("Original List:");
        products.forEach(System.out::println);

        // Sort by price using a lambda expression
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\nSorted by Price (Ascending):");
        products.forEach(System.out::println);

        // Sort by name using a lambda expression
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("\nSorted by Name (Alphabetical):");
        products.forEach(System.out::println);

        // Example of block lambda (Functional Interface)
        Comparator<Product> priceDescending = (p1, p2) -> {
            if (p1.getPrice() < p2.getPrice()) return 1;
            else if (p1.getPrice() > p2.getPrice()) return -1;
            else return 0;
        };

        Collections.sort(products, priceDescending);
        System.out.println("\nSorted by Price (Descending, Block Lambda):");
        products.forEach(System.out::println);
    }
}
