package blackjack.domain;

import blackjack.domain.deck.Deck;
import blackjack.domain.deck.StandardDeckFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeckFactoryTest {
    @Test
    void createStandardDeck() {
        Deck standardDeck = StandardDeckFactory.createStandardDeck();

        assertEquals(52, standardDeck.getCards().size());
    }
}