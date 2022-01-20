package racingcar;

public interface MoveStrategy<T> {
    T nextPosition(T currentPosition);
    T initialPosition();
}
