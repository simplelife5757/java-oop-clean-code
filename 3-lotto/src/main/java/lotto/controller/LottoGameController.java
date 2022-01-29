package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.ManualLottoTickets;
import lotto.domain.ManualPurchaseAmount;
import lotto.domain.PurchaseMoney;
import lotto.view.InputView;

import java.util.List;
import java.util.stream.Collectors;


public class LottoGameController {
    public void play() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputPurchaseMoney());

        ManualPurchaseAmount manualPurchaseAmount = new ManualPurchaseAmount(InputView.inputManualPurchaseAmount());
        purchaseMoney.validateManualPurchaseAmount(manualPurchaseAmount);

        List<LottoTicket> manualLottoTickets = createManualLottoTickets(
                InputView.inputManualLottoTickets(manualPurchaseAmount.getManualPurchaseAmount())
        );
    }

    public List<LottoTicket> createManualLottoTickets(List<String> manualLottoTickets) {
        return manualLottoTickets.stream().map(LottoTicket::new).collect(Collectors.toList());
    }
}
