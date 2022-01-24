package lotto.controller;

import lotto.view.InputView;

public class LottoGameController {
    public void play() {
        int purchaseMoney = InputView.inputPurchaseMoney();

        int purchaseAmount = InputView.inputManualPurchaseAmount();
        System.out.println(InputView.inputManualLottoNumbers(purchaseAmount));
    }
}
