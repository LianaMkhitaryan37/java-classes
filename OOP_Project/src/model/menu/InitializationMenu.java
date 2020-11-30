package model.menu;

import model.shapes.Shape;
import service.ShapeService;

public class InitializationMenu implements Menu {
    private ShapeService service;
    private Menu previousMenu;
    private Shape createdShape;

    public Shape getCreatedShape() {
        return createdShape;
    }

    public InitializationMenu(ShapeService service) {
        this.service = service;
    }

    @Override
    public void printOptions() {
        System.out.println("Choose one of following options to create " + service.shapeType());
        System.out.println("1: Read From File");
        System.out.println("2: Manual creation");
        System.out.println("3: Go back");
        System.out.println("0: Quit");
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 1: {
                createdShape = service.readFromFile();
                return service.createShapeMenu(createdShape);
            }
            case 2: {
                createdShape = service.createManual();
                return service.createShapeMenu(createdShape);
            }
            case 3: {
                return previousMenu;
            }
            case 0:
                return null;
            default:
                throw new IllegalStateException("Unexpected value: " + n);

        }
    }

    @Override
    public void setPreviousMenu(Menu item) {
        this.previousMenu = item;
    }
}
