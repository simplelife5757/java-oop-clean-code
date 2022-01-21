package stringcalculator;

public class PositiveIntegerParseStrategy implements ParseStrategy<String, Integer> {
    @Override
    public Integer parse(String value) {
        Integer parsedInteger = parseInt(value);
        if (parsedInteger < 0) {
            throw new IllegalArgumentException("양수만 입력하셔야 합니다.");
        }
        return parsedInteger;
    }

    private Integer parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하셔야 합니다.");
        }
    }
}
