package racingcar;

public class Car implements Movable {
    private final MoveStrategy<Integer> moveStrategy;
    private Integer position;

    public Car(MoveStrategy<Integer> moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.position = moveStrategy.initialPosition();
    }

    @Override
    public void move() {
        this.position = this.moveStrategy.nextPosition(this.position);
    }

    public Integer getPosition() {
        return position;
    }
}
