package pr;

import java.util.ArrayList;
import java.util.List;

public final class App {
    public static void main(String[] args) {
        humanTest();
    }

    private static void humanTest() {
        List<Human> people = new ArrayList<>();
        people.add(new Human("Vasya", "12/12/2000", true, 74));
        people.add(new Human("Petya", "12/12/2000", true, 87));
        people.add(new Human("Vanya", "12/12/2000", true, 74));
        people.add(new Human("Masha", "12/12/2000", false, 55));

        for (var p : people) {
            System.out.println(p);
        }

        System.out.println();
        var it = people.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        var elevator = new Elevator(15);
        for (int i = 0; !elevator.isFull(i); i++) {
            elevator.add(new Human("", "", true, i));
        }
        System.out.println(elevator.getCurrentWeight());
        elevator.remove();
        System.out.println(elevator.getCurrentWeight());
        elevator.add(new Human("", "", true, 1));
        System.out.println(elevator.getCurrentWeight());
        while (!elevator.isEmpty()) {
            elevator.remove();
            System.out.println(elevator.getCurrentWeight());
        }
    }
}
