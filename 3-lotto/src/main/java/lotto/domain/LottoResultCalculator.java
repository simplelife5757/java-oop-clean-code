package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber winningBonusNumber;

    public LottoResultCalculator(LottoTicket winningLottoTicket, LottoNumber winningBonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.winningBonusNumber = winningBonusNumber;
    }

    public Map<LottoPrize, Integer> calculateResult(List<LottoTicket> lottoTickets) {
        Map<LottoPrize, Integer> result = new HashMap<>();
        for (LottoTicket lottoTicket: lottoTickets) {
            LottoPrize lottoPrize = calculateLottoPrize(lottoTicket);
            result.put(lottoPrize, result.getOrDefault(lottoPrize, 0)+1);
        }
        return result;
    }

    private LottoPrize calculateLottoPrize(LottoTicket lottoTicket) {
        int winningNumber = this.winningLottoTicket.countWinningNumber(lottoTicket);
        boolean containBonus = lottoTicket.contain(this.winningBonusNumber);
        return Arrays.stream(LottoPrize.values())
                .filter(l -> l.equal(winningNumber, containBonus))
                .findFirst().orElse(LottoPrize.NOTHING);
    }
}
