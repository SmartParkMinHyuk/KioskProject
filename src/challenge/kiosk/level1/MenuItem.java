package challenge.kiosk.level1;

/**
 * MenuItem 클래스 생성하기
 * 설명 : 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.
 * 클래스는 이름, 가격, 설명 필드를 갖습니다.
 * */
public class MenuItem {

    private String name;
    private double price;
    private String explain;

    public MenuItem(String name, double price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExplain() {
        return explain;
    }

}