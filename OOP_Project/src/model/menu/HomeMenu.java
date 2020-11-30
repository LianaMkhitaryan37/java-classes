package model.menu;

import service.*;

public class HomeMenu implements Menu {
    private Menu previous;

    @Override
    public void printOptions() {
        System.out.println("For Starting create one of corresponding shapes");
        System.out.println("1: Rectangle");
        System.out.println("2: Square");
        System.out.println("3: Oval");
        System.out.println("4: Circle");
        System.out.println("5: Triangle");
        System.out.println("0: Quit");
    }

    @Override
    public Menu processRequest(int n) {
        Menu menu;
        switch (n) {
            case 1:
                menu = new InitializationMenu(new RectangleService());
                break;
            case 2:
                menu = new InitializationMenu(new SquareService());
                break;
            case 3:
                menu = new InitializationMenu(new OvalService());
                break;
            case 4:
                menu = new InitializationMenu(new CircleService());
                break;
            case 5:
                menu = new InitializationMenu(new TriangleService());
                break;
            case 0:
                return null;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
        menu.setPreviousMenu(this);
        return menu;
    }
    @Override
    public void setPreviousMenu(Menu item) {
        this.previous = item;
    }
}
