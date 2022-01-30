package lotto.domain;

import java.util.Comparator;

public enum LottoPrize {
    NOTHING(0, 0, false),
    SEVENTH(1, 0, false),
    SIXTH(2, 0, false),
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

    public boolean hasEqualPrize(int winningCount, boolean containBonus) {
        return this.winningCount == winningCount && this.containBonus == containBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public static Comparator<LottoPrize> comparator = new Comparator<LottoPrize>() {
        public int compare(LottoPrize first, LottoPrize second) {
            if (first.containBonus) {
                return -1;
            }
            if (second.containBonus) {
                return 1;
            }
            return first.getWinningCount() - second.getWinningCount();
        }
    };

}
