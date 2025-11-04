class Printer {
    // Synchronized method ensures only one thread can print at a time
    synchronized void printDocument(String user, String documentName) {
        System.out.println(user + " started printing: " + documentName);
        try {
            Thread.sleep(2000); // Simulate printing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user + " finished printing: " + documentName);
    }
}

class User implements Runnable {
    private String userName;
    private Printer printer;

    public User(String userName, Printer printer) {
        this.userName = userName;
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printDocument(userName, "Document_from_" + userName + ".pdf");
    }
}

public class PrintSimulation {
    public static void main(String[] args) {
        System.out.println("=== Office Print Queue Simulation ===");

        // Shared Printer object
        Printer sharedPrinter = new Printer();

        // Create multiple user threads
        Thread user1 = new Thread(new User("Alice", sharedPrinter));
        Thread user2 = new Thread(new User("Bob", sharedPrinter));
        Thread user3 = new Thread(new User("Charlie", sharedPrinter));

        // Start the threads
        user1.start();
        user2.start();
        user3.start();
    }
}