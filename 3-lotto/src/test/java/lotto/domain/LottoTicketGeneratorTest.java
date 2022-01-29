package lotto.domain;

import lotto.util.SequentialLottoTicketGeneratorStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @Test
    void generateManualLottoTickets() {
        // Given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        List<String> givenLottoTickets = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");

        // When
        List<LottoTicket> lottoTickets = lottoTicketGenerator.generateManualLottoTickets(givenLottoTickets);

        // Then
        List<LottoTicket> expected = Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 6"), new LottoTicket("7, 8, 9, 10, 11, 12"));
        assertThat(lottoTickets).isEqualTo(expected);
    }

    @Test
    void generateAutoLottoTickets() {
        // Given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        SequentialLottoTicketGeneratorStrategy generatorStrategy = new SequentialLottoTicketGeneratorStrategy();

        // When
        List<LottoTicket> lottoTickets = lottoTicketGenerator.generateAutoLottoTickets(generatorStrategy, 2);

        // Then
        List<LottoTicket> expected = Arrays.asList(new LottoTicket("1, 2, 3, 4, 5, 6"), new LottoTicket("7, 8, 9, 10, 11, 12"));
        assertThat(lottoTickets).isEqualTo(expected);
    }
}