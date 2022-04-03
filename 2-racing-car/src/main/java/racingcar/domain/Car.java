package racingcar.domain;

public class Car {
    private final MoveStrategy<Integer> moveStrategy;
    private int position;
    private String name;

    public Car(String name, MoveStrategy<Integer> moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        this.position = this.moveStrategy.nextPosition(this.position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public CarSnapShot snapShot() {
        return new CarSnapShot(position, name);
    }

    public MoveStrategy<Integer> getMoveStrategy() {
        return moveStrategy;
    }
}
