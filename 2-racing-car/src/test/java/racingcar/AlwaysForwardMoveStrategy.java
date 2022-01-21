package racingcar;

import racingcar.domain.MoveStrategy;

public class AlwaysForwardMoveStrategy implements MoveStrategy<Integer> {
    public AlwaysForwardMoveStrategy() {
    }

    @Override
    public Integer nextPosition(Integer currentPosition) {
        return currentPosition + 1;
    }

    @Override
    public Integer initialPosition() {
        return 0;
    }
}
