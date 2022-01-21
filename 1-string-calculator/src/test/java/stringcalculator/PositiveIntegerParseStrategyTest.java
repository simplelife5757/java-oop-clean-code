package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositiveIntegerParseStrategyTest {

    @Test
    void parse() {
        PositiveIntegerParseStrategy positiveIntegerParseStrategy = new PositiveIntegerParseStrategy();

        Integer parse = positiveIntegerParseStrategy.parse("3");
        assertThat(parse).isEqualTo(3);

        assertThrows(IllegalArgumentException.class, () -> positiveIntegerParseStrategy.parse("-1"));
        assertThrows(IllegalArgumentException.class, () -> positiveIntegerParseStrategy.parse("a"));
    }


}