package service;

import model.menu.ShapeMenu;
import model.menu.TriangleMenu;
import model.shapes.Shape;
import model.shapes.Triangle;

import java.awt.*;
import java.util.Scanner;

public class TriangleService extends ShapeService {
    public static void changeStart(Triangle shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start coordinates [x,y]");
        shape.setStart(new Point(scanner.nextInt(), scanner.nextInt()));
    }

    public static void changeCorners(Triangle shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 side lengths");
        shape.setCorners(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
    }

    public Triangle createManual() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Triangle");
        System.out.println("Enter 3 side lengths");
        Triangle result = new Triangle(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
        System.out.println("Enter start coordinates [x,y]");
        result.setStart(new Point(scanner.nextInt(), scanner.nextInt()));
        return result;
    }

    @Override
    public Shape readFromFile() {
        System.out.println("Creating Triangle");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        Triangle result = new Triangle();
        return result.readFromFile(scanner.nextLine());
    }

    @Override
    public String shapeType() {
        return "Triangle";
    }

    @Override
    public ShapeMenu createShapeMenu(Shape menu) {
        return new TriangleMenu((Triangle) menu);
    }
}
