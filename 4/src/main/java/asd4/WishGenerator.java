package asd4;

import java.util.Random;

public class WishGenerator {
    private Random r = new Random();
    public WishType next() {
        switch (r.nextInt(4)) {
            case 0:
                return WishType.TOY;
            case 1:
                return WishType.GADGET;
            case 2:
                return WishType.CLOTH;
            case 3:
                return WishType.FOOD;
            default:
                return WishType.TOY;// Actually never happens
        }
    }
}
