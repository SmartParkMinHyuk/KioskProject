package challenge.kiosk.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);


    // console 색 데이터
    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";


    private final List<Menu> mainMenuList;
    private List<Cart> cartList = new ArrayList<>();

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

                // 프로그램 종료하기
                if (option1 == 0) {
                    System.out.println("프 로 그 램 을 종 료 합 니 다. 이 용 해 주 셔 서 감 사 합 니 다.");
                    return;
                }

                // 장바구니 주문 하기
                if (option1 == mainMenuList.size()+1) {
                    printOrderMenu();
                    int cartOption = inputOption();
                    selectOrderMenu(cartOption);
                    System.out.println(" 주 문 이 완 료 되 었 습 니다");
                    continue;
                }

                // 장바구니 주문 정보 초기화 하기
                if (option1 == mainMenuList.size()+2) {
                    clearCart();
                    System.out.println(" 장 바 구 니 초 기 화 - 메 뉴 로 이 동 합 니 다.");
                    continue;
                }

                // 메뉴아이템 선택 화면으로 가기
                selectMenu(option1);


            }catch (Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            // 서브 메뉴 아이템 화면
            while(true) {

                int option2;
                int option3;
                try {
                    // 서브 메뉴 선택 페이지
                    printMenuItem(option1);
                    option2 = inputOption();

                    if (option2 == 0) {
                        System.out.println("메뉴 선택페이지로 이동합니다.");
                        break;
                    } else {
                        selectMenuItem(option1, option2);
                    }

                    // 장바구니 담을 지 여부 선택 페이지
                    printCartMenu();
                    option3 = inputOption();

                    if (option3 == 2) {
                        System.out.println("장바구니에 담지 않으셨습니다. 메뉴를 처음부터 다시 선택해주세요");
                        break;
                    } else {
                        selectCartMenu(option1, option2, option3);
                        break;
                    }

                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void printMenu() {
        System.out.println(BOLD + "[ NEW BURGERS MENU ]" + RESET);
        int index = 1;
        for (Menu menu : mainMenuList) {
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", menu.getMenuName()) + RESET);
            index++;
        }
        System.out.println(RED + "0."+ RESET +"exit           | exit");
        if (cartList.size () != 0) {
            System.out.println(" ");
            System.out.println(BOLD + "[ ORDER MENU ]" + RESET);
            System.out.println(
                    RED + (index++) + "." + PURPLE + String.format("%-15s", "Orders" +  " | " + RED + "장바구니를 확인 후 주문합니다." + RESET));
            System.out.println(
                    RED + (index) + "." + PURPLE + String.format("%-15s", "Cancel" +  " | " + RED + "진행중인 주문을 취소합니다." + RESET));
        }
    }

    public int inputOption() {
        try {
            System.out.print("원하시는 번호를 입력해주세요 : ");
            return sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
            throw new IllegalArgumentException("잘못된 값입니다. 숫자를 입력하세요. 다시 입력하세요.");
        }
    }

    public void selectMenu(int option1) {

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

        Menu selectedMenu = mainMenuList.get(option1 - 1);
        MenuItem selectedMenuItem = selectedMenu.getMenuItem().get(option2 - 1);

        if (option2 < 0 || option2 > mainMenuList.get(option1 - 1).getMenuItem().size()) {
            throw new IndexOutOfBoundsException("잘못된 아이템 번호입니다. 다시 입력하세요.");
        } else {
            System.out.println(
                    selectedMenuItem.getName() + "아이템를 선택하셨습니다.");
        }
    }

    public void printCartMenu(){
        System.out.println(BOLD + "[ 제품을 장바구니에 담으시겠습니까?  ]" + RESET);
        System.out.println(BOLD + "[ 1.yes / 2.No ]" + RESET);
    }

    public void selectCartMenu(int option1, int option2, int option3){

        Menu selectedMenu = mainMenuList.get(option1 - 1);
        MenuItem selectedMenuItem = selectedMenu.getMenuItem().get(option2 - 1);

        if (option3 > 2) {
            throw new IndexOutOfBoundsException("잘못된 아이템 번호입니다. 다시 입력하세요.");
        } else {

            int index = 0;
            boolean itemExistsInCart = false;

            if (cartList.size () != 0) {
                // 장바구니에 담기 기능 CartList에 몇번째에 저장되어있는지 찾기
                for (Cart carts : cartList) {
                    if (carts.getCartItem().getName().equals(selectedMenuItem.getName())) {
                        cartList.set(index, new Cart(selectedMenuItem, cartList.get(index).getQuantity() + 1));
                        itemExistsInCart = true;
                        for (int i = 0; i < 10; i++) {
                            System.out.println();
                        }
                        System.out.println(BOLD + "[ " + selectedMenuItem.getName() + " ]" + RESET + "의 갯수를 추가 했습니다.");
                        break;
                    }
                    index++;
                }
            }

            // 카트에 신규로 들어오거나 추가된 상품이 없다면 추가 로직
            if (!itemExistsInCart) {
                cartList.add(new Cart(selectedMenuItem, 1)); // 새로운 아이템 추가
                for (int i = 0; i < 10; i++) {
                    System.out.println();
                }
                System.out.println(BOLD + "[ " + selectedMenuItem.getName() + " ]" + RESET + "를 장바구니에 담았습니다.");
            }
        }
    }

    public void printOrderMenu(){

        System.out.println(BOLD + "[ ORDERS ]" + RESET);

        int index = 1;
        double totalPrice = 0.0;

        for(Cart carts : cartList){
            carts.print(index++);
            totalPrice += carts.calculateTotalPrice();
        }
        System.out.println(" ");
        System.out.println("[ TOTAL PRICE ]");
        System.out.println(Math.round(totalPrice * 10.0) / 10.0);
        System.out.println(" ");
        System.out.println(BOLD + "[ 위와 같이 주문 하시겠습니까? ]" + RESET);
        System.out.println(BOLD + "1. 주문" + RESET);
        System.out.println(BOLD + "2. 메뉴판" + RESET);
    }

    public void selectOrderMenu(int cartOption){
        if (cartOption == 1) {
            System.out.println("주문을 실행합니다.");
            // 할인율 명시 후 계산 필요. level 2
        } else if (cartOption == 2) {
            System.out.println("메뉴로 돌아갑니다.");
        } else {
            System.out.println("잘못된 선택입니다. 메뉴판으로 돌아갑니다.");
        }
    }

    public void clearCart(){
        cartList = new ArrayList<>();
    }
}











