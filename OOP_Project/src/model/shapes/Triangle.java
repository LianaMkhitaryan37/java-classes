package model.shapes;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Triangle implements SaveAbleShape {
    private int a = 3, b = 4, c = 5;
    private Point start;

    public Triangle() {

    }

    private Triangle(String element) {
        String[] values = element.split(",");
        validateString(values);
        setCorners(new int[]{
                Integer.parseInt(values[2]),
                Integer.parseInt(values[3]),
                Integer.parseInt(values[4])
        });
        setStart(new Point(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
    }

    private void validateString(String[] parts) {
        assert (parts.length == 5);
        assert (!parts[0].isEmpty());
        assert (!parts[1].isEmpty());
        assert (!parts[2].isEmpty());
        assert (!parts[3].isEmpty());
        assert (!parts[4].isEmpty());
    }

    public Triangle(int[] corners) {
        setCorners(corners);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int[] getCorners() {
        return new int[]{a, b, c};
    }

    public void setCorners(int[] corners) {
        validateCorners(corners);
        a = corners[0];
        b = corners[1];
        c = corners[2];
    }

    @Override
    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }


    @Override
    public void draw() {
        System.out.println("Draw Triangle");
        System.out.println("Corners are [ " + a + " , " + b + " , " + c + " ]");
    }

    @Override
    public boolean intersects(Shape other) {
        return other.intersects(this);
    }

    public boolean intersects(Rectangle other) {
        return start == other.getTopLeft();
    }

    public boolean intersects(Triangle other) {
        return start == other.start;
    }

    public boolean intersects(Oval other) {
        return start == other.getCenter();
    }

    private void validateCorners(int[] corners) {
        if (corners.length < 3 || corners[0] <= 0 || corners[1] <= 0 || corners[2] <= 0) {
            throw new RuntimeException("Please provide 3 non negative corner values");
        }
        int maxCorner = Math.max(corners[0], Math.max(corners[1], corners[2]));
        if (corners[0] + corners[1] <= maxCorner || corners[2] + corners[1] <= maxCorner || corners[0] + corners[2] <= maxCorner) {
            throw new RuntimeException("Given corners doesn't construct triangle");
        }
    }

    @Override
    public Shape readFromFile(String filePath) {
        try {
            String contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0])[0];
            return new Triangle(contentOfFile);
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
        }

        return new Triangle();
    }

    @Override
    public void writeToFile(String filePath) {
        String result = String.format("%d,%d,%d,%d,%d", start.x, start.y, a, b, c);
        try {
            Files.write(Paths.get(filePath), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
