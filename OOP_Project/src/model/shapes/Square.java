package model.shapes;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(Point topLeft, int corner) {
        super(topLeft, corner, corner);
    }

    private Square(String contentOfFile) {
        String[] values = contentOfFile.split(",");
        setTopLeft(new Point(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
        setWidth(Integer.parseInt(values[2]));
    }

    @Override
    public void setWidth(int corner) {
        if (corner < 0) {
            System.out.println("Corner must be positive");
            return;
        }
        super.setWidth(corner);
        super.setHeight(corner);
    }

    @Override
    public void setHeight(int corner) {
        setWidth(corner);
    }

    @Override
    public void draw() {
        System.out.println("Square Draw");
        System.out.println(
                "{ Start=" + "[x=" + getTopLeft().x + ",y=" + getTopLeft().y + "]" +
                        ", corner=" + getHeight() + '}'
        );
    }

    @Override
    public Shape readFromFile(String filePath) {
        try {
            String contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0])[0];
            return new Square(contentOfFile);
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
        }
        return new Square();
    }

    @Override
    public void writeToFile(String filePath) {
        String result = String.format("%d,%d,%d", getTopLeft().x, getTopLeft().y, getWidth());
        try {
            Files.write(Paths.get(filePath), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
