package main;

import service.ShapeService;

public class Main {

    public static void main(String[] args) {
        ShapeService service = new ShapeService();
        service.printShapeData(service.createTriangle());
        service.printShapeData(service.createCircle());
        service.printShapeData(service.createOval());
        service.printShapeData(service.createRectangle());
        service.printShapeData(service.createSquare());

    }
}
