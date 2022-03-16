package blackjack.domain;

public class Record {
    private int winningCount = 0;
    private int losingCount = 0;

    public Record() {}

    public void addWinningCount() {
        this.winningCount++;
    }

    public void addLosingCount() {
        this.losingCount++;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getLosingCount() {
        return losingCount;
    }
}
