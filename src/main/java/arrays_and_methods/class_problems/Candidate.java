package arrays_and_methods.class_problems;

import java.util.Locale;

/**
 * Week 5 Category C Practice Problem — Problem 5: Placement Drive Shortlisting & Ranking Engine
 *
 * Candidate model class encapsulating candidate profile details: name, cgpa, and coding score.
 * Implements Comparable<Candidate> so that Arrays.sort(...) can rank candidates descending
 * by composite score without any custom comparator or manual sorting logic.
 */
public class Candidate implements Comparable<Candidate> {

    private final String name;
    private final double cgpa;
    private final int codingScore;

    /**
     * Constructs a new Candidate with name, CGPA, and coding score.
     *
     * @param name        the candidate's name
     * @param cgpa        the candidate's CGPA (0.0 - 10.0)
     * @param codingScore the candidate's coding test score (0 - 100)
     */
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    /**
     * Calculates the composite score:
     * compositeScore = (cgpa * 10.0) + (codingScore * 0.5)
     *
     * @return the candidate's composite score
     */
    public double getCompositeScore() {
        return (cgpa * 10.0) + (codingScore * 0.5);
    }

    /**
     * Compares candidates in descending order based on their composite score.
     *
     * @param other the candidate to compare against
     * @return negative integer if this > other, positive if this < other, 0 if equal
     */
    @Override
    public int compareTo(Candidate other) {
        // Descending order of composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s (%.1f)", name, getCompositeScore());
    }

    // Static delegate methods for compatibility when called on Candidate class
    public static boolean isEligible(double cgpa) {
        return PlacementDriveShortlistingEngine.isEligible(cgpa);
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return PlacementDriveShortlistingEngine.isEligible(cgpa, codingScore);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        return PlacementDriveShortlistingEngine.shortlistAndRank(candidates);
    }
}
