package service;

import model.menu.OvalMenu;
import model.menu.ShapeMenu;
import model.shapes.Oval;
import model.shapes.Shape;

import java.awt.*;
import java.util.Scanner;

public class OvalService extends ShapeService {

    public static void changeCenter(Oval shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter center coordinates [x,y]");
        Point center = new Point(scanner.nextInt(), scanner.nextInt());
        shape.setCenter(center);
    }

    public static void changeHorizontalRadius(Oval shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter horizontal radius");
        shape.setRadiusHorizontal(scanner.nextInt());
    }
    public static void changeVerticalRadius(Oval shape) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Vertical radius");
        shape.setRadiusVertical(scanner.nextInt());
    }

    @Override
    public Shape createManual() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Oval");
        Oval result = new Oval();
        System.out.println("Enter center coordinates [x,y]");
        result.setCenter(new Point(scanner.nextInt(), scanner.nextInt()));
        System.out.println("Enter horizontal radius");
        result.setRadiusHorizontal(scanner.nextInt());
        System.out.println("Enter Vertical radius");
        result.setRadiusVertical(scanner.nextInt());
        return result;
    }

    @Override
    public Shape readFromFile() {
        System.out.println("Creating Oval");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        Oval result = new Oval();
        return result.readFromFile(scanner.nextLine());
    }

    @Override
    public String shapeType() {
        return "Oval";
    }

    @Override
    public ShapeMenu createShapeMenu(Shape menu) {
        return new OvalMenu((Oval) menu);
    }
}
