package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void 생성() {
        // Given
        LottoNumber lottoNumber = new LottoNumber("1");

        // Then
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(1);
    }

    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber("-1"));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber("46"));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber("a"));
    }

}