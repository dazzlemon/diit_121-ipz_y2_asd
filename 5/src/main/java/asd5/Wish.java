package asd5;

public class Wish {
    private WishType wishType;
    private String receiver;// name
    private boolean received;

    public Wish(WishType wishType, String receiver) {
        this.wishType = wishType;
        this.receiver = receiver;
        this.received = true;
    }

    public WishType getWishType() {
        return wishType;
    }

    public String getReceiver() {
        return receiver;
    }

    public boolean isReceived() {
        return received;
    }

    public void receive() {
        received = true;
    }

    public String toString() {
        return String.format(
            "Wish: { WishType: %s, receiver: %s, received: %s }",
            wishType, receiver, received
        );
    }
}
