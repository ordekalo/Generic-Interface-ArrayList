/*
  @author Or Dekalo
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Function take ArrayList  and print all elements to the screen
     *
     * @param lst: list of elements
     */
    static <E> void print(ArrayList<E> lst) {
        for (E e : lst) System.out.println(e);
    }

    /**
     * Function take Array and print all elements to the screen
     *
     * @param arr: Array of all elements
     */
    public static <T> void print(T[] arr) {
        for (T t : arr) System.out.println(t);
    }

    public static Course<?>[] fromArrayListToArray(ArrayList<Course<?>> lst) {

        Course<?>[] arr = new Course<?>[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            arr[i] = new Course<>(lst.get(i).getIdOrName(), lst.get(i).getAvg());

        }
        return arr;

    }

    /**
     * Function scan the courses from the user and add it to Arraylist
     *
     * @param numOfCourses: number of all courses
     * @param option:       option = true --> mean user choose to insert courses by name , and false mean insert by ID
     * @return ArrayList of courses
     */
    public static ArrayList<Course<?>> insert(int numOfCourses, boolean option) {
        Scanner in = new Scanner(System.in);
        ArrayList<Course<?>> arr = new ArrayList<>();
        for (int i = 0; i < numOfCourses; i++) {
            Course<?> c;
            if (option) {
                System.out.print("Enter course name: ");
                String name = in.next();
                System.out.print("Enter avg of course: ");
                float avg = in.nextFloat();
                c = new Course<>(name, avg);
            } else {
                System.out.print("Enter course ID: ");
                int number = in.nextInt();
                System.out.print("Enter avg of course: ");
                float avg = in.nextFloat();
                c = new Course<>(number, avg);
            }
            arr.add(c);
        }
        in.close();
        return arr;
    }

    /**
     * Swap for Bubble sort
     *
     * @param arr:    Array of elements
     * @param first:  first element
     * @param second: second element
     */
    static <T> void swap(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * Bubble sort
     * Function take Array and sort it
     *
     * @param arr: Array of elements
     */
    public static <T extends Comparable<T>> void bubbleSort(Course<T>[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    //swap
                    swap(arr, j + 1, j);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCourse, num;
        boolean option;
        System.out.print("Please enter how many courses:");
        numOfCourse = in.nextInt();
        System.out.print("Please press 1 to insert the courses by names, 2 by id:");
        num = in.nextInt();
        option = num == 1;

        ArrayList<Course<?>> lst = insert(numOfCourse, option);
        Course<?>[] arr1 = fromArrayListToArray(lst);
        Course[] arr2 = fromArrayListToArray(lst);

        System.out.println("All courses in ArrayList:");
        print(lst);

        System.out.println("All courses in 'regular' array:");
        print(arr1);

        Arrays.sort(arr1);
        System.out.println("The 'regular' array of courses, after sorting with Arrays.sort:");
        print(arr1);

        bubbleSort(arr2);
        System.out.println("The 'regular' array of courses, after my sorting method:");
        print(arr2);
        in.close();
    }


}
