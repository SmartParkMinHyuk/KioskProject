package necessary.kiosk.level5;

import java.util.List;

public class Menu {

    // console 색 데이터
    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    private String menuName;
    private List<MenuItem> menuItem;

    public Menu(String menu,List<MenuItem> menuItems) {
        this.menuName = menu;
        this.menuItem = menuItems;
    }

    public String getMenuName() {
        return menuName;
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItem() {
        return menuItem;
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void printMenuItem(List<MenuItem> menuItem) {
        int index = 1;
        for (MenuItem item : menuItem) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", item.getName()) + RESET +
                            " | " + RED + "W " + String.format("%.1f", item.getPrice()) + RESET +
                            " | " + item.getExplain());
            index++;
        }
        System.out.println(RED + "0."+ RESET +"back           | back");
    }
}