package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private final String name = "딜러";
    private final Cards cards = new Cards(new ArrayList<>());

    public void receiveCards(Cards cards) {
        this.cards.addAll(cards);
    }

    public String getName() {
        return name;
    }

    public List<String> getCardNames() {
        return cards.getCardNames();
    }

    public int getScore() {
        return cards.getScore();
    }
}

