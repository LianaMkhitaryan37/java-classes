package model.shapes;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Rectangle implements SaveAbleShape {
    private Point topLeft;
    private int width = 1;
    private int height = 1;

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        setWidth(width);
        setHeight(height);
    }

    public Rectangle() {
    }

    private Rectangle(String contentOfFile) {
        String[] values = contentOfFile.split(",");
        setTopLeft(new Point(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
        setWidth(Integer.parseInt(values[2]));
        setHeight(Integer.parseInt(values[3]));
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new RuntimeException("Width must be positive");
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new RuntimeException("Height must be positive");
        }
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle Draw");
        System.out.println(
                "{ Start=" + "[x=" + topLeft.x + ",y=" + topLeft.y + "]" +
                        ", width=" + width +
                        ", height=" + height +
                        '}'
        );
    }

    @Override
    public boolean intersects(Shape other) {
        return other.intersects(this);
    }

    @Override
    public boolean intersects(Rectangle other) {
        int disX = Math.abs(other.topLeft.x - topLeft.x);
        int disY = Math.abs(other.topLeft.y - topLeft.y);
        return disX < (other.width + width) || disY < (other.height + height);
    }

    @Override
    public boolean intersects(Triangle other) {
        return other.intersects(this);
    }

    @Override
    public boolean intersects(Oval other) {
        return other.intersects(this);
    }

    public double diagonalLength() {
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public Shape readFromFile(String filePath) {
        try {
            String contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0])[0];
            return new Rectangle(contentOfFile);
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
        }
        return new Rectangle();
    }

    @Override
    public void writeToFile(String filePath) {
        String result = String.format("%d,%d,%d,%d", topLeft.x, topLeft.y, width, height);
        try {
            Files.write(Paths.get(filePath), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
