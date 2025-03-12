package necessary.kiosk.level5;

import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 키오스크 Level 5 구현.
 * 날짜 : 2025/03/11
 * 작성자 : 박민혁
 * 개요 : 코딩스파르타 Spring 과정 3주차 LEVEL 5 과제 ( LEVEL 5/5 )
 * 요구사항이 가지는 의도
 * 'MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
 * Getter와 Setter 메서드를 사용해 데이터를 관리합니다.
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
        Menu drink = new Menu("Drinks", drinks);

        // 디저트 데이터
        List<MenuItem> Desserts = new ArrayList<>();
        Desserts.add(new MenuItem("Cheese Cake",6.9,"milk, water, 숙성 120일"));
        Desserts.add(new MenuItem("Tomato",8.9,"현지에서 막 따온 토마토"));
        Desserts.add(new MenuItem("Banana",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        Desserts.add(new MenuItem("Water",5.4,"경기도 광주 처맛골에서 떠온 미네랄 듬뿍 물"));
        Menu Dessert = new Menu("Desserts", Desserts);

        // kiosk 객체 생성
        List<Menu> kiosks = new ArrayList<>();
        kiosks.add(burger);
        kiosks.add(drink);
        kiosks.add(Dessert);

        Kiosk kiosk = new Kiosk(kiosks);

        kiosk.start();
    }
}