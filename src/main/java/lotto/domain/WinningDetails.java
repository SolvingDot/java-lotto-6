package lotto.domain;

public enum WinningDetails {
    FIRST_PLACE(1, 6, 2_000_000_000),
    SECOND_PLACE(2, 5, 30_000_000),
    THIRD_PLACE(3, 5, 1_500_000),
    FOURTH_PLACE(4, 4, 50_000),
    FIFTH_PLACE(5, 3, 5_000);

    private final int rank;
    private final int numberOfMatches;
    private final long winningAmount;

    WinningDetails(int rank, int numberOfMatches, long winningAmount) {
        this.rank = rank;
        this.numberOfMatches = numberOfMatches;
        this.winningAmount = winningAmount;
    }

    public int getRank() {
        return rank;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
