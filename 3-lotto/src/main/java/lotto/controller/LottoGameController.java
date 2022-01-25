package lotto.controller;

import lotto.domain.ManualPurchaseAmount;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;

public class LottoGameController {
    public void play() {
        PurchaseMoney purchaseMoney = InputView.inputPurchaseMoney();

        ManualPurchaseAmount manualPurchaseAmount = InputView.inputManualPurchaseAmount();
        purchaseMoney.validateManualPurchaseAmount(manualPurchaseAmount);
    }
}
