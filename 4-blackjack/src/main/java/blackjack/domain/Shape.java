package blackjack.domain;

public enum Shape {
    CLUBS("♣"), DIAMONDS("◆"), HEARTS("♥"), SPADES("♠");

    private String shape;

    Shape(String shape) {
        this.shape = shape;
    }
}
