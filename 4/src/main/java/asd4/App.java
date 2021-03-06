package asd4;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        var wishList = new LinkedList<Wish>();
        var wg = new WishGenerator();
        for (int i = 0; i < 10; i++) {
            wishList.add(wg.next());
        }
        for (int i = 0; i < 10; i++) {
            WishCounter.count(wishList.remove());
        }
        WishCounter.printStats();
    }
}
