package arrays_and_methods.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Week 5 Category C Practice Problem — Problem 5: Placement Drive Shortlisting & Ranking Engine
 *
 * Problem Statement:
 * The placement cell wants one script to do two jobs: decide who's eligible for a company's coding round,
 * and rank everyone who qualifies. Eligibility isn't one simple rule — a strong CGPA alone is enough,
 * but a borderline CGPA can still qualify through a genuinely good coding-test score. Once shortlisted,
 * candidates should be ranked by a composite score, using Java's own sort rather than writing a sort by hand.
 *
 * Requirements:
 * - Provide two overloaded isEligible(...) checks: a CGPA-only quick filter, and a combined
 *   CGPA-and-coding-score filter for borderline cases — decide the exact thresholds yourself.
 * - Candidate must implement Comparable<Candidate> so that Arrays.sort(...) alone can rank a
 *   shortlisted array by composite score, descending, with no separate comparison logic written elsewhere.
 *
 * Function Signature(s):
 * - public Candidate(String name, double cgpa, int codingScore)
 * - static boolean isEligible(double cgpa)
 * - static boolean isEligible(double cgpa, int codingScore)
 * - int compareTo(Candidate other)
 * - static String shortlistAndRank(Candidate[] candidates)
 */
public class PlacementDriveShortlistingEngine {

    // Minimum CGPA required to qualify directly without looking at coding score
    public static final double DIRECT_CGPA_THRESHOLD = 7.0;

    // Minimum borderline CGPA required when backed by a strong coding score
    public static final double BORDERLINE_CGPA_THRESHOLD = 6.5;

    // Minimum coding score required for borderline CGPA candidates
    public static final int BORDERLINE_CODING_THRESHOLD = 60;

    /**
     * CGPA-only quick filter for candidates with strong academic performance.
     *
     * @param cgpa candidate's CGPA
     * @return true if candidate meets direct CGPA cutoff (>= 7.0)
     */
    public static boolean isEligible(double cgpa) {
        return cgpa >= DIRECT_CGPA_THRESHOLD;
    }

    /**
     * Overloaded combined filter: candidates qualify either directly by CGPA or
     * by meeting the borderline CGPA (>= 6.5) along with a strong coding score (>= 60).
     *
     * @param cgpa        candidate's CGPA
     * @param codingScore candidate's coding score
     * @return true if candidate qualifies under either rule
     */
    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= BORDERLINE_CGPA_THRESHOLD && codingScore >= BORDERLINE_CODING_THRESHOLD);
    }

    /**
     * Filters candidates by eligibility, sorts them descending by composite score using
     * standard Arrays.sort(...), and returns a formatted leaderboard string.
     *
     * @param candidates array of candidates
     * @return formatted ranking string
     */
    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> qualified = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c != null && isEligible(c.getCgpa(), c.getCodingScore())) {
                qualified.add(c);
            }
        }

        if (qualified.isEmpty()) {
            return "";
        }

        Candidate[] shortlisted = qualified.toArray(new Candidate[0]);
        // Arrays.sort relies on Candidate's compareTo (descending composite score)
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ")
              .append(shortlisted[i].getName())
              .append(String.format(Locale.US, " (%.1f)", shortlisted[i].getCompositeScore()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Placement Drive Shortlisting & Ranking Engine ===");

        // Sample Test Case from PDF
        Candidate[] batch1 = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Running shortlistAndRank on sample batch:");
        String result = shortlistAndRank(batch1);
        System.out.println("Output:   " + result);
        System.out.println("Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)");
    }
}
