package asd4;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        WishGenerator wg = new WishGenerator();
        Queue<Wish> wishList = new LinkedList<>();
        //var wishList = new LinkedList<Wish>();
        //var wg = new WishGenerator();
        for (int i = 0; i < 10; i++) {
            wishList.add(wg.next());
        }
        for (int i = 0; i < 10; i++) {
            WishCounter.count(wishList.remove());
        }
        WishCounter.printStats();
    }
}
