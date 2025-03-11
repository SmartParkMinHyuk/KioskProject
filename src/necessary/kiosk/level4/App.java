package necessary.kiosk.level4;

import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 키오스크 Level 4 구현.
 * 날짜 : 2025/03/10
 * 작성자 : 박민혁
 * 개요 : 코딩스파르타 Spring 과정 3주차 LEVEL 4 과제 ( LEVEL 4/5 )
 * 요구사항이 가지는 의도
 * 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 * 함수에서 관리하던 전체 순서 제어를 `Kiosk` 클래스를 통해 관리합니다.
 * */
public class App {

    public static void main(String[] args) {
        // 버거 데이터
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
        Menu burger = new Menu("Burgers", burgers);

        // 음료 데이터
        List<MenuItem> drinks = new ArrayList<>();
        drinks.add(new MenuItem("Coke",5.0,"suger, water, suger"));
        drinks.add(new MenuItem("Sprite",4.5,"suger, water, suger"));
        drinks.add(new MenuItem("Beer",9.0,"suger, water, meal"));
        drinks.add(new MenuItem("Wine",5.4,"grape, wawter, achol"));
        Menu drink = new Menu("drinks", drinks);

        // 디저트 데이터
        List<MenuItem> Desserts = new ArrayList<>();
        Desserts.add(new MenuItem("Cheese Cake",6.9,"milk, water, 숙성 120일"));
        Desserts.add(new MenuItem("Tomato",8.9,"현지에서 막 따온 토마토"));
        Desserts.add(new MenuItem("Banana",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Desserts.add(new MenuItem("Water",5.4,"경기도 광주 처맛골에서 떠온 미네랄 듬뿍 물"));
        Menu Dessert = new Menu("Desserts", Desserts);

        // kiosksr 객체 생성
        List<Menu> kiosks = new ArrayList<>();
        kiosks.add(burger);
        kiosks.add(drink);
        kiosks.add(Dessert);

        Kiosk kiosk = new Kiosk(kiosks);

        kiosk.start();
    }

}