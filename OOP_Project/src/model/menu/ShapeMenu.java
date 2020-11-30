package model.menu;

import main.MenuCreator;
import model.shapes.Shape;
import service.ShapeService;

import java.lang.reflect.Method;

public abstract class ShapeMenu implements Menu {
    private Menu previousMenu;
    private Shape shape;
    protected int length = 4;

    public ShapeMenu(Shape shape) {
        this.shape = shape;
    }

    public abstract int createSpecializedMenu();

    @Override
    public void setPreviousMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    @Override
    public void printOptions() {
        length=4;
        System.out.println(shape.getClass().getSimpleName());
        System.out.println("1: Print Area");
        System.out.println("2: Print Perimeter");
        System.out.println("3: Draw");
        System.out.println("4: Check if intersected with other Shape");
        final int actionMenuLength = createSpecializedMenu() + length;
        System.out.printf("%d: Go Back to previous menu\n", actionMenuLength + 1);
        System.out.println("0: Quit");
        length = actionMenuLength+1;
    }

    @Override
    public Menu processRequest(int n) {
        if (n == 1) {
            System.out.println(shape.area());
        } else if (n == 2) {
            System.out.println(shape.perimeter());
        } else if (n == 3) {
            shape.draw();
        } else if (n == 4) {
            Shape shape2 = MenuCreator.createShapePage();
            System.out.println((ShapeService.intersects(shape, shape2)) ? "Created Shapes intersect" : "Created Shapes don't intersect");
        } else if (n == length) {
            return previousMenu;
        } else if (n == 0) {
            return null;
        } else {
            throw new IllegalStateException("Unexpected value: " + n);
        }
        return this;
    }

}
