package com.company;

import com.company.employee.Employee;
import com.company.employee.JobInformation;
import com.company.info.AssetDescriptor;
import com.company.info.Date;

public class Main {
    static void sortArray(int[] array) {
        int numberOfElementsToCompare = array.length;
        while (numberOfElementsToCompare != 0) {
            int indexOfLastSwappedElement = 0;
            for (int i = 1; i < numberOfElementsToCompare; ++i) {
                if (array[i - 1] > array[i]) {
                    int z = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = z;
                    indexOfLastSwappedElement = i;
                }
            }
            numberOfElementsToCompare = indexOfLastSwappedElement;
        }
    }

    static void printArray(int[] array) {
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Bubble Sort
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sortArray(a);
        printArray(a);
        int[] b = {0, 1, 4, 5, 6, 7, 8, 2, 3, 9};
        sortArray(b);
        printArray(b);

        // Logical Structure
        Date hiredDate = new Date((byte) 12, (byte) 10, 2018);
        Employee worker = new Employee("Aram", hiredDate, 12000,
                new JobInformation(hiredDate, "Armenia", "BackEnd", "Engineering", "Software Engineer", ""));
        worker.setBirthDate(new Date((byte) 12, (byte) 10, 1998));
        worker.setManager(hiredDate, "Hovhannes Grigoryan");
        worker.seteMail("annagrigoryan1@gmail.com");
        worker.setLastName("Grigoryan");
        worker.setPhoneNumber("+37455000000");
        worker.receiveAsset(
                new AssetDescriptor("Computer", "MacBook Pro", 110321, hiredDate)
        );
        worker.receiveAsset(
                new AssetDescriptor("Test device", "Iphone SE", 110652, hiredDate)
        );
        worker.printJobInformation();
        worker.returnAsset(hiredDate,110321);
        for (AssetDescriptor asset:worker.getActiveAssets()
             ) {
            System.out.println(asset);
        }
    }
}
