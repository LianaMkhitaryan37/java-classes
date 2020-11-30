package main;

import model.menu.HomeMenu;
import model.menu.InitializationMenu;
import model.menu.Menu;
import model.menu.ShapeMenu;
import model.shapes.Shape;

import java.util.Scanner;

public class MenuCreator {
    static final Scanner scanner = new Scanner(System.in);
    public static void start(){
        System.out.println("Welcome");
        Menu activePage = new HomeMenu();
        while (activePage!=null){
            activePage.printOptions();
            int q = scanner.nextInt();
            activePage = activePage.processRequest(q);
        }
    }
    public static Shape createShapePage(){
        Menu activePage = new HomeMenu();
        activePage.printOptions();
        int q = scanner.nextInt();
        try {
            InitializationMenu menu = (InitializationMenu) activePage.processRequest(q);
            menu.printOptions();
            q = scanner.nextInt();
            menu.processRequest(q);
            return menu.getCreatedShape();
        } catch (NullPointerException e){
            System.out.println("Bye");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
