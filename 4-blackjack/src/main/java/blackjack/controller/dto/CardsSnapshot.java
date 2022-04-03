package blackjack.controller.dto;

import blackjack.domain.cards.Cards;

import java.util.List;

public class CardsSnapshot {
    private final String name;
    private final Cards cards;

    public CardsSnapshot(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public List<String> getCardNames() {
        return cards.getCardNames();
    }

    public int getCardsScore() {
        return this.cards.getScore();
    }
}
