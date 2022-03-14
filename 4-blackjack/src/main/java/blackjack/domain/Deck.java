package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck(List<Card> cars) {
        this.cards = cars;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> pickRandomCards(int n) {
        List<Card> randomCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            randomCards.add(removeRandomCard());
        }
        return randomCards;
    }

    private Card removeRandomCard() {
        Collections.shuffle(cards);
        return cards.remove(0);
    }
}
