package lotto;

import lotto.controller.LottoGameController;

public class LottoGameLauncher {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.play();
    }
}
