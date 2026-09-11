package arrays_and_methods.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 5 Category C Assignment Problem — Problem 5: Fantasy League Auto-Draft Ranking Engine
 *
 * Problem Statement:
 * An auto-draft feature needs to decide which players are draftable and rank them by
 * fantasy points — but the draft rule isn't one simple cutoff. A player with a long
 * track record qualifies on experience alone, but a newer player still needs to be both
 * reasonably experienced and currently fit to make the cut.
 *
 * Requirements:
 * - Provide two overloaded isDraftable(...) checks: a matches-played-only rule for established
 *   players, and a combined matches-and-fitness rule for everyone else — decide the exact thresholds yourself.
 * - Player must implement Comparable<Player> so that Arrays.sort(...) alone can rank the draftable
 *   array by fantasy points, descending, with no separate comparison logic written elsewhere.
 *
 * Function Signature(s):
 * - public Player(String name, int matchesPlayed, double battingAverage, boolean injured)
 * - static boolean isDraftable(int matchesPlayed)
 * - static boolean isDraftable(int matchesPlayed, boolean injured)
 * - int compareTo(Player other)
 * - static String draftAndRank(Player[] players)
 */
public class FantasyLeagueAutoDraftRankingEngine {

    // Threshold for established players qualifying on experience alone (matches >= 10)
    public static final int EXPERIENCE_THRESHOLD = 10;

    // Minimum matches required for emerging players if uninjured
    public static final int MIN_MATCHES_IF_FIT = 5;

    /**
     * Established player draft qualification rule based solely on match experience.
     * Established veterans qualify regardless of current fitness status.
     *
     * @param matchesPlayed total career matches played
     * @return true if matches played meets or exceeds experience cutoff (>= 10)
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_THRESHOLD;
    }

    /**
     * Overloaded draft qualification rule: an established player qualifies on matches alone,
     * whereas an emerging player must have at least 5 matches and be currently fit (not injured).
     *
     * @param matchesPlayed total matches played
     * @param injured       whether the player is currently injured
     * @return true if the player meets either eligibility criterion
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return isDraftable(matchesPlayed) || (matchesPlayed >= MIN_MATCHES_IF_FIT && !injured);
    }

    /**
     * Filters draftable players using overloaded qualification rules, sorts them descending
     * by batting average (fantasy rating) using standard Arrays.sort(...), and returns the formatted draft list.
     *
     * @param players array of candidate players
     * @return formatted draft ranking string: "1. <name> | 2. <name> | ..."
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();
        for (Player p : players) {
            if (p != null && isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        if (draftableList.isEmpty()) {
            return "";
        }

        Player[] draftable = draftableList.toArray(new Player[0]);
        // Arrays.sort relies directly on Player's compareTo (descending by batting average)
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftable[i].getName());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Fantasy League Auto-Draft Ranking Engine ===");

        // Sample Test Case from PDF
        Player[] players1 = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Running draftAndRank on sample lineup:");
        String result = draftAndRank(players1);
        System.out.println("Output:   " + result);
        System.out.println("Expected: 1. Rahul | 2. Virat | 3. Dev");
    }
}
