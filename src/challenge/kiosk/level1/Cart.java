package challenge.kiosk.level1;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static final String BOLD = "\u001B[1m"; // 굵게
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    private MenuItem cartItem;
    private int quantity;

    public Cart(MenuItem cartItem, int quantity) {
        this.cartItem = cartItem;
        this.quantity = quantity;
    }

    public MenuItem getCartItem() {
        return cartItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void print(int index) {
        System.out.println(
                RED + (index) + "." + PURPLE + String.format("%-15s", getCartItem().getName()) + RESET +
                        " | " + RED + "W " + String.format("%.1f", getCartItem().getPrice()) + RESET +
                        " | " + getCartItem().getExplain()+ " | " + " 갯수 : " + getQuantity());
    }
    public double calculateTotalPrice() {
        return getCartItem().getPrice() * getQuantity();
    }
}

