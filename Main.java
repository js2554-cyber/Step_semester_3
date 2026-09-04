import java.util.Locale;
import java.util.Scanner;

/**
 * Day 1 Live-Coding Session — 5 Problems Runner
 *
 * This runner executes demonstrations of all 5 problems from the Day 1 assignment.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("             DAY 1 LIVE-CODING SESSION — 5 PROBLEMS (BridgeLabz)                ");
        System.out.println("================================================================================\n");

        runAllSampleTests();

        if (args.length > 0 && args[0].equalsIgnoreCase("--menu")) {
            interactiveMenu();
        }
    }

    public static void runAllSampleTests() {
        // Problem 1
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. ROCK-PAPER-SCISSORS GAME");
        System.out.println("--------------------------------------------------------------------------------");
        String[] samplePlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] sampleComputerMoves = {"Scissors", "Paper", "Rock", "Paper", "Rock"};
        RockPaperScissorsGame.runGameSimulation(samplePlayerMoves, sampleComputerMoves);

        // Problem 2
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("2. PALINDROME CHECKER (3 APPROACHES)");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1 (\"madam\"):");
        System.out.println(PalindromeChecker.formatResult("madam"));

        System.out.println("\nTest Case 2 (\"hello\"):");
        System.out.println(PalindromeChecker.formatResult("hello"));

        // Problem 3
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("3. BMI CALCULATOR FOR A TEAM");
        System.out.println("--------------------------------------------------------------------------------");
        double h1 = 1.75, w1 = 70.0;
        double bmi1 = w1 / (h1 * h1);
        System.out.printf(Locale.US, "Person 1 — Height: %.2f m, Weight: %.0f kg -> BMI: %.2f | Status: %s%n",
                h1, w1, bmi1, BmiCalculator.getBmiStatus(bmi1));

        double h2 = 1.60, w2 = 90.0;
        double bmi2 = w2 / (h2 * h2);
        System.out.printf(Locale.US, "Person 2 — Height: %.2f m, Weight: %.0f kg -> BMI: %.2f | Status: %s%n",
                h2, w2, bmi2, BmiCalculator.getBmiStatus(bmi2));

        System.out.println("\nTeam Wellness Report Table:");
        double[] teamHeights = {1.75, 1.60, 1.82, 1.55, 1.68};
        double[] teamWeights = {70.0, 90.0, 75.0, 42.0, 68.0};
        BmiCalculator.printWellnessReport(teamHeights, teamWeights);

        // Problem 4
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("4. FIRST NON-REPEATING CHARACTER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Input: \"swiss\"");
        System.out.print("Output: ");
        FirstNonRepeatingCharacter.displayFirstNonRepeatingChar("swiss");

        System.out.println("\nInput: \"aabbcc\"");
        System.out.print("Output: ");
        FirstNonRepeatingCharacter.displayFirstNonRepeatingChar("aabbcc");

        // Problem 5
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("5. REVERSE CUSTOMER NAME");
        System.out.println("--------------------------------------------------------------------------------");
        String name = "Sunil";
        String rev = ReverseCustomerName.reverseCustomerName(name);
        System.out.println("Input: \"" + name + "\"");
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + rev);

        System.out.println("\n================================================================================");
        System.out.println("All 5 problem tests completed successfully!");
        System.out.println("================================================================================");
    }

    public static void interactiveMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect a problem to run interactively:");
            System.out.println("1. Rock-Paper-Scissors Game");
            System.out.println("2. Palindrome Checker (3 Approaches)");
            System.out.println("3. BMI Calculator for a Team");
            System.out.println("4. First Non-Repeating Character");
            System.out.println("5. Reverse Customer Name");
            System.out.println("6. Run all sample tests");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            if (!scanner.hasNextInt()) break;
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    RockPaperScissorsGame.main(new String[]{"--interactive"});
                    break;
                case 2:
                    PalindromeChecker.main(new String[]{"--interactive"});
                    break;
                case 3:
                    BmiCalculator.main(new String[]{"--interactive"});
                    break;
                case 4:
                    FirstNonRepeatingCharacter.main(new String[]{"--interactive"});
                    break;
                case 5:
                    ReverseCustomerName.main(new String[]{"--interactive"});
                    break;
                case 6:
                    runAllSampleTests();
                    break;
                case 0:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
