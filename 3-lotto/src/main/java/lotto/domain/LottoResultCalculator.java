package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber winningBonusNumber;

    public LottoResultCalculator(LottoTicket winningLottoTicket, LottoNumber winningBonusNumber) {
        this.winningLottoTicket = winningLottoTicket;
        this.winningBonusNumber = winningBonusNumber;
    }

    public LottoResult calculateResult(List<LottoTicket> lottoTickets) {
        Map<LottoPrize, Integer> result = calculateCountByLottoPrize(lottoTickets);
        Integer totalPrize = result.entrySet()
                .stream()
                .map(lottoPrizeIntegerEntry -> lottoPrizeIntegerEntry.getKey().getPrize() * lottoPrizeIntegerEntry.getValue())
                .reduce(0, Integer::sum);
        return new LottoResult(result, totalPrize / (lottoTickets.size() * 1000L));
    }

    private Map<LottoPrize, Integer> calculateCountByLottoPrize(List<LottoTicket> lottoTickets) {
        Map<LottoPrize, Integer> result = Arrays.stream(LottoPrize.values()).collect(Collectors.toMap(Function.identity(), i -> 0));
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
                .filter(l -> l.hasEqualPrize(winningNumber, containBonus))
                .findFirst().orElseThrow();
    }
}
