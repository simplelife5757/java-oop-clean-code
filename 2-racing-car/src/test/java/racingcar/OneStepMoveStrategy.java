package racingcar;

import racingcar.domain.MoveStrategy;

public class OneStepMoveStrategy implements MoveStrategy<Integer> {
    public OneStepMoveStrategy() {
    }

    @Override
    public Integer nextPosition(Integer position) {
        return position+1;
    }
}
