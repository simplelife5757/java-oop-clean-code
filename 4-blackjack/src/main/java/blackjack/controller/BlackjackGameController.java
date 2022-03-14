package blackjack.controller;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Player;
import blackjack.domain.StandardDeckFactory;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGameController {
    public void play() {
        List<String> playerNames = InputView.inputPlayerNames();

        BlackjackGame blackjackGame = new BlackjackGame(createPlayer(playerNames), StandardDeckFactory.createStandardDeck());
        blackjackGame.giveOutCards();
        OutputView.printCardSnapshots(blackjackGame.getCardSnapshots());
        for (String playerName: playerNames) {
            giveAdditionalCard(blackjackGame, playerName);
        }
        blackjackGame.giveAdditionalCardToDealer();
    }

    private void giveAdditionalCard(BlackjackGame blackjackGame, String playerName) {
        while (blackjackGame.canReceiveAdditionalCard(playerName) && InputView.askOneMoreCard(playerName)) {
            blackjackGame.giveAdditionalCard(playerName);
            OutputView.printCardSnapshot(blackjackGame.getCardSnapshot(playerName));
        }
    }

    private List<Player> createPlayer(List<String> playerNames) {
        return playerNames.stream().map(Player::new).collect(Collectors.toList());
    }
}
