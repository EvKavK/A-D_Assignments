import java.util.Scanner;

public class MovieTheater {

    static char[][] seats = new char[5][5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSeats();

        while (true) {
            System.out.println("\nMovie Theater Seat Reservation System");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Show seating chart");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat(scanner);
                    break;
                case 2:
                    cancelSeat(scanner);
                    break;
                case 3:
                    printSeatingChart();
                    break;
                case 4:
                    System.out.println("Thank you for using the reservation system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1-4.");
            }
        }
    }

    public static void initializeSeats() {
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                seats[row][col] = 'O';
            }
        }
    }

    public static void printSeatingChart() {
        System.out.println("\nSeating Chart (O = Open, X = Taken):");
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                System.out.print(seats[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void reserveSeat(Scanner scanner) {
        System.out.print("Enter row (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0-4): ");
        int col = scanner.nextInt();

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'O') {
                seats[row][col] = 'X';
                System.out.println("Seat reserved successfully!");
            } else {
                System.out.println("Seat already taken. Suggesting next available seat...");
                suggestNextAvailableSeat();
            }
        } else {
            System.out.println("Invalid seat selection. Please try again.");
        }
    }

    public static void cancelSeat(Scanner scanner) {
        System.out.print("Enter row to cancel (0-4): ");
        int row = scanner.nextInt();
        System.out.print("Enter column to cancel (0-4): ");
        int col = scanner.nextInt();

        if (isValidSeat(row, col)) {
            if (seats[row][col] == 'X') {
                seats[row][col] = 'O';
                System.out.println("Reservation cancelled.");
            } else {
                System.out.println("Seat is already available.");
            }
        } else {
            System.out.println("Invalid seat. Please try again.");
        }
    }

    public static boolean isValidSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }

    public static void suggestNextAvailableSeat() {
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col] == 'O') {
                    System.out.println("Next available seat: Row " + row + " Column " + col);
                    return;
                }
            }
        }
        System.out.println("Sorry, no seats available.");
    }
}