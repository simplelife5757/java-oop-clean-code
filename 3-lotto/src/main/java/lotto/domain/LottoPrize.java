package lotto.domain;

public enum LottoPrize {
    NOTHING(0, 0, false),
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int winningCount;
    private final int prize;
    private final boolean containBonus;

    LottoPrize(int winningCount, int prize, boolean containBonus) {
        this.winningCount = winningCount;
        this.prize = prize;
        this.containBonus = containBonus;
    }

    public boolean equal(int winningCount, boolean containBonus) {
        return this.winningCount == winningCount && this.containBonus == containBonus;
    }
}
