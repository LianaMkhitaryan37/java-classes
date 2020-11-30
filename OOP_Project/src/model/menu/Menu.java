package model.menu;

public interface Menu {
    void printOptions();

    Menu processRequest(int n);

    void setPreviousMenu(Menu item);
}
