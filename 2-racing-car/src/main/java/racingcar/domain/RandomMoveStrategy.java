package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy<Integer> {
    Random random = new Random();

    @Override
    public Integer nextPosition(Integer currentPosition) {
        if (random.nextInt(10) >= 4) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
