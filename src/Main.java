import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter how many courses: ");
        int amount = scanner.nextInt();
        System.out.print("Please press 1 to insert the courses by names, 2 by id:");
        int selection = scanner.nextInt();
        System.out.println();
        System.out.println(insert(scanner, amount, selection));
        ;

        scanner.close();
    }

    static ArrayList<Course> insert(Scanner scanner, int amount, int selection) {
        ArrayList<Course> courseArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (selection == 1) {
                System.out.print("Please enter name: ");
                String name = scanner.next();
                System.out.print("Please enter avg: ");
                float avg = scanner.nextFloat();
                Course<String> course = new Course<>(name, avg);
                courseArrayList.add(course);

            } else {
                System.out.print("Please enter id: ");
                int id = scanner.nextInt();
                System.out.print("Please enter avg: ");
                float avg = scanner.nextFloat();
                Course<Integer> course = new Course<>(id, avg);
                courseArrayList.add(course);
            }
            System.out.println();

        }

        return courseArrayList;
    }
}
