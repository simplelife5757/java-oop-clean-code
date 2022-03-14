package blackjack.domain;

import java.util.List;

public class CardSnapshot {
    private final String name;
    private final List<String> cards;

    public CardSnapshot(String name, List<String> cardNames) {
        this.name = name;
        this.cards = cardNames;
    }

    public String getName() {
        return name;
    }

    public List<String> getCards() {
        return cards;
    }
}
