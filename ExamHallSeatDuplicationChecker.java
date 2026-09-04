import java.util.Scanner;

/**
 * Week 1 - Problem 1: The Exam Hall Seat Duplication Checker
 *
 * Scenario:
 * The Examination Cell manages seat allocation across a large exam hall for hundreds of students.
 * Before an exam begins, invigilators must confirm that no seat number has been assigned to two
 * different students by mistake. The system needs to scan the full list of assigned seat numbers
 * and flag any duplicates before the exam starts.
 *
 * Concepts covered: Arrays, nested loops, conditional logic, basic output formatting.
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers in the provided array.
     * Uses nested loops and arrays only (no Collections class).
     *
     * @param seatNumbers array of integer seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Check if seatNumbers[i] has already been seen earlier in the array.
            // If already seen, skip it to avoid printing the same duplicate multiple times.
            boolean alreadySeen = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadySeen = true;
                    break;
                }
            }
            if (alreadySeen) {
                continue;
            }

            // Compare seatNumbers[i] against subsequent elements
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Exam Hall Seat Duplication Checker ===");

        // Sample Test Case 1 from PDF
        System.out.println("\nSample Test Case 1:");
        int[] test1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105}\nOutput: ");
        checkDuplicateSeats(test1);

        // Sample Test Case 2 from PDF
        System.out.println("\nSample Test Case 2:");
        int[] test2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105}\nOutput: ");
        checkDuplicateSeats(test2);

        // Optional interactive mode if user runs with interactive arguments
        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter number of seats: ");
            int n = scanner.nextInt();
            int[] customSeats = new int[n];
            System.out.println("Enter " + n + " seat numbers:");
            for (int i = 0; i < n; i++) {
                customSeats[i] = scanner.nextInt();
            }
            System.out.println("\nOutput:");
            checkDuplicateSeats(customSeats);
            scanner.close();
        }
    }
}
