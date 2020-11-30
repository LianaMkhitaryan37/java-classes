package service;

import model.menu.Menu;
import model.menu.ShapeMenu;
import model.shapes.SaveAbleShape;
import model.shapes.Shape;

import java.util.Scanner;

public abstract class ShapeService {

    public abstract Shape createManual();

    public abstract Shape readFromFile();

    public abstract String shapeType();

    public abstract ShapeMenu createShapeMenu(Shape menu);

    public static boolean intersects(Shape first, Shape second) {
        return first.intersects(second);
    }

    public static void writeToFile(SaveAbleShape rect) {
        System.out.println("Writing To File");
        System.out.println("Enter path for file");
        Scanner scanner = new Scanner(System.in);
        rect.writeToFile(scanner.nextLine());
    }
}
