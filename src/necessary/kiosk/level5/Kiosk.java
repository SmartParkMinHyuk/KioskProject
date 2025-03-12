package necessary.kiosk.level5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // console 색 데이터
    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    private final List<Menu> mainMenuList;

    public Kiosk(List<Menu> mainMenuList) {
        this.mainMenuList = mainMenuList;
    }

    // 키오스크 순서를 제어
    public void start() {

        // 메인 메뉴 화면
        while(true) {

            int option1;

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
            // 서브 메뉴 아이템 화면
            while(true) {

                int option2;

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
        System.out.println(BOLD + "[ GIMBABSARANG MENU ]" + RESET);
        int index = 1;
        for (Menu menu : mainMenuList) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", menu.getMenuName()) + RESET);
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

    public void selectMenu(int option1) {

        // 기존코드
        // menu.get(option1 - 1).getMenuName()

        // 변경코드
        // Menu selectedMenu = menu.get(option1 - 1);
        // selectedMenu.getMenuName()

        Menu selectedMenu = mainMenuList.get(option1 - 1);

        if (option1 < 0 || option1 > mainMenuList.size()) {
            throw new IndexOutOfBoundsException("잘못된 메뉴 번호입니다. 다시 입력하세요.");
        } else {
            System.out.println(
                    selectedMenu.getMenuName() + "메뉴를 선택하셨습니다.");
        }
    }

    public void printMenuItem(int option1) {
        Menu selectedMenu = mainMenuList.get(option1 - 1);
        System.out.println(BOLD + "[ "+ selectedMenu.getMenuName()+" ]" + RESET);
        selectedMenu.printMenuItem(selectedMenu.getMenuItem());
    }

    public void selectMenuItem(int option1, int option2) {

        // 기존코드
        // menu.get(option1 - 1).getMenuItem().get(option2 - 1).getName()

        // 변경코드
        // Menu selectedMenu = menu.get(option1 - 1); kiosk 객체  -> Menu 객체
        // MenuItem selectedMenuItem = selectedMenu.getMenuItem().get(option2 - 1); Menu 객체 -> Menuitem 객체
        // selectedMenuItem.getName();

        Menu selectedMenu = mainMenuList.get(option1 - 1);
        MenuItem selectedMenuItem = selectedMenu.getMenuItem().get(option2 - 1);

        if (option2 < 0 || option2 > mainMenuList.get(option1 - 1).getMenuItem().size()) {
            throw new IndexOutOfBoundsException("잘못된 아이템 번호입니다. 다시 입력하세요.");
        } else {
            System.out.println(
                    selectedMenuItem.getName() + "아이템를 선택하셨습니다.");
        }
    }
}











