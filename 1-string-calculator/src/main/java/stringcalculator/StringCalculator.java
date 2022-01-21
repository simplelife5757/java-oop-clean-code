package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    private final SplitStrategy<String> splitStrategy;
    private final ParseStrategy<String, Integer> parseStrategy;

    public StringCalculator(SplitStrategy<String> splitStrategy, ParseStrategy<String, Integer> parseStrategy) {
        this.splitStrategy = splitStrategy;
        this.parseStrategy = parseStrategy;
    }

    public int splitAndSum(String input) {
        String[] values = splitStrategy.split(input);
        return Arrays.stream(values)
                .map(parseStrategy::parse)
                .reduce(0, Integer::sum);
    }
}
