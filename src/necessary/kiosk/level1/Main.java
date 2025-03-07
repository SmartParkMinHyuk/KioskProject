package necessary.kiosk.level1;

import java.util.Scanner;

/**
 *  제목 : 키오스크 Level 1 구현.
 *  날짜 : 2025/03/074
 *  작성자 : 박민혁
 *  개요 : 코딩스파르타 Spring 과정 3주차 LEVEL 1 과제 ( LEVEL 1/5 )
 *
 *  - 요구사항이 가지는 의도
 *      입력 처리와 간단한 흐름 제어를 복습합니다. (프로그래밍 검증)
 *      Scanner 활용법, 조건문, 반복문을 재확인하며 입력 데이터를 처리하는 방법 강화
 */
public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        /**
         * Scanner
         */
        Scanner sc = new Scanner(System.in);

        /**
         * 반복문 while
         */
        while(true) {

            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println(RED + "1."+ PURPLE + " ShackBurger"+ RESET + "   | "+ RED + "W 6.9"+ RESET +" | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println(RED + "2."+ PURPLE + " SmokeShack"+ RESET + "    | "+ RED + "W 8.9"+ RESET +" | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println(RED + "3."+ PURPLE + " Cheeseburger"+ RESET + "  | "+ RED + "W 6.9"+ RESET +" | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println(RED + "4."+ PURPLE + " Hamburger"+ RESET + "     | "+ RED + "W 5.4"+ RESET +" | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println(RED + "0."+ RESET +" exit          | exit");
            System.out.print("원하시는 번호를 입력해주세요 : ");
            int option = sc.nextInt();

            /**
             * 조건문 switch
             */
            switch (option) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
