import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — Problem 3: BMI Calculator for a Team
 *
 * Scenario:
 * The Corporate Wellness Program
 * An organization's HR wellness team is running a health check-up camp for a department
 * of employees. For each employee, height (in meters) and weight (in kg) are recorded,
 * and the system must calculate BMI and classify their health status, then present all
 * details in a clean table for the wellness report.
 *
 * Concepts covered: Parallel/2D arrays, arithmetic operations, conditional logic,
 * formatted tabular output.
 */
public class BmiCalculator {

    /**
     * Classifies the health status based on BMI value.
     * BMI < 18.5       -> Underweight
     * 18.5 - 24.9      -> Normal
     * 25 - 29.9        -> Overweight
     * >= 30            -> Obese
     *
     * @param bmi calculated Body Mass Index
     * @return status string
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI for each person and prints a formatted tabular wellness report.
     *
     * @param heights array of heights in meters
     * @param weights array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length == 0 || weights.length == 0) {
            System.out.println("No wellness data available.");
            return;
        }

        int n = Math.min(heights.length, weights.length);

        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-14s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = (h <= 0) ? 0.0 : (w / (h * h));
            String status = getBmiStatus(bmi);

            System.out.printf(Locale.US, "Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-14s%n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: BMI Calculator for a Team ===");

        // Sample Cases from PDF
        System.out.println("\nSample Cases from PDF:");
        double h1 = 1.75, w1 = 70.0;
        double bmi1 = w1 / (h1 * h1);
        System.out.printf(Locale.US, "Person 1 — Height: %.2f m, Weight: %.0f kg -> BMI: %.2f | Status: %s%n",
                h1, w1, bmi1, getBmiStatus(bmi1));

        double h2 = 1.60, w2 = 90.0;
        double bmi2 = w2 / (h2 * h2);
        System.out.printf(Locale.US, "Person 2 — Height: %.2f m, Weight: %.0f kg -> BMI: %.2f | Status: %s%n",
                h2, w2, bmi2, getBmiStatus(bmi2));

        // Suggested: 10 people for a live demo using arrays
        System.out.println("\n--- Department Wellness Report (10 Members) ---");
        double[] teamHeights = {1.75, 1.60, 1.82, 1.55, 1.68, 1.72, 1.90, 1.50, 1.65, 1.78};
        double[] teamWeights = {70.0, 90.0, 75.0, 42.0, 68.0, 85.0, 95.0, 52.0, 61.0, 82.0};
        printWellnessReport(teamHeights, teamWeights);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of people in the team: ");
            int count = scanner.nextInt();
            double[] customHeights = new double[count];
            double[] customWeights = new double[count];

            for (int i = 0; i < count; i++) {
                System.out.printf("Person %d - Height (m): ", (i + 1));
                customHeights[i] = scanner.nextDouble();
                System.out.printf("Person %d - Weight (kg): ", (i + 1));
                customWeights[i] = scanner.nextDouble();
            }

            System.out.println("\n--- Custom Team Wellness Report ---");
            printWellnessReport(customHeights, customWeights);
            scanner.close();
        }
    }
}
