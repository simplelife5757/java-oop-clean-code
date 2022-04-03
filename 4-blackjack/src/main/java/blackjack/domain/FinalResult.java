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

    private String getRecord() {
        if (losingCount == 0 && winningCount == 1) {
            return "승";
        }
        if (winningCount == 0 && losingCount == 1) {
            return "패";
        }
        return String.format("%s승 %s패", winningCount, losingCount);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, getRecord());
    }
}
