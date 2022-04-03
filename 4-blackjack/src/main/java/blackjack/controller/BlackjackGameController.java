package blackjack.controller;

import blackjack.domain.*;
import blackjack.domain.deck.StandardDeckFactory;
import blackjack.view.ConsoleInputView;
import blackjack.view.ConsoleOutputView;

public class BlackjackGameController {
    public void play() {
        BlackjackGame blackjackGame = new BlackjackGame(
                new ConsoleInputView(), new ConsoleOutputView(), StandardDeckFactory.createStandardDeck()
        );
        blackjackGame.initGame();

        blackjackGame.outputCardResults();

        blackjackGame.recordFinalResults();
        blackjackGame.outputFinalResults();
    }
}
