package stringcalculator;

import java.util.Objects;

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
        int index = raw.indexOf(END_INDEX_OF_CUSTOM_DELIMITER);
        String customDelimiter = raw.substring(2, index);
        return raw.substring(index + 1).split(customDelimiter);
    }
}
