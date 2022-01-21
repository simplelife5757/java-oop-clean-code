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
//                .map(parseStrategy::parse) // parse 에서 양수 validate 까지 하는게 나을까? ㅇㅇ 그럴듯,, 아 근데 map을 이렇게 사용하는게 맞나?
    }
}
