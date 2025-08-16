import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Animal Shelter Menu =====");
            System.out.println("1. Add a dog");
            System.out.println("2. Add a cat");
            System.out.println("3. Adopt any (oldest animal)");
            System.out.println("4. Adopt a dog");
            System.out.println("5. Adopt a cat");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter dog's name: ");
                    String dogName = scanner.nextLine().trim();
                    shelter.enqueue(dogName, "dog");
                }

                case 2 -> {
                    System.out.print("Enter cat's name: ");
                    String catName = scanner.nextLine().trim();
                    shelter.enqueue(catName, "cat");
                }

                case 3 -> shelter.dequeueAny();

                case 4 -> shelter.dequeueType("dog");

                case 5 -> shelter.dequeueType("cat");

                case 6 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}