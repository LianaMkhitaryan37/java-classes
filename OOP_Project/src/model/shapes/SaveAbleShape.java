package model.shapes;

public interface SaveAbleShape extends Shape {
    Shape readFromFile(String filePath);

    void writeToFile(String filePath);
}
