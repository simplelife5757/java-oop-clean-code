package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> countByLottoPrize;
    private final long yield;

    public LottoResult(Map<LottoPrize, Integer> countByLottoPrize, long yield) {
        this.countByLottoPrize = countByLottoPrize;
        this.yield = yield;
    }

    public Map<LottoPrize, Integer> getCountByLottoPrize() {
        return countByLottoPrize;
    }

    public long getYield() {
        return yield;
    }
}
