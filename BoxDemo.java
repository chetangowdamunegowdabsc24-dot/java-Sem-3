
import java.util.ArrayList;  

class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

       public void addItem(T item) {
        items.add(item);
    }

        public void displayItems() {
        System.out.println("Box contains:");
        for (T item : items) {
            System.out.println(" - " + item);
        }
    }
}

public class BoxDemo {
    public static void main(String[] args) {
        System.out.println("=== Generic Box and Wrapper Classes Demo ===");

                Box<Integer> intBox = new Box<>();
        intBox.addItem(10);   // Autoboxing
        intBox.addItem(20);
        intBox.addItem(30);
        intBox.displayItems();

        System.out.println();
        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem(12.5);
        doubleBox.addItem(45.7);
        doubleBox.addItem(99.9);
        doubleBox.displayItems();

        System.out.println();

      Box<String> stringBox = new Box<>();
        stringBox.addItem("Apples");
        stringBox.addItem("Bananas");
        stringBox.addItem("Cherries");
        stringBox.displayItems();
    }
}

