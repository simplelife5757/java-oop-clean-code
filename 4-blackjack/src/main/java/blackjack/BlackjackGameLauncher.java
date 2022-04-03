package blackjack;

import blackjack.controller.BlackjackGameController;

public class BlackjackGameLauncher {
    public static void main(String[] args) {
        BlackjackGameController blackjackGameController = new BlackjackGameController();
        blackjackGameController.play();
    }
}
