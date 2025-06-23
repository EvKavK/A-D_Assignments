import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        System.out.println("Undo/Redo Console App (ArrayList Version)");
        System.out.println("Commands: add <text>, undo, redo, current, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;

            } else if (input.equalsIgnoreCase("undo")) {
                if (manager.undo()) {
                    System.out.println("Undo successful.");
                } else {
                    System.out.println("Nothing to undo.");
                }

            } else if (input.equalsIgnoreCase("redo")) {
                if (manager.redo()) {
                    System.out.println("Redo successful.");
                } else {
                    System.out.println("Nothing to redo.");
                }

            } else if (input.equalsIgnoreCase("current")) {
                String state = manager.getCurrentState();
                System.out.println("Current State: " + (state != null ? state : "None"));

            } else if (input.startsWith("add ")) {
                String state = input.substring(4).trim();
                if (!state.isEmpty()) {
                    manager.addState(state);
                    System.out.println("Added state: " + state);
                } else {
                    System.out.println("No state provided.");
                }

            } else {
                System.out.println("Unknown command. Try: add, undo, redo, current, exit");
            }
        }

        scanner.close();
    }
}