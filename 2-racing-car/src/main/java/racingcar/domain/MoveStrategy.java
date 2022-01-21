package racingcar.domain;

public interface MoveStrategy<T> {
    T nextPosition(T currentPosition);
    T initialPosition();
}
