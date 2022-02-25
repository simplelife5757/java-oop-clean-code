package blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardDeckFactory {

    public static Deck createStandardDeck() {
        List<Card> cards = new ArrayList<>();
        for (Shape shape: Shape.values()) {
            cards.addAll(createCards(shape));
        }
        return new Deck(cards);
    }

    private static List<Card> createCards(Shape shape) {
        return Arrays.stream(Rank.values()).map(rank -> new Card(rank, shape)).collect(Collectors.toList());
    }
}
