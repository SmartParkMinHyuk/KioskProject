package necessary.kiosk.level4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> Menu;

    public Kiosk(List<Menu> Menu) {
        this.Menu = Menu;
    }

    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    public void start() {
        while(true) {

            int option1;
            int option2;

            try {
                printMenu();

                option1 = inputOption();

                if (option1 == 0) {
                    return;
                } else {
                    selectMenu(option1);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            while(true) {
                try {
                    printMenuItem(option1);

                    option2 = inputOption();

                    if (option2 == 0) {
                        break;

                    } else {
                        selectMenuItem(option1, option2);
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void printMenu() {
        int index = 1;
        for (Menu menu : Menu) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", menu.menuName) + RESET);
            index++;
        }
        System.out.println(RED + "0."+ RESET +"exit           | exit");
    }

    public int inputOption() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("원하시는 번호를 입력해주세요 : ");
            return sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
            throw new IllegalArgumentException("잘못된 값입니다. 숫자를 입력하세요. 다시 입력하세요.");
        }
    }

    public void selectMenu(int option1) throws Exception {
        if (option1 < 0 || option1 > Menu.size()) {
            throw new IndexOutOfBoundsException("잘못된 메뉴 번호입니다. 다시 입력하세요.");
        } else {
            System.out.println(
                    Menu.get(option1 - 1).menuName + "메뉴를 선택하셨습니다.");
        }
    }

    public void printMenuItem(int option1) {
        int index = 1;
        for (MenuItem item : Menu.get(option1 - 1).menuItem) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", item.name) + RESET +
                            " | " + RED + "W " + String.format("%.1f", item.price) + RESET +
                            " | " + item.explain);
            index++;
        }
        System.out.println(RED + "0."+ RESET +"back           | back");
    }

    public void selectMenuItem(int option1, int option2) {
        if (option2 < 0 || option2 > Menu.get(option1 - 1).menuItem.size()) {
            throw new IndexOutOfBoundsException("잘못된 아이템 번호입니다. 다시 입력하세요.");
        } else {
            System.out.println(
                    Menu.get(option1 - 1).menuItem.get(option2 - 1).name + "아이템를 선택하셨습니다.");
        }
    }
}











