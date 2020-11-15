package service;

import model.*;
import model.Rectangle;
import model.Shape;

import java.awt.*;
import java.util.Scanner;

public class ShapeService {
    private final Scanner scanner = new Scanner(System.in);

    public Triangle createTriangle() {
        System.out.println("Creating Triangle");
        System.out.println("Enter 3 side lengths");
        return new Triangle(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
    }

    public Rectangle createRectangle() {
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

    public Oval createOval() {
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

    public Circle createCircle() {
        System.out.println("Creating Circle");
        System.out.println("Enter center coordinates [x,y]");
        Point center = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Enter radius");
        return new Circle(center, scanner.nextInt());
    }

    public Square createSquare() {
        System.out.println("Creating Square");
        System.out.println("Enter topLeft coordinates [x,y]");
        Square result = new Square(new Point(scanner.nextInt(), scanner.nextInt()), 1);
        System.out.println("Enter corner");
        result.setWidth(scanner.nextInt());
        return result;
    }

    public void printShapeData(Shape data) {
        data.draw();
        System.out.println("Area is " + data.area());
        System.out.println("Perimeter is " + data.perimeter());
    }
}
