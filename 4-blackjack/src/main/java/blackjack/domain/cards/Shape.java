package blackjack.domain.cards;

public enum Shape {
    CLUBS("클로버"), DIAMONDS("다이아"), HEARTS("하트"), SPADES("스페이드");

    private String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
