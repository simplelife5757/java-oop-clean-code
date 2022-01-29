package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class LottoGameController {
    public void play() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputPurchaseMoney());

        ManualPurchaseAmount manualPurchaseAmount = new ManualPurchaseAmount(InputView.inputManualPurchaseAmount());
        purchaseMoney.validateManualPurchaseAmount(manualPurchaseAmount);

        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();
        List<LottoTicket> manualLottoTickets = lottoTicketGenerator.generateManualLottoTickets(
                InputView.inputManualLottoTickets(manualPurchaseAmount.getManualPurchaseAmount())
        );
        int autoLottoTicketAmount = purchaseMoney.getPurchaseAmount() - manualPurchaseAmount.getManualPurchaseAmount();
        List<LottoTicket> autoLottoTickets = lottoTicketGenerator.generateAutoLottoTickets(
                new RandomLottoTicketGeneratorStrategy(), autoLottoTicketAmount
        );

        OutputView.printLottoTickets(manualLottoTickets, autoLottoTickets);
    }
}
