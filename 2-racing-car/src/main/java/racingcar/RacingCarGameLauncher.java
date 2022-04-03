package racingcar;

import racingcar.controller.RacingCarGameController;

public class RacingCarGameLauncher {
    public static void main(String[] args) {
        RacingCarGameController controller = new RacingCarGameController();
        controller.initAndPlay();
    }
}
