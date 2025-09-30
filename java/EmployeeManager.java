import java.util.Scanner;

class Employee {
    String name;
    int age;
    String department;

    Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("-----------------------");
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

               System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        Employee e1 = new Employee(name, age, department);
        System.out.println("\nEmployee Details:");
        e1.display();

                if (args.length > 0) {
            System.out.println("Processing batch updates:");
            for (String arg : args) {
                System.out.println("Argument: " + arg);
            }
        } else {
            System.out.println("No command-line arguments provided.");
        }

        sc.close();
    }
}
