package asd4;

import java.util.Random;

public class WishGenerator {
    private Random r = new Random();
    public Wish next() {
        switch (r.nextInt(4)) {
            case 0:
                return Wish.TOY;
            case 1:
                return Wish.GADGET;
            case 2:
                return Wish.CLOTH;
            case 3:
                return Wish.FOOD;
            default:
                return Wish.TOY;// Actually never happens
        }
    }
}
