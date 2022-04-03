package racingcar.domain;

public interface MoveStrategy<T> {
    T nextPosition(T position);
}
