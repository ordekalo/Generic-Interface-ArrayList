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
        ArrayList<Course<?>> courses_array_list = insert(scanner, amount, selection);
        print(courses_array_list);
        scanner.close();
        Course[] courses_list = fromArrayListToArray(courses_array_list);
        System.out.println("All courses in 'regular' array:");
        print(courses_list);

//        TODO
//        Arrays.sort(courses_list);
//        print(courses_list);

        System.out.println("The 'regular' array of courses, after my sorting method:");
        bubbleSort(courses_list);
        print(courses_list);
    }

    static ArrayList<Course<?>> insert(Scanner scanner, int amount, int selection) {
        ArrayList<Course<?>> courseArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (selection == 1) {
                System.out.print("Please enter name: ");
                String name = scanner.next();
                System.out.print("Please enter avg: ");
                float avg = scanner.nextFloat();
                courseArrayList.add(new Course<>(name, avg));

            } else {
                System.out.print("Please enter id: ");
                int id = scanner.nextInt();
                System.out.print("Please enter avg: ");
                float avg = scanner.nextFloat();
                courseArrayList.add(new Course<>(id, avg));
            }
            System.out.println();
        }
        return courseArrayList;
    }

    static <T> void print(ArrayList<T> arrayList) {
        System.out.println("All courses in ArrayList:");
        for (T t : arrayList) {
            System.out.println(t);
        }
        System.out.println();
    }

    static Course<?>[] fromArrayListToArray(ArrayList<Course<?>> arrayList) {
        Course<?>[] courses = new Course[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            courses[i] = arrayList.get(i);
        }
        return courses;
    }

    static <T> void print(T[] courses) {
        for (T course : courses) {
            System.out.println(course);
        }
        System.out.println();
    }


    static <T> void swap(T[] values, int first, int second) {
        T temp = values[first];
        values[first] = values[second];
        values[second] = temp;
    }


    static <T extends Comparable<T>> void bubbleSort(T[] values) {
        int length = values.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (values[j + 1].compareTo(values[j]) > 0) {
                    swap(values, j + 1, j);
                }
            }
        }
    }
}
