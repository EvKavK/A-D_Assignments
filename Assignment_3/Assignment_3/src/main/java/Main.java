import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList myList = new SingleLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1 - Add Number");
            System.out.println("2 - Delete Number by Position");
            System.out.println("3 - Print List");
            System.out.println("4 - Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to add: ");
                    int value = scanner.nextInt();
                    myList.add(value);
                    break;
                case 2:
                    System.out.print("Enter the position to delete: ");
                    int pos = scanner.nextInt();
                    myList.delete(pos);
                    break;
                case 3:
                    myList.printList();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}