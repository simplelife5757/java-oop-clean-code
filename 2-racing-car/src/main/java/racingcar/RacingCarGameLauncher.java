package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;

public class RacingCarGameLauncher {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new ConsoleInputView(), new ConsoleOutputView());

        racingCarGameController.initAndPlay();
        racingCarGameController.outputRoundResult();
        racingCarGameController.outputFinalWinningCarNames();
    }
}
