package string.assigment_problems;

import java.util.Scanner;

/**
 * Week 1 Assignment — Problem 3: The Traffic Signal Streak Analyzer
 *
 * Scenario:
 * The city traffic control department logs the color shown by a signal every minute using
 * single letters — 'R' for red, 'Y' for yellow, 'G' for green. Engineers suspect a malfunctioning
 * signal at one junction might be getting "stuck" on one color for unusually long stretches.
 * They need a tool that scans a day's log and reports the longest continuous streak of the same color,
 * so they know exactly which signal to inspect first.
 *
 * Concepts covered: String traversal, character comparison, loops, tracking a running maximum.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of the same signal color.
     *
     * @param signalLog string representing sequence of signal readings (e.g., "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxColor = currentColor;
                }
                currentColor = ch;
                currentStreak = 1;
            }
        }

        // Check streak of the final run
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxColor = currentColor;
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Traffic Signal Streak Analyzer ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        String log1 = "RRGGGYRR";
        System.out.println("Input: \"" + log1 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        String log2 = "RRRRYYGG";
        System.out.println("Input: \"" + log2 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log2);

        // Optional interactive mode
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter signal log string (e.g. RRGGGYRR): ");
            String customLog = scanner.nextLine();
            System.out.print("Output: ");
            findLongestStreak(customLog);
            scanner.close();
        }
    }
}
