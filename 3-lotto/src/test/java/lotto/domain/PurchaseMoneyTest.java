package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseMoneyTest {

    @Test
    void 객체_생성() {
        // Given
        PurchaseMoney purchaseMoney = new PurchaseMoney("1000");

        // Then
        assertThat(purchaseMoney.getPurchaseMoney()).isEqualTo(1000);
    }

    @Test
    void validate() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseMoney("a"));
        assertThrows(IllegalArgumentException.class, () -> new PurchaseMoney("-1"));
        assertThrows(IllegalArgumentException.class, () -> new PurchaseMoney("15200"));
    }

    @Test
    void validateManualPurchaseAmount() {
        // Given
        PurchaseMoney purchaseMoney = new PurchaseMoney("1000");
        ManualPurchaseAmount manualPurchaseAmount = new ManualPurchaseAmount("4");

        // Then
        assertThrows(IllegalArgumentException.class, () -> purchaseMoney.validateManualPurchaseAmount(manualPurchaseAmount));
    }
}