package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoTicketGeneratorStrategyTest {
    @Test
    void randomLottoTicketGeneratorStrategy() {
        // Given
        RandomLottoTicketGeneratorStrategy generatorStrategy = new RandomLottoTicketGeneratorStrategy();

        // Expect
        assertThat(generatorStrategy.generate().getLottoNumbers().size()).isEqualTo(6);
    }

}