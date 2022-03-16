package blackjack.domain;

public class FinalResult {
    private final String name;
    private final int winningCount;
    private final int losingCount;

    public FinalResult(String name, int winningCount, int losingCount) {
        this.name = name;
        this.winningCount = winningCount;
        this.losingCount = losingCount;
    }

    public String getName() {
        return name;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getLosingCount() {
        return losingCount;
    }

    @Override
    public String toString() {
        String record;
        if (losingCount == 0) {
            record = "승";
        }
        if (winningCount == 0) {
            record = "패";
        }
        record = String.format("%s승 %s패", winningCount, losingCount);

        return String.format("%s: %s", name, record);
    }
}
