package blackjack.domain;

import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck(List<Card> cars) {
        this.cards = cars;
    }

    public List<Card> getCards() {
        return cards;
    }
}
