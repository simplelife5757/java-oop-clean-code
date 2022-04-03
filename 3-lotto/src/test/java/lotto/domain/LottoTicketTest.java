package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 생성() {
        // Given
        LottoTicket lottoTicket = new LottoTicket("1,2,3,4,5,6");

        // Then
        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(
                Arrays.stream(new LottoNumber[]{
                        new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")
                }).collect(Collectors.toList())
        );
    }

    @Test
    void validate() {
        // Given
        assertThrows(IllegalArgumentException.class, () -> new LottoTicket("1,2,3,4,5,6,7"));
        assertThrows(IllegalArgumentException.class, () -> new LottoTicket("1,2,3,4,5,5"));
    }

}