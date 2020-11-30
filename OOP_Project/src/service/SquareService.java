package service;

import model.menu.ShapeMenu;
import model.menu.SquareMenu;
import model.shapes.Rectangle;
import model.shapes.Shape;
import model.shapes.Square;

import java.awt.*;
import java.util.Scanner;

public class SquareService extends ShapeService {

    public static void changeCorner(Square square) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter corner");
        square.setWidth(scanner.nextInt());
    }

    @Override
    public Shape createManual() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Creating Square");
        System.out.println("Enter topLeft coordinates [x,y]");
        Square result = new Square(new Point(scanner.nextInt(), scanner.nextInt()), 1);
        System.out.println("Enter corner");
        result.setWidth(scanner.nextInt());
        return result;
    }

    @Override
    public Shape readFromFile() {
        System.out.println("Creating Square");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        Square result = new Square();
        return result.readFromFile(scanner.nextLine());
    }

    @Override
    public String shapeType() {
        return "Square";
    }

    @Override
    public ShapeMenu createShapeMenu(Shape menu) {
        return new SquareMenu((Square) menu);
    }
}
