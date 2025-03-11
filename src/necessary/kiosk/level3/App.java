package necessary.kiosk.level3;

import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 키오스크 Level 3 구현.
 * 날짜 : 2025/03/10
 * 작성자 : 박민혁
 * 개요 : 코딩스파르타 Spring 과정 3주차 LEVEL 3 과제 ( LEVEL 3/5 )
 * 요구사항이 가지는 의도
 * 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 * 함수에서 관리하던 전체 순서 제어를 `Kiosk` 클래스를 통해 관리합니다.
 * */
public class App {

    public static void main(String[] args) {

        List<MenuItem> items = new ArrayList<MenuItem>();

        // 키오스크 메뉴화면
        items.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        // 키오스크 객체 인스턴스화
        // `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 넘겨줍니다.
        Kiosk ki = new Kiosk(items);

        // 키오스크 실행
        ki.start();

    }

}
