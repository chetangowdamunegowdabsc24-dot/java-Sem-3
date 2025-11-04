
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentMarksList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

                ArrayList<Integer> marksList = new ArrayList<>();

        System.out.println("=== Student Marks List Application ===");
        marksList.add(85);
        marksList.add(90);
        marksList.add(76);
        marksList.add(88);
        marksList.add(95);

        System.out.println("\nInitial Marks List: " + marksList);

              System.out.println("\nTraversing marks list using Iterator:");
        Iterator<Integer> itr = marksList.iterator();
        while (itr.hasNext()) {
            System.out.println("Mark: " + itr.next());
        }
        System.out.print("\nEnter the index of mark to update (0 - " + (marksList.size() - 1) + "): ");
        int index = sc.nextInt();
        System.out.print("Enter new mark: ");
        int newMark = sc.nextInt();
        marksList.set(index, newMark);
        System.out.println("Updated Marks List: " + marksList);

        
        System.out.print("\nEnter index of mark to delete (0 - " + (marksList.size() - 1) + "): ");
        int delIndex = sc.nextInt();
        marksList.remove(delIndex);
        System.out.println("Marks List after deletion: " + marksList);

               System.out.println("\nFinal Marks List using for-each loop:");
        for (int mark : marksList) {
            System.out.println("Mark: " + mark);
        }

        sc.close();
        System.out.println("\n=== End of Program ===");
    }
}
