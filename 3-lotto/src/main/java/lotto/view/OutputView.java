package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoTickets(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        System.out.printf("수동으로 %s장, 자동으로 %s장을 구매했습니다.%n", manualLottoTickets.size(), autoLottoTickets.size());
        manualLottoTickets.forEach(System.out::println);
        autoLottoTickets.forEach(System.out::println);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        lottoResult.getCountByLottoPrize().entrySet().stream()
                .filter(lottoPrizeIntegerEntry -> lottoPrizeIntegerEntry.getKey().getWinningCount() >= 3)
                .sorted(Map.Entry.comparingByKey())
                .forEach(lottoPrizeIntegerEntry -> printCountByLottoPrize(lottoPrizeIntegerEntry.getKey(), lottoPrizeIntegerEntry.getValue()));
        System.out.printf("총 수익률은%s입니다.(기준이 1이기 때문에 손해~)", lottoResult.getYield());
    }

    private static void printCountByLottoPrize(LottoPrize key, Integer value) {
        if (key.equals(LottoPrize.SECOND)) {
            System.out.printf("%s개 일치, 보너스 볼 일치(%s)- %s개\n", key.getWinningCount(), key.getPrize(), value);
            return;
        }
        System.out.printf("%s개 일치 (%s)- %s개\n", key.getWinningCount(), key.getPrize(), value);
    }

}
