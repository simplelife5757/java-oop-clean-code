package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private final String name = "딜러";
    private final Cards cards = new Cards(new ArrayList<>());
    private final Record record = new Record();

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

    public void win() {
        this.record.addWinningCount();
    }

    public void lose() {
        this.record.addLosingCount();
    }

    public Record getRecord() {
        return record;
    }
}

