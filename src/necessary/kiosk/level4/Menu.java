package necessary.kiosk.level4;

import java.util.List;

public class Menu {

    String menuName;
    List<MenuItem> menuItem;

    public Menu(String menu,List<MenuItem> menuItems) {
        this.menuName = menu;
        this.menuItem = menuItems;
    }
}