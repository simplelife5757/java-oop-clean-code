package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printResult() {
        LottoResult lottoResult = new LottoResult(new HashMap<>() {{
            put(LottoPrize.FIFTH, 1);
        }}, 1);
        OutputView.printLottoResult(lottoResult);
    }
}