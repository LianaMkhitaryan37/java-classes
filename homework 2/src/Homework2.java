import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Homework2 {
    private static void printArrayElements(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + ((i % 29 == 0 && 0 != i) ? " \n" : " "));
        }
        System.out.println();
        System.out.println();
    }

    private static void printArrayElements(double[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + ((i % 29 == 0 && 0 != i) ? " \n" : " "));
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        {
            System.out.println("Task 1");
            System.out.println("Create an array and fill it with 2 number.");
            int[] arrayWithTwoNumbers = {15, 25};
            printArrayElements(arrayWithTwoNumbers);
        }
        {
            System.out.println("Task 2");
            System.out.println("Create an array and fill it with numbers from 1:1000.");
            int[] arrayFrom1To1000 = new int[1000];
            for (int i = 0; i < 1000; ++i) {
                arrayFrom1To1000[i] = i + 1;
            }
            printArrayElements(arrayFrom1To1000);
        }
        {
            System.out.println("Task 3");
            System.out.println("Create an array and fill it with odd numbers from -20:20");
            final int NUMBER_OF_ODD_ELEMENTS = 20;
            int[] arrayWithOddNumbers = new int[NUMBER_OF_ODD_ELEMENTS];
            for (int i = -19, arrayIndex = 0; i < 20; i += 2) {
                arrayWithOddNumbers[arrayIndex++] = i;
            }
            printArrayElements(arrayWithOddNumbers);
        }
        {
            System.out.println("Task 4");
            System.out.println("Create an array and fill it. Print all elements which can be divided by 5.");
            int[] a = new int[10];
            for (int i = 0; i < a.length; ++i) {
                a[i] = ThreadLocalRandom.current().nextInt(-100, 201);
            }
            printArrayElements(a);
            boolean found = false;
            for (int i = 0; i < a.length; ++i) {
                if (a[i] % 5 == 0) {
                    found = true;
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println((!found) ? "Nothing found" : "");
        }
        {
            System.out.println("Task 5");
            System.out.println("Create an array and fill it. Print all elements which are between 24.12 and 467.23.");
            double[] a = new double[10];
            for (int i = 0; i < a.length; ++i) {
                a[i] = ThreadLocalRandom.current().nextDouble(-100.2, 201.4);
            }
            printArrayElements(a);
            for (int i = 0; i < a.length; ++i) {
                if (a[i] > 24.12 && a[i] < 467.2)
                    System.out.print(a[i]);
            }
            System.out.println();
        }
        {
            System.out.println("Task 6");
            System.out.println("Create an array and fill it. Print count of elements which can be divided by 2.");

            int[] a = new int[10];
            for (int i = 0; i < a.length; ++i) {
                a[i] = ThreadLocalRandom.current().nextInt(-100, 201);
            }
            printArrayElements(a);
            int count = 0;
            for (int i = 0; i < a.length; ++i) {
                if (a[i] % 2 == 0)
                    ++count;

            }
            System.out.println("Count of elements which can be divided by 2 is " + count);

        }
        {
            System.out.println("Task 7");
            System.out.println("Given an integer, 0< N < 21 , print its first 10 multiples.");
//            Each multiple N x i (where 0<i<11)
//    should be printed on a new line in the
//    form: N x i = result.
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter a number from (0,21) range : ");
            int n = reader.nextInt();
            for (int i = 1; i < 11; ++i) {
                System.out.println(n + " x " + i + " = " + n * i);
            }
        }
    }
}