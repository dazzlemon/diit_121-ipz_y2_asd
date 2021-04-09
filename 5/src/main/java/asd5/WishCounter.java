package asd5;

public class WishCounter {
    private static int toyCounter = 0;
    private static int gadgetCounter = 0;
    private static int clothCounter = 0;
    private static int foodCounter = 0;

    public static String statsString() {
        return String.format(
            "Toys: %d\n" +
            "Gadgets: %d\n" +
            "Clothes: %d\n" +
            "Food: %d\n",
            toyCounter,
            gadgetCounter,
            clothCounter,
            foodCounter
        );
    }

    public static void count(WishType w) {
        switch (w) {
        case CLOTH:
            clothCounter++;
            break;
        case FOOD:
            foodCounter++;
            break;
        case GADGET:
            gadgetCounter++;
            break;
        case TOY:
            toyCounter++;
            break;
        }
    }
}