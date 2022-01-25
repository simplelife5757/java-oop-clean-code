package lotto.domain;

public class ManualPurchaseAmount {
    private final int manualPurchaseAmount;

    public ManualPurchaseAmount(String manualPurchaseAmount) {
        try {
            this.manualPurchaseAmount= Integer.parseInt(manualPurchaseAmount);
            validate(this.manualPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자로 입력해 주세요.");
    }
}

    private void validate(int manualPurchaseAmount) {
        if (manualPurchaseAmount < 0) {
            throw new IllegalArgumentException("구입금액은 양수로 입력해 주세요.");
        }
    }

    public int getManualPurchaseAmount() {
        return manualPurchaseAmount;
    }
}
