package blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardDeckFactoryTest {
    @Test
    void createStandardDeck() {
        Deck standardDeck = StandardDeckFactory.createStandardDeck();

        assertEquals(52, standardDeck.getCards().size());
    }
}