package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void splitAndSum() {
        StringCalculator stringCalculator = new StringCalculator(new CustomSplitStrategy(), new PositiveIntegerParseStrategy());

        assertThat(stringCalculator.splitAndSum("")).isZero();
        assertThat(stringCalculator.splitAndSum("1,2")).isEqualTo(3);
        assertThat(stringCalculator.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(stringCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

}