package blackjack.domain;

import blackjack.domain.deck.Deck;
import blackjack.domain.participants.Participants;
import blackjack.view.ConsoleInputView;
import blackjack.view.OutputView;

public class BlackjackGame {
    private final ConsoleInputView inputView;
    private final OutputView outputView;
    private final Deck deck;
    private final Participants participants;

    public BlackjackGame(ConsoleInputView inputView, OutputView outputView, Deck deck) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.deck = deck;
        this.participants = new Participants(inputView.inputPlayerNames());
    }

    public void initGame() {
        participants.initCard(deck);
        outputView.outputCardSnapshots(this.participants.getCardSnapShots());
        participants.giveAdditionalCard(inputView, outputView, deck);
    }

    public void outputCardResults() {
        this.outputView.outputCardResults(this.participants.getCardSnapShots());
    }

    public void recordFinalResults() {
        this.participants.recordFinalResults();
    }

    public void outputFinalResults() {
        this.outputView.outputFinalResults(this.participants.getFinalResults());
    }
}
