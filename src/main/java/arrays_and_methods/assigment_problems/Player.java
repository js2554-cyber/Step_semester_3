package arrays_and_methods.assigment_problems;

import java.util.Locale;

/**
 * Week 5 Category C Assignment Problem — Problem 5: Fantasy League Auto-Draft Ranking Engine
 *
 * Player model class encapsulating draft candidate profile details: name, matches played,
 * batting average, and injury status.
 * Implements Comparable<Player> so that Arrays.sort(...) alone ranks draftable players
 * descending by fantasy points (batting average) without custom comparators.
 */
public class Player implements Comparable<Player> {

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    /**
     * Constructs a new Player profile.
     *
     * @param name           player's name
     * @param matchesPlayed  total career matches played
     * @param battingAverage current batting average / fantasy points baseline
     * @param injured        current injury status flag (true if injured)
     */
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    /**
     * Ranks players in descending order of their batting average (fantasy points).
     *
     * @param other player to compare against
     * @return negative if this > other, positive if this < other, 0 if equal
     */
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s (%.1f avg, %d matches, injured=%b)",
                name, battingAverage, matchesPlayed, injured);
    }

    // Static delegate methods for compatibility when called on Player class
    public static boolean isDraftable(int matchesPlayed) {
        return FantasyLeagueAutoDraftRankingEngine.isDraftable(matchesPlayed);
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return FantasyLeagueAutoDraftRankingEngine.isDraftable(matchesPlayed, injured);
    }

    public static String draftAndRank(Player[] players) {
        return FantasyLeagueAutoDraftRankingEngine.draftAndRank(players);
    }
}
