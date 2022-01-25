package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualPurchaseAmountTest {

    @Test
    void 객체_생성() {
        // Given
        ManualPurchaseAmount manualPurchaseAmount = new ManualPurchaseAmount("2");

        // Then
        assertThat(manualPurchaseAmount.getManualPurchaseAmount()).isEqualTo(2);
    }
    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class, () -> new ManualPurchaseAmount("a"));
        assertThrows(IllegalArgumentException.class, () -> new ManualPurchaseAmount("-1"));
    }

}