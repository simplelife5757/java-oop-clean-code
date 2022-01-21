package stringcalculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitStrategy implements SplitStrategy<String> {

    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String EMPTY = "";
    public static final String DEFAULT_NUMBER = "0";
    public static final String START_INDEX_OF_CUSTOM_DELIMITER = "//";
    public static final String END_INDEX_OF_CUSTOM_DELIMITER = "\n";

    @Override
    public String[] split(String raw) {
        if (raw == null || raw.isEmpty()) {
            return new String[] {DEFAULT_NUMBER};
        }
        if (!raw.startsWith(START_INDEX_OF_CUSTOM_DELIMITER)) {
            return raw.split(DEFAULT_DELIMITER);
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(raw);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
    }
}
