package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void addAll(Cards cards) {
        this.cards.addAll(cards.getCards());
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<String> getCardNames() {
        return cards.stream().map(Card::getCard).collect(Collectors.toList());
    }

    public int getScore() {
        return cards.stream().map(card -> card.getRank().getScore()).reduce(0, Integer::sum);
    }
}
