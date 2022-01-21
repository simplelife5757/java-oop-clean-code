package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSplitStrategyTest {

    @Test
    void 학습테스트() {
        String given = "abc\nd";

        assertThat(given.indexOf("\n")).isEqualTo(3);
        assertThat(given).hasSize(5);

        String given2 = "a:bc,d";

        assertThat(given2.split("[:,]")).isEqualTo(new String[] {"a", "bc", "d"});
    }

    @Test
    void split() {
        CustomSplitStrategy customSplitStrategy = new CustomSplitStrategy();

        String[] result = customSplitStrategy.split("1,2:3");

        assertThat(result).isEqualTo(new String[] {"1", "2", "3"});
    }

    @Test
    void split_null_of_empty() {
        CustomSplitStrategy customSplitStrategy = new CustomSplitStrategy();

        assertThat(customSplitStrategy.split("")).isEqualTo(new String[] {"0"});

        assertThat(customSplitStrategy.split(null)).isEqualTo(new String[] {"0"});
    }
}