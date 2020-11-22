package service;

import model.Student;
import model.StudentCompare;

import java.util.Arrays;

public class StudentService {

    public static void printStudentsFullName(Student[] students) {
        System.out.println("Task1");
        for (Student student :
                students) {
            System.out.println(student.getFullName());
        }
    }

    public static void printMaleStudents(Student[] students) {
        System.out.println("Task2");
        for (Student student :
                students) {
            if (student.isMale())
                System.out.println(student);
        }
    }

    public static void printFemaleStudentsWithGreaterMark(Student[] students) {
        System.out.println("Task3");
        for (Student student :
                students) {
            if (student.isFemale() && student.getMark() > 50.4)
                System.out.println(student);
        }
    }

    public static void printStudentsWithMinimalMark(Student[] students) {
        System.out.println("Task4");
        double minMark = minimalMarkOfStudents(students);
        for (Student student :
                students) {
            if (student.getMark() == minMark) {
                System.out.println(student);
            }
        }
    }

    public static void printBiggestMaleStudent(Student[] students) {
        System.out.println("Task5");
        Student result = null;
        int year = Integer.MAX_VALUE;
        for (Student student :
                students) {
            if (student.isMale() && student.getYear() < year) {
                year = student.getYear();
                result = student;
            }
        }
        System.out.println(result);
    }

    public static void printStudentsSortedByMark(Student[] arr) {
        System.out.println("Task6");
        sort(arr);
        for (Student obj : arr) {
            System.out.println(obj);
        }
    }

    public static void printFemaleStudentsSortedByYear(Student[] arr) {
        System.out.println("Task7");
        StudentCompare.setToCompareWithYear();
        sort(arr);
        for (Student obj : arr) {
            if (obj.isFemale())
                System.out.println(obj);
        }
    }

    private static double minimalMarkOfStudents(Student[] stud) {
        double mark = Double.MIN_VALUE;
        for (Student student :
                stud) {
            if (student.getMark() < mark)
                mark = student.getMark();
        }
        return mark;
    }

    private static Student[] merge(Student[] result, int start, int middle, int end) {
        Student[] arr1 = new Student[middle - start + 1];
        Student[] arr2 = new Student[end - middle];

        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = result[start + i];
        }
        for (int j = 0; j < arr2.length; ++j) {
            arr2[j] = result[middle + 1 + j];
        }
        int index1 = 0, index2 = 0, resultIndex = start;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (StudentCompare.compare(arr1[index1], arr2[index2])) {
                result[resultIndex++] = arr1[index1++];
            } else {
                result[resultIndex++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            result[resultIndex++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            result[resultIndex++] = arr2[index2++];
        }
        return result;
    }

    private static void sort(Student[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Student[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);

            merge(arr, start, middle, end);
        }
    }
}

