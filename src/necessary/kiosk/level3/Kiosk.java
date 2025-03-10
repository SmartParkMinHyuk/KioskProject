package necessary.kiosk.level3;

import java.util.List;
import java.util.Scanner;

/**
 * Kiosk 클래스 생성하기
 * 설명 : 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.
 * `MenuItem`을 관리하는 리스트가 필드로 존재합니다.
 * `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리합니다.
 * `List<MenuItem> menuItems` 는 `Kiosk` 클래스 생성자를 통해 값을 할당합니다.
 * `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 넘겨줍니다.
 */
public class Kiosk {

    List<MenuItem> items;

    public Kiosk(List<MenuItem> menuItems) {
        this.items = menuItems;
    }

    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    public void start(){

        System.out.println("프로그램 시작.");
        // 메뉴 호출
        printItemsMenu(items);

        selectMenuItem();

    }

    public void printItemsMenu(List<MenuItem> items){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println(BOLD + "[ SHAKESHACK MENU ]" + RESET);
        int index = 1;
        for (MenuItem item : items) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", item.name) + RESET +
                            " | " + RED + "W " + String.format("%.1f", item.price) + RESET +
                            " | " + item.explain);
            index++;
        }
        System.out.println(RED + "0."+ RESET +" exit           | exit");

    }

    public int inputOption(Scanner sc){
        System.out.print("원하시는 번호를 입력해주세요 : ");
        return sc.nextInt();
    }

    public void selectMenuItem() {

        Scanner sc = new Scanner(System.in);

        while(true) {

            int option = -1;

            try {
                option = inputOption(sc);
            } catch (Exception e) {
                // 메뉴판 호출
                printItemsMenu(items);

                //유효하지 않은 입력에 대해 오류 메시지를 출력합니다.
                System.out.println();
                System.out.println("WANNING WANNING WANNING : 잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
                System.out.println();
                sc.nextLine(); //  버퍼에 남아있는 잘못된 입력을 처리하기 위해
                continue; // 반복문 다시 시작
            }

            switch (option) {
                //`0`을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’됩니다.
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    // 메뉴판 호출
                    printItemsMenu(items);
                    System.out.println();

                    if (option > 0 && option <= items.size()) {
                        MenuItem selectedItem = items.get(option - 1);
                        System.out.print(BOLD + "선택한 메뉴 : " + PURPLE + selectedItem.name + RESET);
                        System.out.print(BOLD + " 가격 : " + RED + "W " + selectedItem.price + RESET);
                        System.out.println(BOLD + " 설명 : " + RESET + selectedItem.explain);
                    } else {
                        //유효하지 않은 입력에 대해 오류 메시지를 출력합니다.
                        System.out.println("WANNING WANNING WANNING : 잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
                    }
                    System.out.println();
            }
        }
    }
}











