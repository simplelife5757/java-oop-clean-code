package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {
    @Test
    void calculate() {
        LottoTicket winningTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoNumber winningBonus = new LottoNumber("7");
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningTicket, winningBonus);


        // When
        List<LottoTicket> lottoTickets = Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 6"));
        Map<LottoPrize, Integer> result = lottoResultCalculator.calculateResult(lottoTickets);

        // Then
        assertThat(result).hasSize(1).containsKey(LottoPrize.FIRST);
        assertThat(result.get(LottoPrize.FIRST)).isEqualTo(1);
    }

}