package lotto.domain;

public class PurchaseMoney {
    private final int purchaseMoney;

    public PurchaseMoney(String purchaseMoney) {
        try {
            this.purchaseMoney = Integer.parseInt(purchaseMoney);
            validate(this.purchaseMoney);
        } catch (NumberFormatException e) {
        throw new IllegalArgumentException("구입금액은 숫자로 입력해 주세요.");
    }
}

    private void validate(int purchaseMoney) {
        if (purchaseMoney < 0) {
            throw new IllegalArgumentException("구입금액은 양수로 입력해 주세요.");
        }
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위로 입력해 주세요.");
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public void validateManualPurchaseAmount(ManualPurchaseAmount manualPurchaseAmount) {
        if (purchaseMoney / 10000 < manualPurchaseAmount.getManualPurchaseAmount()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 구입금액 보다 적게 입력해 주세요.");
        }
    }
}
