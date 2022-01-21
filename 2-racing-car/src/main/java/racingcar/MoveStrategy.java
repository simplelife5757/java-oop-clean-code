package racingcar;

public interface MoveStrategy<T> {
    T nextPosition(T position);
}
