package blackjack.domain.participants;

import blackjack.domain.cards.Cards;
import blackjack.view.InputView;

import java.util.ArrayList;

public class Participant {
    private final String name;
    private final Cards cards = new Cards(new ArrayList<>());
    private int winningCount;
    private int losingCount;

    public Participant(String name) {
        this.name = name;
    }

    public void receiveCards(Cards cards) {
        this.cards.addAll(cards);
    }

    public Cards getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cards.getScore();
    }

    public boolean canReceiveAdditionalCard(InputView inputView) {
        return true;
    }

    public void win() {
        this.winningCount += 1;
    }

    public void lose() {
        this.losingCount += 1;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getLosingCount() {
        return losingCount;
    }
}
