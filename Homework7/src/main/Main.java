package main;

import model.Reader;
import model.Student;
import service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter file path");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        try {
            Student[] students = Reader.readFromFile(filePath);
            StudentService.printStudentsFullName(students);
            StudentService.printMaleStudents(students);
            StudentService.printFemaleStudentsWithGreaterMark(students);
            StudentService.printStudentsWithMinimalMark(students);
            StudentService.printBiggestMaleStudent(students);
            StudentService.printStudentsSortedByMark(students);
            StudentService.printFemaleStudentsSortedByYear(students);
        } catch (IOException e) {
            System.out.println("Tasks will be executed if entered path is valid");
        }
    }
}
