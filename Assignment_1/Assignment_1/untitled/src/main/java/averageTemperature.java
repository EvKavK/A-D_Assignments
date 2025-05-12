import java.util.Scanner;
import java.util.Arrays;

public class averageTemperature {
    private Scanner scanner = new Scanner(System.in);
    private double[] temperatures = new double[7];
    private double sum = 0;

    public static void main(String[] args) {
        averageTemperature temp = new averageTemperature();
        temp.getTemperatures();
        temp.calculateAverage();
        temp.displayTemperatures();
    }

    public void getTemperatures() {
        System.out.println("Enter this week's temperatures: ");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }
    }

    public void calculateAverage() {
        double average = sum / temperatures.length;
        System.out.println("The average temperature for this week is: " + average);
    }

    public void displayTemperatures() {
        System.out.println("The temperatures for this week are: " + Arrays.toString(temperatures));
    }
}
