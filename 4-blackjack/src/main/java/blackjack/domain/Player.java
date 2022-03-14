package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Cards cards = new Cards(new ArrayList<>());

    public Player(String name) {
        this.name = name;
    }

    public void receiveCards(Cards cards) {
        this.cards.addAll(cards);
    }

    public List<String> getCardNames() {
        return cards.getCardNames();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cards.getScore();
    }
}
