package service;

import model.menu.CircleMenu;
import model.menu.Menu;
import model.menu.ShapeMenu;
import model.shapes.Circle;
import model.shapes.SaveAbleShape;
import model.shapes.Shape;

import java.awt.*;
import java.util.Scanner;

public class CircleService extends ShapeService {
    public static void changeRadius(Circle shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius");
        shape.setRadiusHorizontal(scanner.nextInt());
    }

    public Circle createManual() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Circle");
        System.out.println("Enter center coordinates [x,y]");
        Point center = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter radius");
        return new Circle(center, scanner.nextInt());
    }

    @Override
    public Shape readFromFile() {
        System.out.println("Creating Circle");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        Circle result = new Circle();
        return result.readFromFile(scanner.nextLine());
    }

    @Override
    public String shapeType() {
        return "Circle";
    }

    @Override
    public ShapeMenu createShapeMenu(Shape menu) {
        return new CircleMenu((Circle) menu);
    }

}
