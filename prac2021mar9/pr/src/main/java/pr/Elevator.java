package pr;

import java.util.Stack;

public class Elevator {
    private final int maxWeight;
    private int currentWeight;
    Stack<Human> passengers;

    public Elevator(int maxWeight) {
        passengers = new Stack<>();
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void add(Human passenger) {
        passengers.push(passenger);
        currentWeight += passenger.getWeightKg();
    }

    public boolean isFull(int weight) {
        return maxWeight < currentWeight + weight;
    }

    public boolean isEmpty() {
        return passengers.isEmpty();
    }

    public void remove() {
        currentWeight -= passengers.pop().getWeightKg();
    }
}
