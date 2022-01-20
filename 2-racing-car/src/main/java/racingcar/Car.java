package racingcar;

public class Car implements Movable {
    private final MoveStrategy<Integer> moveStrategy;
    private Integer position;
    private String name;

    public Car(String name, MoveStrategy<Integer> moveStrategy) {
        this.name = name;
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

    public CarSnapShot snapShot() {
        return new CarSnapShot(position);
    }
}
