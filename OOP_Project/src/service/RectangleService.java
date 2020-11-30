package service;

import model.menu.RectangleMenu;
import model.menu.ShapeMenu;
import model.shapes.Rectangle;
import model.shapes.Shape;

import java.awt.*;
import java.util.Scanner;

public class RectangleService extends ShapeService {

    public Rectangle createManual() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Rectangle");
        Rectangle result = new Rectangle();
        System.out.println("Enter topLeft coordinates [x,y]");
        result.setTopLeft(new Point(scanner.nextInt(), scanner.nextInt()));
        System.out.println("Enter width");
        result.setWidth(scanner.nextInt());
        System.out.println("Enter height");
        result.setHeight(scanner.nextInt());
        return result;
    }

    @Override
    public Shape readFromFile() {
        System.out.println("Creating Rectangle");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        Rectangle result = new Rectangle();
        return result.readFromFile(scanner.nextLine());
    }

    @Override
    public String shapeType() {
        return "Rectangle";
    }

    @Override
    public ShapeMenu createShapeMenu(Shape menu) {
        return new RectangleMenu((Rectangle) menu);
    }

    public static void changeTopLeft(Rectangle rect) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter topLeft coordinates [x,y]");
        rect.setTopLeft(new Point(scanner.nextInt(), scanner.nextInt()));
    }

    public static void changeWidth(Rectangle rect) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        rect.setWidth(scanner.nextInt());
    }

    public static void changeHeight(Rectangle rect) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height");
        rect.setHeight(scanner.nextInt());
    }
}