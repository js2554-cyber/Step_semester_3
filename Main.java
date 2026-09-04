import java.util.Scanner;

/**
 * Week 1 Assignment Runner
 * CodInClub powered by BridgeLabz
 *
 * This class runs demonstrations for all 5 problems or allows interactive selection.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("            WEEK 1 ASSIGNMENT - 5 PROBLEMS (CodInClub / BridgeLabz)             ");
        System.out.println("================================================================================\n");

        runAllSampleTests();

        if (args.length > 0 && args[0].equalsIgnoreCase("--menu")) {
            interactiveMenu();
        }
    }

    public static void runAllSampleTests() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1. THE EXAM HALL SEAT DUPLICATION CHECKER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1:");
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105}\nOutput: ");
        ExamHallSeatDuplicationChecker.checkDuplicateSeats(seats1);

        System.out.println("\nTest Case 2:");
        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105}\nOutput: ");
        ExamHallSeatDuplicationChecker.checkDuplicateSeats(seats2);

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("2. THE TYPING SPEED TEST ACCURACY CHECKER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1:");
        System.out.println("original=\"hello world\", typed=\"hello worlt\"");
        System.out.print("Output: ");
        TypingSpeedTestAccuracyChecker.checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest Case 2:");
        System.out.println("original=\"coding\", typed=\"coding\"");
        System.out.print("Output: ");
        TypingSpeedTestAccuracyChecker.checkTypingAccuracy("coding", "coding");

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("3. THE TRAFFIC SIGNAL STREAK ANALYZER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1:");
        System.out.println("Input: \"RRGGGYRR\"");
        System.out.print("Output: ");
        TrafficSignalStreakAnalyzer.findLongestStreak("RRGGGYRR");

        System.out.println("\nTest Case 2:");
        System.out.println("Input: \"RRRRYYGG\"");
        System.out.print("Output: ");
        TrafficSignalStreakAnalyzer.findLongestStreak("RRRRYYGG");

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("4. THE WAREHOUSE INVENTORY BALANCER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1:");
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};
        System.out.println("sectionA={20,15,30}, sectionB={25,10,30}");
        System.out.print("Output: ");
        WarehouseInventoryBalancer.analyzeInventory(secA, secB);

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("5. THE MOVIE REVIEW WORD LENGTH PROFILER");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Test Case 1:");
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review + "\"");
        System.out.print("Output: ");
        MovieReviewWordLengthProfiler.classifyWordLengths(review);

        System.out.println("\n================================================================================");
        System.out.println("All sample test cases executed successfully!");
        System.out.println("================================================================================");
    }

    public static void interactiveMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect a problem to test interactively:");
            System.out.println("1. Exam Hall Seat Duplication Checker");
            System.out.println("2. Typing Speed Test Accuracy Checker");
            System.out.println("3. Traffic Signal Streak Analyzer");
            System.out.println("4. Warehouse Inventory Balancer");
            System.out.println("5. Movie Review Word Length Profiler");
            System.out.println("6. Run all sample tests again");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            if (!scanner.hasNextInt()) break;
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    ExamHallSeatDuplicationChecker.main(new String[]{"--interactive"});
                    break;
                case 2:
                    TypingSpeedTestAccuracyChecker.main(new String[]{"--interactive"});
                    break;
                case 3:
                    TrafficSignalStreakAnalyzer.main(new String[]{"--interactive"});
                    break;
                case 4:
                    WarehouseInventoryBalancer.main(new String[]{"--interactive"});
                    break;
                case 5:
                    MovieReviewWordLengthProfiler.main(new String[]{"--interactive"});
                    break;
                case 6:
                    runAllSampleTests();
                    break;
                case 0:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
