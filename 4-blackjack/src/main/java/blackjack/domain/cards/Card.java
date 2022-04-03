package blackjack.domain.cards;

public class Card {
    private final Rank rank;
    private final Shape shape;

    public Card(Rank rank, Shape shape) {
        this.rank = rank;
        this.shape = shape;
    }

    public String getCard() {
        return rank.getScore() + shape.getShape();
    }

    public Rank getRank() {
        return rank;
    }
}
