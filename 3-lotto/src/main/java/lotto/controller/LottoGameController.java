package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        LottoTicket lastWinningLottoTicket = new LottoTicket(InputView.inputLastWinningLottoNumbers());
        LottoNumber lastBonusNumber = new LottoNumber(InputView.inputBonusNumber());

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lastWinningLottoTicket, lastBonusNumber);
        LottoResult lottoResult = lottoResultCalculator.calculateResult(Stream.concat(manualLottoTickets.stream(), autoLottoTickets.stream()).collect(Collectors.toList()));
        OutputView.printLottoResult(lottoResult);
    }
}
