class Vehicle {
    String brand = "Generic Vehicle";

    Vehicle() {
        System.out.println("Vehicle constructor called");
    }

    void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {
    String model;

    Car(String model) {
        super(); // Calls Vehicle constructor
        this.model = model;
        System.out.println("Car constructor called");
    }

      void start() {
        System.out.println("Car " + model + " is starting...");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String model, int batteryCapacity) {
        super(model); // Calls Car constructor
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }

       void start() {
        super.start(); // Calls Car's start method
        System.out.println("ElectricCar with battery capacity " + batteryCapacity + " kWh is starting silently...");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar("Tesla Model S", 100);
        tesla.start();
    }
}
