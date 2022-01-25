package lotto.controller;

import lotto.domain.ManualPurchaseAmount;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;

import java.util.List;

public class LottoGameController {
    public void play() {
        PurchaseMoney purchaseMoney = InputView.inputPurchaseMoney();

        ManualPurchaseAmount manualPurchaseAmount = InputView.inputManualPurchaseAmount();
        purchaseMoney.validateManualPurchaseAmount(manualPurchaseAmount);

        InputView.inputManualLottoTickets(manualPurchaseAmount.getManualPurchaseAmount());
    }
}
