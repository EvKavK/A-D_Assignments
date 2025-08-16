import java.util.ArrayList;

public class SingleLinkedList {
    private ArrayList<Integer> list;

    public SingleLinkedList() {
        list = new ArrayList<>();
    }

    public void add(int data) {
        list.add(data);
    }

    public void delete(int position) {
        if (position < 0 || position >= list.size()) {
            System.out.println("Invalid position: " + position);
            return;
        }
        list.remove(position);
        System.out.println("Deleted number at position " + position);
    }

    public void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Current list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}