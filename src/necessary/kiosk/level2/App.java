package necessary.kiosk.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 제목 : 키오스크 Level 2 구현.
 * 날짜 : 2025/03/07
 * 작성자 : 박민혁
 * 개요 : 코딩스파르타 Spring 과정 3주차 LEVEL 2 과제 ( LEVEL 2/5 )
 *  - 요구사항이 가지는 의도
 *      객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 *      햄버거 메뉴를 MenuItem 클래스와 List를 통해 관리합니다.
 * */
public class App {

    // console 메뉴판 글자 색
    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    // console 메뉴판 구현
    public static void printMessage(List<MenuItem> items) {
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

    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> items = new ArrayList<MenuItem>();

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        items.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 메뉴판 호출
        printMessage(items);

        while(true) {
            // 숫자를 입력 받기
            System.out.print("원하시는 번호를 입력해주세요 : ");
            int option = sc.nextInt();

            // 입력된 숫자에 따른 처리
            switch (option) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    for (int i = 0; i < 10; i++) {
                        System.out.println();
                    }
                    // 메뉴판 호출
                    printMessage(items);
                        System.out.println();

                    if (option > 0 && option <= items.size()) {
                        MenuItem selectedItem = items.get(option - 1);
                        System.out.print(BOLD + "선택한 메뉴 : " + PURPLE + selectedItem.name + RESET);
                        System.out.print(BOLD + " 가격 : " + RED + "W " +  selectedItem.price + RESET);
                        System.out.println(BOLD + " 설명 : " + RESET + selectedItem.explain);
                    } else {
                        System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
                    }
                    System.out.println();
            }
        }
    }
}
